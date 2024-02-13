package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserlaunching {
	
public WebDriver driver;
	 public synchronized void launchingbrowser( String browserName) throws Exception {

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

}
}
