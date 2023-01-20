package Practice_Package;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("use-fake-device-for-media-stream");
		opt.addArguments("use-fake-ui-for-media-stream");
		//opt.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		//click on test mic
		driver.findElement(By.id("mic-launcher")).click();
		
//		WebDriverWait wait2= new WebDriverWait(driver, 50);
//		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[.='Testing Area']/..//ul")));
//		WebElement msg=driver.findElement(By.xpath("//h3[.='Testing Area']/..//ul"));
//		
//		System.out.println(msg.getText());
		
		
		
		

	}

}
