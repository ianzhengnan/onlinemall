package com.ian.onlinemall.action;

import com.ian.onlinemall.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	protected UserManager userMgr;
	protected String tip;
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public void setUserMgr(UserManager userMgr){
		this.userMgr = userMgr;
	}
}
