package com.pages.facbookPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseUtil.TestBase;

public class LoginPage extends TestBase
{
	@FindBy(id="email")
	WebElement username;
	@FindBy(id="pass")
	WebElement password;
	@FindBy(xpath="//*[@id='u_0_b' or @name='login']")
	WebElement signIn;
	
	
	@FindBy(xpath="//textarea[contains(@title,'Write something')]")
	WebElement postArea;
	@FindBy(xpath="//*[@id='u_0_c']/a")
	WebElement homeIcon;
	
	@FindBy(xpath="//span[text()='Post']")
	WebElement postButton;
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void sigIn(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
	}
	
	public void postMessage(String message)
	{
		homeIcon.click();
		postArea.sendKeys(message);
		postArea.sendKeys(Keys.ENTER);
		postButton.click();
	}
}
