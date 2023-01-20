package SamplePracticeTestng;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationHirarcy {
	
	@BeforeSuite
	public void ConnectDB()
	{
		Reporter.log("DataBaseConnected",true);
	}
	@BeforeClass
	public void launchBrowser()
	{
		Reporter.log("Browser is Launched Successfully", true);
	}
	@BeforeMethod
	public void loginToApp()
	{
		Reporter.log("Succesfully Login", true);
	}
	@Test(priority=1)
	public void createStudent()
	{
		Reporter.log("Student Created", true);
	}
	@Test(priority=2, invocationCount=2)
	public void updateStudent()
	{
		Reporter.log("Student Updated", true);
	}
	@AfterMethod
	public void logoutToApp()
	{
		Reporter.log("Logout Succesfully", true);
	}
	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("Browser is Closed", true);
	}
	@AfterSuite
	public void dissconnectDB()
	{
		Reporter.log("DataBase Disconnected", true);
	}
}
