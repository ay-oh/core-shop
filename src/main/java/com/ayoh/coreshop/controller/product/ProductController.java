package com.ayoh.coreshop.controller.product;

import com.ayoh.coreshop.entity.product.Product;
import com.ayoh.coreshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * layered architecture (레이어드 아키텍처)
 * 스트레오타입 애노테이션
 * <p>
 * 컨트롤러의 역할은 사용자의 요청을 받으면 필요한 작업을 담당하는 서비스에게 위임하고, 응답만 적절하게 받아서 뷰로 전달한다.
 */
@Controller
public final class ProductController {

    // Mission #1: @Autowired

    // final 의 용도
    // 1. 변수에 final 이 붙으면? > 재할당 금지
    // 2. 메서드에 final 이 붙으면? -> 오버라이딩(재정의) 금지
    // 3. 클래스에 final 이 붙으면? -> 상속 금지
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Model View Controller -> layered 아키텍처
    // http://localhost:8080/index.html
    @GetMapping(path = "/")
    public String goProductsPage(Model model) {
        // ProductDto productDto = new ProductDto(1L, "테스트 상품 1", 39_800L, "테스트 상품 상세 설명", LocalDateTime.now(), LocalDateTime.now());

        // 1. ProductService 의 여러 기능이 있을 텐데, 전체 상품의 목록을 조회하는 기능을 호출한다.
        Collection<Product> products = productService.getProducts();

        // 2. 상품 목록 응답 값을 받아서 전달할 뷰에 모델을 담는다.
        // model.addAttribute("productDto", products);
        model.addAttribute("result", products);

        return "index";
    }

}
