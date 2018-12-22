package com.framework.qa.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.framework.qa.logger.Logger;
import com.framework.qa.webelement.BaseElement;

public class WebEventListener extends AbstractWebDriverEventListener implements WebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		Logger.info("Before navigating to: '" + url + "'");
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		Logger.info("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(BaseElement element, WebDriver driver) {
		Logger.info("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(BaseElement element, WebDriver driver) {
		Logger.info("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(BaseElement element, WebDriver driver) {
		Logger.info("Trying to click on: " + element.toString());
	}

	public void afterClickOn(BaseElement element, WebDriver driver) {
		Logger.info("Clicked on: " + element.toString());
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		Logger.info("Navigating back to previous page");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		Logger.info("Navigated back to previous page");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		Logger.info("Navigating forward to next page");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		Logger.info("Navigated forward to next page");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		Logger.info("Before executing script: '" + script + "'");
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		Logger.info("After executing script: '" + script + "'");
	}

	public void beforeFindBy(By by, BaseElement element, WebDriver driver) {
		Logger.info("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, BaseElement element, WebDriver driver) {
		Logger.info("Found Element By : " + element.toString());
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		Logger.info("Before navigating refresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		Logger.info("After navigating refresh");
	}

	@Override
	public void onException(Throwable error, WebDriver driver) {
		Logger.info("Exception occured: " + error);
	}

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		Logger.info("Before alert accept");
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		Logger.info("After alert accept");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		Logger.info("After alert dismiss");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		Logger.info("Before alert dismiss");
	}

	public void beforeChangeValueOf(BaseElement element, WebDriver driver, CharSequence[] keysToSend) {
		Logger.info(
				"Before change value of element:" + element.toString() + " with keys to send:" + keysToSend.toString());
	}

	public void afterChangeValueOf(BaseElement element, WebDriver driver, CharSequence[] keysToSend) {
		Logger.info(
				"After change value of element:" + element.toString() + " with keys to send:" + keysToSend.toString());
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver driver) {
		Logger.info("Before switching window to " + arg0);
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver driver) {
		Logger.info("After switching window to " + arg0);
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		Logger.info("Before getting screenshot as " + arg0);
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		Logger.info("After getting screenshot as " + arg0);
	}

	public void beforeGetText(BaseElement element, WebDriver driver) {
		Logger.info("Before getting text of element:" + element.toString());
	}

	public void afterGetText(BaseElement element, WebDriver driver, String arg2) {
		Logger.info("After getting text of element:" + element.toString());
	}
}