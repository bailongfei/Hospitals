package com.aaa.dao;


import com.aaa.entity.Pager;

public interface DrugDao {
	/**
	 * ���Խ���������ѯ�ͷ�ҳ
	 * @param pager ��ҳʵ��
	 * @param params ��������
	 * @return ��ҳʵ��
	 */
	public Pager findDurg(Pager pager,Object... params);
	
}
