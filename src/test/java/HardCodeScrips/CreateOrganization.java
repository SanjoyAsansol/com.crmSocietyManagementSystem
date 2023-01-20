package HardCodeScrips;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.SocietyManagementSystem.genericLib.DataBaseUtility;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
			
			Random r= new Random();
			int random=r.nextInt(500);
			
			//Step1: Get data from properties
			FileInputStream fis= new FileInputStream("./src/test/resources/CommonData1.properties");
			Properties pobj= new Properties();
			pobj.load(fis);
			String URL=pobj.getProperty("url");
			String USERNAME=pobj.getProperty("username");
			String PASSWORD=pobj.getProperty("password");
			
			//Step2: Get data from ExcellSheet
			FileInputStream fi= new FileInputStream("./src/test/resources/TestData1.xlsx");
			Workbook wb= WorkbookFactory.create(fi);
			Sheet sh=wb.getSheet("Organization");
			String OrgName=sh.getRow(0).getCell(1).getStringCellValue()+random;
			//String WebSite=sh.getRow(1).getCell(1).getStringCellValue()+random;
			
			//login to app
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium-21-09-22\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.ENTER);
			
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
			Actions act= new Actions(driver);
			act.moveToElement(SignOut).perform();
			SignOut.click();
			
			
			

		}

	}


