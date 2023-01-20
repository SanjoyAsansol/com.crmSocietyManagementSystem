package com.sms.HardcodeTest;

import java.io.FileInputStream;
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

public class Tc_Accounts_05_Test {
	public static void main(String[] args) throws Throwable {
		Random r= new Random();
		int random=r.nextInt(500);
		
		//Step1: Get data from properties
				FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
				Properties pobj= new Properties();
				pobj.load(fis);
				String URL=pobj.getProperty("url");
				String USERNAME=pobj.getProperty("username");
				String PASSWORD=pobj.getProperty("password");
				
				//Step2: Get data from ExcellSheet
				FileInputStream fi= new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb= WorkbookFactory.create(fi);
				Sheet sh=wb.getSheet("Administrator");
				String value=sh.getRow(0).getCell(1).getStringCellValue()+random;
				//String WebSite=sh.getRow(1).getCell(1).getStringCellValue()+random;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium-21-09-22\\chromedriver.exe");
		
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
		//click on Accounts
		driver.findElement(By.xpath("//a[.=' Accounts']")).click();
		//click on add Admninistrator
		driver.findElement(By.xpath("//a[.=' Administrator']")).click();
		//click on Add Admin
				driver.findElement(By.id("add_admin")).click();
				ArrayList<String> list= new ArrayList<String>();
				list.add("username");
				list.add("password");
				list.add("name");
				
				for(int i=0; i<=sh.getLastRowNum(); i++)
				{
				String data=sh.getRow(i).getCell(1).getStringCellValue()+random;	
				driver.findElement(By.name(list.get(i))).sendKeys(data);
				}
				//
				driver.findElement(By.name("save_admin")).click();
		//Search box
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(value);
		String createdadmin=driver.findElement(By.className("sorting_1")).getText();
		if(createdadmin.equals(value))
		{
			System.out.println("TC is pass");
		}
		else
		{
			System.out.println("TC is fail");
		}
		driver.close();
	}

}
