package com.sms.HardcodeTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc_Expences_15Test {
	public static void main(String[] args) throws Throwable {
				//Random number
				Random r= new Random();
				int random=r.nextInt(50);
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
				Sheet sh=book.getSheet("Expences");
				String updateprice= sh.getRow(8).getCell(1).getStringCellValue()+random;
				
				//Launch Chrome
				WebDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(URL);
				//Login to application
				driver.findElement(By.id("username")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
				//click on Expences
				driver.findElement(By.xpath("//a[.=' Expenses']")).click();
//				//add expense
//				driver.findElement(By.id("add_expenses")).click();
//				//send all data from excell
//				HashMap<String,String> map= new HashMap<String, String>();
//				for(int i=7;i<=sh.getLastRowNum();i++)
//				{
//					String key= sh.getRow(i).getCell(0).getStringCellValue();
//					String value= sh.getRow(i).getCell(1).getStringCellValue();
//					map.put(key, value);
//					
//				}
//				for(Entry<String, String> set:map.entrySet())
//				{
//					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//				}
//				WebElement semdd=driver.findElement(By.name("sem"));
//				Select s= new Select(semdd);
//				s.selectByVisibleText("1st");
//				//select date
//				WebElement date=driver.findElement(By.name("deadline"));
//				String deadline="16-12-2022";		
//				date.clear();
//				date.sendKeys(deadline);
//				driver.findElement(By.name("save_expenses")).click();
				driver.findElement(By.xpath("//td[.='shoe']/../../tr[2]/td[6]/center[1]/a[1]")).click();
				WebElement price=driver.findElement(By.name("price"));
				price.clear();
				price.sendKeys(updateprice);
				
				driver.findElement(By.name("update_expenses")).click();
				String actualprice=driver.findElement(By.xpath("//td[.='shoe']/following-sibling::td[1]")).getText();
				if(updateprice.contains(actualprice))
				{
					System.out.println("TC is Pass");
				}
				else
				{
					System.out.println("TC is fail");
				}
				//Click on Options and logout
		    	driver.findElement(By.xpath("//a[.=' Options']")).click();
				driver.findElement(By.xpath("//a[.=' Logout']")).click();
				driver.close();
	}
}
