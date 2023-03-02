package com.ayoh.coreshop.controller.product;

import com.ayoh.coreshop.dto.product.ProductCreateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminProductController {

    @GetMapping(path = "/admin/products/new")
    public String newProduct(Model model) {
        model.addAttribute("productCreateRequest", ProductCreateRequest.empty());
        return "pages/products/form";
    }

}
