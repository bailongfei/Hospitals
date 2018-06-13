package com.aaa.daoimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.dao.PrescribeDao;
import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

@Repository
public class PrescribeDaoImpl implements PrescribeDao {
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	// ��Ӵ�����
	@Override
	public void addPrescribe(Prescribe prescribe) {
		this.hibernateTemplate.save(prescribe);
	}

	// ��Ӵ�����ϸ
	@Override
	public void addLop(Lop lop) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(lop);
	}

	// ������ϸ��ѯ
	@Override
	public List<Lop> findLop(int pid) {
		return this.hibernateTemplate.find("select new Map(l.lid as lid,l.drug.did as did,l.drug.dname as dname,l.gg as gg,l.dw as dw,l.sl as sl) from Lop as l where l.prescribe.patients.id='" + pid + "'");
	}

	// ɾ������������ϸ
	@Override
	public void deleteLop(Lop lop) {
		this.hibernateTemplate.delete(lop);
	}

	// �޸Ĵ�����ϸ
	@Override
	public void updateLop(final Lop lop) {
		this.hibernateTemplate.bulkUpdate("update Lop as lop set lop.sl=? where lop.lid=?", lop.getSl(), lop.getLid());
	}

}
