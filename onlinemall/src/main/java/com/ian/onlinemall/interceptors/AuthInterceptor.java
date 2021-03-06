package com.ian.onlinemall.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by I076453 on 10/28/2016.
 */
public class AuthInterceptor implements Interceptor{

    private HttpServletRequest request;

    public void destroy() {

    }

    public void init() {

    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {

//        ActionContext atx = actionInvocation.getInvocationContext();
        request = ServletActionContext.getRequest();
        Cookie cie = null;
        for (Cookie cookie: request.getCookies()) {
            if (cookie.getName().equals("loginUsername")){
                cie = cookie;
                break;
            }
        }

        if (cie == null){
            return Action.LOGIN;
        }else{
            return actionInvocation.invoke();
        }
    }


}
