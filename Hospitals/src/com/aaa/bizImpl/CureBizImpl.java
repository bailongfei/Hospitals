package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.CureBiz;
import com.aaa.dao.CureDao;
import com.aaa.entity.Cure;

@Service
public class CureBizImpl implements CureBiz {
	@Resource
	private CureDao dao;

	public CureDao getDao() {
		return dao;
	}

	public void setDao(CureDao dao) {
		this.dao = dao;
	}

	public void addCure(List<Cure> list) {
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			dao.addCure(list.get(i));
		}

	}

}
