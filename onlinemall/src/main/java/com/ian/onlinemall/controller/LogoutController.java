package com.ian.onlinemall.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;

//import com.opensymphony.xwork2.ActionContext;

@Results({
	@Result(name="success", type="redirectAction", params = {"actionName" , "login"})
})
public class LogoutController extends BaseController implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5031149294672562432L;
	
	private HttpServletRequest request;
	
	// GET /api/logout
	public String index(){
		return logout();
	}
	
	
	
	public String logout(){
//		ActionContext atx = ActionContext.getContext();
//		atx.getSession().remove("loginUser");
		
		request.getCookies()[0].getName();
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName() == "loginUsername") {
				cookie.setMaxAge(0);
			}
		}
		
		return "success";
	}

	public void setServletRequest(HttpServletRequest paramHttpServletRequest) {
		this.request = paramHttpServletRequest;
	}
	
}
