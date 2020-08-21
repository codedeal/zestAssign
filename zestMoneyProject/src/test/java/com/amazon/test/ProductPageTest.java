package com.amazon.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseUtil.TestBase;
import com.pages.amazonandFlipkart.FlipkartProductPage;
import com.pages.amazonandFlipkart.ProductPage;

public class ProductPageTest  extends TestBase{
	
	ProductPage productPage;
	FlipkartProductPage flipkartProductPage;
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.get(prop.getProperty("urlamazon"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void productComparisionTest()
	{
		productPage=new ProductPage();	
		productPage.searchForProduct("Apple iPhone XR (128GB) - Yellow");
		double amazonMobilePrice=productPage.getPrice();
		driver.get(prop.getProperty("urlflipkart"));
		flipkartProductPage = new FlipkartProductPage();
		flipkartProductPage.searchForProduct("Apple iPhone XR (128GB) - Yellow");
        double flipkartMobilePrice=flipkartProductPage.getPrice();	
        if(amazonMobilePrice==flipkartMobilePrice)
        {
        	System.out.println("Both sites have Equal Price");
        }
        else
        {
        	if(amazonMobilePrice<flipkartMobilePrice)
        		System.out.println("Amazon sites have low Price");
        	else
        		System.out.println("Flipkart sites have low Price");
        	
        }
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("in after");
		driver.close();
		driver.quit();
	}

}
