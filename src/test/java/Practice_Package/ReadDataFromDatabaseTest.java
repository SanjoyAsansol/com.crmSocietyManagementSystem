package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver driver= new Driver();// import from mysql.cj.jdbc
			
		//Step 1: Register to the Database
		DriverManager.registerDriver(driver);
		
		//Step 2: get connection for the database
		con=DriverManager.getConnection("Jdbc:mysqli://localhost:3306/sdet45","root" ,"root");

		//Step 3: issue create statement
		Statement state= con.createStatement();
		String query ="select * from studentinfo;";
		
		
		//Step 4: execute query
		ResultSet result=state.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			
		}
	}
		catch(Exception e)
		{
			
		}
		finally {
			//Step 5: close the database
			con.close();
			System.out.println("Close the database connection successfully");
				}
		}
		
	}


