package com.ian.onlinemall.controller;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.RestActionSupport;

import com.opensymphony.xwork2.ActionContext;

@Results({
	@Result(name="success", type="redirectAction", params = {"actionName" , "login"})
})
public class LogoutController extends RestActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5031149294672562432L;
	
	// GET /api/logout
	public String index(){
		return logout();
	}
	
	public String logout(){
		ActionContext atx = ActionContext.getContext();
		atx.getSession().remove("loginUser");
		return "success";
	}
	
}
