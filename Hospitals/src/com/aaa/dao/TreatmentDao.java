package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Treatment;

public interface TreatmentDao {
	// ģ����ѯ
	public List<Treatment> findTreatment(String zjm);
}
