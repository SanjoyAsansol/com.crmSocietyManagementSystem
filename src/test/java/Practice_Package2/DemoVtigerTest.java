package Practice_Package2;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoVtigerTest {

	public static void main(String[] args) throws Throwable {
		
		Random r= new Random();
		int random=r.nextInt(500);
		
		//Step1: Get data from properties
				FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData1.properties");
				Properties pobj= new Properties();
				pobj.load(fis);
				String URL=pobj.getProperty("url");
				String USERNAME=pobj.getProperty("username");
				String PASSWORD=pobj.getProperty("password");
				
				//Step2: Get data from ExcellSheet
				FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
				Workbook wb= WorkbookFactory.create(fi);
				Sheet sh=wb.getSheet("Contact");
				String OrgName=sh.getRow(1).getCell(0).getStringCellValue()+random;
				String lastname=sh.getRow(0).getCell(0).getStringCellValue();
				String Organization_name=sh.getRow(0).getCell(1).getStringCellValue()+random;
				
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
				
				//click on organization//
				driver.findElement(By.linkText("Organizations")).click();
				//click on lookup image anf fill all the details//
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(OrgName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//validation//
				String created_organization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(created_organization.contains(OrgName))
				{
					System.out.println(OrgName+" organization created successfully!");
					
				}
				else {
					System.out.println("Organization Not Created");
				}
				//click on Contacts
				driver.findElement(By.linkText("Contacts")).click();
				//click on create Contacts
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				//putting attribute value in map
				Thread.sleep(3000);
				HashMap<String, String> map= new HashMap<String, String>();
				for(int i=3;i<=sh.getLastRowNum();i++)
				{
					String key=sh.getRow(i).getCell(0).getStringCellValue();
					String value=sh.getRow(i).getCell(1).getStringCellValue()+random;
					map.put(key, value);
					
				}
				Thread.sleep(3000);
				for(Entry <String, String> set:map.entrySet())
				{
					
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
					Thread.sleep(3000);
				}
					
				
				
				
				
				
				//driver.findElement(By.name("lastname")).sendKeys(lastname);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				//click on save button
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//shitch to child
				String parentid=driver.getWindowHandle();
				Set<String> allid = driver.getWindowHandles();
				Iterator<String> it=allid.iterator();
				while(it.hasNext())
				{
					 String winid = it.next();
					 String title=driver.switchTo().window(winid).getTitle();
					 if(title.contains("Accounts&action"))
					 {
						 //driver.switchTo().window(winid);
						 break;
					 }
				}
//				for(String id:allid)
//				{
//					String title=driver.switchTo().window(id).getTitle();
//					if(title.contains("Accounts&action"))
//					{
//						driver.switchTo().window(id);
//						break;
//					}
//				}
				//click on search
				driver.findElement(By.id("search_txt")).sendKeys(OrgName);
				driver.findElement(By.name("search")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();	
				//switch to Parent id
				driver.switchTo().window(parentid);
				driver.close();

				
	}}