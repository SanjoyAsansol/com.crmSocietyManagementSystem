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

public class Tc_Activity_20_Test {
	public static void main(String[] args) throws Throwable {
		
		Random r= new Random();
		int random=r.nextInt();
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
		Sheet sh=wb.getSheet("All Module");
		String deadlinedate= sh.getRow(0).getCell(4).getStringCellValue();
		String StudentID= sh.getRow(1).getCell(4).getStringCellValue();
		//Launch driver
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
		//click on Expences
		driver.findElement(By.xpath("//a[.=' Expenses']")).click();
		//add expense
	 	driver.findElement(By.id("add_expenses")).click();
	 	HashMap<String, String> map= new HashMap<String, String>();
	 	for(int i=0; i<=sh.getLastRowNum();i++)
	 	{
	 		String key=sh.getRow(i).getCell(0).getStringCellValue();
	 		String value=sh.getRow(i).getCell(1).getStringCellValue();
	 		map.put(key, value);
	 	}
	 	for(Entry<String, String> set:map.entrySet())
	 	{
	 		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	 	}
	 	//select Sem Dropdown
		WebElement semdd=driver.findElement(By.name("sem"));
		Select s= new Select(semdd);
		s.selectByVisibleText("1st");
		//put date on calendar
		driver.findElement(By.name("deadline")).sendKeys(deadlinedate);
		//click on transaction
		driver.findElement(By.xpath("//a[.=' Transaction']")).click();
		//click on search
		driver.findElement(By.id("search")).sendKeys(StudentID);
		//click on search
		driver.findElement(By.id("btn_search")).click();
		String actualstudentID=driver.findElement(By.xpath("//label[text()='"+StudentID+"']")).getText();
		if(actualstudentID.equals(StudentID))
		{
			System.out.println("Student Created Successfully");
		}
		else
		{
			System.out.println("Student not Created");
		}
		//Click on Options and logout
		driver.findElement(By.xpath("//a[.=' Options']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		driver.close();
	}

}
