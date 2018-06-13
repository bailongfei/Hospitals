package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.PrescribeBiz;
import com.aaa.dao.PrescribeDao;
import com.aaa.entity.Lop;
import com.aaa.entity.Prescribe;

@Service
public class PrescribeBizImpl implements PrescribeBiz {
	@Resource
	private PrescribeDao dao;

	public PrescribeDao getDao() {
		return dao;
	}

	public void setDao(PrescribeDao dao) {
		this.dao = dao;
	}

	// ѭ����Ӵ�����ϸ
	@Override
	public void addPrescribe(Prescribe prescribe, List<Lop> lopList) {
		// ��Ӵ���
		dao.addPrescribe(prescribe);
		for (int i = 0; i < lopList.size(); i++) {
			// ѭ��ȡ��lop
			Lop lop = lopList.get(i);
			// ���lop����ܱ�(prescribe)��id
			lop.setPrescribe(prescribe);
			// ��Ӹ���
			System.out.println("һ�Զ�");
			dao.addLop(lop);
		}
		/*
		 * for (Lop lop : lopList) { prescribe.getLops().add(lop);
		 * lop.setPrescribe(prescribe); } dao.addPrescribe(prescribe);
		 */
	}

	// ��ѯ������ϸ��
	@Override
	public List<Lop> findLop(int pid) {
		// TODO Auto-generated method stub
		return dao.findLop(pid);
	}

	// ɾ��������ϸ
	@Override
	public void deleteLop(Lop lop) {
		dao.deleteLop(lop);

	}

	// �޸Ĵ�����ϸ��
	@Override
	public void updateLop(Lop lop) {
		dao.updateLop(lop);
	}
}
