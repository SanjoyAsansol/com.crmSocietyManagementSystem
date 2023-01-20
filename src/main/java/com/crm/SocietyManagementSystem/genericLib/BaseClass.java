package com.crm.SocietyManagementSystem.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.OptionsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver ListnerDriver;
	public FileUtility fu= new FileUtility();
	public ExcellUtility eu= new ExcellUtility();
	public DataBaseUtility du= new DataBaseUtility();
	public WebDriverUtility wu= new WebDriverUtility();
	public JavaUtility ju= new JavaUtility();
	
	@BeforeSuite(alwaysRun=true)
	public void configBS() throws Throwable
	{
		du.connectToDB();
		System.out.println("Database Connected Successfully");
	}
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun=true)
	public void configBC() throws Throwable
	{
//		String URL= fu.getDataFromProperty("url");
//		driver.get(URL);
		String BROWSER= fu.getDataFromProperty("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
//			WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", "C:\\Selenium-21-09-22\\msedgedriver.exe");
			driver= new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		
		
		ListnerDriver= driver;
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		
	}
		
	@BeforeMethod(alwaysRun= true)
	public void configBM() throws Throwable
	{
//      for IRetryAnalyser
		String URL= fu.getDataFromProperty("url");
		driver.get(URL);
		String USERNAME= fu.getDataFromProperty("username");
		String PASSWORD= fu.getDataFromProperty("password");
		LoginPage lp= new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("Login Successfully");
	}
	
	@AfterMethod(alwaysRun=true)
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOptions();
		OptionsPage op= new OptionsPage(driver);
		op.clickLogout();
		System.out.println("Logout Successfully");
	}
	@AfterClass(alwaysRun=true)
	public void configAC()
	{
		driver.quit();
		System.out.println("Browser closed Successfully");
	}
	@AfterSuite(alwaysRun=true)
	public void configAS() throws Throwable
	{
		du.closeDB();
		System.out.println("DataBase Close Successfully");
	}
	

}
