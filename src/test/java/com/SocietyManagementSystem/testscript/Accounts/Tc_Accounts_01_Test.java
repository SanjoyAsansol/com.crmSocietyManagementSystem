package com.SocietyManagementSystem.testscript.Accounts;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.crm.SocietyManagementSystem.genericLib.DataBaseUtility;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.AccountPage;
import com.sms.ObjectRepo.AddAdminPage;
import com.sms.ObjectRepo.AdministratorPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.OptionsPage;
import com.sms.ObjectRepo.StudentPage;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.crm.SocietyManagementSystem.genericLib.ListenersImplementationClass.class)
public class Tc_Accounts_01_Test extends BaseClass {
	 @Test
	 public void Accounts01() throws Throwable {
		 
		HomePage hp= new HomePage(driver);
		hp.clickAccounts();
		Assert.fail();
		
		//click on add Admninistrator
		AccountPage apg= new AccountPage(driver);
		apg.clickAdministrator();
		
		//click on Add Admin
		AdministratorPage ap= new AdministratorPage(driver);
		ap.addAmnistrator();
		
		
		String username= eu.getDataFromExcell("Administrator", 0, 1)+ju.getRandomNo();
		String actualpassword= eu.getDataFromExcell("Administrator", 1, 1);
		String actualname= eu.getDataFromExcell("Administrator", 2, 1);
		AddAdminPage aap= new AddAdminPage(driver);
		aap.addAdmin(username, actualpassword, actualname);
	
		ap.dropDown(driver, wu, 3);
		Thread.sleep(3000);
		String actualcostomername= ap.getActualCustomerName(driver, eu);
		if(actualcostomername.equals(username))
		{
			System.out.println("Admin Created Successfully");
		}
		else
		{
			System.out.println("Admin not created");
		}
		
				

	}
	

}
