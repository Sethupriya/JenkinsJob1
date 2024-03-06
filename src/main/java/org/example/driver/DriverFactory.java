package org.example.driver;

import org.example.config.ConfigReader;
import org.example.enums.Configproperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private DriverFactory() {
    }

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        WebDriver driver = null;

        String runmode = ConfigReader.getProperty(Configproperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(String.valueOf(Browser.CHROME));
                driver = new RemoteWebDriver(new URL(ConfigReader.getProperty(Configproperties.SELENIUMGRIDURL)), capabilities);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("Edge")) {

            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(String.valueOf(Browser.EDGE));
                capabilities.setCapability("--headless",true);
                driver = new RemoteWebDriver(new URL(ConfigReader.getProperty(Configproperties.SELENIUMGRIDURL)), capabilities);
            } else {
                //EdgeDriverService service =
                        //new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();
                driver = new EdgeDriver();
            }
        }else if (browser.equalsIgnoreCase("FireFox")) {

            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(String.valueOf(Browser.FIREFOX));
                driver = new RemoteWebDriver(new URL(ConfigReader.getProperty(Configproperties.SELENIUMGRIDURL)), capabilities);
            } else {
                driver = new FirefoxDriver();
            }
        }
        else {
            //driver = new ChromeDriver();
            //driver.get(URL);
            System.out.println("Passed browser name " + browser + " is invalid");
        }
        return driver;

    }

}
