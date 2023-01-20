package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AutomateRmg2Test {

	public static void main(String[] args) throws SQLException {
		Connection con= null;
		Statement state=null;
		String projectname="Cricbuzz";
		WebDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://rmgtestingserver:8084");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				//Click on projects
				driver.findElement(By.linkText("Projects")).click();
				//create project
				driver.findElement(By.xpath("//span[text()='Create Project']")).click();
				driver.findElement(By.name("projectName")).sendKeys(projectname);
				driver.findElement(By.name("createdBy")).sendKeys("Vijaylaxmi");
				//select created from dropdown
				WebElement dd= driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[1]"));
				Select s= new Select(dd);
				s.selectByVisibleText("Created");
				//click on add Project
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				//TestYantaServer Validation
				Driver driver1= new Driver();
				try {
				DriverManager.registerDriver(driver1);
				con=DriverManager.getConnection("Jdbc:mysql://rmgtestingserver:3333/projects","root@%" ,"root");
				state= con.createStatement();
				String query="select * from project;";
				ResultSet rs=state.executeQuery(query);
				boolean flag=false;
				while(rs.next())
				{
					 //actualproject=(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
					String actualprojectname=rs.getString(4);
					//System.out.println(actualprojectname);
					if(projectname.equalsIgnoreCase(actualprojectname))
					{
						flag=true;
						break;
					}
				}
				if(flag)
				{
					System.out.println("Project is Created");
				}
				else {
					System.out.println("Project is not Created");
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally {
				con.close();
				}
			}
		}
