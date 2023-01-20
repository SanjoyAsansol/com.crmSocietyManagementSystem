package com.crm.SocietyManagementSystem.genericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait for the page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait until element to be visible
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will select data from dropdown using index
	 * @param ele
	 * @param index
	 */
	public void getSelect(WebElement ele, int index)
	{
		Select s= new Select(ele);
		s.selectByIndex(index);
	}
	/**
	 * This method will select data from dropdown using visibleText
	 * @param ele
	 * @param text
	 */
	public void getSelect(WebElement ele, String visibleText)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * This method will select data from dropdown using value
	 * @param ele
	 * @param value
	 */
	public void getSelectByValue(WebElement ele,String value)
	{
		Select s= new Select(ele);
		s.selectByValue(value);
	}
	public void acceptAlert(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
		alt.accept();
	}
	public String getAlertMsg(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
		
	}
	public void dismissAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
		
	}
	public void sendKeysAlert(WebDriver driver, String text)
	{
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(text);
		
	}
	/**
	 * This method will perform mouse over action
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver,WebElement ele)
	{
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method will perform drag and drop
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(src, dst).perform();;
	}
	/**
	 * This metod will perform double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will perform right click on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
/**
 * this method will perform click on webpage
 * @param driver
 * @param ele
 */
	public void moveAndClick(WebDriver driver, WebElement ele)
	{
		Actions act= new Actions(driver);
		act.click(ele).perform();
		
	}
	/**
	 *  This method will perform right click on element
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver, WebElement ele)
	{
		Actions act= new Actions(driver);
		act.contextClick(ele).perform();
		
	}
	/**
	 * This method will Press Enter Key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method will Press Enter Key
	 * @throws AWTException
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws AWTException
	 */
	public void enterRelese(WebDriver driver) throws AWTException
	{
		Robot r= new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch the frame based on name or id attribute value
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * This method will switch between windows
	 * @param driver
	 * @param partialTitle
	 */
	public void switchWindow(WebDriver driver, String partialTitle)
	{
		///step1: use getWindowHandes to capture all window id's
		Set<String> windows=driver.getWindowHandles();
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId=it.next();
			//step5: switch to current window and capture title 
			String title=driver.switchTo().window(winId).getTitle();
			//step6: check whether current window is expected
			if(title.contains(partialTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500);");
		
	}
	/**
	 * This method will scroll until specified element
	 * @param driver
	 * @param expAddress
	 */
	public void scrollAction(WebDriver driver, WebElement expAddress)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", expAddress);
		
	}
	
	
	

}












