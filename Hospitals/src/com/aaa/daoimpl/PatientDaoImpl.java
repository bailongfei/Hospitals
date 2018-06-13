package com.aaa.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.PatientDao;
import com.aaa.entity.Patients;
import com.aaa.entity.Patientdetail;
@Repository
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
    public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

    //�������������
	@Override
	public void addPatientDetail(Patientdetail patientdetail) {
		
        this.hibernateTemplate.saveOrUpdate(patientdetail);
	}
	//���߲�ѯ
	@Override
	public List<Patients> findPatients() {
		List<Patients> list=this.getHibernateTemplate().find("select new Map(p.id as id,p.patientname as name,p.sex as sex,p.age as age,p.status as status,p.idnumber as idnumber) from Patients as p");
		return list;
	}
	//���߾���״̬���޸�
	@Override
	public void updateP_status(Patients patients) {
		this.getHibernateTemplate().saveOrUpdate(patients);
	}
	

}
