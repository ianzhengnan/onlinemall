package com.ian.onlinemall.controller;

//import java.util.HashMap;
//import java.util.Map;

import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.ian.onlinemall.domain.User;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Results({
	@Result(name="success", type="redirectAction", params = {"actionName" , "goods"}),
	@Result(name="error", location="/WEB-INF/content/test/error.jsp"),
	@Result(name="index", location="/WEB-INF/content/test/login.jsp")
})
public class LoginController extends BaseController implements ModelDriven<User>, ServletResponseAware, ServletRequestAware{

	private static final long serialVersionUID = -6475078107590624578L;
	private User user;
	private User loginUser;
	private ActionContext act;
	private HttpServletResponse response;
	private HttpServletRequest request;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	// GET /login
	public HttpHeaders index(){
		Cookie cie = null;
		for (Cookie cookie: request.getCookies()) {
			if (cookie.getName().equals("loginUsername")){
				cie = cookie;
				break;
			}
		}
		if(cie != null && cie.getName().equals("loginUsername")){
			setTip("您已经登陆！");
			loginUser = userMgr.getUserById(cie.getValue());
			saveCartToSession(loginUser);
			return new DefaultHttpHeaders("success")
					.disableCaching();
		}else{
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
		
		loginUser = userMgr.signInByName(user.getName(), user.getPassword());
		
		if (loginUser != null) {
			setTip("登录成功！");

			Cookie cookie = new Cookie("loginUsername", loginUser.getUuid());
			cookie.setMaxAge(60 * 60);
			cookie.setPath("/");
			response.addCookie(cookie);
			saveCartToSession(loginUser);
			
			return "success";
		}else{
			setTip("登录失败！");
			return "error";
		}
	}
	
	private void saveCartToSession(User user){
		act = ActionContext.getContext();
		act.getSession().put("cart", userMgr.getCartByUser(user));
	}

	public User getModel() {
		return user;
	}

	public void setServletResponse(HttpServletResponse paramHttpServletResponse) {
		this.response = paramHttpServletResponse;
	}

	public void setServletRequest(HttpServletRequest paramHttpServletRequest) {
		this.request = paramHttpServletRequest;
	}

}
