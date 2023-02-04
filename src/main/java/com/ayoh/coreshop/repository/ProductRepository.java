package com.ayoh.coreshop.repository;

import com.ayoh.coreshop.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
