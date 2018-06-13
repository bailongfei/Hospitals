package com.aaa.dao;

import java.util.List;

import com.aaa.entity.PageEntity;
import com.aaa.entity.Pager;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;



//排班明细
public interface ScheduleItemDao {
	//排班明细查询
	 public String select();
	 //分页
	 public PageEntity findByPages(PageEntity pageEntity);
	 public PageEntity findByPages2(PageEntity pageEntity,String name);
	 //添加排班明细
	 public void save(Scheduleitem sitem);

	 //根据医生姓名查询
	 //查询人员
	 public String select1();
	 //添加人员
	 public void add(Stuff s);
	 //类型查询
	 public String select2();
	 
	
	
}
