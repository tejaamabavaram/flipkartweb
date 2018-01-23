/**
 * 
 */
package com.web_flipkart;


import com.qmetry.qaf.automation.step.QAFTestStep;
import com.web_flipkart.pages.BootiesdetailsTestPage;
import com.web_flipkart.pages.BootiesresultsTestPage;
import com.web_flipkart.pages.CartTestPage;
import com.web_flipkart.pages.HomeTestPage1;

/**
 * @author Praveenkumar.dm
 */
public class StepsBackLog {
	HomeTestPage1 homepage = new HomeTestPage1();
	BootiesresultsTestPage bootiesresultpage = new BootiesresultsTestPage();
	BootiesdetailsTestPage bootiesdetailspage = new BootiesdetailsTestPage();

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user is on flipkart homepage")
	public void userIsOnFlipkartHomepage() {

		homepage.launchApplication();
		homepage.closePopupButton();
		homepage.verifyFlipHomePage();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects product {0} from {1} category")
	public void userSelectsProductFromCategory(String subcategorytype, String categorytype) {
		homepage.selectcatogery(categorytype, subcategorytype);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see product results")
	public void userShouldSeeProductResults() {

		bootiesresultpage.verifyProduct();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user sets {0} and {1} price")
	public void userSetsAndPrice(String minprice, String maxprice) {
		bootiesresultpage.setPriceMinRange(minprice);
		bootiesresultpage.setPriceMaxRange(maxprice);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selets price {0}")
	public void userSeletsPrice(String filter) {
		bootiesresultpage.selectBootiesFilter(filter);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see only product less than max value")
	public void userShouldSeeOnlyProductLessThanMaxValue() {

	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user select {0} product from product results")
	public void userSelectProductFromProductResults(String str0) {
		bootiesresultpage.selectProductName(Integer.parseInt(str0));
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user should see product details matching correctly")
	public void userShouldSeeProductDetailsMatchingCorrectly() {

		bootiesdetailspage.verifyBootieProductsDetails();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user check for the delivery {0}")
	public void userCheckForTheDelivery(String pinnum) {
		bootiesdetailspage.enterPincode(pinnum);
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects add to cart")
	public void userSelectsAddToCart() {
		bootiesdetailspage.selectAddToCart();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "product has been added to the cart")
	public void productHasBeenAddedToTheCart() {
		CartTestPage cartpage = new CartTestPage();
		cartpage.selectDeliveryDetails();
	}

}
