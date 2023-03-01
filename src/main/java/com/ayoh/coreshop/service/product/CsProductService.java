package com.ayoh.coreshop.service.product;

import com.ayoh.coreshop.entity.product.Product;
import com.ayoh.coreshop.entity.product.ProductSellStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 스트레오타입 애너테이션(stereotype: 편견, 선입견) annotation).
 */
@Service
public class CsProductService implements ProductService {

    @Override
    public List<Product> getProducts() {
        // 여기서 미리 3개 정도 상품 데이터를 세팅
        // 변수를 사용하는 이유: 재활용하기 위해서
        Product product1 = new Product();
        product1.setName("노스페이스 패딩");
        // product1.setPrice(1_000_000_000);
        product1.setPrice(198_000);
        product1.setDetails("이건 우리 학창시절에 아주 유행했던 경량화 패딩입니다.");
        product1.setSellStatus(ProductSellStatus.FOR_SALE);
        product1.setCreatedDate(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("노스페이스 패딩 2");
        // product1.setPrice(1_000_000_000);
        product2.setPrice(108_000);
        product2.setDetails("이건 우리 학창시절에 아주 유행했던 경량화 패딩입니다.");
        product2.setSellStatus(ProductSellStatus.FOR_SALE);
        product2.setCreatedDate(LocalDateTime.now());

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        List.of(product1, product2, product1, product2);

        return products;
    }

}
