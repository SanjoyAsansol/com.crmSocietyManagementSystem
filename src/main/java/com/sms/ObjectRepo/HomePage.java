package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declarization
	@FindBy(xpath= "//a[.=' Accounts']")
	private WebElement acountsLink;
	@FindBy(xpath= "//a[.=' Activities']")
	private WebElement activitiesLink;
	@FindBy(xpath= "//a[.=' Expenses']")////a[.=' Expenses']
	private WebElement ExpensesLink;
	@FindBy(xpath="//a[.=' Transaction']")
	private WebElement TransactionLink;
	@FindBy(xpath = "//a[.=\" Options\"]")
	private WebElement optionsLink;
	@FindBy(xpath="//a[.=' Student']")
	private WebElement StudentLink;
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getAcountsLink() {
		return acountsLink;
	}
	public WebElement getActivitiesLink() {
		return activitiesLink;
	}
	public WebElement getExpensesLink() {
		return ExpensesLink;
	}
	public WebElement getTransactionLink() {
		return TransactionLink;
	}
	public WebElement getOptionsLink()
	{
		return optionsLink;
	}
	public WebElement getStudentLink()
	{
		return StudentLink;
	}
	//business logic
	public void clickAccounts()
	{
		acountsLink.click();
	}
	public void clickOptions()
	{
		optionsLink.click();
	}
	public void clickExpenses()
	{
		ExpensesLink.click();
	}
	public void clickTransaction()
	{
		TransactionLink.click();
	}
	public void clickStudentLink()
	{
		StudentLink.click();
	}
	
	
	
}
