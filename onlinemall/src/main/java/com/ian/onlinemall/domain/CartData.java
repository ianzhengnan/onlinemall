package com.ian.onlinemall.domain;


import java.sql.Timestamp;

/**
 * Created by I076453 on 10/24/2016.
 */
public class CartData implements Comparable<CartData>{

    private Goods goods;
    private Cart cart;
    private Integer quantity;

    public CartData(){

    }

    public CartData(Cart cart){
        this.cart = cart;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartData)) return false;

        CartData cartData = (CartData) o;

        return cartData.getCart().equals(this.cart) && cartData.getGoods().equals(this.goods);

    }

    @Override
    public int hashCode() {
        int result = getGoods() != null ? getGoods().hashCode() : 0;
        result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
        return result;
    }

    public int compareTo(CartData o) {
        if((this.goods.getName().length() - o.getGoods().getName().length()) == 0){
            return 0;
        }else{
            return this.goods.getName().length() - o.getGoods().getName().length();
        }
    }
}
