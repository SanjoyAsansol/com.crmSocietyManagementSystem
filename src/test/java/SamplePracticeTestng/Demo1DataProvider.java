package SamplePracticeTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo1DataProvider {
	@DataProvider
	public Object[][] getData()
	{
		Object[][] arr= new Object[2][2];
		arr[0][0]="Sanjoy";
		arr[0][1]="Mondal";
		arr[1][0]="Ajoy";
		arr[1][1]="Mondal";
		return arr;
	}
	@Test(dataProvider="getData")
	public void practiceDataProvider(String name, String title)
	{
		System.out.println(name+" ---------------> "+title);
	}

}
