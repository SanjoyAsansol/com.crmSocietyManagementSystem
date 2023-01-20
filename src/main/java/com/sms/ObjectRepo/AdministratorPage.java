package com.sms.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

public class AdministratorPage {
	//declaration
	@FindBy(id="add_admin")
	private WebElement addAdminButton;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTB;
	@FindBy(xpath ="//select[@name='table_length']")
	private WebElement dropDownLink;
	
	
	//initialization
	public AdministratorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getAddAdminButton() {
		return addAdminButton;
	}
	public WebElement getSearchTB() {
		return searchTB;
	}
	public WebElement getDropDownLink() {
		return dropDownLink;
	}
	//business logic
	public void addAmnistrator()
	{
		addAdminButton.click();
	}
	public void dropDown(WebDriver driver,WebDriverUtility wu, int index)
	{
		//dropDownLink.click();
		wu.getSelect(dropDownLink, index);
	}
	public String getActualCustomerName(WebDriver driver,ExcellUtility eu) throws Throwable
	{
		String actualusername=driver.findElement(By.xpath("//td[text()='"+eu.getDataFromExcell("Administrator", 0, 1)+"']")).getText();
		return actualusername;
	}
	public String getSearchdUsername(WebDriver driver)
	{
		String createdadmin=driver.findElement(By.className("sorting_1")).getText();
		return createdadmin;
		
	}
}
