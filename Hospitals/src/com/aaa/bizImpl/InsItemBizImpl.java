package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.InsItemBiz;
import com.aaa.dao.InsItemDao;
import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;

@Service
public class InsItemBizImpl implements InsItemBiz {
	@Resource
	private InsItemDao dao;

	public InsItemDao getDao() {
		return dao;
	}

	public void setDao(InsItemDao dao) {
		this.dao = dao;
	}

	// ������Ŀ�Ĳ�ѯ
	@Override
	public List<Inspectionitem> findInsItem() {
		return dao.findInsItem();
	}

	// ��Ӽ��������
	@Override
	public void addInsItem(Inspection inspection) {
		dao.addInsItem(inspection);
	}

	// ��ѯ���������
	@Override
	public List<Inspection> findInspection(int patientsid) {
		// TODO Auto-generated method stub
		return dao.findInspection(patientsid);
	}

	@Override
	public List<Insiteminfo> findInsItemInfo(int jyxId) {
		// TODO Auto-generated method stub
		return dao.findInsItemInfo(jyxId);
	}

}
