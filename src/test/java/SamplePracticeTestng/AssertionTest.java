package SamplePracticeTestng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	public void Sample1()
	{
		String s= "India";
		String s2= "Pakistan";
		assertEquals(s, s2);
		Reporter.log("Pass", true);
	}
	@Test
	public void Sample2()
	{
		String s= "India";
		String s2= "Indi";
		assertTrue(s.contains(s2));
		Reporter.log("Pass", true);
	}
	@Test
	public void Sample3()
	{
		String s= null;
		assertNotNull(s, "Assertion Failed");
	}
	@Test
	public void Sample4()
	{
		String s= "India";
		String s2= "Pakistan";
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(s.equals(s2), "Assertion Failed");
		System.out.println("Soft Assert failed");
		sa.assertAll();
	}	
		
		
		
		
}
