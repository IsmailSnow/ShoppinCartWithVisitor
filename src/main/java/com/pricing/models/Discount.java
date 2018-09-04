package com.pricing.models;

import com.pricing.models.common.IShoppingCartElement;
import com.pricing.models.common.IShoppingCartVisitor;

public class Discount implements IShoppingCartElement {

	  private int discount;
	  private ShoppingCart shoppingCart;
	  
	  public Discount(int discount) {
	    super();
	    this.discount = discount;
	  }
	  
	  @Override
	  public void accept(IShoppingCartVisitor shoppingCartVisitor) {
	    shoppingCartVisitor.visitDiscount(this);
	  }

	  public int getDiscount() {
	    return discount;
	  }

	  public void setDiscount(int discount) {
	    this.discount = discount;
	  }

	  public ShoppingCart getShoppingCart() {
	    return shoppingCart;
	  }

	  public void setShoppingCart(ShoppingCart shoppingCart) {
	    this.shoppingCart = shoppingCart;
	  }

	}