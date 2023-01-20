package com.SocietyManagementSystem.testscript.Expenses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.SocietyManagementSystem.genericLib.BaseClass;
import com.crm.SocietyManagementSystem.genericLib.ExcellUtility;
import com.crm.SocietyManagementSystem.genericLib.FileUtility;
import com.crm.SocietyManagementSystem.genericLib.WebDriverUtility;
import com.sms.ObjectRepo.ExpensesPage;
import com.sms.ObjectRepo.HomePage;
import com.sms.ObjectRepo.LoginPage;
import com.sms.ObjectRepo.OptionsPage;
import com.sms.ObjectRepo.UpdateExpesesPage;

public class Tc_Expenses_15 extends BaseClass {


	@Test
	public void Expenses15() throws Throwable {
	
	String updateprice=eu.getDataFromExcell("Expences", 8, 1)+ju.getRandomNo();
	String expenseName = eu.getDataFromExcell("Expences", 7, 1);
	HomePage hp= new HomePage(driver);
	hp.clickExpenses();
	ExpensesPage ep= new ExpensesPage(driver);
	ep.searchTBpassValue(expenseName);
	ep.clickUpdateExpense(driver, expenseName);
	UpdateExpesesPage uep= new UpdateExpesesPage(driver);
	uep.updateExpenses(eu, wu, 3);
	ExpensesPage exp= new ExpensesPage(driver);
	//String actualprice=exp.getPrice(driver, eu);
	String actualprice=exp.getPrice(driver, expenseName);
	if(updateprice.contains(actualprice))
	{
		System.out.println("TC is Pass");
	}
	else
	{
	System.out.println("TC is fail");
	}
	
	
	
	
	
	
//	//Click on Options and logout
//	hp.clickOptions();
//	OptionsPage op= new OptionsPage(driver);
//	op.clickLogout();
//	driver.close();
	}
}


////add expense
//driver.findElement(By.id("add_expenses")).click();
////send all data from excell
//HashMap<String,String> map= new HashMap<String, String>();
//for(int i=7;i<=sh.getLastRowNum();i++)
//{
//	String key= sh.getRow(i).getCell(0).getStringCellValue();
//	String value= sh.getRow(i).getCell(1).getStringCellValue();
//	map.put(key, value);
//	
//}
//for(Entry<String, String> set:map.entrySet())
//{
//	driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//}
//WebElement semdd=driver.findElement(By.name("sem"));
//Select s= new Select(semdd);
//s.selectByVisibleText("1st");
////select date
//WebElement date=driver.findElement(By.name("deadline"));
//String deadline="16-12-2022";		
//date.clear();
//date.sendKeys(deadline);
//driver.findElement(By.name("save_expenses")).click();
