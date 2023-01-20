package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetDataFromRmdServerTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
		
		try {
			Driver driver= new Driver();
			//Step1: register to database
			DriverManager.registerDriver(driver);
			//step2: Get connection for database
			con=DriverManager.getConnection("Jdbc:mysql://rmgtestingserver:3333/projects","root@%" ,"root");
			//step 3: Issue create Statement
			Statement state=con.createStatement();
			//Step4:Update Query
			String query= "insert into Project values('TY_Project_11','Sanjoy','21/12/2022','SocietyManagementSystem','Created','3');";
			//String querydelete=""
			result=state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally {
			//Step 5: 
			if(result==1)
			{
				System.out.println("Data inserted succesfully");
			}
			else
			{
				System.out.println("data not inserted");
			}
			con.close();
		}
	}
}
			
			