package com.web_flipkart.pages;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.web_flipkart.beans.BeanProductInformation;
import com.web_flipkart.components.BootiesProductComponents;
import com.web_flipkart.utilities.CommonUtilities;

public class BootiesresultsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Booties.comp.prductinfo")
	private List<BootiesProductComponents> bootiesCompPrductinfo;
	@FindBy(locator = "Booties.link.itemsfilter")
	private QAFWebElement bootiesLinkItemsfilter;
	@FindBy(locator = "Booties.dropdown.minprice")
	private QAFWebElement bootiesDropdownMinprice;
	@FindBy(locator = "Booties.dropdown.maxprice")
	private QAFWebElement bootiesDropdownMaxprice;
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<BootiesProductComponents> getBootiesCompPrductinfo() {
		return bootiesCompPrductinfo;
	}

	public QAFWebElement getBootiesLinkItemsfilter() {
		return bootiesLinkItemsfilter;
	}

	public QAFWebElement getBootiesDropdownMinprice() {
		return bootiesDropdownMinprice;
	}

	public QAFWebElement getBootiesDropdownMaxprice() {
		return bootiesDropdownMaxprice;
	}
	public void setPriceMinRange(String minRange)
	{
		Select select =new Select(bootiesDropdownMinprice);
		select.selectByValue(minRange);
		//bootiesDropdownMinprice.sendKeys(minRange);
	}
	
	public void setPriceMaxRange(String maxRange)
	{
		Select select2 = new Select(bootiesDropdownMaxprice);
		select2.selectByValue(maxRange);
		//bootiesDropdownMaxprice.sendKeys(maxRange);
		
	}
	public void selectBootiesFilter(String itemsfilter)
	{
		bootiesLinkItemsfilter.waitForVisible();
		bootiesLinkItemsfilter.click();
		QAFTestBase.pause(2000);
	}
	
	public void verifyProduct()
	{
		getBootiesCompPrductinfo().get(0).getBootiesLinkProductname().waitForVisible();
		Validator.verifyThat(getBootiesCompPrductinfo().size(), Matchers.greaterThan(0));
		
		for(BootiesProductComponents b: getBootiesCompPrductinfo())
		{
			System.out.println("ProductName ="+b.getBootiesLinkProductname().getText());
			System.out.println("ProductPrice ="+b.getBootiesLinkProductprice().getText());
		}
		
	}
	public void selectProductName(int index)
	{
		BeanProductInformation infobean1 = new BeanProductInformation();
		infobean1.setProductName(getBootiesCompPrductinfo().get(index).getBootiesLinkProductname().getText());
		infobean1.setProductPrice(getBootiesCompPrductinfo().get(index).getBootiesLinkProductprice().getText());
		HashMap<String, BeanProductInformation> productinfo = new HashMap<String, BeanProductInformation>();
		productinfo.put(infobean1.getProductName(), infobean1);
		getBootiesCompPrductinfo().get(index).getBootiesLinkProductname().click();
		CommonUtilities .setProductItem(productinfo);
		QAFTestBase.pause(3000);
		
	}



}
