package com.pricing.service;

import com.pricing.models.CartItem;
import com.pricing.models.Discount;
import com.pricing.models.ShoppingCart;
import com.pricing.models.common.IShoppingCartVisitor;

public class GenerateBillShoppingCartVisitor implements IShoppingCartVisitor {

	@Override
	public void visitCartItem(CartItem cartItem) {

		double itemCost = cartItem.getItemCount() * cartItem.getPrice();
		cartItem.getShoppingCart().setTotalBill(cartItem.getShoppingCart().getTotalBill() + itemCost);

		System.out.println(cartItem.getItemCount() + " " + cartItem.getName().toUpperCase() + "(" + cartItem.getPrice()
				+ ") - Rs." + itemCost);
	}

	@Override
	public void visitDiscount(Discount discount) {
		System.out.println("\nTotal bill : " + discount.getShoppingCart().getTotalBill());
		discount.getShoppingCart()
				.setTotalBill(discount.getShoppingCart().getTotalBill() * (100 - discount.getDiscount()) / 100);

		System.out.println(
				"After Discount (" + discount.getDiscount() + "%) : " + discount.getShoppingCart().getTotalBill());
	}


	@Override
	public void visitShoppingCart(ShoppingCart shoppingCart) {

		System.out.println("---- GenerateBillShoppingCartVisitor ----");

		for (int i = 0; i < shoppingCart.getCartItems().size(); i++) {
			shoppingCart.getCartItems().get(i).accept(this);
		}

		System.out.println("\nAmount to pay : " + shoppingCart.getTotalBill());
	}

}