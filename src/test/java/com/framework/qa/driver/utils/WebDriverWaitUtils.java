package com.framework.qa.driver.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.qa.logger.Logger;
import com.framework.qa.webelement.BaseElement;

/**
 * 
 * @author eldo_rajan
 *
 */
public class WebDriverWaitUtils {

	public WebDriverUtils wdUtils;

	public WebDriverWaitUtils() {
		wdUtils = new WebDriverUtils();
	}

	public WebDriverWaitUtils(WebDriverUtils wdUtils) {
		this.wdUtils = wdUtils;
	}

	public void delay(int seconds) {
		try {
			Logger.info("Waiting for " + seconds + " seconds");
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public BaseElement waitElementToBeClickable(BaseElement element, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return new BaseElement(wait.until(ExpectedConditions.elementToBeClickable(element)));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	public BaseElement waitElementToBeVisible(BaseElement element, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return new BaseElement(wait.until(ExpectedConditions.visibilityOf(element)));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	public boolean waitElementToBeSelected(BaseElement element, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitPageIsActive() {
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, 5000);
		try {
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					if (((JavascriptExecutor) d).executeScript("return $.active").toString().equals("0"))
						return true;
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean waitPageIsNotActive() {
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, 5 / 100, 100);

		try {
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					if (((JavascriptExecutor) d).executeScript("return $.active").toString().equals("1"))
						return true;
					return false;
				}
			});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void waitForAlertToBePresent(Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
		}
	}

	public boolean waitElementToBeWithAttributeValueContains(BaseElement element, String attribute, String value,
			Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.attributeContains(element, attribute, value));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitElementToBeWithAttributeValueEquals(BaseElement element, String attribute, String value,
			Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitElementToBeWithNotEmptyAttribute(BaseElement element, String attribute,
			Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitElementToBeWithSelectionState(BaseElement element, boolean selected, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public WebDriver waitForIFrameToBeAvailableAndSwitchToIt(int frameLocator, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	public WebDriver waitForIFrameToBeAvailableAndSwitchToIt(BaseElement frameLocator, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	public boolean waitForNumberOfWindowsToBe(int expectedNumberOfWindows, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForElementToBeStale(BaseElement element, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.stalenessOf(element));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForTextToBePresentInElement(BaseElement element, String text, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForTextToBePresentInElementAttributeValue(BaseElement element, String text,
			Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForPageTitleContains(String title, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForPageTitleIs(String title, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForPageUrlContains(String url, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.urlContains(url));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForPageUrlMatches(String url, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.urlMatches(url));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public boolean waitForPageUrlToBe(String url, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}
		WebDriverWait wait = new WebDriverWait(wdUtils.webdriver, waitTimeInSeconds);
		try {
			return wait.until(ExpectedConditions.urlToBe(url));
		} catch (Exception e) {
			Logger.error(e.getLocalizedMessage());
			return false;
		}
	}

	public void waitElementAndType(BaseElement element, String text, Integer waitTimeInSeconds) {
		if (waitTimeInSeconds == null) {
			waitTimeInSeconds = 10;
		}

		waitElementToBeVisible(element, waitTimeInSeconds);
		waitElementToBeClickable(element, waitTimeInSeconds);
		element.clearAndType(text);

	}
}