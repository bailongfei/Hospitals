package com.aaa.util;

import java.sql.SQLException;
/**
 * ��ҳ������
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
	  //��ÿҳ�����ݷ�װ��PageEntity
	   page.setList(list);
	   //����ȫ���ѯ
	   List list2=hibernateTemplate.find(hql);
	   //������
	   int count=list2!=null ? list2.size() : 0;
	   
	   //������������װ��PageEntity
	   page.setAllRows(count);
	   //��ҳ����װ��PageEntity
	   if(count%page.getPageSize()==0){
		   
		   page.setAllPage(count/page.getPageSize());
	   }else{
		   page.setAllPage(count/page.getPageSize()+1);
	   }
	return page;
	
	   
   }
}
