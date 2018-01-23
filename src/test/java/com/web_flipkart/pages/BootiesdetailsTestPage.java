package com.web_flipkart.pages;

import java.util.HashMap;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.web_flipkart.beans.BeanProductInformation;
import com.web_flipkart.utilities.CommonUtilities;

public class BootiesdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Booties.detail.productname")
	private QAFWebElement bootiesDetailProductname;
	@FindBy(locator = "Booties.detail.productprice")
	private QAFWebElement bootiesDetailProductprice;
	@FindBy(locator = "Booties.details.txtfld.pincode")
	private QAFWebElement bootiesDetailsTxtfldPincode;
	@FindBy(locator = "Booties.detail.addToCart")
	private QAFWebElement bootiesDetailAddToCart;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getBootiesDetailProductname() {
		return bootiesDetailProductname;
	}

	public QAFWebElement getBootiesDetailProductprice() {
		return bootiesDetailProductprice;
	}

	public QAFWebElement getBootiesDetailsTxtfldPincode() {
		return bootiesDetailsTxtfldPincode;
	}

	public QAFWebElement getBootiesDetailAddToCart() {
		return bootiesDetailAddToCart;
	}
	public void enterPincode(String pincode)
	{
		getBootiesDetailsTxtfldPincode().sendKeys(pincode);
	}
	public void verifyBootieProductsDetails()
	{
		if(driver.getWindowHandles().size()>1)
		{
			System.out.println(driver.getWindowHandles().size());

			CommonUtilities.switchToWindow(driver);
		}
		getBootiesDetailProductname().waitForVisible();
		 HashMap<String, BeanProductInformation > productInfos =CommonUtilities .getProductItem();
		for(String key: productInfos.keySet())
		{
			BeanProductInformation details =productInfos.get(key);
			Validator.verifyThat(getBootiesDetailProductname().getText(), Matchers.containsString(details.getProductName()));
			Validator.verifyThat(getBootiesDetailProductprice().getText(), Matchers.containsString(details.getProductPrice()));
		}
		
	}
	public void selectAddToCart() 
	{
		getBootiesDetailAddToCart().click();
		QAFTestBase.pause(5000);
	}

}
