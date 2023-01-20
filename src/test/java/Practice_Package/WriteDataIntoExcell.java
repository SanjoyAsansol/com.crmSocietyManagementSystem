package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcell {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Accounts");
		sh.createRow(2).createCell(0).setCellValue("Apple");
		FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		System.out.println("Data Written To Excell File Successfully");
	

		
	}

}
