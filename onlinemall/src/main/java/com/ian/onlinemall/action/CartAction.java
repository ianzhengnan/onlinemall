package com.ian.onlinemall.action;

import javax.servlet.http.HttpServletRequest;

import com.ian.onlinemall.domain.CartData;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.exception.OmException;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	private List<CartData> disItems = new ArrayList<CartData>();

	public String execute() throws OmException{
		
		//to-do: get cart
		act = ActionContext.getContext();
		cart = (Cart) act.getSession().get("cart");

		if (method == null){
			setDisItems(cart);
			return SUCCESS;
		}

		if (method.equals("add")) {
			userMgr.addGoodsToCart(goods, cart);
		}else if (method.equals("remove")) {
			userMgr.removeGoodsFromCart(goods, cart);
		}
		setDisItems(cart);

		return SUCCESS;
	}



	public void setServletRequest(HttpServletRequest httpServletRequest) {
		request = httpServletRequest;
	}

	public List<CartData> getDisItems() {
		return disItems;
	}

	public void setDisItems(Cart cart) {

		if (cart == null){
			return;
		}

		for (Goods goods : cart.getGoods()) {
			CartData cartData = new CartData(cart);
			cartData.setGoods(goods);
			if (disItems.contains(cartData)){
				int quantity  = (disItems.get(disItems.indexOf(cartData)).getQuantity()) + 1;
				disItems.get(disItems.indexOf(cartData)).setQuantity(quantity);
			}else{
				cartData.setQuantity(1);
				disItems.add(cartData);
			}
		}
		Collections.sort(disItems);
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
