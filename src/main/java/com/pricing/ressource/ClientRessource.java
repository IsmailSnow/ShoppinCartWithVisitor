package com.pricing.ressource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.models.CartItem;
import com.pricing.models.ShoppingCart;
import com.pricing.service.GenerateBillShoppingCartVisitor;
import com.pricing.service.PrintShoppingCartVisitor;

@RestController
@RequestMapping("/shoppingCart")
public class ClientRessource {

	@RequestMapping("/command")
	public String getCommand() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addCartItem(new CartItem("Apple", 4, 12.50));
		shoppingCart.addCartItem(new CartItem("Mango", 6, 24.50));
		shoppingCart.addCartItem(new CartItem("Orange", 8, 6.50));
		shoppingCart.giveDiscount();

		shoppingCart.accept(new PrintShoppingCartVisitor());
		System.out.println();
		shoppingCart.accept(new GenerateBillShoppingCartVisitor());

		return "Hello World";
	}

}
