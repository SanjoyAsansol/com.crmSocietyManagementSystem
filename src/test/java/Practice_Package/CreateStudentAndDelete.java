package Practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.AddStudentPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.StudentPage;

public class CreateStudentAndDelete  {
public static void main(String[] args) throws Throwable {
	WebDriver driver= null;
	JavaUtility ju= new JavaUtility();
	FileUtility fu= new FileUtility();
	ExcellUtility eu= new ExcellUtility();
	WebDriverUtility wu= new WebDriverUtility();
	String StudentId = eu.getDataFromExcell("Student1", 0, 1);
	String Firstname = eu.getDataFromExcell("Student1", 1, 1);
	String Middlename = eu.getDataFromExcell("Student1",2, 1);
	String lastname = eu.getDataFromExcell("Student1", 3, 1);
	String Section = eu.getDataFromExcell("Student1", 4, 1);

	//Launch Driver

	if(fu.getDataFromProperty("browser").equals("chrome"))
	{
	driver= new ChromeDriver();
	}
	else {
		System.out.println("Invalid Browser");
	}
	//login
	wu.maximizeWindow(driver);
	wu.waitForPageLoad(driver);
	driver.get(fu.getDataFromProperty("url"));
	
	LoginPage lp= new LoginPage(driver);
	lp.login(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));
	HomePage hp = new HomePage(driver);
	hp.clickAccounts();
	hp.clickStudentLink();
	StudentPage sp= new StudentPage(driver);
	sp.clickAddStudentButton();
	
	AddStudentPage asp= new AddStudentPage(driver);
	asp.uploadImage();
	asp.createStudent(wu, StudentId, Firstname, Middlename, lastname, 1, Section);
	//Search Student
	sp.passValueToSearchTB(StudentId);
	
	sp.deleteStudent(driver, StudentId);
	System.out.println("Student deleted");
	
	
	
	
		

	}

}
