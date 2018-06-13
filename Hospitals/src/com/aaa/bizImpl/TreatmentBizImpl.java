package com.aaa.bizImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.TreatmentBiz;
import com.aaa.dao.TreatmentDao;
import com.aaa.entity.Treatment;
@Service
public class TreatmentBizImpl implements TreatmentBiz {
@Resource
private TreatmentDao dao;

	public TreatmentDao getDao() {
	return dao;
}

public void setDao(TreatmentDao dao) {
	this.dao = dao;
}

	@Override
	public List<Treatment> findTreatment(String zjm) {
		// TODO Auto-generated method stub
		return dao.findTreatment(zjm);
	}

}
