package org.example.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    @DataProvider(name="login")
    public static Object[] getData(Method m) throws IOException {
        String testName = m.getName();
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        if(list.isEmpty()) {
            /*int sheetCount=ExcelUtils.getSheetName();
            for(int i=0;i<=sheetCount;i++){
                if(list.get(i).)
            }*/
            list = ExcelUtils.getExcelData("Login");
            //System.out.println(list);
        }
        List<Map<String,String>> smallList = new ArrayList<>();
        for(int i=0;i< list.size();i++){
            if(list.get(i).get("testname").equalsIgnoreCase(testName)){
                if(list.get(i).get("execute").equalsIgnoreCase("yes")){
                    smallList.add(list.get(i));
                }
            }
        }
        return smallList.toArray();
    }
}
