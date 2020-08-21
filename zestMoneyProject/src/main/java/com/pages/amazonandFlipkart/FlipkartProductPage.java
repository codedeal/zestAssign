package com.pages.amazonandFlipkart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseUtil.TestBase;

public class FlipkartProductPage extends TestBase
{
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	WebElement crossButtonFlipkart;
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement serachBoxFlipkart;
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchButtonFlipkart;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement searchProductIPhone;
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div/div")
	//@FindBy(xpath="//*[@id='search']/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/a/span[1]/span[2]/span[2]")
	WebElement productPriceFlipkart;
	
	public FlipkartProductPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void searchForProduct(String productName)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 crossButtonFlipkart.click();
		serachBoxFlipkart.sendKeys(productName);
		
		serachBoxFlipkart.sendKeys(Keys.ENTER);
		//swipeToElement(searchProductIPhone);
		searchProductIPhone.click();
		System.out.println("handles"+driver.getWindowHandle());
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println("in window handle");
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		System.out.println(driver.getTitle());
	}
	
	public void swipeToElement(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,searchProductIPhone);
	}
	
	
	public double getPrice()
	{
		
		String priceDetail = productPriceFlipkart.getText();
		System.out.println(priceDetail);
        String[] arrOfStr = priceDetail.split("₹"); 
        System.out.println("price we got"+arrOfStr[1]);
        String price=arrOfStr[1];
        return Double.parseDouble(price.replace(",", ""));
		
	}
}
