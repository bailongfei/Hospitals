package com.aaa.services;

import java.util.List;

import com.aaa.entity.Applicationresult;
import com.aaa.entity.Patients;

public interface ResultService {
   public List<Object[]> select();
   public Patients selectbyid(int jcjId);
   public void insert(Applicationresult result);
}
