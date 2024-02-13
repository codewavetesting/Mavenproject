package com.generic;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Webdriverutilitymethods {
	
	
	
	
	/**
	 * this method wait for 20 sec for page loading
	 * @param driver
	 */
	
   public void waitUntilPageLoad(WebDriver driver)
   {
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
   }
   public void clearmethod(WebElement element)
   {
	   element.sendKeys(Keys.CONTROL + "a");  
	   element.sendKeys(Keys.DELETE);     
   }

   /**
    * This method wait for the element to be visible
    * @param driver
    * @param element
    * 
//    */
//   public void waitForElementVisibility(WebDriver driver, WebElement element) {
//	    try {
//	        WebDriverWait wait = new WebDriverWait(driver, 20);
//	        wait.until(ExpectedConditions.visibilityOf(element));
//	    } catch (TimeoutException e) {
//	        // Handle the timeout exception if the element is not visible within 20 seconds
//	        System.out.println("Timeout waiting for element visibility: " + e.getMessage());
//	    }
//	}
//   /**
//    * This method wait for the element to be clicked, its custom wait created to avoid elemenInterAceptable Exception
//    * @param element
//    * @throws throwable
//    * 
//    */
//   public void waitForElemeentuntilclickable(WebDriver driver, WebElement element)
//   {
//	WebDriverWait wait1 = new WebDriverWait(driver, 20);
//	wait1.until(ExpectedConditions.elementToBeClickable(element));
//   }

   public void waitAndClick(WebElement element) throws InterruptedException
   {
	int count = 0;
       while(count<20) {
		   try {
		element.click();
		       break;
		}catch(Throwable e){
			Thread.sleep(1000);
			   count++;
		   }
       }

   }
   /**
    * this method enables user to handle dropdown using visible text
    * @param element
    * @param option
    */

   public void select(WebElement element, String option)
   {
	   Select select=new Select(element);
	select.selectByVisibleText(option);
	
   }

   /**
    * this methods enables user to handle dropdown using index
    * @param element
    * @param index
    */

   public void select(WebElement element, int index)
   {
	   Select select=new Select(element);
	select.selectByIndex(index);   
   }

   /**
    * This method will perform mouse over action
    * @param driver
    * @param element
    */

   public void mouseOver(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	
   }

   /**
    * This method performs right click operation 
    * @param driver
    * @param element
    */
   public void rightClick(WebDriver driver,WebElement element)
   {
	   Actions act = new Actions(driver);
	act.contextClick(element).perform();
   }

   /**
    * This method helps to switch from one window to another
    * @param driver
    * @parampartialWinTitle
    */
   public void switchToWindow(WebDriver driver, String partialWinTitle)
   {
	   Set<String> window = driver.getWindowHandles();
	   Iterator<String> it = window.iterator();
	   while(it.hasNext())
	   {
		   String winId=it.next();
		   String title=driver.switchTo().window(winId).getTitle();
           if(title.contains(partialWinTitle))
           {
	   break;
           }
		
	   }
	
   }
   /**
    * Accept alert 
    * @param driver
    */

   public void acceptAlert(WebDriver driver)
   {
	driver.switchTo().alert().accept();
   }

   /**
    * Cancel Alert
    * @param driver
    */
   public void cancelAlert(WebDriver driver)
   {
	driver.switchTo().alert().dismiss();
   }
   /**
    * This method used for scrolling action in a webpage
    * @param driver
    * @param element
    */
   public void scrollToWebElement(WebDriver driver, WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y= element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
   }


    public void switchFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
    }   

    public void switchFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
    } 
	
    public void switchFrame(WebDriver driver,String idOrName) {
	driver.switchTo().frame(idOrName);
    } 

    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/"+screenshotName+".PNG");
	Files.copy(src, dest);
    }

    /**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver ,WebElement element ) {
	   Actions act = new Actions(driver);
	act.sendKeys(element ,Keys.ENTER).perform();
   } 
   
   /*This will help when interceptable exception comes 
    * 
    */
   public void clickbyusingjavascriptexecutor(WebDriver driver ,WebElement element)
   {
	   JavascriptExecutor js =(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", element);
   }
   public void scrollToElement(WebDriver driver, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
   public static String generateRandomMobileNumber() {
       Random random = new Random();
       StringBuilder stringBuilder = new StringBuilder();
       for (int i = 0; i < 10; i++) {
           stringBuilder.append(random.nextInt(10));
       }
       return stringBuilder.toString();
   }
   
   public static String generateRandomEmail() {
       Random random = new Random();
       String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
       StringBuilder email = new StringBuilder();

       // Add random characters to the email ID
       for (int i = 0; i < 10; i++) {
           int randomIndex = random.nextInt(characters.length());
           char randomChar = characters.charAt(randomIndex);
           email.append(randomChar);
       }

       // Append the domain and extension for a valid email ID
       email.append("@gmail.com");

       return email.toString();
   }
   public static String generateRandomName() {
       Random random = new Random();
       String characters = "abcdefghijklmnopqrstuvwxyz";
       StringBuilder name = new StringBuilder();

       // Generate a random name of length between 5 and 10 characters
       int nameLength = random.nextInt(6) + 5;

       for (int i = 0; i < nameLength; i++) {
           int randomIndex = random.nextInt(characters.length());
           char randomChar = characters.charAt(randomIndex);
           name.append(randomChar);
       }

       return name.toString();
   }
   
   
   
   public static String generateRandomPassword() {
	    SecureRandom random = new SecureRandom();
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

	    StringBuilder password = new StringBuilder();

	    // Ensure the password meets the specified conditions
	    boolean hasSpecialChar = false;
	    boolean hasNumber = false;
	    boolean hasCapitalLetter = false;

	    // Generate a random password of length between 8 and 12 characters
	    int passwordLength = random.nextInt(5) + 8;

	    for (int i = 0; i < passwordLength; i++) {
	        int randomIndex = random.nextInt(characters.length());
	        char randomChar = characters.charAt(randomIndex);

	        if ("!@#$%^&*()-_=+".indexOf(randomChar) != -1) {
	            hasSpecialChar = true;
	        } else if (Character.isDigit(randomChar)) {
	            hasNumber = true;
	        } else if (Character.isUpperCase(randomChar)) {
	            hasCapitalLetter = true;
	        }

	        password.append(randomChar);
	    }

	    // Check if the password meets all conditions
	    if (hasSpecialChar && hasNumber && hasCapitalLetter) {
	        return password.toString();
	    } else {
	        // If conditions are not met, recursively call the method to generate a new password
	        return generateRandomPassword();
	    }
	}
   
   public static String generateRandomStreetAddress() {
	    SecureRandom random = new SecureRandom();

	    // Example arrays for street names and numbers
	    String[] streetNames = {"Maple", "Oak", "Pine", "Cedar", "Main", "Elm", "Park", "Washington", "Lake"};
	    String[] streetTypes = {"St", "Ave", "Blvd", "Ln", "Rd"};

	    // Generate a random street address
	    String streetName = streetNames[random.nextInt(streetNames.length)];
	    int streetNumber = random.nextInt(1000) + 1; // Random street number between 1 and 1000
	    String streetType = streetTypes[random.nextInt(streetTypes.length)];

	    return streetNumber + " " + streetName + " " + streetType;
	}
   
   public static String generateRandomPin() {
	    SecureRandom random = new SecureRandom();

	    // Generate a random 6-digit PIN code
	    int pinCode = 100000 + random.nextInt(900000);

	    return String.format("%06d", pinCode);
	}
   
   public void javascriptSendData(WebDriver driver, WebElement element, String data) {
	    try {
	        if (driver instanceof JavascriptExecutor) {
	            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
	            javascriptExecutor.executeScript("arguments[0].value = arguments[1];", element, data);
	        } else {
	            System.out.println("Driver does not support JavascriptExecutor");
	        }
	    } catch (Exception e) {
	        System.out.println("Exception occurred: " + e.getMessage());
	    }
	}
   
   public void passeneterkey() throws Exception
   {
	   Robot rb=new Robot();
	   rb.keyPress(KeyEvent.VK_ENTER);
	   rb.keyRelease(KeyEvent.VK_ENTER);
	   
   }
   
   public static void clearInputField(WebDriver driver, WebElement element) {
     
	   element.sendKeys(Keys.CONTROL + "a"); // Select all text
	   element.sendKeys(Keys.DELETE); // Delete selected text
   }
   public static void Actionscrolldown(WebDriver driver)
   {
	   Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.tagName("body"))).click().sendKeys(Keys.PAGE_DOWN).perform();
   }
   public static void ArrowKeyDown(WebElement element) {
       element.sendKeys(Keys.ARROW_DOWN);
   }
   public static void ArrowKeyUp(WebElement element) {
       element.sendKeys(Keys.ARROW_UP);
   }
	
}













   









