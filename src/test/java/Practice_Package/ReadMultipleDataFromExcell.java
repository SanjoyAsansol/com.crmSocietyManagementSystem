package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcell {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Accounts");
		for(int i=0; i<=sh.getLastRowNum(); i++)
		{
			String data=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data);
		}

}
}
