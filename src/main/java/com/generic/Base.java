package com.generic;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static ExtentReports extent;
	protected ExtentTest test;
	public static Base base ;

	@BeforeSuite
	public void setup() throws Throwable {

		extent = extentReportGenerator();
	}

	@Parameters("browsername")
	@BeforeMethod
	public void launchbrowser(java.lang.reflect.Method m,ITestContext context, @Optional("chrome") String browserName) throws Exception {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "internet explorer":
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		default:
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
		Capabilities capability = ((RemoteWebDriver) driver).getCapabilities();
		extent.setSystemInfo("OS", System.getProperty("os.name"));

		extent.setSystemInfo("Selenium Version", System.getProperty("selenium.version"));
		extent.setSystemInfo("Java version", System.getProperty("java.version"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Filelibe fl = new Filelibe();
		String url = fl.getproperty("url");
		driver.get(url);

		String browserInfo = capability.getBrowserName() + " " + capability.getBrowserVersion();
		 test = extent.createTest(m.getName());
		

//		String author = context.getCurrentXmlTest().getParameter("author");
//		test.assignAuthor(author);
		test.assignDevice(browserInfo);

	}

	@AfterMethod
	public void closeBrowser(java.lang.reflect.Method m, ITestResult result) throws Throwable {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			String Screenshotpathfail = capturescreenshot(
					 result.getMethod().getMethodName() + ".jpg");
			test.addScreenCaptureFromPath(Screenshotpathfail);
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(m.getName() + "  " + "this test is passed");
			String Screenshotpathpass = capturescreenshot(
					 result.getMethod().getMethodName() + ".jpg");
			test.addScreenCaptureFromPath(Screenshotpathpass);
		}
		 else if (result.getStatus() == ITestResult.SKIP) {
				test.pass(m.getName() + "  " + "this test is Skipped");
				String Screenshotpathskipped = capturescreenshot(
						result.getMethod().getMethodName() + ".jpg");
				test.addScreenCaptureFromPath(Screenshotpathskipped);
		}
		test.assignCategory(m.getAnnotation(Test.class).groups());
		driver.quit();

	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//		String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
//		String path = System.getProperty("user.dir") + "/HTMLReports/ExtentReport/report-" + timeStamp + ".html";
//		try {
//		    Desktop.getDesktop().browse(new File(path).toURI());
//		} catch (IOException e) {
//		    e.printStackTrace();
//		    System.out.println("Report not opening. Error message: " + e.getMessage());
//		}

		
		base.closeserver();
		   // Open the Extent report automatically
        try {
            openExtentReport();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error opening the Extent report: " + e.getMessage());
        }

	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	
	
	

//    Methods of base class 
	private static  ExtentReports extentReportGenerator() throws Throwable {
		String separator = File.separator;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
		String path = System.getProperty("user.dir") + separator + "HTMLReports" + separator + "ExtentReport"
				+ separator + "report-" + timeStamp + ".html";
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.loadJSONConfig(new File("./src/main/resources/extentreportsconfig.json"));
		reporter.viewConfigurer().viewOrder().as(new ViewName[] {

				ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.EXCEPTION, ViewName.LOG, ViewName.AUTHOR,
				ViewName.DEVICE }).apply();

		extent.attachReporter(reporter);

		return extent;
	}

	public void login() throws Exception {
		Filelibe fl = new Filelibe();
		String email = fl.getproperty("email");
		String password = fl.getproperty("password");

		com.pom.login log = new com.pom.login(driver);
		log.getemail().sendKeys(email);
		log.getpassword().sendKeys(password);
		log.getloginbtn().click();

	}

	public void logout() {
		com.pom.login log = new com.pom.login(driver);
		log.getlogoutmenu().click();
		log.getlogout().click();
	}

	public void closeserver() {
		try {
			String processName = "chrome.exe";
			Process process = Runtime.getRuntime().exec("taskkill /F /IM " + processName);
			process.waitFor();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public String getMethodName() {
		// Use reflection to get the current method name
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		String methodName = stackTraceElements[2].getMethodName();
		return methodName;
	}

	public static String capturescreenshot(String filename) throws Throwable

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
		String screenshotPath = "./Screenshot/" + "/" + timeStamp + "_screenshot.png";

		File desfile = new File(screenshotPath);
		FileUtils.copyFile(src, desfile);
		return desfile.getAbsolutePath();
	}

	public static String base64() throws Throwable

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
		String screenshotPath = "./Screenshot/" + "/" + timeStamp + "_screenshot.png";
		return base64;
	}
	 private void openExtentReport() throws IOException {
	        String separator = File.separator;
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	        String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
	        String path = System.getProperty("user.dir") + separator + "HTMLReports" + separator + "ExtentReport" + separator + "report-" + timeStamp + ".html";

	        File reportFile = new File(path);

	        if (Desktop.isDesktopSupported()) {
	            Desktop.getDesktop().browse(reportFile.toURI());
	        } else {
	            System.out.println("Opening the report is not supported on this platform.");
	        }
	    }
}