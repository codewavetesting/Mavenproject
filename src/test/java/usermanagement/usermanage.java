package usermanagement;



import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.generic.ITestListernersImp;
import com.generic.Retryanalyzer;
import com.generic.Base;
import com.generic.Javageneric;

import com.generic.Webdriverutilitymethods;
import com.pom.usermangement;



@Listeners(com.generic.ITestListernersImp.class)
public class usermanage extends Base {
	
	Base base=new Base();
	@Test(priority = 1)
	public void editdataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(3000);
		
	    um.getediticonfirstdata().click();
		um.getediticonprofile().click();
		um.getedit().click();
		
		 WebElement clear = um.geteditphone();
//	 wd.clearmethod(clear);
		
		um.geteditphone().clear();
		um.geteditphone().sendKeys(wd.generateRandomMobileNumber());
		
		WebElement gender = um.getgender();
		
		wd.select(gender, 1);
		WebElement religion = um.getreligion();
		wd.select(religion, 2);
		
		um.getsavechanges().click();
		base.logout();
	

	}
	
	@Test(priority = 2)
	public void blockuser() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(3000);
		
	    um.getediticonfirstdata().click();
		um.getediticonprofile().click();
		
		um.getblockuser().click();
		 WebElement block = um.getblockpoup();
		 wd.clickbyusingjavascriptexecutor(driver, block);
		
		
		
		 base.logout();
		
	}
	@Test(priority = 3)
	public void unblockuser() throws Exception
	{ 
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(3000);
		
	    um.getediticonfirstdata().click();
		um.getediticonprofile().click();
		
		um.getUnblockuser().click();
		WebElement unblock = um.getUnblockpopup();
		 wd.clickbyusingjavascriptexecutor(driver, unblock);
		
		 base.logout();
	}
	@Test(priority = 4)
	public void maleandactivedataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getMalefilter().click();
	um.getactivefilter().click();
	um.getapply().click();
	base.logout();
	
}
	
	@Test(priority = 5)
	public void maleandactivecleardataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getMalefilter().click();
	um.getactivefilter().click();
	um.getapply().click();
	
	base.logout();
}
	
	@Test(priority = 6)
	public void maleandinactivedataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getMalefilter().click();
	um.getInactivefilter().click();
	um.getapply().click();
	base.logout();
	
}
	@Test(priority = 7)
	public void maleandblockeddataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getMalefilter().click();
	um.getBlockedfilter().click();
	um.getapply().click();
	base.logout();
	
}
	
	@Test	(priority = 8)
	public void femaleandactivedataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getfemale().click();
	um.getactivefilter().click();
	um.getapply().click();
	base.logout();
	
}
	

	@Test	(priority = 9)
	public void femaleandinactivedataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getfemale().click();
	um.getactivefilter().click();
	um.getapply().click();
	base.logout();
	
}
	@Test(priority = 10)
	public void femaleandblockeddataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getfemale().click();
	um.getBlockedfilter().click();
	um.getapply().click();
	base.logout();
	
}
	
	@Test(priority = 11)
	public void othersandblockeddataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getOthersfilter().click();
	um.getBlockedfilter().click();
	um.getapply().click();
	
	base.logout();
}
	@Test(priority = 12)
	public void othersandactiveddataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getOthersfilter().click();
	um.getactivefilter().click();
	um.getapply().click();
	
	base.logout();
}
	
	@Test(priority = 13)
	public void othersandinactiveddataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getfilter().click();
	um.getOthersfilter().click();
	um.getInactivefilter().click();
	um.getapply().click();
	base.logout();
	
}
	@Test(priority = 14)
	public void validsearchTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getsearch().click();
	um.getsearch().sendKeys("steve");
	um.getsearch().clear();
	base.logout();
}
	
	@Test(priority = 15)
	public void invalidsearchTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);
	
	um.getsearch().click();
	um.getsearch().sendKeys("ghhdvhdv");
	System.out.println(um.getnodatavailable().getText());
	base.logout();
}
	@Test(priority = 16)
	public void nextandpreviuos_dataTest() throws Exception
	{
		base.login();
		ExtentTest test = extent.createTest(base.getMethodName());
		Javageneric jv = new Javageneric();
		Webdriverutilitymethods wd = new Webdriverutilitymethods();
		usermangement um=new usermangement(driver);
		um.getManagment().click();
		um.getUserManagement().click();
		Thread.sleep(2000);	
		WebElement next = um.getnextbutton();
	wd.clickbyusingjavascriptexecutor(driver, next);
	Thread.sleep(1000);	
	wd.clickbyusingjavascriptexecutor(driver, next);
	Thread.sleep(1000);	
	wd.clickbyusingjavascriptexecutor(driver, next);
	Thread.sleep(1000);	
	wd.clickbyusingjavascriptexecutor(driver, next);
	Thread.sleep(1000);	
	wd.clickbyusingjavascriptexecutor(driver, next);
	Thread.sleep(1000);	
	WebElement prevoius = um.getprevious();
	wd.clickbyusingjavascriptexecutor(driver, prevoius);
	Thread.sleep(1000);	
	wd.clickbyusingjavascriptexecutor(driver, prevoius);
	base.logout();
	
}
	
	
}
