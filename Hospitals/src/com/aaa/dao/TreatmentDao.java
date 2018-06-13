package com.aaa.dao;

import java.util.List;

import com.aaa.entity.Treatment;

public interface TreatmentDao {
	// Ä£ºı²éÑ¯
	public List<Treatment> findTreatment(String zjm);
}
