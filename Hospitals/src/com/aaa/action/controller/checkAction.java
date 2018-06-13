package com.aaa.action.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.aaa.entity.Applicationform;
import com.aaa.entity.Applicationitem;
import com.aaa.servicesimpl.CheckServiceImpl;
import com.aaa.util.BaseAction;
import com.aaa.util.Message;
import com.aaa.util.Pager;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;


public class checkAction extends BaseAction{
	@Resource
	private CheckServiceImpl ser;
	private Applicationform app;
	 private Pager pager;
	  private int curPage;
	  private int pageSize=5;
	  private String target;
	  private String menuIds;
	  private Integer id;
	  private Integer money;
	  private Integer appid;
      private String url;
	public Applicationform getApp() {
		return app;
	}

	public void setApp(Applicationform app) {
		this.app = app;
	}
	//查询预约检查
	public String select(){
	List<Object[]> list=ser.select();
    List<Applicationform> list1=new ArrayList<Applicationform>();
    Object[] obj=null;
    for (int i = 0; i < list.size(); i++) {
	   obj=list.get(i);
	   list1.add((Applicationform) obj[0]);
    }
	  getRequest().put("app", list1);
    	  return "success";
      }
	//分页
	public String findAll(){
		    Pager p=ser.findByPagers(curPage, pageSize);
		    getRequest().put("p",p);
		  return "success";
		  
	  }
	//获取单条数据
	public String selectbyid(){
		  Applicationform appl=ser.selectbyid(app.getJcId());
		  getRequest().put("app", appl);
		return "success";
	}
	//删除
	public String update(){
		ser.update(app);
		return "success";
	}
	public void findMoney(){
		System.out.println(id);
		Map list=ser.findMoney(id);
		System.out.println(list);
		this.getPrintWriter().print(JSON.toJSONString(list));
	}
    //检查结果
	public String getResult(){
		System.out.println(id+"getResult"+money);
		ser.updateIccard(id, money);
		
		Applicationform appl=ser.selectbyid(app.getJcId());
		  getRequest().put("app", appl);
		/*Message me=new Message(appid,"操作成功!");  
		
		this.getPrintWriter().print(JSON.toJSONString(me));*/
		//url="${pageContext.request.contextPath}/hospital/html/zbf/result.jsp";
		return "success";
	}
	public CheckServiceImpl getSer() {
		return ser;
	}

	public void setSer(CheckServiceImpl ser) {
		this.ser = ser;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
   
	

	
	
	
}
