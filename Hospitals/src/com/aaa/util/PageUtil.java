package com.aaa.util;

import java.sql.SQLException;
/**
 * 分页辅助类
 */
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.PageEntity;
@Component
public class PageUtil {
	@Autowired
	private HibernateTemplate hibernateTemplate;
   public PageEntity getPage(final String hql,final PageEntity page){
	   List list=hibernateTemplate.executeFind(new HibernateCallback<List>() {

		public List doInHibernate(Session session) throws HibernateException,
				SQLException {
			Query query=session.createQuery(hql);
			query.setFirstResult((page.getCurrPage()-1)*page.getPageSize());
			query.setMaxResults(page.getPageSize());
			return query.list();
		}
	});
	  //将每页的数据封装到PageEntity
	   page.setList(list);
	   //进行全表查询
	   List list2=hibernateTemplate.find(hql);
	   //总条数
	   int count=list2!=null ? list2.size() : 0;
	   
	   //将张总条数封装到PageEntity
	   page.setAllRows(count);
	   //总页数封装到PageEntity
	   if(count%page.getPageSize()==0){
		   
		   page.setAllPage(count/page.getPageSize());
	   }else{
		   page.setAllPage(count/page.getPageSize()+1);
	   }
	return page;
	
	   
   }
}
