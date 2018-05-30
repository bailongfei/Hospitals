package com.aaa.services;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.util.Pager;

public interface AdminService {
    public boolean adminLogin(String userName,String password);
    public	List findModules(String userName);
    public Pager findAllRolesByPager(int curPage,int pageSize);
    public void saveOrUpdate(Roles roles);
    public Map findByIdRoles(Roles roles);
    public void deleteRoles(Roles roles);
    public List findAllMenusByRoleId(int rolesId);
    public int addOrdeleteRolesModule(String menuIds,int rolesId);
}
