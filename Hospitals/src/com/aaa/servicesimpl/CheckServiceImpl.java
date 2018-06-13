package com.aaa.servicesimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.daoimpl.CheckDaoImpl;
import com.aaa.entity.Applicationform;
import com.aaa.services.CheckService;
import com.aaa.util.Pager;
@Service
public class CheckServiceImpl implements CheckService {
   @Resource
	private CheckDaoImpl dao;




	@Override
	public List<Object[]> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}
	@Override
	public Pager findByPagers(int curPage, int pageSize) {
		
		return dao.findByPages(curPage, pageSize);
	}
	@Override
	public Applicationform selectbyid(int jcId) {
		// TODO Auto-generated method stub
		return dao.selectbyid(jcId);
	}
	@Override
	public void update(Applicationform app) {
		// TODO Auto-generated method stub
		dao.update(app);
	}
	@Override
	public void updateIccard(int id,int money) {
		dao.updateIccard(id, money);
		
	}
	@Override
	public Map findMoney(int id) {
		
		return dao.findMoney(id);
	}

}
