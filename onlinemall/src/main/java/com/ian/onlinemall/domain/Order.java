package com.ian.onlinemall.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDER_TABLE")
public class Order extends BaseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String number;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_uuid", nullable=false, updatable=false)
	private User user;
	
	@OneToMany(targetEntity=Goods.class)
	@JoinColumn(name="goods_id", nullable=true)
	private Set<Goods> goods = new HashSet<Goods>();
	
	@OneToOne(targetEntity=Address.class)
	@JoinColumn(name="address_uuid", nullable=false, updatable=true)
	private Address address;
	
	@Column(nullable=false)
	private Integer quantity;
	
	private String paymentMethod;

	public Order(){
		
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
