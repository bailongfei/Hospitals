package com.aaa.servicesimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.daoimpl.ResultDaoImpl;
import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationresult;
import com.aaa.entity.Patients;
import com.aaa.services.ResultService;
@Service
public class ResultServiceImpl implements ResultService {
	@Resource
 private ResultDaoImpl dao;
	
	public ResultDaoImpl getDao() {
		return dao;
	}

	public void setDao(ResultDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Object[]> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public Patients selectbyid(int jcjId) {
		// TODO Auto-generated method stub
		return dao.selectbyid(jcjId);
	}

	@Override
	public void insert(Applicationresult result) {
		// TODO Auto-generated method stub
		dao.insert(result);
	}

}
