package com.aaa.dao;


import com.aaa.entity.Pager;

public interface DrugDao {
	/**
	 * 可以进行条件查询和分页
	 * @param pager 分页实体
	 * @param params 条件参数
	 * @return 分页实体
	 */
	public Pager findDurg(Pager pager,Object... params);
	
}
