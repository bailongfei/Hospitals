package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Appiteminfo;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;

public interface AppItemDao {
	// 查询检查项目
	public List<Applicationitem> findAppItem();

	// 添加检查申请
	public void addAppItem(Applicationform application);

	// 查询检查申请表
	public List<Applicationform> findApplication(int pid);

	// 查询检查项目详情
	public List<Appiteminfo> findAppItemInfo(int jcxId);
}
