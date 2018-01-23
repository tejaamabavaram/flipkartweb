package com.web_flipkart.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class BootiesProductComponents extends QAFWebComponent{

	@FindBy(locator = "Booties.link.productname")
	private QAFWebElement bootiesLinkProductname;
	@FindBy(locator = "Booties.link.productprice")
	private QAFWebElement bootiesLinkProductprice;
	public BootiesProductComponents(String locator) {
		super(locator);
		
	}
	
	public QAFWebElement getBootiesLinkProductname() {
		return bootiesLinkProductname;
	}

	public QAFWebElement getBootiesLinkProductprice() {
		return bootiesLinkProductprice;
}
}
