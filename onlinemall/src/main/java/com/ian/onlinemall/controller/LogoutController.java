package com.ian.onlinemall.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

//import com.opensymphony.xwork2.ActionContext;

@Results({
	@Result(name="success", type="redirectAction", params = {"actionName" , "login"})
})
public class LogoutController extends BaseController implements ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5031149294672562432L;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	// GET /api/logout
	public String index(){
		return logout();
	}
	
	
	
	public String logout(){
//		ActionContext atx = ActionContext.getContext();
//		atx.getSession().remove("loginUser");
		
//		request.getCookies()[0].getName();
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("loginUsername")) {
				Cookie cie = new Cookie("loginUsername", "");
				cie.setPath("/");
				cie.setMaxAge(0);
				response.addCookie(cie);
				break;
			}
		}
		
		return "success";
	}

	public void setServletRequest(HttpServletRequest paramHttpServletRequest) {
		this.request = paramHttpServletRequest;
	}

	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}
}
