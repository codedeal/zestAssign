package com.pages.amazonandFlipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseUtil.TestBase;

//*[@id="nav-search"]/form/div[2]/div/input
//*[@id="priceblock_ourprice"]
//*[@id="priceblock_ourprice"]
public class ProductPage extends TestBase 
{ 
	@FindBy(xpath="//*[@id='twotabsearchtextbox']")
	WebElement serachBoxAmazon;
	@FindBy(xpath="//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchButtonAmazon;
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone 11 (64GB) - Yellow')]")
	WebElement searchProductIPhone;
	@FindBy(xpath="//*[@id='priceblock_ourprice']")
	//@FindBy(xpath="//*[@id='search']/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div/a/span[1]/span[2]/span[2]")
	WebElement productPriceAmazon;
	
	public ProductPage(){
		PageFactory.initElements(driver, this);
	}
	public void searchForProduct(String productName)
	{
		serachBoxAmazon.sendKeys(productName);
		
		serachBoxAmazon.sendKeys(Keys.ENTER);
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
		
		String priceDetail = productPriceAmazon.getText();
		System.out.println(priceDetail);
        String[] arrOfStr = priceDetail.split(" "); 
        System.out.println("price we got"+arrOfStr[1]);
        String price=arrOfStr[1];
        return Double.parseDouble(price.replace(",", ""));
		
	}
	
	
    
}
