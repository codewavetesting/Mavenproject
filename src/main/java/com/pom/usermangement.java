package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.Webdriverutilitymethods;

public class usermangement {
	public usermangement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span [text()='Management']")
	private WebElement Managment;
	
	public WebElement getManagment()

	{
		return Managment;
	}
	
	@FindBy(xpath = "//td[text()='No data available...']")
	private WebElement nodatavailable;
	
	public WebElement getnodatavailable()

	{
		return nodatavailable;
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
	@FindBy(xpath = "//span[text()='User Management']")
	private WebElement UserManagement;
	
	public	WebElement getUserManagement()
	{
		return UserManagement;
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement search;
	
	public	WebElement getsearch()
	{
		return search;
	}
	@FindBy(xpath = "(//tr[@class='ant-table-row ant-table-row-level-0'])[2]")
	private WebElement editiconfirstdata;
	
	public	WebElement getediticonfirstdata()
	{ 
		return editiconfirstdata;
	}

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement editphone;
	
	public	WebElement geteditphone()
	{
		return editphone;
	}
	@FindBy(id="gender")
	private WebElement gender;
	
	public	WebElement getgender()
	{
		return gender;
	}
	@FindBy(id="religion")
	private WebElement religion;
	
	public	WebElement getreligion()
	{
		return religion;
	}
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement savechanges;
	
	public	WebElement getsavechanges()
	{
		return savechanges;
	}
	
	@FindBy(xpath ="//img[@alt='Dropdown Trigger']")
	private WebElement editiconprofile;
	
	public	WebElement getediticonprofile()
	{
		return editiconprofile;
	}
	

	@FindBy(xpath ="//span[text()='Edit']")
	private WebElement edit;
	
	public	WebElement getedit()
	{
		return edit;
	}
	@FindBy(xpath ="//div[@class='user-text']//div[2]//img[1]")
	private WebElement filter;
	
	public	WebElement getfilter()
	{
		return filter;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Male']")
	private WebElement Malefilter;
	
	public	WebElement getMalefilter()
	{
		return Malefilter;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Active']")
	private WebElement activefilter;
	
	public	WebElement getactivefilter()
	{
		return activefilter;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Apply']")
	private WebElement apply;
	
	public	WebElement getapply()
	{
		return apply;
	}
	@FindBy(xpath ="//button[normalize-space()='Female']")
	private WebElement femalefilter;
	
	public	WebElement getfemale()
	{
		return femalefilter;
	}
	@FindBy(xpath ="//button[normalize-space()='Inactive']")
	private WebElement Inactivefilter;
	
	public	WebElement getInactivefilter()
	{
		return Inactivefilter;
	}
	
	@FindBy(xpath ="//button[normalize-space()='Others']")
	private WebElement Othersfilter;
	
	public	WebElement getOthersfilter()
	{
		return Othersfilter;
	}
	
	
	@FindBy(xpath ="//button[normalize-space()='Blocked']")
	private WebElement Blockedfilter;
	
	public	WebElement getBlockedfilter()
	{
		return Blockedfilter;
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
	
	@FindBy(xpath ="//span[text()='Block User']")
	private WebElement blockuser;
	
	public	WebElement getblockuser()
	{
		return blockuser;
	}
	
	@FindBy(xpath ="//span[text()='Deactivate Account']")
	private WebElement deactivateuser;
	
	public	WebElement getdeactivateuser()
	{
		return deactivateuser;
	}
	
	@FindBy(xpath ="//span[text()='Unblock User']")
	private WebElement Unblockuser ;
	
	public	WebElement getUnblockuser()
	{
		return Unblockuser;
	}
	
	@FindBy(xpath ="//button[text()='Block']")
	private WebElement blockpoup;
	
	public	WebElement getblockpoup()
	{
		return blockpoup;
	}
	@FindBy(xpath ="//button[text()='Unblock']")
	private WebElement Unblockpopup;
	
	public	WebElement getUnblockpopup()
	{
		return Unblockpopup;
	}
	
}
