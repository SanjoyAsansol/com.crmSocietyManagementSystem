package Organization;

import java.io.FileInputStream;

import java.util.ArrayList;

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
import org.openqa.selenium.interactions.Actions;

import com.crm.SocietyManagementSystem.genericLib.DataBaseUtility;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		JavaUtility ju= new JavaUtility();
		DataBaseUtility du= new DataBaseUtility();
		ExcellUtility eu= new ExcellUtility();
		FileUtility fu= new FileUtility();
		WebDriverUtility wu= new WebDriverUtility();
		String url = fu.getDataFromProperty("username");
	    int random = ju.getRandomNo();
		
	
	    String OrgName = eu.getDataFromExcell("Organization", 0, 1)+random;
		//Step2: Get data from ExcellSheet
		FileInputStream fi= new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Organization");
		//String OrgName=sh.getRow(0).getCell(1).getStringCellValue()+random;
		//String WebSite=sh.getRow(1).getCell(1).getStringCellValue()+random;
		
		//login to app
		
		WebDriver driver= new ChromeDriver();
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		
		driver.get(fu.getDataFromProperty("urlvtiger"));
		driver.findElement(By.name("user_name")).sendKeys(fu.getDataFromProperty("username"),Keys.TAB,fu.getDataFromProperty("password"),Keys.TAB,Keys.ENTER);
		
		//Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		ArrayList<String> list= new ArrayList<String>();
		list.add("accountname");
		list.add("website");
		list.add("tickersymbol");
		list.add("phone");
		for(int i=0; i<=sh.getLastRowNum();i++)
		{
			String value=sh.getRow(i).getCell(1).getStringCellValue()+random;
			driver.findElement(By.name(list.get(i))).sendKeys(value);
			
		}
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualOrgname=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualOrgname.contains(OrgName))
		{
			System.out.println("Organization is created");
		}
		else
		{
			System.out.println("Organization is  not created");

		}
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//sign out
		WebElement SignOut= driver.findElement(By.linkText("Sign Out"));
		wu.moveToElement(driver, SignOut);
		SignOut.click();
		
		
		

	}

}
