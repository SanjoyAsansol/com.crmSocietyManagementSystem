package com.sms.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentPage {
	@FindBy(id="add_student")
	private WebElement AddStudentButton;
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTB;
	@FindBy(xpath="//a[.=' Yes']")
	private WebElement deleteYesButton;
	public StudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddStudentButton() {
		return AddStudentButton;
	}
	public WebElement getsearchTB()
	{
		return searchTB;
	}
	public WebElement getdeleteYesButton()
	{
		return deleteYesButton;
	}
	public void clickAddStudentButton()
	{
		AddStudentButton.click();
	}
	public void passValueToSearchTB(String StudentId)
	{
		searchTB.sendKeys(StudentId);
	}
	public String studentIDValidation(WebDriver driver,String StudentID) throws Throwable
	{
		String actualStudentID=driver.findElement(By.xpath("//label[text()='"+StudentID+"']")).getText();
		return actualStudentID;
	}
	public void deleteStudent(WebDriver driver, String studentID)
	{
		driver.findElement(By.xpath("//td[.='"+studentID+"']/parent::tr/child::td/descendant::a[.=' Delete']")).click();
		deleteYesButton.click();
	}
}
