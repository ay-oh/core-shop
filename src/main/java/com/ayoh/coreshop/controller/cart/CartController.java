package com.ayoh.coreshop.controller.cart;

import com.ayoh.coreshop.dto.cart.CartAddRequest;
import com.ayoh.coreshop.dto.cart.CartResponse;
import com.ayoh.coreshop.dto.cart.CartUpdateRequest;
import com.ayoh.coreshop.entity.cart.Cart;
import com.ayoh.coreshop.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    /**
     * 장바구니를 새로 생성한다.
     */
    @PostMapping(path = "/carts/create")
    public ResponseEntity<?> createCart() {
        if (isValidCreateUser()) {
            throw new IllegalArgumentException("장바구니 생성 시 비회원 정보가 없거나 회원 인증 정보가 포함되어 있습니다.");
        }

        Cart cart = cartService.createCart(false);

        return ResponseEntity.created(URI.create("")).body(cart);
    }

    /**
     * 장바구니에 상품을 담는다.
     *
     * @return
     */
    @PostMapping(path = "/carts/add")
    public ResponseEntity<?> addProductToCart(@RequestBody @Valid CartAddRequest cartAddRequest) {
        CartResponse cartResponse = cartService.addProductToCart(cartAddRequest);
        return ResponseEntity.created(URI.create("")).body(cartResponse);
    }

    private static boolean isValidCreateUser() {
        return false;
        // return ObjectUtils.isNotEmpty(getCurrentMemberId()) || ObjectUtils.isEmpty(getNonmemberCartKey());
    }

    /**
     * 회원 번호로 장바구니 번호를 조회한다.
     *
     * @param memberId 회원 번호
     * @return
     */
    @GetMapping(path = "/carts/members/{memberId}")
    public ResponseEntity<?> retrieveCartIdByMemberId(@PathVariable long memberId) {
        return null;
    }

    /**
     * 장바구니 번호로 장바구니 정보를 조회한다.
     *
     * @param cartId 장바구니 번호
     * @return
     */
    @GetMapping(path = "/carts/{cartId}")
    public ResponseEntity<?> retrieveCartByCartId(@PathVariable long cartId) {
        return null;
    }

    /**
     * 장바구니에 담긴 상품 수량을 조회한다.
     *
     * @param cartId 장바구니 번호
     * @return
     */
    @GetMapping(path = "/carts/count")
    public ResponseEntity<?> retrieveCartProductCount(@RequestParam(required = false) Long cartId) {
        return null;
    }

    @PutMapping("/carts/update")
    public ResponseEntity<?> updateProductInCart(@RequestBody @Valid CartUpdateRequest cartUpdateRequest) {
        return null;
    }

    @DeleteMapping("/carts/remove")
    public ResponseEntity<?> removeProductInCart(@RequestBody @Valid CartUpdateRequest cartUpdateRequest) {
        return null;
    }

}
