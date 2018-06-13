package com.aaa.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.DrugBiz;
import com.aaa.dao.DrugDao;
import com.aaa.entity.Pager;
@Service
public class DrugBizImpl implements DrugBiz {
@Resource
private DrugDao dao;


	public DrugDao getDao() {
	return dao;
}


public void setDao(DrugDao dao) {
	this.dao = dao;
}

	@Override
	public Pager findDrug(Pager pager, Object... params) {
		// TODO Auto-generated method stub
		return dao.findDurg(pager, params);
	}

}
