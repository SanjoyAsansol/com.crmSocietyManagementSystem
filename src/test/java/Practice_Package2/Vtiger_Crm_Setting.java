package Practice_Package2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.SocietyManagementSystem.genericLib.DataBaseUtility;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.JavaUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;

public class Vtiger_Crm_Setting {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= null;
		DataBaseUtility db = new DataBaseUtility();
		ExcellUtility eu= new ExcellUtility();
		FileUtility fu= new FileUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wu= new WebDriverUtility();
		
		
		if(fu.getDataFromProperty("browser").equals("chrome"))
		{	
			System.out.println("Chrome driver Launched Succesfully");
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(fu.getDataFromProperty("urlvtiger"));
		//login to vtiger
		driver.findElement(By.name("user_name")).sendKeys(fu.getDataFromProperty("username"),Keys.TAB,fu.getDataFromProperty("password"),Keys.TAB,Keys.ENTER);
		//move to setting and click crm settings
		driver.findElement(By.xpath("//td[@valign='bottom']/../td[3]/table/tbody/tr/td[4]")).click();
		WebElement crmsrttings = driver.findElement(By.xpath("//a[.='CRM Settings']"));
		wu.moveAndClick(driver, crmsrttings);
		//scroll upto workflows
		WebElement workflows = driver.findElement(By.xpath("//a[contains(.,'Workflows')]"));
		wu.scrollAction(driver, workflows);
		workflows.click();
		driver.findElement(By.id("new_workflow")).click();
		//module list dropdown and select list option and create
		WebElement moduledd = driver.findElement(By.id("module_list"));
		wu.getSelect(moduledd, 3);
		driver.findElement(By.id("new_workflow_popup_save")).click();
		//Fetch data from excell
		String actualDescription=eu.getDataFromExcell("Crm Settings", 0, 0)+ju.getRandomNo();
		//write on description the data fetch from excell
		driver.findElement(By.id("save_description")).sendKeys(actualDescription);
		//click on save button
		driver.findElement(By.id("save_submit")).click();
		//again scroll down upto workflow
		wu.scrollBarAction(driver);
		//click on workflows
		driver.findElement(By.xpath("//a[contains(.,'Workflows' )]")).click();
		//Again scroll down
		WebElement scrolllastoption = driver.findElement(By.xpath("//td[.='"+actualDescription+"']"));
		wu.scrollAction(driver, scrolllastoption);
		//validation
		String expDescription=scrolllastoption.getText();
		if(actualDescription.equals(expDescription))
		{
			System.out.println("TC is pass");
			//delete that particular lead
			driver.findElement(By.xpath("//table[@id='expressionlist']/descendant::td[.='"+actualDescription+"']/../td[3]/a[2]")).click();
			System.out.println("deleted");
			wu.acceptAlert(driver);
		}
		else
		{
			System.out.println("TC is fail");
		}
		
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.moveAndClick(driver, administrator);
		//click on Sign Out
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
		
		

	}

}
