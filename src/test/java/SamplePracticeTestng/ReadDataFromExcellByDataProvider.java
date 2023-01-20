package SamplePracticeTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;

public class ReadDataFromExcellByDataProvider {
	
	//public Object[][] readMultipleSetOfData(String Sheetname) throws 

//	{
//		FileInputStream fis= new FileInputStream(IPathConstants.ExcellPath);
//		Workbook book= WorkbookFactory.create(fis);
//		Sheet sh=book.getSheet(Sheetname);
//		int lastrow= sh.getLastRowNum();
//		int lastcell= sh.getRow(0).getLastCellNum();
//		Object[][] objarr=new Object[lastrow][lastcell];
//		for(int i=0; i<=lastrow; i++)
//		{
//			
//			for(int j=0; j<lastcell;j++)
//			{
//				
//				objarr[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		return objarr;
//
//	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcellUtility eu= new ExcellUtility();
		Object[][] value = eu.readMultipleSetOfData("DataProvider");
		return value;
	}
	@Test(dataProvider="getData")
	public void readData(String src, String des)
	{
		System.out.println(src+"--------->"+des);
	}
		
}
