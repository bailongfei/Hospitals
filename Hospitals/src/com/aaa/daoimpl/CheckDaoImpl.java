package com.aaa.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.dao.CheckDao;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Iccard;
import com.aaa.util.Pager;
import com.aaa.util.PagerCallBack;

@Component
public class CheckDaoImpl implements CheckDao { 
	@Autowired
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public List<Object[]> select() {
		// TODO Auto-generated method stub
		return ht.find("from Applicationform a join a.patients join a.applicationitem");
	}
	@Override
	public Pager findByPages(int curPage,int pageSize) {
		// TODO Auto-generated method stub
		String hql="from Applicationform";
		List<Applicationform> list=this.getHt().executeFind(new PagerCallBack<Applicationform>(hql, null, curPage, pageSize));
		//总条数
		int count=Integer.valueOf(this.getHt().find("select count(*) from Applicationform").get(0).toString());
		//分页对象
		Pager p=new Pager(list, curPage, pageSize, count);
		return p;
	}

	@Override
	public Applicationform selectbyid(int jcId) {
		// TODO Auto-generated method stub
		return ht.get(Applicationform.class, jcId);
	}

	@Override
	public void update(Applicationform app) {
		// TODO Auto-generated method stub
		ht.update(app);
	}

	@Override
	public void updateIccard(int id,int money) {
		System.out.println(id+money);
		String hql="update Iccard as i set i.money=? where i.patients.id=?";
		this.getHt().bulkUpdate(hql,money,id);
		
	}

	@Override
	public Map findMoney(int id) {
		System.out.println("daoimpl:"+id);
		String hql="select new Map(i.money as money) from Iccard as i where i.patients.id=?";
		List<Map> list=this.getHt().find(hql,id);
		return list.get(0);
	}

}
