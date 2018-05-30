package com.aaa.servicesimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.AdminDao;
import com.aaa.entity.Modules;
import com.aaa.entity.Roles;
import com.aaa.entity.Rolesmodule;
import com.aaa.services.AdminService;
import com.aaa.util.Pager;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
  private AdminDao dao;
	
	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean adminLogin(String userName, String password) {
		
		return dao.adminLogin(userName, password);
	}

	@Override
	public List findModules(String userName) {
		
		return dao.findModules(userName);
	}

	@Override
	public Pager findAllRolesByPager(int curPage, int pageSize) {
		
		return dao.findAllRolesByPager(curPage, pageSize);
	}

	@Override
	public void saveOrUpdate(Roles roles) {
		if(roles.getRolesId()!=null&&roles.getRolesId()>0){
			dao.updateRoles(roles);
		}else{
			dao.saveRoles(roles);
		}
		
	}

	@Override
	public Map findByIdRoles(Roles roles) {
		
		return dao.findByIdRoles(roles);
	}

	@Override
	public void deleteRoles(Roles roles) {
		dao.deleteRoles(roles);
		
	}

	@Override
	public List findAllMenusByRoleId(int rolesId) {
		
		return dao.findAllMenusByRoleId(rolesId);
	}

	@Transactional
	@Override
	public int addOrdeleteRolesModule(String menuIds,int rolesId) {
		int result=-1;//结果
		//思路分析：先删除该角色id对应的中间 表中所有数据，再把需要录入的数据录入到中间表
		if(menuIds!=null&&menuIds.length()>0){
			dao.deleteRolesModule(rolesId);//先删除
			String[] idAry=menuIds.split(",");//分割
			for (int i = 0; i < idAry.length; i++) {
				//菜单对象
				Modules mo=new Modules();
				mo.setModulesId(idAry[i]);
				//角色对象
				Roles ro=new Roles();
				ro.setRolesId(rolesId);
				//创建中间表对象
				Rolesmodule rm=new Rolesmodule();
				rm.setModules(mo);
				rm.setRoles(ro);
				//插入中间表对象
				dao.saveRolesModule(rm);
				result++;
			}
		}
		return result;
	}

	

}
