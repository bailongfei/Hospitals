package com.aaa.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.dao.ResultDao;
import com.aaa.entity.Applicationresult;
import com.aaa.entity.Patients;
@Component
public class ResultDaoImpl implements ResultDao {
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
		return ht.find("from Applicationresult a join a.inspection join a.applicationform join a.patients");
	}

	@Override
	public Patients selectbyid(int jcjId) {
		// TODO Auto-generated method stub
		return ht.get(Patients.class, jcjId);
	}

	@Override
	public void insert(Applicationresult result) {
		// TODO Auto-generated method stub
		ht.save(result);
	}
    
}
