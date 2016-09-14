package com.ian.onlinemall.test;

import com.ian.onlinemall.domain.Address;
import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.ian.onlinemall.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class InsertData extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tip;
	private UserManager userMgr;
	
	private User user;
	private Address ad1;
	
	@Override
	public String execute() throws OmException{
		
		insertUser("李四2", "lisi");
		
		User userTmp = userMgr.signInByName("李四2", "lisi");
		
		if (userTmp != null) {
			setTip(userTmp.getName() + " 插入成功！");
			return SUCCESS;
		}else{
			setTip("插入失败！");
			return ERROR;
		}		
	}
	
	private User insertUser(String name, String password) throws OmException{
		
		ad1 = new Address();
		ad1.setCountry("中国");
		ad1.setDefault(true);
		ad1.setProvince("上海");
		ad1.setCity("上海");
		ad1.setRegion("闵行区");
		ad1.setZipcode("210000");
		ad1.setDetail("申滨路1051弄100号305室");
		
		user = new User();
		
		user.setName(name);
		user.setPassword(password);
		user.setEmail("flks@163.com");
		user.setSex("male");
		user.setTel("13762534987");
		user.setAge(23);
		user.setRole("cust");
		
		try {
			userMgr.createUser(user);
		} catch (OmException e1) {
			e1.printStackTrace();
		}
		
		ad1.setUser(user);
		
		try {
			userMgr.createAddress(ad1);
		} catch (OmException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public UserManager getUserMgr() {
		return userMgr;
	}

	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}
	
}
