package com.aaa.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.AppItemDao;
import com.aaa.entity.Appiteminfo;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;

@Repository
public class AppItemDaoImpl implements AppItemDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 查询检查项目
	@Override
	public List<Applicationitem> findAppItem() {
		List<Applicationitem> list = this.hibernateTemplate.find("select new Map(a.jcxId as jcxId,a.name as name) from Applicationitem as a");
		return list;
	}

	// 添加申请检查表
	@Override
	public void addAppItem(Applicationform application) {
		this.hibernateTemplate.save(application);

	}
//查询检查申请
	@Override
	public List<Applicationform> findApplication(int pid) {
		//List<Applicationform> list=this.hibernateTemplate.find("select new Map(a.jcId as jcid , a.patients.pid as pid,a.applicationitem.jcxId as aid, a.applicationitem.name as aname,a.checkPoint as point,a.mainInfo as info,a.goal as goal,a.state as state) from Applicationform as a where a.patients.pid='"+pid+"'");
		List<Applicationform> list=this.hibernateTemplate.find("select new Map(a.jcId as jcid , p.id as pid,ai.jcxId as aid, ai.name as aname,a.checkPoint as point,a.mainInfo as info,a.goal as goal,a.state as state) from Applicationform as a left join a.patients as p left join a.applicationitem as ai where p.id='"+pid+"'");
		return list;
	}
	//查询检查项目详情
	@Override
	public List<Appiteminfo> findAppItemInfo(int jcxId) {
		List<Appiteminfo> list=this.hibernateTemplate.find("select new Map(a.aid as aid,a.aname as aname,a.applicationitem.jcxId as jcxId,a.count as count,a.price as price) from Appiteminfo as a where a.applicationitem.jcxId='"+jcxId+"'");
		return list;
	}

}
