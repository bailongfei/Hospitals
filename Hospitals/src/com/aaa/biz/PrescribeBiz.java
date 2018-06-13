package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

public interface PrescribeBiz {
	// ѭ����Ӵ�����ϸ
	public void addPrescribe(Prescribe prescribe, List<Lop> lopList);

	// ��ѯ������ϸ
	public List<Lop> findLop(int pid);

	// ɾ����������
	public void deleteLop(Lop lop);

	// �޸Ĵ�����ϸ
	public void updateLop(Lop lop);
}
