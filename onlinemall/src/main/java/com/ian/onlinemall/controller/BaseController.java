package com.ian.onlinemall.controller;

import org.apache.struts2.rest.RestActionSupport;

import com.ian.onlinemall.service.UserManager;

public abstract class BaseController extends RestActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1312312312312312L;
	
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
