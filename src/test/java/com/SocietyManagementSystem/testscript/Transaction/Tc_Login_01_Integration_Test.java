package com.SocietyManagementSystem.testscript.Transaction;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.AddStudentPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.StudentPage;
import com.sms.ObjectRepo.TransactionPage;

public class Tc_Login_01_Integration_Test extends BaseClass {
	@Test
	public void Login01() throws Throwable {

		String StudentID=eu.getDataFromExcell("Student", 0, 1);
		String Firstname=eu.getDataFromExcell("Student", 1, 1);
		String Middlename = eu.getDataFromExcell("Student", 2, 1);
		String Lastname = eu.getDataFromExcell("Student", 3, 1);
		String Section = eu.getDataFromExcell("Student", 4, 1);

		//Click accounts
		HomePage hp =new HomePage(driver);
		hp.clickAccounts();
		//click on student
		hp.clickStudentLink();
		
		//click on Add_student
		StudentPage sp= new StudentPage(driver);
		sp.clickAddStudentButton();
		AddStudentPage asp= new AddStudentPage(driver);
		asp.createStudent(wu, StudentID, Firstname, Middlename, Lastname, 2, Section);

		//click on transaction
		hp.clickTransaction();
		//driver.findElement(By.xpath("//a[.=' Transaction']")).click();
	
		//click on search
		TransactionPage tp= new TransactionPage(driver);
		tp.clickSearchTB();
		tp.passDataToSearchTB(StudentID);
		
		String actualstudentid=sp.studentIDValidation(driver, StudentID);

		Assert.assertEquals(actualstudentid, StudentID);
		{
			System.out.println("Student is Created");
		}
		

	}

}




//driver.findElement(By.id("add_student")).click();
//Send all thee Details
//HashMap<String, String> map= new HashMap<String, String>();
//for(int i=1;i<=sh.getLastRowNum();i++)
//{
//	String key=sh.getRow(i).getCell(0).getStringCellValue();
//	String value=sh.getRow(i).getCell(1).getStringCellValue()+random;
//	//studentid=sh.getRow(1).getCell(1).getStringCellValue()+random;
//	//System.out.println(studentid);
//	map.put(key, value);
//	
//}
//driver.findElement(By.name("student_id")).sendKeys(eu.getDataFromExcell("Student", 0, 1));
//Map<String, String> hashmaplist = eu.getListWithRandomNo("Student", 0, 1, 1);
//for(Entry<String, String> set:hashmaplist.entrySet())
//{
//	
//	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//	
//	
//}
//WebElement yeardd=driver.findElement(By.name("year"));
////Select s = new Select(yeardd);
////s.selectByVisibleText("I");
//wu.getSelect(yeardd, "I");
//Thread.sleep(3000);
////click on save
//driver.findElement(By.name("save_student")).click();
