package SamplePracticeTestng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo extends BaseClass{
	@Test(priority= 0)
	public void createStudent()
	{
		Reporter.log("Student Created", true);
	}
	@Test
	public void updateStudent()
	{
		Reporter.log("Student Updated", true);
	}
	@Test(dependsOnMethods="createStudent")
	public void deleteStudent()
	{
	Reporter.log("Student Deleted", true);
	}

}
