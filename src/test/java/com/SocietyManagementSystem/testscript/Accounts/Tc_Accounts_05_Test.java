package com.SocietyManagementSystem.testscript.Accounts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.AccountPage;
import com.sms.ObjectRepo.AddAdminPage;
import com.sms.ObjectRepo.AdministratorPage;
import com.sms.ObjectRepo.HomePage;
@Listeners(com.crm.SocietyManagementSystem.genericLib.ListenersImplementationClass.class)
public class Tc_Accounts_05_Test extends BaseClass {

	@Test
	//@Test(retryAnalyzer = com.crm.SocietyManagementSystem.genericLib.RetryImplementationClass.class)
	public void Accounts05() throws Throwable  {
		
		
		String username=eu.getDataFromExcell("Administrator", 0, 1)+ju.getRandomNo();
		String password=eu.getDataFromExcell("Administrator", 1, 1);
		String name= eu.getDataFromExcell("Administrator", 2, 1);

		HomePage hp= new HomePage(driver);
		hp.clickAccounts();
		
		AccountPage ap= new AccountPage(driver);
		ap.clickAdministrator();
//		Assert.fail();
		
		AdministratorPage adm= new AdministratorPage(driver);
		adm.addAmnistrator();
		AddAdminPage aap= new AddAdminPage(driver);
		aap.addAdmin(username, password, name);

		Thread.sleep(3000);
		//Search box
		AdministratorPage adp= new AdministratorPage(driver);
		adp.getSearchTB().sendKeys(username);
		Thread.sleep(3000);
		//String createdadmin=driver.findElement(By.className("sorting_1")).getText();
		String searchedUsername=adp.getSearchdUsername(driver);
		Thread.sleep(2000);
		if(searchedUsername.equals(username))
		{
			System.out.println("TC is pass");
		}
		else
		{
			System.out.println("TC is fail");
		}
		
	}

}
