package com.pricing.models.common;

public interface IShoppingCartElement {
	  public void accept(IShoppingCartVisitor shoppingCartVisitor);
	}
