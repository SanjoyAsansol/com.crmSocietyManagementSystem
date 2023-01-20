package SamplePracticeTestng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {

	@Test(priority = 0)
	public void wakeUp()
	{
		Reporter.log("Wake up", true);
	}
	@Test(priority = 1)
	public void doBrush()
	{
		Reporter.log("Do brush", true);
	}
	@Test(priority= 2,invocationCount = 3)
	public void goTestYantra()
	{
		Reporter.log("Go to Test Yantra", true);
	}
}
