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
   public Pager findByPages(int curPage,int pageSize);//分页查询
   public void save(Patients patients);
   public void update(Patients patients);
   public Map findById(Patients patients);
   public void delete(Patients patients);//删除患者
   public List<String> findByKey(String key);//模糊收索
   public Map findByName(Patients patients);
   public void deleteClinicregister(Clinicregister clinicregister);//删除门诊登记表
   public void deleteCharge(Charge charge);//退费
   public List<Map> findOffice();//查询科室
   public List<Map> findStuff();
   public List<Map> findRegisteredtype();
   public void saveClinicregister(Clinicregister clinicregister);//添加挂号
   public void savePatients(Patients patients);
   public void saveCharge(Charge charge);
   public void updateClinicregister(Clinicregister clinicregister);//修改挂号
   public void updatePatients(Patients patients);
   public void updateCharge(Charge charge);
   public String getNewId();//制动生成ID
   public List<Map> findRoles();//查询角色
   public List<Map> findPosition();//查询职务
   public List<Map> findJobtitle();//查询职位
   public List<Map> findStufftype();//查询员工类型
   public String getStuId();//添加员工生成ID
   public void addStuff(Stuff list);//添加员工
   public void addUsers(Usertable list2);//添加用户
}
