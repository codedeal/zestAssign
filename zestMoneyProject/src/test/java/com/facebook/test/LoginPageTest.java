package com.facebook.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseUtil.TestBase;
import com.pages.facbookPages.LoginPage;

public class LoginPageTest extends TestBase
{   
	LoginPage loginPage;
	@BeforeMethod
	public void setUp(){
		initialization();
		driver.get(prop.getProperty("urlfacebook"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPage= new LoginPage();
	
	}
	
	@Test
	public void loginTest() throws InterruptedException
	{
		  loginPage.sigIn(prop.getProperty("username"), prop.getProperty("password"));
		  loginPage.postMessage("Hello");
     }
	
	@AfterMethod
	public void tearDown(){
		System.out.println("in after");
		driver.close();
		driver.quit();
	}
}