package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Appiteminfo;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;

public interface AppItemBiz {
	// ��ѯ�����Ŀ
	public List<Applicationitem> findAppItem();

	// ��Ӽ������
	public void addAppItem(Applicationform application);

	// ��ѯ��������
	public List<Applicationform> findApplication(int pid);

	// ��ѯ�����Ŀ����
	public List<Appiteminfo> findAppItemInfo(int jcxId);
}
