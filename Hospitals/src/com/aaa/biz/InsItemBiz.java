package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Insiteminfo;
import com.aaa.entity.Inspection;
import com.aaa.entity.Inspectionitem;

public interface InsItemBiz {
	// 检验类目查询
	public List<Inspectionitem> findInsItem();

	// 添加检验申请表的信息
	public void addInsItem(Inspection inspection);

	// 检验申请查询
	public List<Inspection> findInspection(int patientsid);

	// 检验类目子类目查询
	public List<Insiteminfo> findInsItemInfo(int jyxId);
}
