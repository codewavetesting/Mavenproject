package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class webdrivermanger {
	public WebDriver browserLaunch(WebDriver driver, String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			 ChromeOptions co=new ChromeOptions();
   co.addArguments("--disable-notifications");
  driver=new ChromeDriver(co);
//			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else if (Browser.equalsIgnoreCase("microsoftedge"))
			driver = new EdgeDriver();
		
		return driver;
	}
	


}
