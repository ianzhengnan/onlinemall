package com.ian.onlinemall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.ian.onlinemall.service.UserManager;
import com.opensymphony.xwork2.ModelDriven;


@Results({
	@Result(name = "success", location = "/WEB-INF/content/test/welcome.jsp"),
	@Result(name = "error", location = "/WEB-INF/content/test/error.jsp"),
	@Result(name = "login", location = "/WEB-INF/content/test/login.jsp"),
	@Result(name = "index", location = "/WEB-INF/content/test/register.jsp")
})
public class SignupController extends BaseController implements ModelDriven<User>, ServletRequestAware, ServletResponseAware{

	private static final long serialVersionUID = 9123017060984593686L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private User user;
	private UserManager userMgr;
	
	

	// GET /api/signup
	public String index(){
		return "index";
	}

	// POST /api/signup
	public String create() throws OmException{
		
		User person = getUser();
		
		if(userMgr.signUp(person)){
			setTip("注册成功！");
			return "index";
		}else{
			setTip("注册失败！");
			return "index";
		}
	}
	
	
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	public User getModel() {
		return user;
	}
	
	// getters and setters
	public UserManager getUserMgr() {
		return userMgr;
	}

	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
