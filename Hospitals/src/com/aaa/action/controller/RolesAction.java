package com.aaa.action.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Roles;
import com.aaa.services.AdminService;
import com.aaa.util.BaseAction;
import com.aaa.util.Message;
import com.alibaba.fastjson.JSON;

@Repository
public class RolesAction extends BaseAction{
	@Autowired
	private AdminService admin;
	private Roles roles;
	private String rolesUrl;
	private String menuIds;
	//查询所有权限模块
   public void findAllModules(){
	   System.out.println("findAllModules");
	   List list=admin.findAllMenusByRoleId(roles.getRolesId());
	   String ro=JSON.toJSONString(list);
	   System.out.println("MOdulesJSONTO"+ro);
	   this.getPrintWriter().print(ro);
   }
   //修改权限--删除所有再添加
   public void allotRight(){
	   int result=admin.addOrdeleteRolesModule(menuIds,roles.getRolesId());
	   Message me=new Message();
	   me.setState(result);
	   if(result>0){
		   me.setMessage("操作成功!");
	   }else{
		   me.setMessage("操作失败!");
	   }
	   this.getPrintWriter().print(JSON.toJSONString(me));
   }
   
public Roles getRoles() {
	return roles;
}
public void setRoles(Roles roles) {
	this.roles = roles;
}
public String getRolesUrl() {
	return rolesUrl;
}
public void setRolesUrl(String rolesUrl) {
	this.rolesUrl = rolesUrl;
}
public String getMenuIds() {
	return menuIds;
}
public void setMenuIds(String menuIds) {
	this.menuIds = menuIds;
}
   
}
