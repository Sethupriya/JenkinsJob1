package org.example.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.constants.FrameworkConstant;
import org.example.exceptions.FrameworkException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelUtils {

    private ExcelUtils(){
    }

    public static List<Map<String,String>> getExcelData(String sheetname){
        List<Map<String,String>> list = null;
        try (FileInputStream fis = new FileInputStream(FrameworkConstant.getEXCELFILEPATH())){
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetname);
            int row_total = sheet.getLastRowNum();
            int column_total= sheet.getRow(0).getLastCellNum();

            list = new ArrayList<>();
            Map<String,String> map = null;

            for(int i=1;i<=row_total;i++){
                map = new HashMap<>();
                for(int j=0;j<column_total;j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new FrameworkException("File not Found exception"+e.getMessage());
            //System.out.println("File not found exception: "+e.getMessage());
        } catch (IOException e) {
            throw new FrameworkException("IO exception"+e.getMessage());
            //System.out.println("IO Exception : "+e.getMessage());
        }
        //System.out.println(list);
        return list;
    }

    public static int getSheetName() throws IOException {
        FileInputStream fis = new FileInputStream(FrameworkConstant.getEXCELFILEPATH());
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetCount=workbook.getNumberOfSheets();
        return sheetCount;
    }

}
