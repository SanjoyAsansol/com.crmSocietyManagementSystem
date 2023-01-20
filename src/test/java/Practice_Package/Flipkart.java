package Practice_Package;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text() = '✕']")).click();
		
		driver.findElement(By.xpath("//div[text() = 'Electronics']")).click();
		
		Actions act = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath("//span[contains(.,'Electronics')]"));
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[@title='Samsung']")).click();
		
		//driver.findElement(By.xpath("//a[text() = 'SAMSUNG Galaxy F23 5G (Copper Blush, 128 GB)']/../../../descendant::span[text()='Coming Soon']")).click();
		driver.findElement(By.xpath("//span[text() = 'Coming Soon']/../../following-sibling::div/div/a[text() = 'SAMSUNG Galaxy F23 5G (Copper Blush, 128 GB)']")).click();
		
		driver.findElement(By.xpath("//a[text() = 'Login']")).click();
		
		String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid)
		{
			String title = driver.switchTo().window(id).getTitle();
			if(title.contains("SAMSUNG Galaxy F23 5G"))
			{
				break;
			}
		}
		String mname = driver.findElement(By.xpath("//span[text() = 'SAMSUNG Galaxy F23 5G (Copper Blush, 128 GB)']")).getText();
		String mprice = driver.findElement(By.xpath("//span[text() = 'SAMSUNG Galaxy F23 5G (Copper Blush, 128 GB)']/../../following-sibling::div[@class='dyC4hf']/div/div/div")).getText();
		System.out.println(mname);
		System.out.println(mprice);
  

	}

}
