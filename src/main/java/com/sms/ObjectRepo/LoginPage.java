package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declarization
	@FindBy(xpath="//input[@id='username']")
	private WebElement usernameTB;
	@FindBy(id="password")
	private WebElement passwordTB;
	@FindBy(id="login")
	private WebElement loginButton;
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getUsernameTB() {
		return usernameTB;
	}
	public WebElement getPasswordTB() {
		return passwordTB;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	//create business library
	public void login(String username, String password)
	{
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginButton.click();
	}
	
	
	

}
