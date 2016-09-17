package com.ian.onlinemall.action;

import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;

public class RegisterAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 48L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws OmException{
		if (getUser().getName() != null && getUser().getPassword() != null) {
			userMgr.signUp(user);
		}
		if (user.getCreatedAt() != null) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
