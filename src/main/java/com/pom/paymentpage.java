package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentpage {
	public paymentpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath ="//span[text()='Payment management']")
	private WebElement Paymentmanagement;
	
	public WebElement getPaymentmanagement()
	{
		return Paymentmanagement;
	}
	@FindBy(xpath = "//td[text()='No data available...']")
	private WebElement nodatavailable;
	
	public WebElement getnodatavailable()

	{
		return nodatavailable;
	}
	@FindBy(xpath = "//span [text()='Management']")
	private WebElement Managment;
	
	public WebElement getManagment()

	{
		return Managment;
	}
	
	@FindBy(xpath ="//div[@class='user-text']//div[2]//img[1]")
	private WebElement filter;
	
	public WebElement getfilter()
	{
		return filter;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Completed']")
	private WebElement Completed;
	
	public WebElement getCompleted()
	{
		return Completed;
	}


	@FindBy(xpath ="//button[normalize-space()='Failed']")
	private WebElement Failed;
	
	public WebElement getFailed()
	{
		return Failed;
	}
	@FindBy(xpath ="//button[normalize-space()='Apply']")
	private WebElement Apply;
	
	
	
	public WebElement getApply()
	{
		return Apply;
	}
	@FindBy(xpath ="//button[normalize-space()='Clear']")
	private WebElement Clear;
	
	public WebElement getClear()
	{
		return Clear;
	}
	@FindBy(xpath ="//input[@placeholder='Search']")
	private WebElement Search;
	
	public WebElement getSearch()
	{
		return Search;
	}
	@FindBy(xpath = "//a[normalize-space()='Previous']")
	private WebElement previous;
	
	public WebElement getprevious()

	{
		return previous;
	}
	@FindBy(xpath = "//a[normalize-space()='Next']")
	private WebElement nextbutton;
	
	public WebElement getnextbutton()

	{
		return nextbutton;
	}
	@FindBy(xpath ="(//input[@placeholder='Add date'])[1]")
	private WebElement fromAdddatefilter;
	
	public	WebElement getfromAdddatefilter()
	{
		return fromAdddatefilter;
	}
	

	@FindBy(xpath ="(//input[@placeholder='Add date'])[2]")
	private WebElement toAdddatefilter;
	
	public	WebElement gettoAdddatefilter()
	{
		return toAdddatefilter;
	}
	@FindBy(xpath ="(//input[@placeholder='Add date'])[2]")
	private WebElement clear;
	
	public	WebElement getclear()
	{
		return clear;
	}

}
