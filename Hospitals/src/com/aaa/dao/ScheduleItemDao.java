package com.aaa.dao;

import java.util.List;

import com.aaa.entity.PageEntity;
import com.aaa.entity.Pager;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;



//�Ű���ϸ
public interface ScheduleItemDao {
	//�Ű���ϸ��ѯ
	 public String select();
	 //��ҳ
	 public PageEntity findByPages(PageEntity pageEntity);
	 public PageEntity findByPages2(PageEntity pageEntity,String name);
	 //����Ű���ϸ
	 public void save(Scheduleitem sitem);

	 //����ҽ��������ѯ
	 //��ѯ��Ա
	 public String select1();
	 //�����Ա
	 public void add(Stuff s);
	 //���Ͳ�ѯ
	 public String select2();
	 
	
	
}
