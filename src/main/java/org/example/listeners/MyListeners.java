package org.example.listeners;

import org.example.annotations.FrameworkAnnotation;
import org.example.reports.ExtentLogger;
import org.example.reports.ExtentReport;
import org.example.utils.Screenshot;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

import static org.example.enums.LogType.*;
import static org.example.reports.FrameworkLogger.log;

public class MyListeners implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentReport.createTest(iTestResult.getMethod().getDescription());
        ExtentReport.addAuthors(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());
        ExtentReport.addCategories(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .category());
        //String testMethodName = iTestResult.getName();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //String testMethodName = iTestResult.getName();
        //System.out.println(testMethodName);
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //Explicitwait.wait(2000);
        //ExtentLogger.pass(iTestResult.getMethod().getMethodName()+ " is passed");
        log(PASS,iTestResult.getMethod().getMethodName() +" is passed");
        //Screenshot.screenShot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        /*String testMethodName = iTestResult.getName();
        System.out.println(testMethodName);
        Screenshot.screenShot(testMethodName);*/
        /*ExtentLogger.fail(iTestResult.getMethod().getMethodName()+" is failed");
        ExtentLogger.fail(iTestResult.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(iTestResult.getThrowable().getStackTrace()));*/
        log(FAIL,iTestResult.getMethod().getMethodName() +" is failed");
        log(FAIL,iTestResult.getThrowable().toString());
        log(FAIL,Arrays.toString(iTestResult.getThrowable().getStackTrace()));
        //Screenshot.screenShot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        //  ExtentLogger.skip(iTestResult.getMethod().getMethodName()+" is skipped");
        log(SKIP,iTestResult.getMethod().getMethodName() +" is skipped");
        //Screenshot.screenShot(iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage().toString());
        }
    }
}
