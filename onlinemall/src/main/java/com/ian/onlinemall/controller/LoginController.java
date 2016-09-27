package com.ian.onlinemall.controller;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ModelDriven;

@Results({
	@Result(name="success", location="login-index.jsp"),
	@Result(name="error", location="login-index.jsp")
})
public class LoginController extends BaseController implements ModelDriven<User>{

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// GET /login
	public HttpHeaders index(){
		user = new User();
		return new DefaultHttpHeaders("index")
				.disableCaching();
	}
	
	// POST /login
	public String create() throws OmException{
		
		User user = getUser();
		
		if (user != null && userMgr.signInByName(user.getName(), user.getPassword()) != null) {
			setTip("登录成功！");
			return "success";
		}else{
			setTip("登录失败！");
			return "error";
		}
		
	}

	public User getModel() {
		return user;
	}
}
