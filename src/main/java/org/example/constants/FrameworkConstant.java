package org.example.constants;

import org.example.config.ConfigReader;
import org.example.enums.Configproperties;
import org.example.utils.DateFormat;

import java.time.Duration;

public final class FrameworkConstant {

    private static Duration EXPLICITWAIT;

    private FrameworkConstant(){}
    private final static String RESOURCEPATH = System.getProperty("user.dir")+"/src/main/java/org/example";
    private final static String TESTRESOURCEPATH = System.getProperty("user.dir")+"/src/test";
    private final static String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
    private final static String SCREENSHOTPATH= RESOURCEPATH+"/screenshotfolder/";
    private final static String EXCELFILEPATH= TESTRESOURCEPATH+"/resources/login_testdata.xlsx";
    private final static String EXTENTREPORTFOLDERPATH=RESOURCEPATH+"/Extent-output/";
    static String extentreportfilepath="";

    public static String getCONFIGFILEPATH() {
        return CONFIGFILEPATH;
    }

    public static String getSCREENSHOTPATH() {
        return SCREENSHOTPATH;
    }

    public static String getEXCELFILEPATH(){
        return EXCELFILEPATH;
    }

    public static String getExtentreportfilepath(){
        if(extentreportfilepath.isEmpty()){
            extentreportfilepath=createReportPath();
        }
        return extentreportfilepath;
    }

    private static String createReportPath(){
        if (ConfigReader.getProperty(Configproperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+ DateFormat.dateFormat() +"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"index.html";
        }
    }

    public static Duration getExplicitwait() {
        EXPLICITWAIT= Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty(Configproperties.EXPLICIT_WAIT)));
        return EXPLICITWAIT;
    }


}
