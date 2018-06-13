package com.aaa.action.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Iccard;
import com.aaa.entity.Patients;
import com.aaa.entity.Stuff;
import com.aaa.entity.Stufftype;
import com.aaa.entity.Usertable;
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
  private Iccard ic;
  private Clinicregister clinicregister;
  private Charge charge;
  private Pager pager;
  private int curPage;
  private int pageSize=4;
  private String target;
  private String menuIds;
  private List<Stuff> list;
  private List<Usertable> list2;
  //��ѯ����
  public void findAll(){
	  /*pager.setPageSize(1);*/
	  Pager p=ps.findByPagers(curPage, pageSize);
	  /*String str=JSONObject.fromObject(p).toString();//��ȡjson*/
	  //String str=JSON.toJSONString(p);
	  String st=JSON.toJSONStringWithDateFormat(p,"yyyy-MM-dd");
	  this.getPrintWriter().print(st);
	/*return this.SUCCESS;*/
	  
  }
  //��ӻ���
  public void saveOrUpdate(){
	  ps.saveOrUpdate(patients);
	  Message message=new Message(patients.getId(),"�����ɹ�!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //ͨ��Id�޸�
  public void findById(){
	  //int id=patients.getId();
	 Map map=ps.findById(patients);
	  String pp=JSON.toJSONString(map);
	  this.getPrintWriter().print(pp);
  }
  //ͨ��name����
  public void findByName(){
	  Map mapName=ps.findByName(patients);
	  String name=JSON.toJSONStringWithDateFormat(mapName,"yyyy-MM-dd");
	  this.getPrintWriter().print(name);
  }
  //ɾ��
  public void delete(){
	  ps.deleteClinicregister(clinicregister);
	  ps.deleteCharge(charge);
	  ps.delete(patients);
	  Message message=new Message(patients.getId(),"�����ɹ�!");
	  this.getPrintWriter().print(JSON.toJSON(message));
  }
  //ģ������
  public void findByKey(){
	  String keyList=ps.findByKey(patients.getPatientname());
	  this.getPrintWriter().print(keyList);
  }
  //��Ӳ��˹Һ�
  public void addOrupdate(){
	  System.out.println("clinicregister");
	  ps.savePatients(clinicregister.getPatients());
	  ps.saveCharge(clinicregister.getCharge());
	  ps.saveClinicregister(clinicregister);
	  ic.setPatients(clinicregister.getPatients());
	 
	  /*ic.setPatients(patients);*/
	  ps.updateIccard(ic);
	  Message message=new Message(clinicregister.getCharge().getCharge(),"�����ɹ�!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //�޸ĹҺ�
  public void updateGh(){
	  System.out.println("updateGh");
	  ps.updatePatients(clinicregister.getPatients());
	  ps.updateCharge(clinicregister.getCharge());
	  ps.updateClinicregister(clinicregister);
	  Message message=new Message(clinicregister.getRegisteredtype().getGhId(),"�����ɹ�!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  //��������
  public void getNewId(){
	  System.out.println("getNewId");
	  String id=ps.getNewId();
	  this.getPrintWriter().print(JSON.toJSONString(id));
  }
  //��ѯԱ�������ң������࣬
  public void findOk(){
	  List<Map> list=ps.findOffice();
	  String json=JSON.toJSONString(list);
	 
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
  //���Ա��-��ѯ��ɫ
  public void selectRolesAll(){
	  List<Map> rol=ps.findRoles();
	  String map=JSON.toJSONString(rol);
	  this.getPrintWriter().print(map);
  }
  //��ѯְ��
  public void findPosition(){
	  List<Map> list=ps.findPosition();
	  String ma=JSON.toJSONString(list);
	  System.out.println("��ѯְ��"+ma);
	  this.getPrintWriter().print(ma);
  }
  //��ѯְλ
  public void findJobtitle(){
	  List<Map> list=ps.findJobtitle();
	  String mp=JSON.toJSONString(list);
	  this.getPrintWriter().print(mp);
  }
  ////��ѯԱ������
  public void findStufftype(){
	  List<Map> list=ps.findStufftype();
	  String stu=JSON.toJSONString(list);
	  this.getPrintWriter().print(stu);
  }
//Ա����������
  public void getStuId(){
	  System.out.println("getStuId");
	  String id=ps.getStuId();
	  this.getPrintWriter().print(JSON.toJSONString(id));
  }
  //���Ա�����˻�
  public void addStuff(){
	  
	  ps.addStuffAndUsers(list, list2);
	  Message message=new Message(list2.size(),"�����ɹ�!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
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

public List<Stuff> getList() {
	return list;
}
public void setList(List<Stuff> list) {
	this.list = list;
}
public List<Usertable> getList2() {
	return list2;
}
public void setList2(List<Usertable> list2) {
	this.list2 = list2;
}
public Iccard getIc() {
	return ic;
}
public void setIc(Iccard ic) {
	this.ic = ic;
}
  
}
