package com.crm.SocietyManagementSystem.genericLib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;



public class JavaUtility {
	public int getRandomNo()
	{
	Random r= new Random();
	int random=r.nextInt(500);
	return random;
	}
	
	public String  getSystemDate()
	{
		Date d= new Date();
		String date=d.toString();
		return date;
		
	}

	public String  getSystemDateDataAndTimeFormat()
	{
		SimpleDateFormat dateformat= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date systemdate= new Date();
		String getDateAndTime= dateformat.format(systemdate);
		return getDateAndTime.replaceAll(":", "-");
		
	}
	
}
