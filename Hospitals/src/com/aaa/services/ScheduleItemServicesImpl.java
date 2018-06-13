package com.aaa.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.dao.ScheduleItemDao;
import com.aaa.entity.PageEntity;
import com.aaa.entity.Pager;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;
@Service
public class ScheduleItemServicesImpl implements ScheduleItemServices{
@Resource
private ScheduleItemDao scheduleItemDaoImpl;

	public ScheduleItemDao getScheduleItemDaoImpl() {
	return scheduleItemDaoImpl;
}

public void setScheduleItemDaoImpl(ScheduleItemDao scheduleItemDaoImpl) {
	this.scheduleItemDaoImpl = scheduleItemDaoImpl;
}

	public String select() {
		// TODO Auto-generated method stub
		return scheduleItemDaoImpl.select();
	}

	@Override
	public PageEntity findByPages(PageEntity pageEntity) {
		// TODO Auto-generated method stub
		return scheduleItemDaoImpl.findByPages(pageEntity);
	}

	@Override
	public String select1() {
		// TODO Auto-generated method stub
		return scheduleItemDaoImpl.select1();
	}

	@Override
	public String select2() {
		// TODO Auto-generated method stub
		return scheduleItemDaoImpl.select2();
	}

	@Override
	public void add(Stuff s) {
		// TODO Auto-generated method stub
		scheduleItemDaoImpl.add(s);
	}

	@Override
	public void save(Scheduleitem sitem) {
		// TODO Auto-generated method stub
		
		scheduleItemDaoImpl.save(sitem);
	}

	@Override
	public PageEntity findByPages2(PageEntity pageEntity, String name) {
		// TODO Auto-generated method stub
		return scheduleItemDaoImpl.findByPages2(pageEntity, name);
	}

	

	
	
	

	

}
