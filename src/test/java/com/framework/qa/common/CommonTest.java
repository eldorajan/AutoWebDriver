package com.framework.qa.common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.framework.qa.action.search.SearchAction;
import com.framework.qa.driver.mode.WebDriverMode;
import com.framework.qa.driver.runner.WebDriverRunner;
import com.framework.qa.logger.Logger;
import com.framework.qa.suitedata.SuiteData;
import com.framework.qa.suitedata.SuiteDataManager;

/**
 * 
 * @author eldo_rajan
 *
 */
public class CommonTest extends WebDriverRunner {

	public SuiteData suiteData = new SuiteData();
	public SearchAction search;

	@BeforeTest(alwaysRun = true)
	public void intializeClassLevel(ITestContext testContext) {
		suiteData = new SuiteDataManager().setupSuiteData(testContext);
		SuiteDataManager.setSuiteData(suiteData);

		if (suiteData.getWebdriverMode().equals(WebDriverMode.Local.toString().toLowerCase())) {
			Logger.info("Browser initialization will be in class level for mode:" + suiteData.getWebdriverMode());
			suiteData.setWebdriver(startBrowser(suiteData));

			if (!browserInstanceExist(suiteData.getWebdriver())) {
				Logger.info("Browser initialization failed, reinitialization is in progress");
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
				}
				suiteData.setWebdriver(startBrowser(suiteData));
				suiteData.setSessionId(getSessionId(suiteData));
			}

			testContext.setAttribute("suiteData", suiteData);
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void intializeMethodLevel(ITestContext testContext) {

		if (suiteData.getWebdriverMode().equals(WebDriverMode.Grid.toString().toLowerCase())) {
			Logger.info("Browser initialization will be in method level for mode:" + suiteData.getWebdriverMode());
			// SuiteDataManager.setSuiteData(suiteData);

			suiteData.setWebdriver(startBrowser(suiteData));

			if (!browserInstanceExist(suiteData.getWebdriver())) {
				Logger.info("Browser initialization failed, reinitialization is in progress");
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
				}
				suiteData.setWebdriver(startBrowser(suiteData));
				suiteData.setSessionId(getSessionId(suiteData));
			}

			testContext.setAttribute("suiteData", suiteData);
		}

		search = new SearchAction();
	}

	@BeforeMethod(alwaysRun = true, dependsOnMethods = "intializeMethodLevel")
	public void intializeActionMethods() {
		search = new SearchAction();
	}

	@AfterTest(alwaysRun = true)
	public void tearDownMethodLevel(ITestContext testContext) {
		if (suiteData.getWebdriverMode().equals(WebDriverMode.Local.toString().toLowerCase())) {
			stopBrowser(suiteData);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDownClassLevel(ITestContext testContext) {
		if (suiteData.getWebdriverMode().equals(WebDriverMode.Grid.toString().toLowerCase())) {
			stopBrowser(suiteData);
		}
	}

	public boolean browserInstanceExist(WebDriver driver) {
		try {
			if (driver.getWindowHandles().isEmpty()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}
}
