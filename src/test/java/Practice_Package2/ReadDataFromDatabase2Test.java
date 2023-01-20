package Practice_Package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase2Test {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		try {
		Driver driver= new Driver();//mysql.cj.jdbc
		//Register to Database
		DriverManager.registerDriver(driver);
		//Connect to database
		con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sdet45","root" ,"root");
		//Issue Create statement
		Statement state=con.createStatement();
		String query= "select * from studentinfo where COURSE='APPIUM';";
		//Execute query
		ResultSet rs=state.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		}
		catch(Exception e)
		{
			
		}
		finally {
			con.close();
			System.out.println("database connection close successfully");
		}
		

	}

}
