package com.aaa.biz;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Iccard;
import com.aaa.util.Pager;

public interface IccardService {
	//��ѯ
	public List<Iccard> select();
//���
	public void addICcard(Iccard i);
	
	  //ͨ��id��ѯ
		public Map findById(int icid);
			   //�޸�
				
				public void saveOrUpdate(Iccard i);
				//ɾ��
				public void delIc(int icid);
			   //wk
			   public List<Iccard> selname(String name);
			   //��ֵ����ѯ
			   public List<Iccard> selectAll();
			 //��ֵ��������ѯ
			   public List<Iccard> selectname(String name); 
			   //��ֵ  id��ѯ
				public Map ICfindById(int icid);
				/*��ֵ���޸ĸý��*/
				public  void updateiccard(int icid,int money);
}
