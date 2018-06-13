package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

public interface PrescribeBiz {
	// 循环添加处方明细
	public void addPrescribe(Prescribe prescribe, List<Lop> lopList);

	// 查询处方明细
	public List<Lop> findLop(int pid);

	// 删除处方详情
	public void deleteLop(Lop lop);

	// 修改处方明细
	public void updateLop(Lop lop);
}
