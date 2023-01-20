package com.SocietyManagementSystem.testscript.Activities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.AddStudentPage;
import com.sms.ObjectRepo.ExpensesPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.OptionsPage;
import com.sms.ObjectRepo.StudentPage;
import com.sms.ObjectRepo.TransactionPage;
import com.sms.ObjectRepo.UpdateExpesesPage;



public class Tc_Activity_20_Test extends BaseClass{

	
	@Test
	public void Activity20() throws Throwable {
		

	
	String deadlinedate=eu.getDataFromExcell("All Module", 0, 4);
	String StudentID = eu.getDataFromExcell("All Module", 1, 4);

	//click on Expences
	HomePage hp= new HomePage(driver);
	hp.clickExpenses();
	//add expense
 	ExpensesPage exp= new ExpensesPage(driver);
 	exp.clickAddExpences();
 	eu.getList("All Module", 0, 1);
 	//select Sem Dropdown
	WebElement semdd=driver.findElement(By.name("sem"));
	UpdateExpesesPage uep= new UpdateExpesesPage(driver);
	wu.getSelect(uep.getSemDropdown(), "1st");
	//put date on calendar
	uep.getDeadlineTB().sendKeys(deadlinedate);
	//click on transaction
	hp.clickTransaction();
	//click on search
	TransactionPage tp= new TransactionPage(driver);
	
	tp.clickSearchTB();
	tp.passDataToSearchTB(StudentID);
	tp.getSearchButton().click();
	Thread.sleep(3000);
	wu.elementToBeVisible(driver, tp.validationText(driver, StudentID));
	
	if(tp.studentIDValidation(driver, StudentID).equals(StudentID))
	{
		System.out.println("Student Created Successfully");
	}
	else
	{
		System.out.println("Student not Created");
	}
	
	StudentPage sp= new StudentPage(driver);
	
	}


}
