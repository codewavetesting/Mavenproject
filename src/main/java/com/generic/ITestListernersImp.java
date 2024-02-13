package com.generic;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ITestListernersImp extends Base implements ITestListener {
  
	public void onTestFailure(ITestResult result) {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        String methodName = result.getMethod().getMethodName();

	        // Create ExtentTest instance
	        ExtentTest test = extent.createTest(methodName + " - Test Failure");

	        try {
	            // Assuming 'driver' is an instance of TakesScreenshot
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File srcFile = ts.getScreenshotAs(OutputType.FILE);

	            // Build a dynamic path for the screenshot with date and time
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	            String timeStamp = dateFormat.format(Calendar.getInstance().getTime());

	            String className = result.getTestClass().getName();
	            String screenshotPath = "./Screenshot_Reports/result/" + className +
	                                    "/classresult" + methodName + "_" + timeStamp + "_screenshot.png";

	            // Create a File object for the destination
	            File destFile = new File(screenshotPath);

	            // Use FileUtils to copy the screenshot file
	            FileUtils.copyFile(srcFile, destFile);

	            // Attach screenshot to the Extent Report
	            test.fail("Test Failed - See screenshot below:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	        } catch (Exception e) {
	            e.printStackTrace();
	        
	    }
	    }}
	
	
	
}
	   
		
	
	
