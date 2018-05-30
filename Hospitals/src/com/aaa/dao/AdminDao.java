package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.entity.Rolesmodule;
import com.aaa.util.Pager;

public interface AdminDao {
	//����Ա��½
	public boolean adminLogin(String userName,String password);
	//��Ȩ�޲�ѯ��ӵ�е�ģ��
    public	List findModules(String userName);
    //��ѯ���н�ɫ
    public Pager findAllRolesByPager(int curPage,int pageSize);
    //��ӽ�ɫ
    public void saveRoles(Roles roles);
    //�޸�
    public Map findByIdRoles(Roles roles);
    public void updateRoles(Roles roles);
    //ɾ��
    public void deleteRoles(Roles roles);
  //��ѯ���в˵������ȡ����Ӧ��ɫ��ŵĲ˵�
    public List findAllMenusByRoleId(int rolesId);
  //ɾ���м����ָ����ɫid��Ӧ������
    public void deleteRolesModule(int rolesId);
  //����ɫ�˵��м���в�������
    public void saveRolesModule(Rolesmodule rolModue);
}
