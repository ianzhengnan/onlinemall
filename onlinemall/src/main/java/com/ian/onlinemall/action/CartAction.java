package com.ian.onlinemall.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author I076453
 */
public class CartAction extends BaseAction implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6876602221879559046L;
	private HttpServletRequest request;
	private Goods goods;
	private Cart cart;
	private String id;
	private String method;
	private ActionContext act;
	

	public String execute() throws OmException{
		
		//to-do: get cart
		act = ActionContext.getContext();
		cart = (Cart) act.getSession().get("cart");
				
		if (method.equals("add")) {
			userMgr.addGoodsToCart(goods, cart);
		}else if (method.equals("remove")) {
			userMgr.removeGoodsFromCart(goods, cart);
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
