package org.example.utils;

import org.apache.commons.io.FileUtils;
import org.example.constants.FrameworkConstant;
import org.example.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void screenShot(String testmethodname){
        //return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        //FrameworkConstant.getSCREENSHOTPATH() + "screnshot" + testmethodname + ".png";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File src =((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(FrameworkConstant.getSCREENSHOTPATH()+testmethodname+"-"+DateFormat.dateFormat() +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBase64ScreenShot(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
