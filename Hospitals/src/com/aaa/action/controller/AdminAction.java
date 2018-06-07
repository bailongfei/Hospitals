package com.aaa.action.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.entity.Usertable;
import com.aaa.services.AdminService;
import com.aaa.util.BaseAction;
import com.aaa.util.Message;
import com.aaa.util.Pager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;
@Controller
public class AdminAction extends BaseAction{
	@Autowired
	private AdminService admin;
	private Roles roles;
	private Usertable user;
	private String adminUrl;
	private int curPage;
	private int pageSize=2;
	private Date day1;
	private Date day2;
  public String adminLogin(){
	  System.out.println("login");
	  boolean result=admin.adminLogin(user.getUserName(),user.getPassword());
	  System.out.println("login:"+result);
	  if(result==true){
		 System.out.println("log:"+result);
		this.getSession().put("adminUsers",user.getUserName());
		String res=JSON.toJSONString(result);
		System.out.println(res);
		this.getPrintWriter().print(res);
		adminUrl="/hospital/html/index.jsp";
		return "adminUrlss";
	  }
	  this.getPrintWriter().print(JSON.toJSONString(result));
	  adminUrl="/hospital/html/login.jsp";
	  return "adminUrlss";
	
	
  }
  
  //权限查询
  public String Rightt(){
	  List list=admin.findModules(user.getUserName());
	  this.getRequest().put("list",list);
    adminUrl="/hospital/html/leftss.jsp";  
	return "Rightt";
  }
  //角色管理
  public void findAllRoles(){
	  Pager p=admin.findAllRolesByPager(curPage, pageSize);
	  String list=JSON.toJSONString(p);
	  this.getPrintWriter().print(list);
  }
  public void saveOrUpdate(){
	  admin.saveOrUpdate(roles);
	  Message message=new Message(roles.getRolesId(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSONString(message));
  }
  public void findById(){
	  Map map=admin.findByIdRoles(roles);
	  String mp=JSON.toJSONString(map);
	  this.getPrintWriter().print(mp);
  }
  public void deleteRoles(){
	  admin.deleteRoles(roles);
	  Message message=new Message(roles.getRolesId(),"操作成功!");
	  this.getPrintWriter().print(JSON.toJSONString(message)); 
	  
  }
   //报表查询
  public void selectChange(){
	  List params=admin.findRegisteredtype();
	  List list=admin.findByDate(day1, day2, params);
	  String change=JSONArray.toJSONString(list);
	  this.getPrintWriter().print(change);
  }
  //科室报表
  public void selectKeshi(){
	  List params=admin.findRegisteredtype();
	  List list=admin.findByDateKeShi(day1, day2, params);
	  String map=JSONArray.toJSONString(list);
	  this.getPrintWriter().print(map);
  }
public Usertable getUser() {
	return user;
}
public void setUser(Usertable user) {
	this.user = user;
}
public String getAdminUrl() {
	return adminUrl;
}
public void setAdminUrl(String adminUrl) {
	this.adminUrl = adminUrl;
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

public Roles getRoles() {
	return roles;
}

public void setRoles(Roles roles) {
	this.roles = roles;
}

public Date getDay1() {
	return day1;
}

public void setDay1(Date day1) {
	this.day1 = day1;
}

public Date getDay2() {
	return day2;
}

public void setDay2(Date day2) {
	this.day2 = day2;
}
  
}
