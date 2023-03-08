package com.ayoh.coreshop.service.cart;

import com.ayoh.coreshop.dto.cart.CartAddRequest;
import com.ayoh.coreshop.dto.cart.CartResponse;
import com.ayoh.coreshop.entity.cart.Cart;

public interface CartService {

    Cart createCart(boolean isBuyNow);

    CartResponse addProductToCart(CartAddRequest cartAddRequest);

}
