package com.crm.SocietyManagementSystem.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to Read data from properties file
	 * @author Sanjoy
	 * @param key
	 * @throws Throwable 
	 */
	public String getDataFromProperty(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.PropertyFilePath);
		Properties pobj= new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
	}

}
