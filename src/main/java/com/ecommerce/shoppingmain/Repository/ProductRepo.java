package com.ecommerce.shoppingmain.Repository;

import com.ecommerce.shoppingmain.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
