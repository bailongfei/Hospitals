package com.aaa.services;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Applicationform;
import com.aaa.util.Pager;

public interface CheckService {
   public List<Object[]> select();
   public Pager findByPagers(int curPage,int pageSize);
   public Applicationform selectbyid(int jcId);
   public void update(Applicationform app);
   public void updateIccard(int id,int money);
   public Map findMoney(int id);
}
