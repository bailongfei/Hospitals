package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Applicationform;
import com.aaa.entity.Iccard;
import com.aaa.util.Pager;

public interface CheckDao {
   public List<Object[]> select();
   public Pager findByPages(int curPage,int pageSize);
   public Applicationform selectbyid(int jcId);
   public void update(Applicationform app);
   public void updateIccard(int id,int money);
   public Map findMoney(int id);
}
