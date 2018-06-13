package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Iccard;
import com.aaa.util.Pager;

public interface ICcardDao {
	//查询
	public List<Iccard> select();
//办卡
	public void addICcard(Iccard i);
	  //通过id查询
	public Map findById(int icid);
		   //修改
	public void update(Iccard i);

	//wk 条件查询
	public List<Iccard> selname(String name);
		   //充值，查询
		   public List<Iccard> selectAll();
		 //充值，条件查询
		   public List<Iccard> selectname(String name);
		 //充值  id查询
			public Map ICfindById(int icid);
			/*充值后修改该金额*/
			public  void updateiccard(int icid,int money);
			//删除
			public void delIc(int icid);   
}
