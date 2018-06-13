package com.aaa.bizImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaa.biz.MedicalRecordBiz;
import com.aaa.dao.MedicalrecordDao;
import com.aaa.entity.Medicalrecord;

@Service
public class MedicalRecordBizImpl implements MedicalRecordBiz {
	@Resource
	private MedicalrecordDao dao;

	public MedicalrecordDao getDao() {
		return dao;
	}

	public void setDao(MedicalrecordDao dao) {
		this.dao = dao;
	}

	// Ìí¼Ó²¡Àú±í
	@Override
	public void addMedicalrecord(Medicalrecord medicalrecord) {
		dao.addMedicalrecord(medicalrecord);

	}

}
