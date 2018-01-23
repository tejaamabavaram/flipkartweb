package com.web_flipkart.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Cartpage.delivery.txt")
	private QAFWebElement cartpageDeliveryTxt;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getCartpageDeliveryTxt() {
		return cartpageDeliveryTxt;
	}
	public void selectDeliveryDetails()
	{
		System.out.println("Delivery status details:"+cartpageDeliveryTxt.getText());
	}

}
