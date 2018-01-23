package com.web_flipkart.utilities;

import java.util.HashMap;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.web_flipkart.beans.BeanProductInformation;

public class CommonUtilities {
	
public static void setProductItem(HashMap<String, BeanProductInformation > productslist) {
	
	ConfigurationManager.getBundle().addProperty("product.information", productslist);
	
}
@SuppressWarnings("unchecked")
public static HashMap<String, BeanProductInformation > getProductItem()
{
	HashMap<String, BeanProductInformation > productslist;
	
	if(ConfigurationManager.getBundle().containsKey("product.information"))
	{
		productslist= (HashMap<String, BeanProductInformation >)ConfigurationManager.getBundle().getProperty("product.information");
	}
	else
	{
		productslist= new HashMap<String, BeanProductInformation >();
	ConfigurationManager.getBundle().addProperty("product.information",productslist );
	}
	
	return productslist;
}

public static void switchToWindow(QAFWebDriver driver)
{
	for(String handle: driver.getWindowHandles())
	{
		driver.switchTo().window(handle);
	}
}


}
