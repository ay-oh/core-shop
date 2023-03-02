package com.ayoh.coreshop.entity.product;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

/**
 * 회원 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "products")
@Entity
@Getter
@Setter
@ToString
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

    @Enumerated(EnumType.STRING)
    @Column(name = "sell_status")
    private ProductSellStatus sellStatus;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_at")
    private LocalDateTime updatedDate;

}
