package com.ecommerce.shoppingmain.Service;

import com.ecommerce.shoppingmain.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;



}
