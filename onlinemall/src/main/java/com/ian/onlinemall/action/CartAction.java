package com.ian.onlinemall.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ian.onlinemall.domain.Goods;

public class CartAction extends BaseAction implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6876602221879559046L;
	private HttpServletRequest request;
	private Goods goods;
	private String id;
	private String method;
	

	public String execute(){
		
		//to-do: get cart
		
		
		
		if (method == "") {
			return SUCCESS;
		}
		
		
		if (method == "add") {
			//to-do:
//			userMgr.addGoodsToCart(goods, cart);
		}else if (method == "remove") {
			
		}
		
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		request = httpServletRequest;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		setGoods(userMgr.getGoodsById(id));
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
