package com.ian.onlinemall.test;

import java.util.ArrayList;
import java.util.List;

import com.ian.onlinemall.domain.Goods;
import com.ian.onlinemall.exception.OmException;
import com.ian.onlinemall.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class InsertGoods extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1803637199392551143L;

	private UserManager userMgr;
	private String tip;
	
	public String execute() throws OmException{
		boolean isSuccess = true;
		List<Goods> items = new ArrayList<Goods>();
		Goods goods = materialFactory(0, "高露洁牙刷", "牙刷", "高露洁"); 
		items.add(goods);
		Goods g1 = materialFactory(1, "佳洁士牙刷", "牙刷", "佳洁士");
		items.add(g1);
		Goods g2 = materialFactory(2, "佳洁士儿童牙刷", "牙刷", "佳洁士");
		items.add(g2);
		Goods g3 = materialFactory(3, "海尔冰箱", "冰箱", "海尔");
		items.add(g3);
		Goods g4 = materialFactory(4, "美的冰箱", "冰箱", "美的");
		items.add(g4);
		
		for (Goods material : items) {
			if(!userMgr.createGoods(material)){
				isSuccess = false;
			}
		}
		if (isSuccess) {
			setTip("成功");
			return "success";
		}else{
			setTip("失败");
			return "error";
		}
	}
	
	
	private Goods materialFactory(int number, String name, String catalog, String brand){
		
		Goods goods = new Goods();
		
		goods.setNumber(String.valueOf(number));
		goods.setName(name);
		goods.setCategory(catalog);
		goods.setBrand(brand);
		goods.setDescription("商品" + name + "是一个好" + catalog + "！");
		goods.setPrice(99);
		goods.setStock(20);
		goods.setUnit("个");
		
		return goods;
	}
	
	
	public void setUserMgr(UserManager userMgr){
		this.userMgr = userMgr;
	}


	public String getTip() {
		return tip;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
