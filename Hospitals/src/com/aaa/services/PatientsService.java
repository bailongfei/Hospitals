package com.aaa.services;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Patients;
import com.aaa.util.Pager;

public interface PatientsService {
 public Pager findByPagers(int curPage,int pageSize);
 public void saveOrUpdate(Patients patients);
 public Map findById(Patients patients);
 public void delete(Patients patients);
 public String findByKey(String key);//模糊搜索
 public Map findByName(Patients patients);
 public void deleteClinicregister(Clinicregister clinicregister);//删除门诊登记表
 public void deleteCharge(Charge charge);//退费
 public List<Map> findOffice();
 public List<Map> findStuff();
 public List<Map> findRegisteredtype();
 public void saveClinicregister(Clinicregister clinicregister);
 public void savePatients(Patients patients);
 public void saveCharge(Charge charge);
 public void updateClinicregister(Clinicregister clinicregister);
 public void updatePatients(Patients patients);
 public void updateCharge(Charge charge);
 public String getNewId();
}
