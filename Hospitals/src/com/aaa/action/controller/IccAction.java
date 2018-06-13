package com.aaa.action.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class IccAction {
   public Map getRequest(){
	return (Map) ActionContext.getContext().get("request");
	   
   }
   
   public Map getSession(){
	return ActionContext.getContext().getSession();
	   
   }
   
   public HttpServletResponse getResponse(){
	return ServletActionContext.getResponse();
	   
   }
   
   public PrintWriter getOut() throws IOException{
	   ServletActionContext.getResponse().setCharacterEncoding("utf-8");
	return ServletActionContext.getResponse().getWriter();
	   
   }
   
   public PrintWriter getPrintWriter() {
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			return out;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
