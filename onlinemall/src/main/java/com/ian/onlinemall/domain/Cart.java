package com.ian.onlinemall.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart extends BaseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="user_uuid", nullable=false, updatable=false)
	private User user;
	
	@ManyToMany(targetEntity=Goods.class,fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
//	@JoinColumn(name="goods_id", nullable=true)
	private List<Goods> goods = new ArrayList<Goods>();
	
	public Cart(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cart)) return false;

		Cart cart = (Cart) o;
		return cart.getUuid().equals(this.getUuid());
	}

	@Override
	public int hashCode() {
		return getUuid() != null ? getUuid().hashCode() : 0;
	}
}
