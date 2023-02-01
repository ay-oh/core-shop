package com.ayoh.coreshop.entity.product;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 회원 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column(name = "stock_number")
    private Integer stockNumber;

    @Column
    private String details;

    @Convert(converter = ProductSellStatusConverter.class)
    @Column(name = "sell_status")
    private ProductSellStatus sellStatus;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

}
