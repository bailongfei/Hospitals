package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;

public interface InsItemDao {
	// ������Ŀ��ѯ
	public List<Inspectionitem> findInsItem();

	// ��Ӽ�����������Ϣ
	public void addInsItem(Inspection inspection);

	// ���������ѯ
	public List<Inspection> findInspection(int patientsid);

	// ������Ŀ����Ŀ��ѯ
	public List<Insiteminfo> findInsItemInfo(int jyxId);
}
