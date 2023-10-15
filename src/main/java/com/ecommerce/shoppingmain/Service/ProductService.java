package com.ecommerce.shoppingmain.Service;

import com.ecommerce.shoppingmain.Model.Product;
import com.ecommerce.shoppingmain.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
public ProductService(ProductRepo productRepo){
    this.productRepo=productRepo;
}

public List<Product>FindAllProduct(){
    return productRepo.findAll();
}
public Optional<Product> FindProduct(long id){
    return productRepo.findById(id);
}
public Product addproduct(Product product){
    return productRepo.save(product);
}
public void deleteProductById(long id){
    productRepo.deleteById(id);
}
public List<Product>getCustomerByDate(String startDate, String endDate){
    return productRepo.getCustomerByDate(startDate,endDate);
}

}
