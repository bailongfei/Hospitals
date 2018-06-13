package com.aaa.services;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Iccard;
import com.aaa.entity.Patients;
import com.aaa.entity.Stuff;
import com.aaa.entity.Stufftype;
import com.aaa.entity.Usertable;
import com.aaa.util.Pager;

public interface PatientsService {
 public Pager findByPagers(int curPage,int pageSize);
 public void saveOrUpdate(Patients patients);
 public Map findById(Patients patients);
 public void delete(Patients patients);
 public String findByKey(String key);//ģ������
 public Map findByName(Patients patients);
 public void deleteClinicregister(Clinicregister clinicregister);//ɾ������ǼǱ�
 public void deleteCharge(Charge charge);//�˷�
 public List<Map> findOffice();
 public List<Map> findStuff();
 public List<Map> findRegisteredtype();
 public void saveClinicregister(Clinicregister clinicregister);
 public void savePatients(Patients patients);
 public void saveCharge(Charge charge);
 public void updateIccard(Iccard ic);//�Һ��޸Ľ��
 public void updateClinicregister(Clinicregister clinicregister);
 public void updatePatients(Patients patients);
 public void updateCharge(Charge charge);
 public String getNewId();
 public List<Map> findRoles();
 public List<Map> findPosition();
 public List<Map> findJobtitle();
 public List<Map> findStufftype();
 public String getStuId();
 /*public void addStuff(Stuff list);//���Ա��
 public void addUsers(Usertable list2);//����û�
*/
 public void addStuffAndUsers(List<Stuff> list,List<Usertable> list2);
 }
