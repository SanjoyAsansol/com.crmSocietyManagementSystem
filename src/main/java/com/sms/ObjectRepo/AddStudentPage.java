package com.sms.ObjectRepo;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

public class AddStudentPage {
	@FindBy(name="student_id")
	private WebElement StudentIDTB;
	@FindBy(name="firstname")
	private WebElement FirstnameTB;
	@FindBy(name="middlename")
	private WebElement MiddlenameTB;
	@FindBy(name="lastname")
	private WebElement LastnameTB;
	@FindBy(name="year")
	private WebElement YearDD;
	@FindBy(name="section")
	private WebElement SectionTB;
	@FindBy(name="save_student")
	private WebElement SaveButton;
	@FindBy(name="image")
	private WebElement imageLink;
	public AddStudentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getStudentIDTB() {
		return StudentIDTB;
	}

	public WebElement getFirstnameTB() {
		return FirstnameTB;
	}

	public WebElement getMiddlenameTB() {
		return MiddlenameTB;
	}

	public WebElement getLastnameTB() {
		return LastnameTB;
	}

	public WebElement getYearDD() {
		return YearDD;
	}

	public WebElement getSectionTB() {
		return SectionTB;
	}
	public WebElement getSaveButton() {
		return SaveButton;
		
	}
	public WebElement getImageLink()
	{
		return imageLink;
	}
	
	public void uploadImage()
	{
		File f=new File("./src/test/resources/img.jpg");
		String abspath = f.getAbsolutePath();
		imageLink.sendKeys(abspath);
		
	}
	public void createStudent(WebDriverUtility wu,String StdID,String FirstName,String MiddleName,String LastName,int index, String SectionName)
	{
		StudentIDTB.sendKeys(StdID);
		FirstnameTB.sendKeys(FirstName);
		MiddlenameTB.sendKeys(MiddleName);
		LastnameTB.sendKeys(LastName);
		wu.getSelect(YearDD, index);
		SectionTB.sendKeys(SectionName);
		SaveButton.click();
	}
	
}
