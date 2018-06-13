package com.aaa.action.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.aaa.entity.Applicationresult;
import com.aaa.entity.Patients;
import com.aaa.servicesimpl.ResultServiceImpl;
import com.aaa.util.BaseAction;

public class ResultAction extends BaseAction{
	@Resource
	private ResultServiceImpl ser;
    private Applicationresult result;
    private Patients p;
    
    public String getResultform(){
    	List<Object[]> list=ser.select();
        List<Applicationresult> list1=new ArrayList<Applicationresult>();
        Object[] obj=null;
        for (int i = 0; i < list.size(); i++) {
    	   obj=list.get(i);
    	   list1.add((Applicationresult) obj[0]);
        }
    	  getRequest().put("result", list1);
        	  return "success";
    }
    public String selectbyid(){
    	Patients result1=ser.selectbyid(p.getId());
    	getRequest().put("result", result1);
    	return "success";
    }
    public void insert(){
    	ser.insert(result);
    	getPrintWriter().print("Ìí¼Ó³É¹¦");
    }

	public ResultServiceImpl getSer() {
		return ser;
	}

	public void setSer(ResultServiceImpl ser) {
		this.ser = ser;
	}
	public Applicationresult getResult() {
		return result;
	}
	public void setResult(Applicationresult result) {
		this.result = result;
	}
	public Patients getP() {
		return p;
	}
	public void setP(Patients p) {
		this.p = p;
	}
	



    
}
