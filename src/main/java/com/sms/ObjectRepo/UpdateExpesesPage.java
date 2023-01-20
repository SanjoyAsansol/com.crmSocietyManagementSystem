package com.sms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

public class UpdateExpesesPage {
	@FindBy(name="detail")
	private WebElement detailTB;
	@FindBy(name="price")
	private WebElement priceTB;
	@FindBy(name="ay1")
	private WebElement ayTB1;
	@FindBy(name="ay2")
	private WebElement ayTB2;
	@FindBy(name="sem")
	private WebElement semDropdown;
	@FindBy(name="deadline")
	private WebElement deadlineTB;
	@FindBy(name="update_expenses")
	private WebElement saveButton;
	public UpdateExpesesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getDetailTB() {
		return detailTB;
	}
	public WebElement getPriceTB() {
		return priceTB;
	}
	public WebElement getAyTB1() {
		return ayTB1;
	}
	public WebElement getAyTB2() {
		return ayTB2;
	}
	public WebElement getSemDropdown() {
		return semDropdown;
	}
	public WebElement getDeadlineTB() {
		return deadlineTB;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	public void updateExpenses(ExcellUtility eu,WebDriverUtility wu, int index) throws Throwable
	{
		detailTB.clear();
		detailTB.sendKeys(eu.getDataFromExcell("Expences", 7, 1));
		priceTB.sendKeys(eu.getDataFromExcell("Expences", 8, 1));
		ayTB1.clear();
		ayTB1.sendKeys(eu.getDataFromExcell("Expences", 9, 1));
		ayTB2.clear();
		ayTB2.sendKeys(eu.getDataFromExcell("Expences", 10, 1));
		wu.getSelect(semDropdown, index);
		//deadlineTB.clear();
		//deadlineTB.sendKeys(eu.getDataFromExcell("Expences", 12, 1));
		saveButton.click();
		
		
	}

}
