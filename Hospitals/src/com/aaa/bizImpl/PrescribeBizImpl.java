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

	// 循环添加处方明细
	@Override
	public void addPrescribe(Prescribe prescribe, List<Lop> lopList) {
		// 添加处方
		dao.addPrescribe(prescribe);
		for (int i = 0; i < lopList.size(); i++) {
			// 循环取出lop
			Lop lop = lopList.get(i);
			// 添加lop外键总表(prescribe)的id
			lop.setPrescribe(prescribe);
			// 添加副表
			System.out.println("一对多");
			dao.addLop(lop);
		}
		/*
		 * for (Lop lop : lopList) { prescribe.getLops().add(lop);
		 * lop.setPrescribe(prescribe); } dao.addPrescribe(prescribe);
		 */
	}

	// 查询处方明细表
	@Override
	public List<Lop> findLop(int pid) {
		// TODO Auto-generated method stub
		return dao.findLop(pid);
	}

	// 删除处方明细
	@Override
	public void deleteLop(Lop lop) {
		dao.deleteLop(lop);

	}

	// 修改处方明细表
	@Override
	public void updateLop(Lop lop) {
		dao.updateLop(lop);
	}
}
