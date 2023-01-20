package Practice_Package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectedQuery2Test {

	public static void main(String[] args) {
		Connection con= null;
		int result= 0;
		try {
			Driver driver= new Driver();
			//Step 1 : Register to Database
			DriverManager.registerDriver(driver);
			//Step 2: get Connetion for Database
			con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/sdet45","root" ,"root");
			//Step 3:Issue Create statement
			Statement state=con.createStatement();
			//Step4:Execute Query
			String query= "insert into studentinfo values('Sanjoy','OAR','Manuel Testing',1)";
			result=state.executeUpdate(query);
			}
			catch(Exception e)
			{
				
			}
			finally{
				
			
			
			}
			
			//Step 4: Execute Query
			
			
			
			
			
		}

	}


