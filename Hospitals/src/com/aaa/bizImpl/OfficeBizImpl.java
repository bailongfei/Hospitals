package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.OfficeBiz;
import com.aaa.dao.OfficeDao;
import com.aaa.entity.Office;

@Service
public class OfficeBizImpl implements OfficeBiz {
	@Resource
	private OfficeDao dao;

	public OfficeDao getDao() {
		return dao;
	}

	public void setDao(OfficeDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Office> findOffice() {
		// TODO Auto-generated method stub
		return dao.findOffice();
	}

}
