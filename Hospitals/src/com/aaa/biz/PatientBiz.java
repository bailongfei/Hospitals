package com.aaa.biz;

import com.aaa.entity.Patients;

import java.util.List;

import com.aaa.entity.Patientdetail;

public interface PatientBiz {
		//患者明细的添加
		public void addPatientDetail(Patientdetail patientdetail);
		//查询患者
		public List<Patients> findPatients();
		//患者就诊状态修改
		public void updateP_status(Patients patients);
}
