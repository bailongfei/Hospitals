package com.aaa.biz;

import com.aaa.entity.Patients;

import java.util.List;

import com.aaa.entity.Patientdetail;

public interface PatientBiz {
		//������ϸ�����
		public void addPatientDetail(Patientdetail patientdetail);
		//��ѯ����
		public List<Patients> findPatients();
		//���߾���״̬�޸�
		public void updateP_status(Patients patients);
}
