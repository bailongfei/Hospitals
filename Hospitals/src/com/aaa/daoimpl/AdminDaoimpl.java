package com.aaa.daoimpl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.AdminDao;
import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.entity.Rolesmodule;
import com.aaa.util.Pager;
import com.aaa.util.PagerCallBack;
@Repository
public class AdminDaoimpl implements AdminDao {
	@Autowired
  private HibernateTemplate ht;
  
	public HibernateTemplate getHt() {
	return ht;
}

public void setHt(HibernateTemplate ht) {
	this.ht = ht;
}

	@Override
	public boolean adminLogin(String userName, String password) {
		System.out.println("daoimpl:"+userName+password);
		String hql="select new Map(u.userName as userName,u.password as password) from Usertable u where u.userName='"+userName+"' and u.password='"+password+"'";
		List list=this.ht.find(hql);
		/*String hql="select new Map(u.userName as userName,u.password as password) from Usertable u where u.userName=?";
		String strWhere=" and u.password=?";
		if(password!=null&&password.length()>0){
			hql+=strWhere;
		}*/
		System.out.println(list);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
		
	}

	

	@Override
	public List findModules(String userName) {
		final String sql="select m.* from modules m,rolesmodule r,roles ro,usertable u where u.rolesId=ro.rolesId and ro.rolesId=r.rolesId and r.modulesId=m.modulesId and u.userName='"+userName+"'";
		List list=this.ht.execute(new HibernateCallback<List>() {

			@Override
			public List<Map> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createSQLQuery(sql);
				//设定结果集中每个对象为Map类型
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List list=query.list();
				return list;
				
			}
		});
		return list;
	}

	@Override
	public Pager findAllRolesByPager(final int curPage,final int pageSize) {
		Pager p=new Pager(curPage, pageSize);
		String hql="select new Map(rolesId as rolesId,rolesName as rolesName,rolesdescribe as rolesdescribe) from Roles";
		List list=this.getHt().executeFind(new PagerCallBack<List<Roles>>(hql,null,(curPage-1)*pageSize, pageSize));
		List<Long> list2=this.getHt().find("select count(*) from Roles");
		p.setList(list);
		p.setTotalCount(Integer.valueOf(list2.get(0).toString()));
		
		return p;
	}

	@Override
	public void saveRoles(Roles roles) {
		this.getHt().save(roles);
	}

	@Override
	public Map findByIdRoles(Roles roles) {
		String hql="select new Map(rolesId as rolesId,rolesName as rolesName,rolesdescribe as rolesdescribe) from Roles where rolesId="+roles.getRolesId();
		List<Map> list=this.getHt().find(hql);
		return list.get(0);
	}

	@Override
	public void updateRoles(Roles roles) {
		this.getHt().update(roles);
	}

	@Override
	public void deleteRoles(Roles roles) {
		this.getHt().delete(roles);
		
	}

	@Override
	public List findAllMenusByRoleId(int rolesId) {
		final String sql="select m.modulesId,m.parentid,m.modulesText, "
	              +"CASE when rolesId is not null then TRUE else FALSE END as checked "
				  +"from modules as m left join (select * from rolesmodule where rolesId=?) as sm on m.modulesId=sm.modulesId ";
		final Object[] params=new Object[]{rolesId};
		List list=this.getHt().execute(new HibernateCallback<List>() {

			@Override
			public List<Map> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createSQLQuery(sql);
				query.setParameter(0,params[0]);
				//设定结果集中每个对象为Map类型
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List result=query.list();
				
				System.out.println("daoimplROles:"+result);
				return result;
				
			}
		});
		return list;
	}

	@Override
	public void deleteRolesModule(int rolesId) {
		String hql="delete from Rolesmodule where roles.rolesId="+rolesId;
		this.getHt().bulkUpdate(hql);//批量更新
	}

	@Override
	public void saveRolesModule(Rolesmodule rolModue) {
		this.getHt().save(rolModue);
		
	}

	@Override
	public List findByDate(final Date day1,final Date day2,Object params) {
		
		final String sql="select COUNT(*) as sumId,ry.typeName as typeName,SUM(cg.charge) as charges from clinicregister c left join charge cg on c.sfId=cg.sfId left join registeredtype ry on c.ghIds=ry.ghId where c.ghIds="+params+" and c.presentTime between ? and ?";
		
		List list=this.getHt().execute(new HibernateCallback<List>() {
			final Object[] params=new Object[]{day1,day2};
			@Override
			public List<Map> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createSQLQuery(sql);
				query.setParameter(0,params[0]);
				query.setParameter(1,params[1]);
				//设定结果集中每个对象为Map类型
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List result=query.list();
				return result;
			}
		});
		  
		return list;
		
		
	}

	@Override
	public List findRegisteredtype() {
		String hql="select r.ghId from Registeredtype r";
		List list=this.getHt().find(hql);
		System.out.println("findRegisteredtype"+list);
		return list;
	}

	@Override
	public List findByDateKeShi(final Date day1, final Date day2, final Object params) {
		final String sql="select ry.typeName as typeName,s.stuffname as stuffname,SUM(cg.charge) as charges from clinicregister c left join charge cg on c.sfId=cg.sfId left join registeredtype ry on c.ghIds=ry.ghId left join stuff s on c.stuffIds=s.stuffid2 where  c.presentTime between ? and ? and c.ghIds=?";
		List list=this.getHt().execute(new HibernateCallback<List>() {

			@Override
			public List<Map> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query=session.createSQLQuery(sql);
				query.setParameter(0, day1);
				query.setParameter(1,day2);
				query.setParameter(2,params);
				query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
				List result=query.list();
				
				return result;
			}
		});
		
		return list;
	}

}
