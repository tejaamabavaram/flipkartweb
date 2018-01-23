package com.web_flipkart.pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomeTestPage1
		extends
			WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Homepage.btn.closepopupbutton")
	private QAFWebElement homepageBtnClosepopupbutton;
	@FindBy(locator = "Homepage.link.category")
	private QAFWebElement homepageLinkCategory;
	@FindBy(locator = "Homepage.link.subcategory")
	private QAFWebElement homepageLinkSubcategory;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getHomepageBtnClosepopupbutton() {
		return homepageBtnClosepopupbutton;
	}

	public QAFWebElement getHomepageLinkCategory() {
		return homepageLinkCategory;
	}

	public QAFWebElement getHomepageLinkSubcategory() {
		return homepageLinkSubcategory;
	}
	public void selectcatogery(String catogery,String subcatogery)
	{
		QAFExtendedWebElement catogerymain = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("Homepage.link.category"),catogery));
		Actions actions= new Actions(driver);
		actions.moveToElement(catogerymain).perform();
		QAFExtendedWebElement catogerysub = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("Homepage.link.subcategory"),subcatogery));
		catogerysub.waitForVisible();
		catogerysub.click();
	}
	public void launchApplication()
	{
		driver.get("/");
	}
	public void closePopupButton()
	{
		if(homepageBtnClosepopupbutton.isPresent()&&homepageBtnClosepopupbutton.isDisplayed())
		{
			homepageBtnClosepopupbutton.click();
		}
		
		/*try {
		FluentWait<WebDriver> wait5 = new FluentWait<WebDriver>(driver);
		wait5.withTimeout(30, TimeUnit.SECONDS);
		wait5.pollingEvery(5, TimeUnit.SECONDS);
		homepageBtnClosepopupbutton.click();
		wait5.ignoring(NoSuchElementException.class);
		
		
		}
		catch (Exception e) {
		
		}*/
	}
	public void verifyFlipHomePage()
	{
		com.qmetry.qaf.automation.util.Validator.verifyThat("FlipKartHomePage verification",driver.getTitle(), Matchers.containsString("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"));
	}

}
