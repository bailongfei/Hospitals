package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

public interface PrescribeDao {
	// 添加处方表
	public void addPrescribe(Prescribe prescribe);

	// 添加处方明细
	public void addLop(Lop lop);

	// 查询处方明细
	public List<Lop> findLop(int pid);

	// 删除单条处方明细
	public void deleteLop(Lop lop);

	// 修改明细表
	public void updateLop(Lop lop);
}
