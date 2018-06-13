package com.aaa.daoimpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.MedicalrecordDao;
import com.aaa.entity.Medicalrecord;

@Repository
public class MedicalrecordDaoImpl implements MedicalrecordDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// Ìí¼Ó²¡Àú
	@Override
	public void addMedicalrecord(Medicalrecord medicalrecord) {
		this.getHibernateTemplate().saveOrUpdate(medicalrecord);
	}

}
