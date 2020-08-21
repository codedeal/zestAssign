package com.pages.tripAdivsorPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseUtil.TestBase;

public class TripPage extends TestBase
{
	@FindBy(xpath="//div[contains(text(),'Where to?')]")
	WebElement where_to;
	@FindBy(xpath="(//button[@type='submit' and @title='Search'])[1]")
	WebElement search_button;
	
	@FindBy(xpath = "//input[@type='search' and @placeholder='Where to?']")
	WebElement searchBarTop;
	
	@FindBy(xpath="(//div[contains(text(),'Club Mahindra')])[1]")
	WebElement club;
	
	@FindBy(xpath="//*[@id='component_4']/div/div/div[1]/div[2]/a/span[2]")
	WebElement review_section;
	
	@FindBy(xpath="//a[text()='Write a review']")
	WebElement write_a_review;
	
	@FindBy(xpath="//input[@name='ReviewTitle']")
	WebElement title_of_review;
	
	@FindBy(xpath="//textarea[@name='ReviewText']")
	WebElement your_review;
	
	@FindBy(xpath="//div[text()='Submit your review']")
	WebElement submit_review;
	
	@FindBy(xpath="//input[@type='checkbox' and @name ='noFraud']")
	WebElement submit_checkbox;
	
	@FindBy(xpath="//*[@id='bubble_rating']")
	WebElement rate_app;
	
	public TripPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchForHotel(String hotel)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);

		actions.moveToElement(searchBarTop).click().perform();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("arguments[0].scrollIntoView()", searchBarTop); 
	   if(searchBarTop.isDisplayed())
		searchBarTop.sendKeys(hotel);
	}
	
	public void setRating(String stars)
	{
	   

	    // click specified star
	 rate_app.click();
	}

	public void selectelementfromList()
	{
		club.click();
	}
	
	public void NavigateToWriteReview()
	{
		  Actions actions = new Actions(driver);

	    actions.moveToElement(review_section).click().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  actions.moveToElement(write_a_review).click().perform();
		
		
	}
	
	public void giveReview()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  for (String handle1 : driver.getWindowHandles()) {
			  
	          System.out.println(handle1);
	 
	          driver.switchTo().window(handle1);
	 
	          }
		  Actions actions = new Actions(driver);

			actions.moveToElement(title_of_review).click().perform();
			setRating("2");
	 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOf(title_of_review));
		title_of_review.sendKeys("Great Stories found");
		your_review.sendKeys("We celebrate our anniversary and birthday at barbeque bay restaurant. We meet the chef ravi who made our day more special. And we enjoy the We celebrate our anniversary and birthday at barbeque bay restaurant. We meet the chef ravi who made our day more special. And we enjoy the"
				+ "We celebrate our anniversary and birthday at barbeque bay restaurant. We meet the chef ravi who made our day more special. And we enjoy the"
				+ "We celebrate our anniversary and birthday at barbeque bay restaurant. We meet the chef ravi who made our day more special. And we enjoy the");
	}
	
	
	public void scrollToSubmitYourReview()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit_review);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void check_checkbox()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		submit_checkbox.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
