package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	//Declarization
	@FindBy(xpath= "//a[.=' Administrator']")
	private WebElement administratorLink; 
	@FindBy(xpath = "//a[.=' Student']")
	private WebElement studentLink;
	//initialization
	public AccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getAdministratorLink() {
		return administratorLink;
	}
	public WebElement getStudentLink() {
		return studentLink;
	}
	public void clickAdministrator()
	{
		administratorLink.click();
	}
	public void clickStudent()
	{
		studentLink.click();
	}
	

}
