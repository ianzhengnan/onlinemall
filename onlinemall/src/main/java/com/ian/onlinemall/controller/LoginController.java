package com.ian.onlinemall.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Results({
	@Result(name="success", location="/WEB-INF/content/test/welcome.jsp"),
	@Result(name="error", location="/WEB-INF/content/test/error.jsp"),
	@Result(name="index", location="/WEB-INF/content/test/login.jsp")
})
public class LoginController extends BaseController implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6475078107590624578L;
	private User user;
	private Map<String, Object> userId = new HashMap<String, Object>();
	private User loginUser;
	private ActionContext act;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// GET /login
	public HttpHeaders index(){
		act = ActionContext.getContext();
		if(act.getSession().size() > 0 && act.getSession().get("loginUser") != null){
			setTip("您已经登陆！");
			user = (User) act.getSession().get("loginUser");
			return new DefaultHttpHeaders("success")
					.disableCaching();
		}else{
			user = new User();
			return new DefaultHttpHeaders("index")
					.disableCaching();
		}
		
	}
	
	// POST /login
	public String create() throws OmException{
		return checkUser();
	}
	
	public String checkUser() throws OmException{
		
		User user = getUser();
		act = ActionContext.getContext();
				
		loginUser = userMgr.signInByName(user.getName(), user.getPassword());
		
		if (user != null && loginUser != null) {
			setTip("登录成功！");
			userId.put("loginUser", loginUser);
			act.getSession().put("loginUser", loginUser);
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
