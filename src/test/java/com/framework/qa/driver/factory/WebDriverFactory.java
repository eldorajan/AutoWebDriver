package com.framework.qa.driver.factory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.framework.qa.common.SuiteData;
import com.framework.qa.driver.browser.WebBrowser;
import com.framework.qa.driver.capabilities.DriverCapabilities;
import com.framework.qa.listeners.WebEventListener;
import com.framework.qa.logger.Logger;
import com.framework.qa.utils.FileHandlingUtils;
import com.opera.core.systems.OperaDriver;

/**
 * 
 * @author eldo_rajan
 *
 */
public class WebDriverFactory {

	public WebDriver setUpLocalDriver(SuiteData suiteData) {
		Logger.info("Starting " + suiteData.getBrowserName() + " browser in local configuration");
		WebDriver driver = null;

		WebBrowser browser = WebBrowser.getBrowserType(suiteData.getBrowserName());

		switch (browser) {
		case Firefox: {
			System.setProperty("webdriver.gecko.driver", suiteData.getFirefoxPath());
			if (suiteData.getOSName().contains("mac")) {
				FileHandlingUtils.makeDriverExectuable(suiteData.getFirefoxPath());
			}
			driver = new FirefoxDriver(new DriverCapabilities().getFireFoxOptions(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case Edge: {
			System.setProperty("webdriver.edge.driver", suiteData.getEdgePath());
			FileHandlingUtils.makeDriverExectuable(suiteData.getEdgePath());
			driver = new EdgeDriver(new DriverCapabilities().getEdgeOptions(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case InternetExplorer: {
			System.setProperty("webdriver.ie.driver", suiteData.getIEPath());
			FileHandlingUtils.makeDriverExectuable(suiteData.getIEPath());
			driver = new InternetExplorerDriver(new DriverCapabilities().getIEOptions(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case Chrome: {
			System.setProperty("webdriver.chrome.driver", suiteData.getChromePath());
			FileHandlingUtils.makeDriverExectuable(suiteData.getChromePath());
			driver = new ChromeDriver(new DriverCapabilities().getChromeOptions(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case Opera: {
			System.setProperty("os.name", "windows");
			driver = new OperaDriver(new DriverCapabilities().getDesiredCapabilities(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case Safari:
			driver = new SafariDriver(new DriverCapabilities().getSafariOptions(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case PhantomJS:
			driver = new PhantomJSDriver(new DriverCapabilities().getDesiredCapabilities(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		case HtmlUnit:
			driver = new HtmlUnitDriver(new DriverCapabilities().getDesiredCapabilities(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		default:
			try {
				Logger.error("Fail to start browser, please check browser parameters.");
				throw new Exception("Fail to start browser, please check browser parameters.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (Boolean.parseBoolean(suiteData.getEventFiringWebDriver())) {
			driver = new EventFiringWebDriver(driver);
			((EventFiringWebDriver) driver).register(new WebEventListener());
		}

		Logger.info("Started " + browser + " browser in local configuration");
		return driver;
	}

	public RemoteWebDriver setUpRemoteDriver(SuiteData suiteData) {
		Logger.info("Starting " + suiteData.getBrowserName() + " browser in remote configuration");
		RemoteWebDriver driver = null;

		WebBrowser browser = WebBrowser.getBrowserType(suiteData.getBrowserName());

		String huburl = "http://localhost:4444/wd/hub";

		try {
			driver = new RemoteWebDriver(new URL(huburl), new DriverCapabilities().getDesiredCapabilities(suiteData));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			Logger.error("Fail to start browser in remote configuration");
			e.printStackTrace();
		}

		Logger.info("Started " + browser + " browser in remote configuration");
		return driver;
	}

}
