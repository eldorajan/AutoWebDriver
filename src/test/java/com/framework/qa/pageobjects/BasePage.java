package com.framework.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.qa.pagefactory.utils.BrowserElementLocatorFactory;
import com.framework.qa.pagefactory.utils.FieldDecorator;
import com.framework.qa.suitedata.SuiteData;
import com.framework.qa.suitedata.SuiteDataManager;

/**
 * 
 * @author eldo_rajan
 *
 */
public class BasePage {

	SuiteData suiteData;
	WebDriver driver;

	public BasePage() {
		suiteData = SuiteDataManager.getSuiteData();
		driver = suiteData.getWebdriver();

		PageFactory.initElements(new FieldDecorator(new BrowserElementLocatorFactory(driver)), this);
	}

}
