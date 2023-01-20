package Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulationTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.worldometers.info/world-population/");
		String population=driver.findElement(By.xpath("//h1[.=' Current World Population']/..//div")).getText();
		System.out.println(population);

	}

}
