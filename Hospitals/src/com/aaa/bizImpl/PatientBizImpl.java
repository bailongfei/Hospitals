package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.biz.PatientBiz;
import com.aaa.dao.PatientDao;
import com.aaa.entity.Patients;
import com.aaa.entity.Patientdetail;

@Service
public class PatientBizImpl implements PatientBiz{
	@Autowired
    private PatientDao dao;

	public PatientDao getDao() {
		return dao;
	}

	public void setDao(PatientDao dao) {
		this.dao = dao;
	}
	
    //添加患者详情
	@Override
	public void addPatientDetail(Patientdetail patientdetail) {
		dao.addPatientDetail(patientdetail);	
	}
    //患者查询
	@Override
	public List<Patients> findPatients() {
		return dao.findPatients();
	}
    //患者就诊状态的修改
	@Override
	public void updateP_status(Patients patients) {
		dao.updateP_status(patients);
	}
	
}
