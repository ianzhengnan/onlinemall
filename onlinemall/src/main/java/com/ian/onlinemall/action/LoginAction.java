package com.ian.onlinemall.action;

import com.ian.onlinemall.domain.User;

public class LoginAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception{
		
		User user = getUser();
		
		if (user != null && userMgr.signInByName(user.getName(), user.getPassword()) != null) {
			setTip("登录成功！");
			return SUCCESS;
		}else{
			setTip("登录失败！");
			return ERROR;
		}
	}
	
}
