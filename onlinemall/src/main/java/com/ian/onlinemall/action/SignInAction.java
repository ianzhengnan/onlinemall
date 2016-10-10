package com.ian.onlinemall.action;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ian.onlinemall.controller.BaseController;
import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ModelDriven;

public class SignInAction extends BaseController implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7136050973987529059L;
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
	public String checkUser() throws OmException{
		
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
