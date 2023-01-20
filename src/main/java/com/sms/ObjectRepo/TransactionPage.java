package com.sms.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;

public class TransactionPage {
	@FindBy(id="search")
	private WebElement searchTB;
	@FindBy(id="btn_search")
	private WebElement searchButton;
	
	
	public TransactionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTB() {
		return searchTB;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	//Business Library
	public void clickSearchTB()
	{
		searchTB.click();
	}
	public void passDataToSearchTB(String data)
	{
		searchTB.sendKeys(data);
		searchButton.click();
		
	}
	public WebElement validationText(WebDriver driver,String path)
	{
		WebElement StdID=driver.findElement(By.xpath("//label[text()='Student ID:']/../../descendant::label[text()='"+path+"']"));
		return StdID;
		
	}
	public String studentIDValidation(WebDriver driver,String path) throws Throwable
	{
		String actualStudentID=driver.findElement(By.xpath("//label[text()='"+path+"']")).getText();
		return actualStudentID;
	}
}
