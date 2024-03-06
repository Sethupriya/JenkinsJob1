package org.example.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.example.constants.FrameworkConstant;
import org.example.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {

    private ExtentReport() {
    }

    private static ExtentReports extentReports;

    public static void initReports() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstant.getExtentreportfilepath());
            extentReports.attachReporter(extentSparkReporter);
            extentSparkReporter.config().setReportName("SPD Report");
            extentSparkReporter.config().setTheme(Theme.STANDARD);
            extentSparkReporter.config().setDocumentTitle("Automation Report without cucumber");
        }
    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unLoad();
        //Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentreportfilepath()).toURI());
    }

    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extentReports.createTest(testcasename));
    }

    public static void addAuthors(String[] authors) {
        for (String temp : authors) {
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType temp : categories) {
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }
}