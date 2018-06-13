package com.aaa.servicesimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaa.dao.PatientsDao;
import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Iccard;
import com.aaa.entity.Patients;
import com.aaa.entity.Stuff;
import com.aaa.entity.Stufftype;
import com.aaa.entity.Usertable;
import com.aaa.services.PatientsService;
import com.aaa.util.Pager;
@Service
public class PatientsServiceImpl implements PatientsService {
@Autowired
 private PatientsDao dao;

	public PatientsDao getDao() {
	return dao;
}

public void setDao(PatientsDao dao) {
	this.dao = dao;
}

	@Override
	public Pager findByPagers(int curPage, int pageSize) {
		
		return dao.findByPages(curPage, pageSize);
	}

	@Override
	public void saveOrUpdate(Patients patients) {
		if(patients.getId()!=null&&patients.getId()>0){
			dao.update(patients);
		}else{
			dao.save(patients);
		}
	}

	@Override
	public Map findById(Patients patients) {
		System.out.println("findById"+dao.findById(patients));
		return dao.findById(patients);
	}

	@Override
	public void delete(Patients patients) {
		dao.delete(patients);
		
	}

	@Override
	public String findByKey(String key) {
		List<String> list=new ArrayList();
		if(key.length()>0&&!key.equals(null)){
		    List list2=dao.findByKey(key);
		    list.addAll(list2);
		}
		String str="";
		for (String string:list) {
			str+=string+",";
		}
		return str;
	}

	@Override
	public Map findByName(Patients patients) {
		Map map=new HashMap();
		if(patients.getPatientname()!=null){
			Map ma=dao.findByName(patients);
			map.putAll(ma);
		}
		
		return map;
	}

	@Override
	public void deleteClinicregister(Clinicregister clinicregister) {
		dao.deleteClinicregister(clinicregister);
	}

	@Override
	public void deleteCharge(Charge charge) {
		dao.deleteCharge(charge);
	}

	@Override
	public List<Map> findOffice() {
		
		return dao.findOffice();
	}

	@Override
	public List<Map> findStuff() {
		
		return dao.findStuff();
	}

	@Override
	public List<Map> findRegisteredtype() {
		
		return dao.findRegisteredtype();
	}

	@Override
	public void saveClinicregister(Clinicregister clinicregister) {
		dao.saveClinicregister(clinicregister);
		
	}

	@Override
	public void savePatients(Patients patients) {
		dao.savePatients(patients);
		
	}

	@Override
	public void saveCharge(Charge charge) {
		dao.saveCharge(charge);
		
	}

	@Override
	public void updateClinicregister(Clinicregister clinicregister) {
		dao.updateClinicregister(clinicregister);
		
	}

	@Override
	public void updatePatients(Patients patients) {
		dao.updatePatients(patients);
		
	}

	@Override
	public void updateCharge(Charge charge) {
		dao.updateCharge(charge);
		
	}

	@Override
	public String getNewId() {
		
		return dao.getNewId();
	}

	@Override
	public List<Map> findRoles() {
		
		return dao.findRoles();
	}

	@Override
	public List<Map> findPosition() {
		
		return dao.findPosition();
	}

	@Override
	public List<Map> findJobtitle() {
		
		return dao.findJobtitle();
	}

	@Override
	public List<Map> findStufftype() {
		
		return dao.findStufftype();
	}

	@Override
	public String getStuId() {
		
		return dao.getStuId();
	}
  @Transactional
	@Override
	public void addStuffAndUsers(List<Stuff> list,List<Usertable> list2) {
		if(list.get(0)!=null&&list2.get(0)!=null){
			//boolean addStu=false;
			
			for (int i = 0; i < list.size(); i++) {
				  dao.addStuff(list.get(i));
				  
			}
			
			for (int i = 0; i < list2.size(); i++) {
				System.out.println("list2Services:"+list2.get(i));
				dao.addUsers(list2.get(i));
			}
		}
		
	}

@Override
public void updateIccard(Iccard ic) {
	dao.updateIccard(ic);
	
}

	

}
