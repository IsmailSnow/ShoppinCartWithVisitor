package com.pricing.models.common;

import com.pricing.models.CartItem;
import com.pricing.models.Discount;
import com.pricing.models.ShoppingCart;

public interface IShoppingCartVisitor {
	  public void visitShoppingCart(ShoppingCart shoppingCart);
	  public void visitCartItem(CartItem cartItem);
	  public void visitDiscount(Discount discount);
	}
