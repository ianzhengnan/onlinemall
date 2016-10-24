package com.ian.onlinemall.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="GOODS")
public class Goods extends BaseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String number;
	
	private String name;
	
	private String category;
	
	private String brand;

	private String description;
	
	@Lob
	private byte[] pic;
	
	private double price;
	private String unit;
	private Integer stock;
	
	public Goods(){
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Goods)) return false;

		Goods goods = (Goods) o;

		return goods.getName().equals(this.getName()) && goods.getBrand().equals(this.getBrand())
				&& goods.getCategory().equals(this.getCategory());

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = getNumber() != null ? getNumber().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
		result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		temp = Double.doubleToLongBits(getPrice());
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
