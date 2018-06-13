package com.aaa.dao;

import java.util.List;


import com.aaa.entity.Applicationresult;
import com.aaa.entity.Patients;

public interface ResultDao {
    public List<Object[]> select();
    public Patients selectbyid(int jcjId);
    public void insert(Applicationresult result);
}
