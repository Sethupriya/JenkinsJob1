package org.example.config;

import org.example.constants.FrameworkConstant;
import org.example.enums.Configproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {

   /* public static WebDriver callOpenBrowser(){
        //WebDriver driver =
       return Driver.openBrowser(ConfigReader.getProperty(Configproperties.BROWSER),
                ConfigReader.getProperty(Configproperties.URL), Integer.parseInt(ConfigReader.getProperty(Configproperties.IMPLICIT_WAIT)));
    }*/

    static HashMap<String, String> configmap = new HashMap<>();

static {
    Properties prop = new Properties();

    try (FileInputStream fis = new FileInputStream(FrameworkConstant.getCONFIGFILEPATH())) {
        prop.load(fis);
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            configmap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    public static String getProperty(Configproperties key) {
//To check the key and value is null or not
        if(Objects.isNull(key) || Objects.isNull(configmap.get(key.name().toLowerCase()))){
            System.out.println("Key" + key+" is not present");
        }
        //System.out.println("Key is : "+key.name().toLowerCase() + "\t" + "Value is : " +configmap.get(key.name().toLowerCase()));

        return configmap.get(key.name().toLowerCase());
    }

}
