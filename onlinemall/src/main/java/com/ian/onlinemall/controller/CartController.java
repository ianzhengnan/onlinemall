package com.ian.onlinemall.controller;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.ian.onlinemall.domain.Cart;
import com.ian.onlinemall.domain.Goods;
import com.opensymphony.xwork2.ModelDriven;

@Results({
	@Result(name = "index", location = "/WEB-INF/content/cart/index.jsp")
})
public class CartController extends BaseController implements ModelDriven<Cart>{

	private Cart cart;
	private Goods goods;
	private String id;

	// GET /cart
	public String index(){
		
		return "index";
	}
	
	public String show(){
		
		return "show";
	}
	
	// PUT /cart/id
	public String update(){

		return "success";
	}
	
	public Cart getModel() {
		return this.cart;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
