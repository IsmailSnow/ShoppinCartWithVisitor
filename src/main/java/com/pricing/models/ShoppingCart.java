package com.pricing.models;

import java.util.ArrayList;
import java.util.List;

import com.pricing.models.common.IShoppingCartElement;
import com.pricing.models.common.IShoppingCartVisitor;

public class ShoppingCart implements IShoppingCartElement {

	  private List<IShoppingCartElement> cartItems = 
	          new ArrayList<IShoppingCartElement>();
	  
	  private double totalBill;
	  
	  public void addCartItem(CartItem shoppingCartElement) {
	    shoppingCartElement.setShoppingCart(this);
	    cartItems.add(shoppingCartElement);
	  }
	  
	  
	  public void giveDiscount() {
	    Discount discount = new Discount(10);
	    discount.setShoppingCart(this);
	    cartItems.add(discount);
	  }

	  @Override
	  public void accept(IShoppingCartVisitor shoppingCartVisitor) {
	    shoppingCartVisitor.visitShoppingCart(this);
	  }

	  public List<IShoppingCartElement> getCartItems() {
	    return cartItems;
	  }

	  public void setCartItems(List<IShoppingCartElement> cartItems) {
	    this.cartItems = cartItems;
	  }

	  public double getTotalBill() {
	    return totalBill;
	  }

	  public void setTotalBill(double totalBill) {
	    this.totalBill = totalBill;
	  }
	}
