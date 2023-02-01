package com.ayoh.coreshop.entity.cartproducts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 장바구니 상품 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "cart_products")
@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_product_no")
    private Long id;

    @Column
    private Integer count;

}
