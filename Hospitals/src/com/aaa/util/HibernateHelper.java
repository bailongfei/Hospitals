package com.aaa.util;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

public class HibernateHelper<T> implements HibernateCallback<T> {

	private String sql;
	private Object[] params;
	
	public HibernateHelper(String sql,Object[] params){
		
	}
	
	@Override
	public T doInHibernate(Session session) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
