package Practice_Package;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/bus-tickets/");
		Thread.sleep(2000);
		//cancel Authentication popup
		driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		//click on buses
		driver.findElement(By.xpath("//ul[@class='makeFlex font12']/li[6]/div/a")).click();
		//click to from and give source location
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Kolkata");
		driver.findElement(By.xpath("//p[@class='searchedResult font14 darkText']/descendant::span[.='Kolkata, West Bengal']")).click();
		//click to to and give destination location
		driver.findElement(By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")).sendKeys("Asansol");
		driver.findElement(By.xpath("//p[@class='searchedResult font14 darkText']/descendant::span[.='Asansol, West Bengal']")).click();
		//chose date
		Date d= new Date();
		String currentdate=d.toString();
		System.out.println(currentdate);
		//Mon Jan 02 2023
		String day="Tue";
		String month="Jan";
		String date="10";
		String year="2023";
		driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+date+" "+year+"']")).click();
		//click on search
		driver.findElement(By.id("search_button")).click();
		//Handel hidden division popup
		//driver.findElement(By.xpath("//img[@src='//jsak.mmtcdn.com/bus_cdn_dt/static/media/ic_close_black.f8e2b843.svg']")).click();
		List<WebElement> buses=driver.findElements(By.xpath("//div[@class='makeFlex column bus-view-left']/div[1]/div[1]/span[1]"));
		for(WebElement bus:buses)
		{
			String singlebus=bus.getText();
			System.out.println(singlebus+" ");
		}
		driver.close();
				
		
	}

}
