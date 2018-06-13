package com.aaa.biz;

import com.aaa.entity.Pager;

public interface DrugBiz {
	/**
	 * 执行分页和条件查询操作
	 * @param pager 分页参数
	 * @param params 参数集合
	 * @return 分页对象
	 */
	public Pager findDrug(Pager pager,Object... params);
}
