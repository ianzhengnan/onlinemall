package com.ian.onlinemall.controller;

import com.ian.onlinemall.service.UserManager;

public abstract class BaseController {

	protected UserManager userMgr;
	protected String tip;
	
	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
