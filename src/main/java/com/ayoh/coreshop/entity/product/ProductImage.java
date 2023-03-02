package com.ayoh.coreshop.entity.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * 상품 이미지 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "product_images")
@Entity
@Getter
@Setter
@ToString
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_no")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_no")
    private Product product;

    @Column
    private String name;

    @Column(name = "origin_name")
    private String originName;

    @Column
    private String url;

    @Column(name = "display_image_yn")
    private boolean isDisplayImage;

}
