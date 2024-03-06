package org.example.utils;

import org.example.config.ConfigReader;
import org.example.driver.DriverManager;
import org.example.enums.Configproperties;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicitwait {

    public static void explicitWait(){
        WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(),
                Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty(Configproperties.EXPLICIT_WAIT))));
    }

}
