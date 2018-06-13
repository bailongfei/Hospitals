package com.aaa.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.Drug;
import com.aaa.entity.Iccard;
import com.aaa.entity.Patients;
import com.aaa.util.Pager;
@Component
public class IccardImpl implements ICcardDao{
@Autowired
	private HibernateTemplate hiber;

	public HibernateTemplate getHiber() {
		return hiber;
	}

	public void setHiber(HibernateTemplate hiber) {
		this.hiber = hiber;
	}
@Transactional
	@Override
	public void addICcard(Iccard i) {
		// TODO Auto-generated method stub
		hiber.save(i);
	}
//IC kø®∞Ï¿Ì≤È—Ø
@Override
public List<Iccard> select() {
	// TODO Auto-generated method stub

	List<Iccard> c=hiber.find("select new Map(i.icid as icid,i.name as name,i.sex as sex,i.card as card,i.money as money,i.iphone as iphone) from Iccard as i");
	return c;
	}

@Override
public Map findById(int icid) {
	System.out.println("doaimpl"+icid);
	// TODO Auto-generated method stub
	String hql="select new Map(i.icid as icid,i.name as name,i.sex as sex,i.card as card,i.money as money,i.iphone as iphone) from Iccard as i where i.icid=? ";
	System.out.println("findById"+this.hiber.find(hql,icid).get(0));
	return (Map)this.hiber.find(hql,icid).get(0);
	}

public List<Iccard> selname(String name){
	   List<Iccard> list=hiber.find("select new Map(i.icid as icid,i.name as name,i.sex as sex,i.card as card,i.money as money,i.iphone as iphone) from Iccard i where i.name like '%"+name+"%'");
	return list;
}



@Override
public void update(Iccard i) {
	// TODO Auto-generated method stub
	/*this.template.update(role);*/
this.hiber.update(i);
}

@Override
public List<Iccard> selectAll() {
	// TODO Auto-generated method stub
	List<Iccard> d=hiber.find("select new Map(i.icid as icid,i.name as name,i.money as money,i.iphone as iphone) from Iccard as i");
	return d;
}

@Override
public List<Iccard> selectname(String name) {
	// TODO Auto-generated method stub
	 List<Iccard> c=hiber.find("select new Map(i.icid as icid,i.name as name,i.money as money,i.iphone as iphone) from Iccard i where i.name like '%"+name+"%'");
		return c;
}

@Override
public Map ICfindById(int icid) {
	// TODO Auto-generated method stub
	String hql="select new Map(i.icid as icid,i.name as name,i.money as money,i.iphone as iphone) from Iccard as i where i.icid=? ";
	System.out.println("ICfindById"+this.hiber.find(hql,icid).get(0));
	return (Map)this.hiber.find(hql,icid).get(0);
}

@Override
public void updateiccard(int icid, int money) {
	// TODO Auto-generated method stub
	Iccard d=	hiber.get(Iccard.class, icid);
	d.setMoney(d.getMoney()+money);
	hiber.update(d);
	
}

@Override
public void delIc(int icid) {
	// TODO Auto-generated method stub
	Iccard ca=hiber.get(Iccard.class, icid);
	hiber.delete(ca);
	
}




}
