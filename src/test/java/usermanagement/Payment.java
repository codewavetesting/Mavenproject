package usermanagement;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.generic.Base;
import com.pom.paymentpage;

//@Listeners(com.generic.ITestListernersImp.class)
public class Payment extends Base {
	Base base = new Base();

	@Test(testName = "validserachinpaymentTest", groups = { "smoke" })
	public void validserachinpaymentTest() throws Exception {
		base.login();

		test.assignAuthor("Nandish");

		paymentpage pm = new paymentpage(driver);

		pm.getManagment().click();

		pm.getPaymentmanagement().click();

		pm.getSearch().sendKeys("7zdj6QquDY");
		Thread.sleep(1000);
		base.logout();
	}

	@Test(testName = "invalidvalidserachinpaymentTest", groups = { "regression" })
	public void invalidvalidserachinpaymentTest() throws Exception {
		base.login();
//		ExtentTest test = extent.createTest(base.getMethodName(),"this is screenshot").assignAuthor("kiran");
		test.assignAuthor("kiran");
		paymentpage pm = new paymentpage(driver);

		pm.getManagment().click();
		pm.getPaymentmanagement().click();
		pm.getSearch().sendKeys("7zdquDY");
		System.out.println(pm.getnodatavailable().getText());
		Thread.sleep(1000);
		base.logout();
	}

	@Test(testName = "applycompletedTest", groups = { "smoke" })
	public void applycompletedTest() throws Exception {

		base.login();
		test.assignAuthor("kiran");
		paymentpage pm = new paymentpage(driver);

		pm.getManagment().click();
		pm.getPaymentmanagement().click();
		pm.getfilter().click();
		pm.getCompleted().click();
		pm.getApply().click();
		;
		Thread.sleep(2000);
		base.logout();
	}

	@Test(testName = "applyfailedTest", groups = { "regression" })
	public void applyfailedTest() throws Exception {

		base.login();
		test.assignAuthor("kiran");
		paymentpage pm = new paymentpage(driver);

		pm.getManagment().click();
		pm.getPaymentmanagement().click();
		pm.getfilter().click();
		pm.getFailed().click();
		pm.getApply().click();
		;
		Thread.sleep(2000);
		base.logout();
	}

	@Test(testName = "applyfailedTest", groups = { "Sanity" })
	public void nextandpreviuos_dataTest() throws Exception {

		base.login();
		;// ExtentTest test =
			// extent.createTest(base.getMethodName()).assignAuthor("nandish")
		test.assignAuthor("kiran");
		paymentpage pm = new paymentpage(driver);

		pm.getManagment().click();
		pm.getPaymentmanagement().click();
		pm.getfilter();
		
		pm.getFailed().click();
		pm.getApply().click();
		Thread.sleep(2000);
		pm.getnextbutton().click();
		pm.getnextbutton().click();
		pm.getnextbutton().click();

		pm.getnextbutton().click();
		pm.getnextbutton().click();
		pm.getprevious().click();
		pm.getprevious().click();
		base.logout();
	}

}
