package com.aaa.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.PageEntity;
import com.aaa.entity.Pager;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;
import com.aaa.util.PageUtil;
import com.alibaba.fastjson.JSON;

@Component
public class ScheduleItemDaoImpl implements  ScheduleItemDao{
	@Autowired
	   private HibernateTemplate hibernateTemplate;
	@Autowired
	   private SessionFactory sessionFactory;
	@Autowired
	   private PageUtil util;
	

	@Override
	public String select() {
		// TODO Auto-generated method stub
		String hql="select new Map(s.id as id,s.scheduletype.ptid as ptid,s.week as week,s.stuff.stuffid2 as stuffid2) from Scheduleitem s";
		//开启事务
		Session se=sessionFactory.openSession();
		
		List<Map<String,Object>> list=se.createQuery(hql).list();
		String json=JSON.toJSONString(list);
		se.close();
		sessionFactory.close(); 
		return json;
	}

	
	@Override
	public PageEntity findByPages(PageEntity pageEntity) {
		String hql="select new Map(s.stuffid2 as stuffid2,s.photo as photo,s.stuffname as stuffname) from Stuff s";
    	
		return util.getPage(hql, pageEntity);
	
	}
	@Override
	public String select1() {
		// TODO Auto-generated method stub
		String hql=" from Stuff ";
		Session se=sessionFactory.openSession();
		Query q=se.createQuery(hql);
		List<Stuff> stuff=q.list();
		String json=JSON.toJSONString(stuff);
		se.close();
		sessionFactory.close();
		return json;
	}
	
	@Override
	public String select2() {
		// TODO Auto-generated method stub
		String hql="select new Map(s.ptid as ptid, s.SName as SName ) from Scheduletype s";
		Session se=sessionFactory.openSession();
		Query q=se.createQuery(hql);
		List<Map<String,Object>> Scheduletype=q.list();
		String json=JSON.toJSONString(Scheduletype);
		se.close();
		sessionFactory.close();
		return json;
	}
	@Override
	public void add(Stuff s) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(s);
	}
	
	@Override
	public void save(Scheduleitem sitem) {
		// TODO Auto-generated method stub
		Session se=sessionFactory.openSession();
		String sql="SELECT  s.id as id  FROM scheduleitem s WHERE  s.stuffid2="+sitem.getStuff().getStuffid2()+" and s.week='"+sitem.getWeek()+"'";
        Query query=se.createSQLQuery(sql);
        //直接用list map接收数据
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map<String,Object>> list=query.list();
		if (list.size()==0) {
			se.save(sitem);
		
		} else {
			int id= (int) list.get(0).get("id");
			String sql2="update scheduleitem set ptid="+sitem.getScheduletype().getPtid()+" where id="+id;
			
			se.createSQLQuery(sql2).executeUpdate();
			se.close();
		sessionFactory.close();
		}
	}


	@Override
	public PageEntity findByPages2(PageEntity pageEntity, String name) {
String hql="select new Map(s.stuffid2 as stuffid2,s.photo as photo,s.stuffname as stuffname) from Stuff s where s.stuffname like '%"+name+"%'";
    	System.out.println(hql);
		return util.getPage(hql, pageEntity);
	}


	


	




	
	
	

}
