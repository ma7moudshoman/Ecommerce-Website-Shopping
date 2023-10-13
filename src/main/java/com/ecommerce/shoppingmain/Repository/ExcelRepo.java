package com.ecommerce.shoppingmain.Repository;

import com.ecommerce.shoppingmain.Model.ExcelTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelRepo extends JpaRepository<ExcelTest,Long> {
}
