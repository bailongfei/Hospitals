package com.aaa.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Treatment;
@Repository
public class TreatmentDaoImpl implements com.aaa.dao.TreatmentDao {
	@Resource
private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Treatment> findTreatment(String zjm) {
		List<Treatment> list=hibernateTemplate.find("select new Map(t.zjm as zjm,t.tname as name,t.monad as monad,t.count as count,t.price as price) from Treatment as t where t.zjm like '%"+zjm+"%'");
		System.out.println("daoimpl"+list.toString());
		return list;
	}

}
