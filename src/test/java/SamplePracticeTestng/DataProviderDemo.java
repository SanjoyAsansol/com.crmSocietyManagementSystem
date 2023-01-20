package SamplePracticeTestng;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;

public class DataProviderDemo {
	WebDriver driver= null;
	@DataProvider
	public Object[][] getData()
	{
		Object[][] arr= new Object[2][2];
		arr[0][0]="admin";
		arr[0][1]="admin";
		arr[1][0]="admin";
		arr[1][1]="admin";
		return arr;
	}
	@BeforeClass
	public void launch() throws Throwable
	{
		driver= new ChromeDriver();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	@Test(dataProvider= "getData")
	public void loginToApp(String un, String pw) throws Throwable
	{
		Thread.sleep(5000);
		System.out.println("Loading");
		FileUtility fu= new FileUtility();
		driver.get(fu.getDataFromProperty("url"));
		LoginPage lp= new LoginPage(driver);
		lp.login(un, pw);
	}

}
