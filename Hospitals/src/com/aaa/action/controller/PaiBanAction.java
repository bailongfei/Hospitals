package com.aaa.action.controller;


import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.aaa.entity.PageEntity;
import com.aaa.entity.Scheduleitem;
import com.aaa.entity.Scheduletype;
import com.aaa.entity.Stuff;
import com.aaa.services.ScheduleItemServices;
import com.aaa.util.BaseAction;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

@Controller
@ParentPackage("struts-default")
public class PaiBanAction extends BaseAction{
	@Autowired
	private ScheduleItemServices scheduleItemServicesImpl;
	private PageEntity pageEntity;
	private  int  ptid;
	private  int stuffid2;
	private  String  week;
	private int sx;
	private int ii;
	private String stuffname;
	private Stuff su;
	/*@Action(value="additem")*/
	public String additem(){  
		Scheduleitem sitem=new Scheduleitem();
		Scheduletype type=new Scheduletype();
		Stuff stuff=new Stuff();
		type.setPtid(ptid);
		sitem.setScheduletype(type);
		
		sitem.setWeek(week);
		stuff.setStuffid2(stuffid2);
		sitem.setStuff(stuff);
		scheduleItemServicesImpl.save(sitem);
		return null;
	     }
	
	
	
    public String findByPages(){
		//分页初始化
		 if(pageEntity==null){pageEntity=new PageEntity();}
		 String str = "";
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	        Calendar lastDate = Calendar.getInstance();
	        if (sx==0) { 
	        	lastDate.roll(Calendar.WEEK_OF_YEAR, 0);//当前日期
			} else  if (sx==1) {
				
				lastDate.roll(Calendar.WEEK_OF_YEAR, -1);//日期回滚7天
			} else  if (sx==2) {
		        lastDate.add(Calendar.WEEK_OF_YEAR, 1);//日期推后7天
			}
	        str=sdf.format(lastDate.getTime());
	        DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd"); 
	        Date date = null;
			try {
				date = fmt.parse(str);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//取时间
			List<Map<String,Object>> time1=new ArrayList<Map<String,Object>>() ;
			for (int i = 0; i < 7; i++) {
				Calendar calendar = new GregorianCalendar();
			    calendar.setTime(date);
			    calendar.add(calendar.DATE,1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
			    date=calendar.getTime(); 
			    Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			    String dateString = formatter.format(date);
			    Map aa=new HashMap();
			    aa.put("datet", dateString);
			    time1.add(aa);
			}
		
		String time=JSON.toJSONString(time1);
		PageEntity stuff1=new PageEntity();
		if (stuffname==null) {
			stuff1=scheduleItemServicesImpl.findByPages(pageEntity);
		} else {
			stuff1=scheduleItemServicesImpl.findByPages2(pageEntity,stuffname);
		}
		String stuff=JSON.toJSONString(stuff1);
		System.out.println(stuff);
		String item=scheduleItemServicesImpl.select();
		String type=scheduleItemServicesImpl.select2();
		Map map=(Map) ActionContext.getContext().get("request");
		map.put("time", time);
		map.put("stuff", stuff);
		map.put("item", item);
		map.put("type", type);
		
	return "success1";
    }



	public Stuff getSu() {
		return su;
	}

	public void setSu(Stuff su) {
		this.su = su;
	}

	public String getStuffname() {
		return stuffname;
	}

	public void setStuffname(String stuffname) {
		this.stuffname = stuffname;
	}

	public int getPtid() {
		return ptid;
	}


	public void setPtid(int ptid) {
		this.ptid = ptid;
	}


	public int getStuffid2() {
		return stuffid2;
	}


	public void setStuffid2(int stuffid2) {
		this.stuffid2 = stuffid2;
	}


	public String getWeek() {
		return week;
	}


	public void setWeek(String week) {
		this.week = week;
	}


	public PageEntity getPageEntity() {
		return pageEntity;
	}


	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

	public ScheduleItemServices getScheduleItemServicesImpl() {
		return scheduleItemServicesImpl;
	}

	public void setScheduleItemServicesImpl(ScheduleItemServices scheduleItemServicesImpl) {
		this.scheduleItemServicesImpl = scheduleItemServicesImpl;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getIi() {
		return ii;
	}

	public void setIi(int ii) {
		this.ii = ii;
	}


}


