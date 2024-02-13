package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.Webdriverutilitymethods;

public class faq {
public faq(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[text()='+ Add New']")
private WebElement addnew ;

public WebElement getaddnew()
{
	return addnew;
}
@FindBy(xpath = "(//div[@class='col-md-8 col-12'])[19]")
private WebElement sevenquestion ;

public WebElement getsevenquestion()
{
	return sevenquestion;
}
@FindBy(xpath = "(//div[@class='col-md-8 col-12'])[20]")
private WebElement sevenanswer ;

public WebElement getsevenanswer()
{
	return sevenanswer;
}

}
