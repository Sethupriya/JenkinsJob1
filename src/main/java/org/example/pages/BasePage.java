package org.example.pages;

import org.example.driver.DriverManager;
import org.example.enums.LogType;
import org.example.enums.WaitStrategy;
import org.example.utils.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.reports.FrameworkLogger.log;

public class BasePage {


    static WebDriver driver;

    public static void sendKeys(WebElement webElement, String value,String message){
        webElement.sendKeys(value);
        //ExtentLogger.pass(message+" is entered",true);
        log(LogType.PASS,message+" is entered");
    }

    public static void click(WebElement webElement,String message){
        webElement.click();
        //ExtentLogger.pass(message + " is clicked",true);
        log(LogType.PASS,message+" is clicked");
    }

    public static void click(By locator, String message){
        findElement(locator).click();
        log(LogType.PASS,message+" is clicked");
    }

    protected void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        log(LogType.PASS,elementname+" is clicked");

    }

    public static WebElement findElement(By locator){
        return DriverManager.getDriver().findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        return DriverManager.getDriver().findElements(locator);
    }

    public static String getTitle(){
        return DriverManager.getDriver().getTitle();
    }

    public static String getURL(){
        return DriverManager.getDriver().getCurrentUrl();
    }
    public static boolean isDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

    public static String getText(WebElement webElement){
        try{
            return webElement.getText();
        }catch (Exception e){
            return "Exception occurred";
        }

    }

    public static void dropDown(By locator,String message,String value){
        List<WebElement> dd = findElements(locator);
        for(WebElement e: dd){
            if(e.getText().equalsIgnoreCase(value)){
                e.click();
            }
        }
    }

}
