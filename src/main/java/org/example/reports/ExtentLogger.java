package org.example.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.example.config.ConfigReader;
import org.example.enums.Configproperties;
import org.example.utils.Screenshot;

public class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }
    public static void pass(String message,boolean isScreenShotRequired){
        if(ConfigReader.getProperty(Configproperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotRequired){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.getBase64ScreenShot()).build());
        }
        else {
            pass(message);
        }
    }

    public static void fail(String message,boolean isScreenShotRequired){
        if(ConfigReader.getProperty(Configproperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenShotRequired){
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(Screenshot.getBase64ScreenShot()).build());
        }
        else{
            fail(message);
        }
    }
}
