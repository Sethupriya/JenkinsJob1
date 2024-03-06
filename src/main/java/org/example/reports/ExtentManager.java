package org.example.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {

    private ExtentManager(){}

    private static ThreadLocal<ExtentTest> extest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){
            return extest.get();
    }

    static void setExtentTest(ExtentTest test){
        if(Objects.nonNull(test)){
            extest.set(test);
        }
    }

    static void unLoad(){
        extest.remove();
    }
}
