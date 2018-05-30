package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.entity.Rolesmodule;
import com.aaa.util.Pager;

public interface AdminDao {
	//管理员登陆
	public boolean adminLogin(String userName,String password);
	//按权限查询所拥有的模块
    public	List findModules(String userName);
    //查询所有角色
    public Pager findAllRolesByPager(int curPage,int pageSize);
    //添加角色
    public void saveRoles(Roles roles);
    //修改
    public Map findByIdRoles(Roles roles);
    public void updateRoles(Roles roles);
    //删除
    public void deleteRoles(Roles roles);
  //查询所有菜单项，并获取到对应角色编号的菜单
    public List findAllMenusByRoleId(int rolesId);
  //删除中间表中指定角色id对应的数据
    public void deleteRolesModule(int rolesId);
  //往角色菜单中间表中插入数据
    public void saveRolesModule(Rolesmodule rolModue);
}
