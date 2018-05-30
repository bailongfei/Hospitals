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
	//��ѯ����Ȩ��ģ��
   public void findAllModules(){
	   System.out.println("findAllModules");
	   List list=admin.findAllMenusByRoleId(roles.getRolesId());
	   String ro=JSON.toJSONString(list);
	   System.out.println("MOdulesJSONTO"+ro);
	   this.getPrintWriter().print(ro);
   }
   //�޸�Ȩ��--ɾ�����������
   public void allotRight(){
	   int result=admin.addOrdeleteRolesModule(menuIds,roles.getRolesId());
	   Message me=new Message();
	   me.setState(result);
	   if(result>0){
		   me.setMessage("�����ɹ�!");
	   }else{
		   me.setMessage("����ʧ��!");
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
