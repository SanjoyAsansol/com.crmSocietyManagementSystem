package SamplePracticeTestng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.DataBaseUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.IPathConstants;
import com.mysql.cj.jdbc.Driver;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.OptionsPage;

public class DemoAnnotation1 {
	WebDriver driver;
	Connection con= null;
	DataBaseUtility du= new DataBaseUtility();
	LoginPage lp= new LoginPage(driver);
	FileUtility fu= new FileUtility();
	HomePage hp= new HomePage(driver);
	OptionsPage op= new OptionsPage(driver);
	@BeforeSuite
	public void connectDB() throws Throwable
	{	Driver driver= new Driver();
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
	public void launchChrome() throws Throwable
	{
		driver= new ChromeDriver();
		driver.get(fu.getDataFromProperty("url"));
	}
	@BeforeMethod
	public void loginApp() throws Throwable
	{
		lp.login(fu.getDataFromProperty("username"), fu.getDataFromProperty("password"));
		System.out.println("Login Successfully");
	}
	@Test
	public void runTest()
	{
		System.out.println("Hello Brother");
	}
	@AfterClass
	public void logoutFromApp()
	{
		driver.close();
//		hp.clickOptions();
//		op.clickLogout();
		
	}
	@AfterSuite
	public void closeDB() throws Throwable
	{
		du.closeDB();
	}

}
