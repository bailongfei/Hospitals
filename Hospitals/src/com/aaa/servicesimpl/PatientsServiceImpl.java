package com.aaa.servicesimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.PatientsDao;
import com.aaa.entity.Charge;
import com.aaa.entity.Clinicregister;
import com.aaa.entity.Patients;
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
		List<String> list=dao.findByKey(key);
		String str="";
		for (String string:list) {
			str+=string+",";
		}
		return str;
	}

	@Override
	public Map findByName(Patients patients) {
		
		return dao.findByName(patients);
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

}
