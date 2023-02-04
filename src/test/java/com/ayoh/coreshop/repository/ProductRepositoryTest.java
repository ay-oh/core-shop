package com.ayoh.coreshop.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.ayoh.coreshop.entity.product.Product;
import com.ayoh.coreshop.entity.product.ProductSellStatus;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

// 테스트 코드 실행 시 application.yaml 에 설정해둔 값보다 application-test.yaml 에 같은 설정이 있다면 더 높은 우선순위를 부여
@TestPropertySource(locations = "classpath:application-test.yaml")
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    void testSave() {
        // given
        Product product = new Product();
        product.setName("테스트 상품");
        product.setPrice(10_000);
        product.setStockNumber(100);
        product.setDetails("테스트 상품 상세 설명");
        product.setSellStatus(ProductSellStatus.FOR_SALE);
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());

        // when
        Product savedProduct = productRepository.save(product);

        // then
        assertThat(savedProduct.getName()).isEqualTo("테스트 상품");
    }

}