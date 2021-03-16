package com.hciulica.springbootecommerce.dao;

import com.hciulica.springbootecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
