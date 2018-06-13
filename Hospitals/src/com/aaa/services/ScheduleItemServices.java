package com.aaa.services;

import java.util.List;

import com.aaa.entity.PageEntity;
import com.aaa.entity.Pager;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;



public interface ScheduleItemServices {
	//排班明细查询
	
		public String select();
		public PageEntity findByPages(PageEntity pageEntity);
		 public PageEntity findByPages2(PageEntity pageEntity,String name);
		//添加修改排班明细
		public void save(Scheduleitem sitem);
		 //查询人员
		 public String select1();
		 //添加人员
		 public void add(Stuff s);
		 //类型查询
		 public String select2();
}
