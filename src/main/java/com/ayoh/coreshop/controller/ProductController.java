package com.ayoh.coreshop.controller;

import com.ayoh.coreshop.dto.ProductDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping(path = "/products")
    public String goProductsPage(Model model) {
        ProductDto productDto = new ProductDto(1L, "테스트 상품 1", 39_800L, "테스트 상품 상세 설명", LocalDateTime.now(),
                                               LocalDateTime.now());

        model.addAttribute("result", productDto);

        return "index";
    }

}
