package com.sms.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

public class ExpensesPage {
	//declaration
	@FindBy(id="add_expenses")
	private WebElement AddExpencesButton;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTB;
	@FindBy(name="table_length")
	private WebElement dropdownLink;
	//initialization
	public ExpensesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getSearchTB() {
		return searchTB;
	}
	//utilization
	public WebElement getAddExpencesButton() {
		return AddExpencesButton;
	}
	public WebElement getsearchTB() {
		return searchTB;
	}
	public WebElement getDropdownLink() {
		return dropdownLink;
	}
	
	//business library
	
//	public void searchTBpassValue(ExcellUtility eu) throws Throwable
//	{
//		searchTB.sendKeys(eu.getDataFromExcell("Expences", 7, 1));
//		
//	}
	public void searchTBpassValue(String expenseName) throws Throwable
	{
		searchTB.sendKeys(expenseName);
		
	}
	public void dropDown(WebDriver driver,WebDriverUtility wu,int index)
	{
		dropdownLink.click();
		wu.getSelect(dropdownLink, index);
	}
//	public void clickUpdateExpense(WebDriver driver,ExcellUtility eu) throws Throwable
//	{
//		driver.findElement(By.xpath("//td[.='"+eu.getDataFromExcell("Expences", 7, 1)+"']/../td[6]/center/a[1]")).click();
//		//driver.findElement(By.xpath("//td[.='"+eu.getDataFromExcell("Expences", 7, 1)+"']/../td[6]/center/a[1]")).click();
//		//driver.findElement(By.xpath("//td[.='"+eu.getDataFromExcell("Expences", 7, 1)+"']/../td[6]/center/a[1]")).click();
//	}
	public void clickUpdateExpense(WebDriver driver,String expenseName) throws Throwable
	{
		driver.findElement(By.xpath("//td[.='"+expenseName+"']/../td[6]/center/a[1]")).click();
		
	}
	public String getPrice(WebDriver driver, String expenseName) throws Throwable
	{
		
		String price=driver.findElement(By.xpath("//td[.='"+expenseName+"']/following-sibling::td[1]")).getText();
		return price;
		
	}
	public void clickAddExpences() {
		// TODO Auto-generated method stub
		AddExpencesButton.click();
	}
}
