package com.ayoh.coreshop.repository;

import com.ayoh.coreshop.entity.product.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.details LIKE %:details% ORDER BY p.price DESC")
    List<Product> findByDetails(@Param("details") String details);

    @Query(value = "SELECT * FROM products p WHERE p.details LIKE %:details% ORDER BY p.price DESC",
           nativeQuery = true)
    List<Product> findByDetailsByNativeQuery(@Param("details") String details);

}
