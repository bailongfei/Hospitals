package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;

public interface InsItemBiz {
	// ������Ŀ��ѯ
	public List<Inspectionitem> findInsItem();

	// ��Ӽ�����������Ϣ
	public void addInsItem(Inspection inspection);

	// ���������ѯ
	public List<Inspection> findInspection(int patientsid);

	// ������Ŀ����Ŀ��ѯ
	public List<Insiteminfo> findInsItemInfo(int jyxId);
}
