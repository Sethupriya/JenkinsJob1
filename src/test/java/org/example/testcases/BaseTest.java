package org.example.testcases;

import org.example.driver.Driver;
import org.testng.annotations.*;

import java.util.Map;

public class BaseTest {
    //@Parameters("browser")
    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        Driver.initDriver(map.get("browser"));
    }

    /* FOR CROSS BROWSER TESTING
    protected void setUp(String browser){
    //Driver.initDriver("Edge");
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                //DriverManager.setDriver(DriverFactory.getDriver(ConfigReader.getProperty(Configproperties.BROWSER)));
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        DriverManager.getDriver().get(ConfigReader.getProperty(Configproperties.URL));
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty(Configproperties.IMPLICIT_WAIT))));

    }
     */
    //@Parameters("browser")
    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        Driver.quitDriver();
    }
}
