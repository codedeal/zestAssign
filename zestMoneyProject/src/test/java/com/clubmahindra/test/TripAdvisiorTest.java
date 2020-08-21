package com.clubmahindra.test;
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
		getUrl(prop.getProperty("urltrip"));
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
		 
	   }
	   
		@AfterMethod
		public void tearDown(){
			System.out.println("in after");
			driver.close();
			driver.quit();
		}
}
