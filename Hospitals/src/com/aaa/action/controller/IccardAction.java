package com.aaa.action.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaa.biz.IccardService;
import com.aaa.entity.Drug;
import com.aaa.entity.Iccard;
import com.aaa.entity.Patients;
import com.aaa.util.Pager;
import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IccardAction extends IccAction {
	@Autowired
	private IccardService iccardService;
	private Iccard i;
	private Patients p;
	private int curPage;
	private int pageSize=4;
	private String name;
	private Integer money;
	private String Iccardjson;
	private Integer icid;
	
	public Integer getIcid() {
		return icid;
	}
	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	public String getIccardjson() {
		return Iccardjson;
	}
	public void setIccardjson(String iccardjson) {
		Iccardjson = iccardjson;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Patients getP() {
		return p;
	}
	public void setP(Patients p) {
		this.p = p;
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
	public IccardService getIccardService() {
		return iccardService;
	}
	public void setIccardService(IccardService iccardService) {
		this.iccardService = iccardService;
	}

	public Iccard getI() {
		return i;
	}
	public void setI(Iccard i) {
		this.i = i;
	}
	
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//联合查询
		//@Action(value="selectic")
	    public String selectic(){  
			List<Iccard> list=iccardService.select();
			System.out.println(list);
			String  jsonStr = JSON.toJSONString(list);
			System.out.println(jsonStr);
			try {
				getOut().print(jsonStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		         return null;
		       
	}
	
	//添加
		//@Action(value="addic",results={@Result(name="addic", location="selectic",type="chain")})

public String  addic(){
			
			//i.setPatients(p);
			iccardService.addICcard(i);
			return "addic";
			
			
		}
		
		//条件查询
	//@Action(value="selname")
	public String selname(){
		List<Iccard> list=iccardService.selname(name);
		String jsonStr = JSON.toJSONString(list);
		System.out.println(jsonStr);
		try {
			getOut().print(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
		//修改
		//@Action(value="updatec")
	     public String updatec(){
			System.out.println(111);
		     iccardService.saveOrUpdate(i);
	    	 return null;
	     }
		//id查询
		//@Action(value="selectbyid")
	    public String selectbyid() throws IOException{
			System.out.println("selectbyid"+i.getIcid());
			Map map= iccardService.findById(i.getIcid());
			String  jsonStr = JSON.toJSONString(map);
			System.out.println(jsonStr);
			getOut().print(jsonStr);
	    		    	 return null;
	    }
		/**
	     * 删除
	     * */
	    //@Action("delic")
	    public void delic(){
	    	iccardService .delIc(icid);
	    	System.out.println(icid);
	    	try {
				getOut().print("true");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
			}
		//充值查询
		//@Action(value="selectsi")
		public String selectsi(){
			List<Iccard> list=iccardService.selectAll();
			System.out.println(list);
			String jsonStr = JSON.toJSONString(list);
			System.out.println(jsonStr);
			try{
				getOut().print(jsonStr);
			}catch(IOException e){
				e.printStackTrace();
			}
			return null;
		}
		
		//条件查询
		//@Action(value="selectname")
		public String selectname(){
			List<Iccard> list=iccardService.selectname(name);
			String jsonStr = JSON.toJSONString(list);
			System.out.println(jsonStr);
			try {
				getOut().print(jsonStr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		//id查询
				//@Action(value="ICfindById")
			    public String ICfindById() throws IOException{
					
					Map map= iccardService.ICfindById(i.getIcid());
					String  jsonStr = JSON.toJSONString(map);
					getOut().print(jsonStr);
			    		    	 return null;
			    }
		
				//@Action(value="adddrug")
				public String updateIccard(){
				/*	List<Iccard> list =JSON.parseArray(Iccardjson,Iccard.class);
					for(Iccard i : list){
						IccardService.updateiccard(i.getIcid(),i.getMoney());
					}
					return null;*/
	
					iccardService.updateiccard(i.getIcid(),i.getMoney());	
	
					return null;	
			}
}
