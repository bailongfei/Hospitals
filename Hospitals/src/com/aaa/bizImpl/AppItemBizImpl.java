package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.AppItemBiz;
import com.aaa.dao.AppItemDao;
import com.aaa.entity.Appiteminfo;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;

@Service
public class AppItemBizImpl implements AppItemBiz {
	@Resource
	private AppItemDao dao;

	public AppItemDao getDao() {
		return dao;
	}

	public void setDao(AppItemDao dao) {
		this.dao = dao;
	}

	// 查询检查项目
	@Override
	public List<Applicationitem> findAppItem() {
		// TODO Auto-generated method stub
		return dao.findAppItem();
	}

	// 添加检查项目表
	@Override
	public void addAppItem(Applicationform application) {
		dao.addAppItem(application);
	}

	// 查询检查申请
	@Override
	public List<Applicationform> findApplication(int pid) {
		// TODO Auto-generated method stub
		return dao.findApplication(pid);
	}

	// 查询检查项目详情
	@Override
	public List<Appiteminfo> findAppItemInfo(int jcxId) {
		// TODO Auto-generated method stub
		return dao.findAppItemInfo(jcxId);
	}

}
