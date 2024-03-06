package org.example.listeners;

import org.example.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> list = ExcelUtils.getExcelData("RunManager");
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++) {
            for(int j=0;j<list.size();j++) {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
                        list.get(j).get("execute").equalsIgnoreCase("yes")) {
                    methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
                    result.add(methods.get(i));
                }

            }
        }
        return result;
    }
}
