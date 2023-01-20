package Practice_Package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class DemoServerValidation {
	 public static void main(String[] args) throws SQLException {
		
	
	Connection con= null;
	Statement state= null;
	String coursename= "APPIUM";
	Driver driver1= new Driver();
	try {
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root" ,"root");
		state= con.createStatement();
		String query="select * from studentinfo;";
		ResultSet rs=state.executeQuery(query);
		boolean flag= false;
		while(rs.next())
		{
			String actualcourse=rs.getString(3);
			System.out.println(actualcourse);
			
			if(actualcourse.equalsIgnoreCase(coursename))
			{
				flag= true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("course is available");
		}
		else {
			System.out.println("course is not available");
		}
		}
			catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			con.close();
			System.out.println("DB connection is closed successfully");
			}
	
	 } 
}
	
	 

	

