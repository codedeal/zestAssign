package com.baseUtil;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gestures  extends TestBase
{
	
	Actions action ;
	WebDriver driver;
	
	public Gestures(WebDriver driver)
	{
		this.driver=driver;
		action = new Actions(driver);
		
	}
	public void waitfortime(int time)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitfortime(WebElement element,int time)
	{
		 WebDriverWait wait = new WebDriverWait(driver, time);
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	
    public void moveToElementClick(WebElement element)
    {
		  Actions actions = new Actions(driver);
          actions.moveToElement(element).click().perform();
    }
    public void switchToWindowHandle()
    {

		  for (String handle1 : driver.getWindowHandles()) {
			  
	          System.out.println(handle1);
	 
	          driver.switchTo().window(handle1);
	 
	          }
    }
}
