package com.aaa.dao;

import com.aaa.entity.Patients;

import java.util.List;

import com.aaa.entity.Patientdetail;

public interface PatientDao {
	//������ϸ�����
	public void addPatientDetail(Patientdetail patientdetail);
	//��ѯ����
	public List<Patients> findPatients();
	//���߾���״̬�޸�
	public void updateP_status(Patients patients);
	
}
