package com.ian.onlinemall.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.service.UserManager;
import com.opensymphony.xwork2.ModelDriven;


@Results({
	@Result(name = "index", location = "/WEB-INF/content/goods/index.jsp"),
	@Result(name = "catalog", location = "/WEB-INF/content/goods/catalog.jsp")
})
@AllowedMethods({"index","show"})
public class GoodsController extends BaseController implements ModelDriven<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1959812886370334219L;
	
	private Goods goods;
	private List<Goods> items = new ArrayList<Goods>();
	private String catalog;
	private UserManager userMgr;
	private String id;
	private final static int pageSize = 5;
	private static int page;
	private int totalPage;
	
	// GET /goods
	public String index(){
		int offset = getPage() * pageSize;
		items = userMgr.getAllGoods(offset + 1, pageSize);
		return "index";
	}
	
	// GET /goods/catalog
	public String show() throws UnsupportedEncodingException{
		URLDecoder.decode(id, "utf-8");
		items = userMgr.getGoodsByCatalog(this.id);
		return "catalog";
	}
	
	
	public Object getModel() {
		return (items != null ? items : goods);
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getItems() {
		return items;
	}

	public void setItems(List<Goods> items) {
		this.items = items;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public void setUserMgr(UserManager userMgr) {
		this.userMgr = userMgr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public UserManager getUserMgr() {
		return userMgr;
	}

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 读取当前Page number
	 * @return
	 */
	public int getPage() {
		return page;
	}
	/**
	 * 设置当前page number
	 * @param page
	 */
	@SuppressWarnings("static-access")
	public void setPage(int page) {
		LOG.error("set page");
		if (page < 0) {
			this.page = 0;
		}else if(page > totalPage){
			this.page = totalPage;
		}
		this.page = page;
	}

	public int getTotalPage() {
		LOG.error("get total page");
		return userMgr.getAllGoods(0, 0).size() / pageSize;
	}

}
