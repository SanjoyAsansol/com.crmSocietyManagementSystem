package com.crm.SocietyManagementSystem.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtility  {
	/**
	 * this method is used to read data from excel
	 * @author Sanjoy
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcell(String sheetname, int rowno,int cellno) throws Throwable
	{
	FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
	Workbook book= WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	Row row=sh.getRow(rowno);
	Cell cel=row.getCell(cellno);
	String value=cel.getStringCellValue();
	//String value=sh.getRow(rowno).getCell(cellno).getStringCellValue();
	return value;
	
	}
	/**
	 * this method is used to write data in excell sheet
	 * @author Sanjoy
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param cellvalue
	 * @throws Throwable
	 */
	public void writeDataIntoExcell(String sheetname, int rowno, int cellno, String cellvalue) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		sh.createRow(rowno).createCell(cellno).setCellValue(cellvalue);
		FileOutputStream fos= new FileOutputStream(IPathConstants.ExcellPath);
		wb.write(fos);
		
	}
	/**
	 * this methos is used to get last row count
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNum(String sheetname) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		return lastrow;
		
	}
	/**
	 * this method is used to get all the value from excell in the form of key and value
	 * @param sheetname
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> getList(String sheetname, int keyCell, int valueCell) throws Throwable
	{	
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=0; i<=lastrow;i++)
		{
			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value=sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
		
	}
	/**
	 * this method is used to get all the value from excell in the form of key and value with random no addition
	 * @param sheetname
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> getListWithRandomNo(String sheetname, int keyCell, int valueCell) throws Throwable
	{	JavaUtility ju= new JavaUtility();
		int random=ju.getRandomNo();
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=0; i<=lastrow;i++)
		{
			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value=sh.getRow(i).getCell(valueCell).getStringCellValue()+ju.getRandomNo();
			map.put(key, value);
		}
		
		return map;
		
	}
	public ArrayList<String> getArrayList(String sheetname, int celNo) throws Throwable
	{
		JavaUtility ju= new JavaUtility();
		int random=ju.getRandomNo();
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		ArrayList<String> list= new ArrayList<String>();
		for(int i= 0; i<=sh.getLastRowNum();i++)
		{
			String value=sh.getRow(i).getCell(celNo).getStringCellValue();
			list.add(value);
		}
		return list;
	}
/**
 * this method is used to get all the value from excell in the form of key and value with random no addition along with coustomized the starting position of for loop
 * @param sheetname
 * @param keyCell
 * @param valueCell
 * @param startingrow
 * @return
 * @throws Throwable
 */
	public Map<String, String> getListWithRandomNo(String sheetname, int keyCell, int valueCell, int startingrow) throws Throwable
	{	JavaUtility ju= new JavaUtility();
		int random=ju.getRandomNo();
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		HashMap<String, String> map= new HashMap<String, String>();
		for(int i=startingrow; i<=lastrow;i++)
		{
			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value=sh.getRow(i).getCell(valueCell).getStringCellValue()+ju.getRandomNo();
			map.put(key, value);
		}
		
		return map;
		
	}
	/**
	 * This method used to read multiple data by DataProvider
	 * @param Sheetname
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleSetOfData(String Sheetname) throws Throwable
	{
		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
		Workbook book= WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(Sheetname);
		int lastrow= sh.getLastRowNum()+1;
		int lastcell= sh.getRow(0).getLastCellNum();
		
		Object[][] objarr=new Object[lastrow][lastcell];
		for(int i=0; i<lastrow; i++)
		{
			
			for(int j=0; j<lastcell;j++)
			{
				
				objarr[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return objarr;
	}
}
