package com.ecommerce.shoppingmain.Service;

import com.ecommerce.shoppingmain.Repository.ExcelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {
    @Autowired
    private ExcelRepo excelRepo;

}
