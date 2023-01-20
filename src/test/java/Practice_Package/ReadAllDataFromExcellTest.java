package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import 	org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadAllDataFromExcellTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Accounts");
		DataFormatter format= new DataFormatter();
		for(int i=0; i<=sh.getLastRowNum(); i++)
			{
				Row row=sh.getRow(i);
				for(int j=0; j<row.getLastCellNum(); j++)
				{
					String value=format.formatCellValue(row.getCell(j));
					System.out.println(value+" ");
				}
				System.out.println();
						
					
			}
		

	}

}
