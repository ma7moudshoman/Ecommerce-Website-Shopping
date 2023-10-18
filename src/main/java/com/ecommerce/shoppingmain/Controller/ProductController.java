package com.ecommerce.shoppingmain.Controller;

import com.ecommerce.shoppingmain.Entity.DateRange;
import com.ecommerce.shoppingmain.Entity.ProductDTO;
import com.ecommerce.shoppingmain.Model.Product;
import com.ecommerce.shoppingmain.Repository.ProductRepo;
import com.ecommerce.shoppingmain.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
     private ProductService productService;
@Autowired
    private ProductRepo productRepo;


@GetMapping("/products")
    public String AllProducts(Model model){
    model.addAttribute("products",productService.FindAllProduct());
    model.addAttribute("DateRange", new DateRange());
    return "products";
}
@GetMapping("/GetCustomer")
    public  String getCustomerByDate(Model model , @ModelAttribute DateRange dateRange){
    List<Product> products = productService.getCustomerByDate(dateRange.getStartDate(), dateRange.getEndDate());
    model.addAttribute("products" ,products);
    model.addAttribute("DateRange" , new DateRange());
    return "products";
}
@GetMapping("/delete/{id}")
    private String delete (@PathVariable long id){
    productService.deleteProductById(id);
    return "redirect:/products";
}
@GetMapping("/update/{id}")
    public  String update(@PathVariable Long id , Model model){
    Product product = productService.FindProduct(id).get();
    ProductDTO productDTO= new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setFullName(product.getFullName());
    productDTO.setAge(product.getAge());
    productDTO.setDate(product.getDate());
    productDTO.setName(product.getName());
    productDTO.setDescription(product.getDescription());
    productDTO.setPrice(product.getPrice());
    productDTO.setGender(product.getGender());
    model.addAttribute("DTO" ,productDTO );
    return "addProduct";
}

@PostMapping("/addProduct")
    private String addProduct(@ModelAttribute ("dto") ProductDTO  dto, Model model  ){

    Product product= new Product();
    product.setId(dto.getId());
    product.setAge(dto.getAge());
    product.setDate(dto.getDate());
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());
    product.setGender(dto.getGender());
    product.setFullName(dto.getFullName());
    product.setDescription(dto.getDescription());
    productService.addProduct(product);
    return "redirect:/products";

}
@GetMapping("/AdoutUs")
    public  String aboutus(){
    return "AboutUs";

}
@GetMapping("/test")
    public String test(Model model){
    return "test";
}
@GetMapping("/testJason")
    public String test(){
    return "testJason";
}






}
