package com.crm.SocietyManagementSystem.genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class DataBaseUtility {
	
	Connection con= null;
	public void connectToDB() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		//con = DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUSERNAME,IPathConstants.DBPASSWORD);
		con = DriverManager.getConnection(IPathConstants.DBURLMYSQL,IPathConstants.DBUSERNAMEMYSQL,IPathConstants.DBPASSWORDMYSQL);
	}
	
	public String executeQueryAndGetData(String query, int columIndex,String expData) throws Throwable
	{
		ResultSet res = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(res.next())
		{
			String data=res.getString(columIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
			if(flag)
			{
				System.out.println(expData+"Executed succesfully");
				return expData;
			}
			else
			{
				System.out.println("Execution Failed");
				return "";
			}
				
		}
	/**
	 * this metod is for close database
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
		
	
	}
			


