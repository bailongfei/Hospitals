package com.aaa.biz;

import com.aaa.entity.Pager;

public interface DrugBiz {
	/**
	 * ִ�з�ҳ��������ѯ����
	 * @param pager ��ҳ����
	 * @param params ��������
	 * @return ��ҳ����
	 */
	public Pager findDrug(Pager pager,Object... params);
}
