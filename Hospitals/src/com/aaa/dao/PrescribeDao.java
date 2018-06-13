package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

public interface PrescribeDao {
	// ��Ӵ�����
	public void addPrescribe(Prescribe prescribe);

	// ��Ӵ�����ϸ
	public void addLop(Lop lop);

	// ��ѯ������ϸ
	public List<Lop> findLop(int pid);

	// ɾ������������ϸ
	public void deleteLop(Lop lop);

	// �޸���ϸ��
	public void updateLop(Lop lop);
}
