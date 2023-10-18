package com.ecommerce.shoppingmain.Service;

import com.ecommerce.shoppingmain.Model.ExcelTest;
import com.ecommerce.shoppingmain.Repository.ExcelRepo;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ExcelService {
    @Autowired
    private ExcelRepo excelRepo;

    public ExcelService(ExcelRepo excelRepo) {
        this.excelRepo = excelRepo;
    }

    public List<ExcelTest> findAllExcelTest() {
        return excelRepo.findAll();
    }

    public Optional<ExcelTest> findExcelTest(long id) {
        return excelRepo.findById(id);
    }

    public ExcelTest addExcelTest(ExcelTest excelTest) {
        return excelRepo.save(excelTest);
    }

    public void deleteExcelTest(long id) {
        excelRepo.deleteById(id);
    }

    public Boolean saveDataFromUploadFile(MultipartFile multipartFile) {
        Boolean isFlag = false;
        String excelTest = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        if (excelTest.equalsIgnoreCase("xls") || excelTest.equalsIgnoreCase("xlsx")) ;
        isFlag = readDataFromExcel(multipartFile);

        return true;
    }


    private Boolean readDataFromExcel(MultipartFile multipartFile) {
        Workbook workbook = getWorkBook(multipartFile);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()) {

            Row row = rows.next();
            ExcelTest test = new ExcelTest();
            if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
                test.setFirstName(row.getCell(0).getStringCellValue());
            }
            if (row.getCell(1).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                String salary = NumberToTextConverter.toText(row.getCell(1).getNumericCellValue());
                test.setSalary(salary);
            } else if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
                test.setSalary(row.getCell(1).getStringCellValue());
            }
            test.setFileType(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
            excelRepo.save(test);
        }
    return true;
    }

private Workbook getWorkBook(MultipartFile multipartFile){
        Workbook workbook=null;
        String extention = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        try {
            if (extention.equalsIgnoreCase("xlsx")){
                workbook=new XSSFWorkbook(multipartFile.getOriginalFilename());
            } else if (extention.equalsIgnoreCase("xls")) {
                workbook=new HSSFWorkbook(multipartFile.getInputStream());
            }

        }catch (Exception p){
            System.out.println(p);
        }
        return workbook;

    }

}


