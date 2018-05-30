package com.aaa.action.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Patients;
import com.aaa.services.PatientsService;
import com.aaa.util.BaseAction;
import com.aaa.util.Message;
import com.aaa.util.Pager;
import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PatientsAction extends BaseAction{
  @Autowired
  private PatientsService ps;
  private Patients patients; 
  private Clinicregister clinicregister;
  private Charge charge;
  private Pager pager;
  private int curPage;
  private int pageSize=2;
  private String target;
  private String menuIds;
  //查询患者
  public void findAll(){
	  /*pager.setPageSize(1);*/
	  Pager p=ps.findByPagers(curPage, pageSize);
	  /*String str=JSONObject.fromObject(p).toString();//获取json*/
	  String str=JSON.toJSONString(p);
	  this.getPrintWriter().print(str);
	/*return this.SUCCESS;*/
	  
  }
  //添加患者
  public void saveOrUpdate(){
	  ps.saveOrUpdate(patients);
	  Message message=new Message(patients.getId(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //通过Id修改
  public void findById(){
	  //int id=patients.getId();
	 Map map=ps.findById(patients);
	  String pp=JSON.toJSONString(map);
	  this.getPrintWriter().print(pp);
  }
  //通过name查找
  public void findByName(){
	  Map mapName=ps.findByName(patients);
	  String name=JSON.toJSONString(mapName);
	  System.out.println(name);
	  this.getPrintWriter().print(name);
  }
  //删除
  public void delete(){
	  ps.deleteClinicregister(clinicregister);
	  ps.deleteCharge(charge);
	  ps.delete(patients);
	  Message message=new Message(patients.getId(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSON(message));
  }
  //模糊搜索
  public void findByKey(){
	  String keyList=ps.findByKey(patients.getPatientname());
	  this.getPrintWriter().print(keyList);
  }
  //添加病人挂号
  public void addOrupdate(){
	  System.out.println("clinicregister");
	  
	  ps.savePatients(clinicregister.getPatients());
	  ps.saveCharge(clinicregister.getCharge());
	  ps.saveClinicregister(clinicregister);
	  Message message=new Message(clinicregister.getCharge().getCharge(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //修改挂号
  public void updateGh(){
	  System.out.println("updateGh");
	  ps.updatePatients(clinicregister.getPatients());
	  ps.updateCharge(clinicregister.getCharge());
	  ps.updateClinicregister(clinicregister);
	  Message message=new Message(clinicregister.getRegisteredtype().getGhId(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //自增序列
  public void getNewId(){
	  System.out.println("getNewId");
	  String id=ps.getNewId();
	  this.getPrintWriter().print(JSON.toJSONString(id));
  }
  //查询员工，科室，科室类，
  public void findOk(){
	  List<Map> list=ps.findOffice();
	  String json=JSON.toJSONString(list);
	  System.out.println(json);
	  this.getPrintWriter().print(json);
  }
  public void findStuff(){
	  List<Map> sut=ps.findStuff();
	  String su=JSON.toJSONString(sut);
	  this.getPrintWriter().print(su);
  }
  public void findRdy(){
	  List<Map> rgs=ps.findRegisteredtype();
	  String rg=JSON.toJSONString(rgs);
	  this.getPrintWriter().print(rg);
  }
public Patients getPatients() {
	return patients;
}
public void setPatients(Patients patients) {
	this.patients = patients;
}
public Pager getPager() {
	return pager;
}
public void setPager(Pager pager) {
	this.pager = pager;
}
public int getCurPage() {
	return curPage;
}
public void setCurPage(int curPage) {
	this.curPage = curPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public String getTarget() {
	return target;
}
public void setTarget(String target) {
	this.target = target;
}
public String getMenuIds() {
	return menuIds;
}
public void setMenuIds(String menuIds) {
	this.menuIds = menuIds;
}
public Clinicregister getClinicregister() {
	return clinicregister;
}
public void setClinicregister(Clinicregister clinicregister) {
	this.clinicregister = clinicregister;
}
public Charge getCharge() {
	return charge;
}
public void setCharge(Charge charge) {
	this.charge = charge;
}
  
}
