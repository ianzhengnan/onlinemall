package com.ian.onlinemall.action;

import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by I076453 on 10/24/2016.
 */
public class TestAction extends BaseAction implements ServletRequestAware{

    public String execute(){


        return null;
    }


    public void setServletRequest(HttpServletRequest httpServletRequest) {

    }
}
