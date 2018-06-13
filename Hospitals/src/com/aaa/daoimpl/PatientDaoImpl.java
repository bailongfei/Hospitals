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

    //患者详情表的添加
	@Override
	public void addPatientDetail(Patientdetail patientdetail) {
		
        this.hibernateTemplate.saveOrUpdate(patientdetail);
	}
	//患者查询
	@Override
	public List<Patients> findPatients() {
		List<Patients> list=this.getHibernateTemplate().find("select new Map(p.id as id,p.patientname as name,p.sex as sex,p.age as age,p.status as status,p.idnumber as idnumber) from Patients as p");
		return list;
	}
	//患者就诊状态的修改
	@Override
	public void updateP_status(Patients patients) {
		this.getHibernateTemplate().saveOrUpdate(patients);
	}
	

}
