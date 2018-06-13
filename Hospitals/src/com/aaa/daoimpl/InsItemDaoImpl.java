package com.aaa.daoimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.InsItemDao;
import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;

@Repository
public class InsItemDaoImpl implements InsItemDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// 查询检验类目表
	@Override
	public List<Inspectionitem> findInsItem() {
		List<Inspectionitem> list = this.hibernateTemplate.find("select new Map(i.jyxId as jyxId,i.name as name) from Inspectionitem i");
		return list;
	}

	// 添加检验表信息
	@Override
	public void addInsItem(Inspection inspection) {
		this.hibernateTemplate.save(inspection);

	}
    //查询检查申请表
	@Override
	public List<Inspection> findInspection(int patientsid) {
		List<Inspection> list=this.hibernateTemplate.find("select new Map(a.jyId as jcid , p.id as pid,ai.jyxId as aid, ai.name as aname,a.checkPoint as point,a.maininfo as info,a.goal as goal,a.state as state) from Inspection as a left join a.patients as p left join a.inspectionitem as ai where p.id='"+patientsid+"'");
		return list;
	}
	// 检验类目子类目查询
	@Override
	public List<Insiteminfo> findInsItemInfo(int jyxId) {
		List<Insiteminfo> list=this.hibernateTemplate.find("select new Map(i.iid as iid,i.iname as iname,i.count as count,i.price as price,i.inspectionitem.jyxId as jyxId) from Insiteminfo as i where i.inspectionitem.jyxId='"+jyxId+"'");
		return list;
	}

}
