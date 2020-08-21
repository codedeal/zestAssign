package com.clubmahindra.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseUtil.TestBase;
import com.pages.tripAdivsorPage.TripPage;

public class TripAdvisiorTest extends TestBase
{
	
	TripPage trippage;
	@BeforeMethod
	public void setUp()
	{
		
		initialization();
		driver.get(prop.getProperty("urltrip"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		trippage = new TripPage();
		
	}
	   @Test
	   public void hotelReivewTest()
	   {
		   trippage.searchForHotel("Club Mahindra");
		   trippage.selectelementfromList();
		   trippage.NavigateToWriteReview();
		   trippage.giveReview();
		   trippage.scrollToSubmitYourReview();
		   trippage.check_checkbox();
		   assertEquals(true, true);
	   }
	   
		@AfterMethod
		public void tearDown(){
			System.out.println("in after");
			driver.close();
			driver.quit();
		}
}
