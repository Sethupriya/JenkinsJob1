package org.example.driver;

import org.example.config.ConfigReader;
import org.example.enums.Configproperties;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public class Driver {

    /*public static void main(String args[]) {
        String browser = "Chrome";
        String URL = "https://www.google.com";
        Driver.openBrowser(browser, URL);
    }*/
    private Driver(){}
    static WebDriver driver;
    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
                //DriverManager.setDriver(DriverFactory.getDriver(browser));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        DriverManager.getDriver().get(ConfigReader.getProperty(Configproperties.URL));
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty(Configproperties.IMPLICIT_WAIT))));
    }

public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unLoad();
        }
}
}