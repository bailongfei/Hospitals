package com.aaa.daoimpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.CureDao;
import com.aaa.entity.Cure;

@Repository
public class CureDaoImpl implements CureDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void addCure(Cure cure) {
		this.hibernateTemplate.saveOrUpdate(cure);

	}

}
