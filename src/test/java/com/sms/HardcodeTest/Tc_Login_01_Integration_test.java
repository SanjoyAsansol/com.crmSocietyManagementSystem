package com.sms.HardcodeTest;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc_Login_01_Integration_test {
public static void main(String[] args) throws Throwable {
		
		//Random number
		Random r= new Random();
		int random=r.nextInt(500);
		//getData from prpoerties
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		//GET data from excell
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh=book.getSheet("Student");
		 String studentid=sh.getRow(1).getCell(1).getStringCellValue()+random;
		
		//Launch Chrome
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		//Login to application
		driver.findElement(By.id("username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
		//Login to accounts
		driver.findElement(By.xpath("//a[.=' Accounts']")).click();
		//click on student
		driver.findElement(By.xpath("//a[.=' Student']")).click();
		//click on Add_student
		driver.findElement(By.id("add_student")).click();
		//Send all thee Details
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue()+random;
			//studentid=sh.getRow(1).getCell(1).getStringCellValue()+random;
			//System.out.println(studentid);
			map.put(key, value);
			
		}
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		WebElement yeardd=driver.findElement(By.name("year"));
		Select s = new Select(yeardd);
		s.selectByVisibleText("I");
		Thread.sleep(3000);
		//click on save
		driver.findElement(By.name("save_student")).click();
		//click on transaction
		driver.findElement(By.xpath("//a[.=' Transaction']")).click();
	
		//click on search
		driver.findElement(By.id("search")).sendKeys(studentid);
		Thread.sleep(2000);
		//click on search
		driver.findElement(By.id("btn_search")).click();
		Thread.sleep(2000);
		String actualstudentid=driver.findElement(By.xpath("//label[.='"+studentid+"']")).getText();
		if(actualstudentid.equals(studentid))
		{
			System.out.println("Student is Created");
		}
		else
		{
			System.out.println("Student is not Created");
		}
		
		driver.close();
	}


}
