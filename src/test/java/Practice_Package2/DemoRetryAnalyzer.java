package Practice_Package2;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners (com.crm.SocietyManagementSystem.genericLib.ListenersImplementationClass.class)
public class DemoRetryAnalyzer {

	@Test
	public void test1()
	{
		System.out.println("Hello1");
		Assert.fail();
		System.out.println("Hello2");
	}
}
