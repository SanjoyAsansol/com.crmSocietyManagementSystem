package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;

public class AddAdminPage {
	//declaration
	@FindBy(name="username")
	private WebElement usernameTB;
	@FindBy(name="password")
	private WebElement passwordTB;
	@FindBy(name="name")
	private WebElement nameTB;
	@FindBy(name="save_admin")
	private WebElement loginButton;
	//initialization
	public AddAdminPage (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getUsernameTB() {
		return usernameTB;
	}
	public WebElement getPasswordTB() {
		return passwordTB;
	}
	public WebElement getNameTB() {
		return nameTB;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	//business logic
	public void addAdmin(String username, String password,String name) throws Throwable
	{
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		nameTB.sendKeys(name);
		loginButton.click();
	}
	
	
	

}
