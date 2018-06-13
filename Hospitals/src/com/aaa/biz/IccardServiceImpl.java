package com.aaa.biz;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.ICcardDao;
import com.aaa.entity.Iccard;
import com.aaa.util.Pager;
@Service
public class IccardServiceImpl implements IccardService{
	@Autowired
	private ICcardDao iccarddao;

	public ICcardDao getIccarddao() {
		return iccarddao;
	}

	public void setIccarddao(ICcardDao iccarddao) {
		this.iccarddao = iccarddao;
	}
@Transactional
	@Override
	public void addICcard(Iccard i) {
		// TODO Auto-generated method stub
		iccarddao.addICcard(i);
	}

@Override
public List<Iccard> select() {
	// TODO Auto-generated method stub
	return iccarddao.select();
}



@Override
public Map findById(int icid) {
	// TODO Auto-generated method stub
	return iccarddao.findById(icid);
}

@Override
public void saveOrUpdate(Iccard i) {
	// TODO Auto-generated method stub
	if(i.getIcid()!=null&&i.getIcid()>0){
		iccarddao.update(i);
	}else{
		iccarddao.addICcard(i);;
	}
}

//wk
public List<Iccard> selname(String name){
	
	return iccarddao.selname(name);
	
	
}

@Override
public List<Iccard> selectAll() {
	// TODO Auto-generated method stub
	return iccarddao.selectAll();
}

@Override
public List<Iccard> selectname(String name) {
	// TODO Auto-generated method stub
	return iccarddao.selectname(name);
}

@Override
public Map ICfindById(int icid) {
	// TODO Auto-generated method stub
	return iccarddao.ICfindById(icid);
}

@Override
public void updateiccard(int icid, int money) {
	// TODO Auto-generated method stub
	iccarddao.updateiccard(icid, money);
}

@Override
public void delIc(int icid) {
	// TODO Auto-generated method stub
	iccarddao.delIc(icid);
}


	

}
