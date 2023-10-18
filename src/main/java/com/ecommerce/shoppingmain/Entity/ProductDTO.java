package com.ecommerce.shoppingmain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private  long id;
    private long price;
    private long age;
    private LocalDate Date;
    private  String FullName;
    private  String startDate;
    private  String endDate;
    private  String name;
    private  String description;




}
