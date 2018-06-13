package com.aaa.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.OfficeDao;
import com.aaa.entity.Office;

@Repository
public class OfficeDaoImpl implements OfficeDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// ø∆ “ºÏ≤È
	@Override
	public List<Office> findOffice() {
		List<Office> list = hibernateTemplate.find("select new Map(o.officeId as id,o.officeName as name) from Office as o");
		return list;
	}

}
