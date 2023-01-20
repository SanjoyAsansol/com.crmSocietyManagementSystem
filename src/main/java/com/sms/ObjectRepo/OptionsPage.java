package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsPage {
	@FindBy(xpath ="//a[.=' Logout']")
	private WebElement logoutLink;
	public OptionsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	//business logic
	public void clickLogout()
	{
		logoutLink.click();
	}
	

}
