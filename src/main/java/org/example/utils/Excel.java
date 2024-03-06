package org.example.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Excel {
    //@Test
    public static void row_count() throws IOException, InvalidFormatException {
        File file =new File("C:/Users/sethu/Selenium/Projectwithoutcucumber/src/test/resources/login_testdata.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);
        XSSFSheet sheet=workbook.getSheet("Sheet1");
        int use_last_row=sheet.getLastRowNum();
        int use_physical_rows=sheet.getPhysicalNumberOfRows();
        System.out.println("Last row: "+use_last_row);//display the last not null index value
        //Assert.assertNull(sheet.getRow(4));
        System.out.println("Physical row: "+use_physical_rows);//display the initialised value only
    }
}
