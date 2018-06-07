package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Patients;
import com.aaa.entity.Stuff;
import com.aaa.entity.Usertable;
import com.aaa.util.Pager;

public interface PatientsDao {
   public Pager findByPages(int curPage,int pageSize);//��ҳ��ѯ
   public void save(Patients patients);
   public void update(Patients patients);
   public Map findById(Patients patients);
   public void delete(Patients patients);//ɾ������
   public List<String> findByKey(String key);//ģ������
   public Map findByName(Patients patients);
   public void deleteClinicregister(Clinicregister clinicregister);//ɾ������ǼǱ�
   public void deleteCharge(Charge charge);//�˷�
   public List<Map> findOffice();//��ѯ����
   public List<Map> findStuff();
   public List<Map> findRegisteredtype();
   public void saveClinicregister(Clinicregister clinicregister);//��ӹҺ�
   public void savePatients(Patients patients);
   public void saveCharge(Charge charge);
   public void updateClinicregister(Clinicregister clinicregister);//�޸ĹҺ�
   public void updatePatients(Patients patients);
   public void updateCharge(Charge charge);
   public String getNewId();//�ƶ�����ID
   public List<Map> findRoles();//��ѯ��ɫ
   public List<Map> findPosition();//��ѯְ��
   public List<Map> findJobtitle();//��ѯְλ
   public List<Map> findStufftype();//��ѯԱ������
   public String getStuId();//���Ա������ID
   public void addStuff(Stuff list);//���Ա��
   public void addUsers(Usertable list2);//����û�
}
