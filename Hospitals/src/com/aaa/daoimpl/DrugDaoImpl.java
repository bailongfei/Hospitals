package com.aaa.daoimpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.DrugDao;
import com.aaa.entity.Pager;
import com.aaa.util.PagerHelper;

@Repository
public class DrugDaoImpl implements DrugDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public Pager findDurg(Pager pager, Object... params) {

		String strWhere = " where d.zhuji like ? ";// 查询条件
		//String hql = " select new Map(d.did as did, d.dname as name, d.spec as spec,d.address.aname as address,d.dosageform.pname2 as dosage,d.doseunit.duname as dose,d.reatiPrice as price) from Drug as d  ";
		String hql = " select new Map(d.did as did, d.dname as dName,d.zhuji as zhuji, d.spec as spec,d.reatiPrice as price,a.aname as aName,dosa.dfName as dfName,dose.duName as duName) from Drug as d left join d.address as a left join d.dosageform as dosa left join d.doseunit as dose ";
		//String hql = " select new Map(d.did as did, d.dname as name,a.aname as address,d.reatiPrice as price) from Drug as d join d.address as a ";

		String hql1 = " select count(*) from Drug as d";
		//if (params != null && params.length > 0) {// 如果参数不为空，绑定查询条件
			hql += strWhere;
			hql1 += strWhere;
		//}
		Pager p = this.hibernateTemplate.execute(new PagerHelper(hql, hql1, params, pager.getCurPage(), pager.getPageSize()));
		return p;
	}

	
}
