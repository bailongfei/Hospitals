package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.Iccard;
import com.aaa.util.Pager;

public interface ICcardDao {
	//��ѯ
	public List<Iccard> select();
//�쿨
	public void addICcard(Iccard i);
	  //ͨ��id��ѯ
	public Map findById(int icid);
		   //�޸�
	public void update(Iccard i);

	//wk ������ѯ
	public List<Iccard> selname(String name);
		   //��ֵ����ѯ
		   public List<Iccard> selectAll();
		 //��ֵ��������ѯ
		   public List<Iccard> selectname(String name);
		 //��ֵ  id��ѯ
			public Map ICfindById(int icid);
			/*��ֵ���޸ĸý��*/
			public  void updateiccard(int icid,int money);
			//ɾ��
			public void delIc(int icid);   
}
