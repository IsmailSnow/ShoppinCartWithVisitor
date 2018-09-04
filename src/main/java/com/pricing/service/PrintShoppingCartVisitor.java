package com.pricing.service;

import com.pricing.models.CartItem;
import com.pricing.models.Discount;
import com.pricing.models.ShoppingCart;
import com.pricing.models.common.IShoppingCartVisitor;

public class PrintShoppingCartVisitor implements IShoppingCartVisitor {

	@Override
	public void visitCartItem(CartItem cartItem) {
		System.out.println(cartItem.getItemCount() + " " + cartItem.getName().toUpperCase() + "(S) each costing Rs."
				+ cartItem.getPrice());
	}

	@Override
	public void visitDiscount(Discount discount) {
		System.out.println("Discount : " + discount.getDiscount() + "%");
	}

	@Override
	public void visitShoppingCart(ShoppingCart shoppingCart) {

		System.out.println("---- PrintShoppingCartVisitor ----");

		for (int i = 0; i < shoppingCart.getCartItems().size(); i++) {
			shoppingCart.getCartItems().get(i).accept(this);
		}

	}
}
