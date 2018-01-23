package com.web_flipkart.steps;

import org.testng.annotations.Test;

import com.web_flipkart.pages.BootiesdetailsTestPage;
import com.web_flipkart.pages.BootiesresultsTestPage;
import com.web_flipkart.pages.CartTestPage;
import com.web_flipkart.pages.HomeTestPage1;

public class FlipkartItemOrderSteps {
	@Test
	public void testItemOrderSteps()
	{
		HomeTestPage1 homepage = new HomeTestPage1();
		homepage.launchApplication();
		homepage.closePopupButton();
		homepage.verifyFlipHomePage();
		homepage.selectcatogery("Baby & Kids", "Booties");
		
		BootiesresultsTestPage bootiesresultpage = new BootiesresultsTestPage();
		bootiesresultpage.verifyProduct();
		
		bootiesresultpage.setPriceMinRange("200");
		bootiesresultpage.setPriceMaxRange("400");
		bootiesresultpage.selectBootiesFilter("Price -- High to Low");
		bootiesresultpage.selectProductName(2);
		
		
		BootiesdetailsTestPage bootiesdetailspage = new BootiesdetailsTestPage();
		bootiesdetailspage.verifyBootieProductsDetails();
		bootiesdetailspage.enterPincode("410509");
		bootiesdetailspage .selectAddToCart();
		
		CartTestPage cartpage = new CartTestPage();
		cartpage.selectDeliveryDetails();
		
		
	}

}
