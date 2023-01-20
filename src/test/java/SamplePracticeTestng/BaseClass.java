package SamplePracticeTestng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.IPathConstants;
import com.mysql.cj.jdbc.Driver;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.OptionsPage;

public class BaseClass  {
	Connection con= null;
	WebDriver driver= null;
	@DataProvider
	public Object[][] getData()
	{
		Object[][] arr= new Object[2][2];
		arr[0][0]= "admin";
		arr[0][1]="admin";
		arr[1][0]="admin";
		arr[1][1]="admin";
		return arr;
	}
	@BeforeSuite
	public void ConnectToDB() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURLMYSQL,IPathConstants.DBUSERNAMEMYSQL,IPathConstants.DBPASSWORDMYSQL);
		String query= "select * from studentinfo;";
		Statement stmt = con.createStatement();
		ResultSet result=stmt.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		System.out.println("DB Onen Successfully");
	}
	@BeforeClass
	public void launchBrowser()
	{
		driver= new ChromeDriver();
	}
	
	@Test(dataProvider="getData")
	public void loginToApp1(String un, String pw) throws Throwable
	{
		FileUtility fu= new FileUtility();
		driver.get(fu.getDataFromProperty("url"));
		LoginPage lp= new LoginPage(driver);
		lp.login(un, pw);
		
	}
	
//	@BeforeMethod
//	public void loginToApp() throws Throwable
//	{
//		FileUtility fu= new FileUtility();
//		driver.get(fu.getDataFromProperty("url"));
//		LoginPage lp= new LoginPage(driver);
//		lp.login(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));
//	}
	@AfterMethod
	public void logoutToApp() throws InterruptedException
	{
		Thread.sleep(10000);
		HomePage hp= new HomePage(driver);
		hp.clickOptions();
		Thread.sleep(10000);
		OptionsPage op= new OptionsPage(driver);
		op.clickLogout();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	@AfterSuite
	public void closeDB() throws Throwable
	{
		con.close();
		System.out.println("DB closed Successfully");
	}
}
