package com.ayoh.coreshop.entity.order;

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
 * 주문 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_no")
    private Long id;

    // TODO #1: @Enumberated 애노테이션을 @Convert 로 수정하세요.
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private ProductSellStatus sellStatus;

    @Column(name = "order_at")
    private LocalDateTime orderDate;

}
