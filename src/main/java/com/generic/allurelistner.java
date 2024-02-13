//package com.generic;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.google.common.io.Files;
//
//import io.qameta.allure.Allure;
//import io.qameta.allure.Attachment;
//import io.qameta.allure.Step;
//
//public class allurelistner extends Base  implements ITestListener{
//
//	 @Step("Failure screenshot: {methodName} - {time}")
//	    @Attachment(value = "Failure screenshot: {methodName} - {time}", type = "image/png")
//	    public  byte[] captureScreenshotFile1(ITestResult result) {
//	        if (ITestResult.FAILURE == result.getStatus()) {
//	            String methodName = result.getMethod().getMethodName();
//
//	            try {
//	                // Assuming 'driver' is an instance of TakesScreenshot
//	                TakesScreenshot ts = (TakesScreenshot) driver;
//	                File srcFile = ts.getScreenshotAs(OutputType.FILE);
//
//	                // Build a dynamic path for the screenshot with date and time
//	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//	                String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
//
//	                String className = result.getTestClass().getName();
//	                String screenshotPath = "./Screenshot_Reports/result/" + className +
//	                        "/classresult" + methodName + "_" + timeStamp + "_screenshot.png";
//
//	                // Create a File object for the destination
//	                File destFile = new File(screenshotPath);
//
//	                // Use FileUtils to copy the screenshot file
//	                FileUtils.copyFile(srcFile, destFile);
//
//	                // Attach screenshot to the Allure report
//	                return attachScreenshotToAllure(destFile, methodName, timeStamp);
//
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	                return null;
//	            }
//	        }
//	        return null;
//	    }
//
//	    @Attachment(value = "Failure screenshot: {methodName} - {time}", type = "image/png")
//	    public byte[] attachScreenshotToAllure(File screenshotFile, String methodName, String time) {
//	        try {
//	            // Attach screenshot to the Allure report
//	            return FileUtils.readFileToByteArray(screenshotFile);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//	    
//}
//
//		
//}
