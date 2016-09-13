package com.ian.onlinemall.action;

import com.ian.onlinemall.domain.User;

public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private String tip;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String execute() throws Exception{
		
		if (getUser().getName().equalsIgnoreCase("ian") 
				&& getUser().getPassword().equals("kaka")) {
			setTip("登录成功！");
			return SUCCESS;
		}else{
			setTip("登录失败！用户名或密码不正确");
			return ERROR;
		}
		
	}
	
}
