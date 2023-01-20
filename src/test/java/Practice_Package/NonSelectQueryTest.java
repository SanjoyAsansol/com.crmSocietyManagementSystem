package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con= null;
		int result=0;
		
		try {
			Driver driver= new Driver();
			
			//Step1: register to database
			DriverManager.registerDriver(driver);
			
			//step2: Get connection for database
			con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sdet45","root" ,"root");
			
			//step3: Issue create statement
			Statement state=con.createStatement();
			String query="insertinto studentinfo values('Nitish','BTM','APPIUM', 1);";
			
			//Step 4: Update Query
			result= state.executeUpdate(query);
		}	
		catch(Exception e)
		{
			
		}
		finally {
			
			if(result==1)
			{
				System.out.println("Data inserted Successfully");
			}
			else {
				System.out.println("data not inserted");
				
			}
			con.close();
			
		}
			
			
		}

	}


