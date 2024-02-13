package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
public login(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//input[@name='email']")
private WebElement email;

public WebElement getemail()
{
	return email;
}
@FindBy(xpath ="//input[@name='password']")
private WebElement password;

public WebElement getpassword()
{
	return password;
}
@FindBy(xpath ="//button[@type='submit']")
private WebElement loginbtn;

public WebElement getloginbtn()
{
	return loginbtn;
}

@FindBy(xpath ="//div[text()='Invalid email']")
private WebElement loginerror;

public WebElement getloginerror()
{
	return loginerror;
}
@FindBy(xpath ="//img[@class='error']")
private WebElement logoutmenu;

public WebElement getlogoutmenu()
{
	return logoutmenu;
}

@FindBy(xpath ="//div[@class='main-header-right']//a[2]")
private WebElement logout;

public WebElement getlogout()
{
	return logout;
}
}
