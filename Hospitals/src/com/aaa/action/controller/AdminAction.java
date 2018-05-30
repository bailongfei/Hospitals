package com.aaa.action.controller;

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
 /*//查询权限
  public void findAllModules(){
	  System.out.println("findAllModules");
	  List list=admin.findAllMenusByRoleId(roles.getRolesId());
	  String mo=JSON.toJSONString(list);
	  System.out.println(mo);
	  this.getPrintWriter().print(mo);
  }*/
  
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
  
}
