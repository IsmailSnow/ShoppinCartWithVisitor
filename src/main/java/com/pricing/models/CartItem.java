package com.pricing.models;

import java.math.BigDecimal;

import com.pricing.models.common.IShoppingCartElement;
import com.pricing.models.common.IShoppingCartVisitor;

public class CartItem implements IShoppingCartElement {

	private String name;
	private int itemCount;
	private double price;
	private ShoppingCart shoppingCart;

	public CartItem(String name, int itemCount, double price) {
		super();
		this.name = name;
		this.itemCount = itemCount;
		this.price = price;
	}

	@Override
	public void accept(IShoppingCartVisitor shoppingCartVisitor) {
		shoppingCartVisitor.visitCartItem(this);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

}
