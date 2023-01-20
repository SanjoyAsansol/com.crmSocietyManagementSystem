package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcellFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Accounts");
		String OrgName=sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(OrgName);
		

	}

}
