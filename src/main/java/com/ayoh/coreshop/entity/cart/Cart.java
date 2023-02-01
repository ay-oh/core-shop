package com.ayoh.coreshop.entity.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 장바구니 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "carts")
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_no")
    private Long id;

}
