package com.ayoh.coreshop.entity.orderproduct;

import com.ayoh.coreshop.entity.product.ProductSellStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 주문 상품 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "order_products")
@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_no")
    private Long id;

    // TODO #1: @Enumerated 애노테이션을 @Convert 로 수정하세요.
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private ProductSellStatus sellStatus;

    @Column(name = "order_at")
    private LocalDateTime orderDate;

}
