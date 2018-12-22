package com.framework.qa.webelement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.framework.qa.logger.Logger;

/**
 * 
 * @author eldo_rajan
 *
 */
public class BaseElement implements WebElement {
	protected int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 5;
	protected int DEFAULT_EXPLICIT_WAIT_TIME_OUT = 15;
	protected int DEFAULT_PAGE_LOAD_TIMEOUT = 90;

	protected WebElement element;

	public BaseElement(WebElement element) {
		this.element = element;
	}

	/**
	 * delay
	 * 
	 * @param seconds
	 */
	public void delay(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * get element
	 * 
	 * @return
	 */
	public WebElement getElement() {
		return element;
	}

	/**
	 * set element
	 * 
	 * @param element
	 */
	public void setElement(WebElement element) {
		this.element = element;
	}

	/**
	 * clear
	 */

	public void clear() {
		try {
			element.clear();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * clear and wait for seconds
	 * 
	 * @param waitTimeInSeconds
	 */
	public void clearAndWait(int waitTimeInSeconds) {
		try {
			element.clear();
			delay(waitTimeInSeconds);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * click
	 */
	public void click() {
		try {
			element.click();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * click and wait for seconds
	 * 
	 * @param waitTimeInSeconds
	 */
	public void clickAndWait(int waitTimeInSeconds) {
		try {
			element.click();
			delay(waitTimeInSeconds);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * get attribute
	 */
	public String getAttribute(String attribute) {
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get css value
	 */

	public String getCssValue(String cssValue) {
		try {
			return element.getCssValue(cssValue);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get location
	 */

	public Point getLocation() {
		try {
			return element.getLocation();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get size
	 */

	public Dimension getSize() {
		try {
			return element.getSize();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get tag name
	 */

	public String getTagName() {
		try {
			return element.getTagName();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get text
	 */

	public String getText() {
		try {
			return element.getText();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get text from textbox
	 */
	public String getTextFromTextBox() {
		try {
			return element.getAttribute("value");
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * is displayed
	 */

	public boolean isDisplayed() {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * is enabled
	 */

	public boolean isEnabled() {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * is selected
	 */

	public boolean isSelected() {
		try {
			return element.isSelected();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * type
	 * 
	 * @param text
	 */
	public void type(String text) {
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * type
	 * 
	 * @param text
	 */
	public void clearAndType(String text) {
		try {
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * send keys
	 * 
	 * @param keysToSend
	 */

	public void sendKeys(CharSequence... keysToSend) {
		try {
			element.sendKeys(keysToSend);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * submit
	 */

	public void submit() {
		try {
			element.submit();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * is element visible
	 * 
	 * @return
	 */
	public boolean isElementVisible() {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * select dropdown
	 * 
	 * @param valToSelect
	 */
	public void selectDropDown(String valueToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(valueToSelect)) {
					Logger.info(String.format("Value is: %s", option.getText()));
					option.click();
					break;
				}
			}
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}

	}

	/**
	 * select value from dropdown
	 * 
	 * @param valToSelect
	 */
	public void selectValueFromDropDown(String valueToSelect) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(valueToSelect)) {
					Logger.info(String.format("Value is: %s", option.getText()));
					select.selectByValue(valueToSelect);
					break;
				}
			}
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}

	}

	/**
	 * select value visible
	 * 
	 * @param valToSelect
	 */
	public void selectValueVisible(String valueToSelect) {
		try {
			new Select(element).selectByVisibleText(valueToSelect);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * get value from dropdown
	 * 
	 * @return
	 */
	public String[] getValueFromDropDown() {
		String[] value;
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			value = new String[options.size()];
			for (int i = 0; i < options.size(); i++) {
				value[i] = options.get(i).getText();
			}

			return value;
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}

	}

	/**
	 * get selected item
	 * 
	 * @return
	 */
	public String selectedItem() {
		try {
			Select select = new Select(element);
			WebElement element = select.getFirstSelectedOption();
			return element.getText();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * check
	 */
	public void check() {
		try {
			element.click();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * uncheck
	 */
	public void uncheck() {
		try {
			if (element.isSelected()) {
				element.click();
			}
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * set check or uncheck based on boolean
	 * 
	 * @param value
	 */
	public void setCheck(boolean value) {
		if (value) {
			check();
		} else {
			uncheck();
		}
	}

	/**
	 * is checked
	 * 
	 * @return
	 */
	public boolean isChecked() {
		try {
			return element.isSelected();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * select
	 */
	public void select() {
		try {
			element.click();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * deselect
	 */
	public void deselect() {
		try {
			if (element.isSelected()) {
				element.click();
			}
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * set select or deselect based on boolean
	 * 
	 * @param value
	 */
	public void setSelect(boolean value) {
		if (value) {
			select();
		} else {
			deselect();
		}
	}

	/**
	 * select value
	 * 
	 * @param sItem
	 */
	public void selectValue(String sItem) {
		selectValueFromDropDown(sItem);
	}

	/**
	 * get item list
	 * 
	 * @return
	 */
	public String[] getItemList() {
		return getValueFromDropDown();
	}

	/**
	 * select item
	 * 
	 * @param sItem
	 */
	public void selectItem(String sItem) {
		selectDropDown(sItem);
	}

	/**
	 * 
	 * @author eldo_rajan
	 *
	 */

	/**
	 * get screenshot as
	 */

	public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
		try {
			return element.getScreenshotAs(outputType);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * find elements
	 */

	public List<WebElement> findElements(By by) {
		try {
			return element.findElements(by);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * find element
	 */

	public WebElement findElement(By by) {
		try {
			return element.findElement(by);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * getRect
	 */

	public Rectangle getRect() {
		try {
			return element.getRect();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get inner html
	 */
	public String getInnerHtml() {
		try {
			return element.getAttribute("innerHTML").trim();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get source
	 * 
	 * @return
	 */
	public String getSource() {
		try {
			return element.getAttribute("src").trim();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get alt
	 * 
	 * @return
	 */
	public String getAlt() {
		try {
			return element.getAttribute("alt").trim();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * get href
	 * 
	 * @return
	 */
	public String getHref() {
		try {
			return element.getAttribute("href").trim();
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * set file to upload
	 * 
	 * @param filePath
	 */
	public void setFileToUpload(final String filePath) {
		WebElement fileInputElement = getNotProxiedInputElement();
		// Set local file detector in case of remote driver usage
		if (isOnRemoteWebDriver(fileInputElement)) {
			setLocalFileDetector((RemoteWebElement) fileInputElement);
		}

		fileInputElement.sendKeys(filePath);
	}

	/**
	 * get element
	 * 
	 * @return
	 */
	private WebElement getNotProxiedInputElement() {
		try {
			return element.findElement(By.xpath("."));
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * is on remote webdriver
	 * 
	 * @param element
	 * @return
	 */
	public boolean isOnRemoteWebDriver(WebElement element) {
		if (!isRemoteWebElement(element)) {
			return false;
		}

		// Since subclasses of RemoteWebElement were finally removed in Selenium
		// 2.26.0,
		// WebElements on local drivers
		// are also instances of RemoteWebElement class. The only way that we
		// found at
		// the current moment to find out
		// whether WebElement instance is on remote driver is to check the class
		// of
		// RemoteWebElement "parent" filed,
		// which contains WebDriver instance to which this RemoteWebElement
		// belongs.
		// As this field has protected access this is done by reflection.
		// TODO It's is a kind of a dirty hack to be improved in future
		// versions.
		RemoteWebElement remoteWebElement = (RemoteWebElement) element;
		try {
			Field elementParentFiled = RemoteWebElement.class.getDeclaredField("parent");
			elementParentFiled.setAccessible(true);
			WebDriver elementParent = (WebDriver) elementParentFiled.get(remoteWebElement);
			return elementParent.getClass().equals(RemoteWebDriver.class);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			throw new RuntimeException("Unable to find out if WebElement is on remote driver", e);
		}
	}

	/**
	 * is remote webelement
	 * 
	 * @param element
	 * @return
	 */
	public boolean isRemoteWebElement(WebElement element) {
		try {
			return element.getClass().equals(RemoteWebElement.class);
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return false;
		}
	}

	/**
	 * Set local file detector
	 * 
	 * @param element
	 */
	private void setLocalFileDetector(RemoteWebElement element) {
		try {
			element.setFileDetector(new LocalFileDetector());
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * Returns all radio buttons belonging to this group.
	 *
	 * @return A list of {@code WebElements} representing radio buttons.
	 */
	public List<WebElement> getButtons() {
		String radioName = element.getAttribute("name");

		String xpath;
		if (radioName == null) {
			xpath = "self::* | following::input[@type = 'radio'] | preceding::input[@type = 'radio']";
		} else {
			xpath = String.format("self::* | following::input[@type = 'radio' and @name = '%s'] | "
					+ "preceding::input[@type = 'radio' and @name = '%s']", radioName, radioName);
		}

		return findElements(By.xpath(xpath));
	}

	/**
	 * Returns selected radio button.
	 *
	 * @return {@code WebElement} representing selected radio button or
	 *         {@code null} if no radio buttons are selected.
	 */
	public WebElement getSelectedButton() {
		return getButtons().stream().filter(WebElement::isSelected).findAny()
				.orElseThrow(() -> new NoSuchElementException("No selected button"));
	}

	/**
	 * Indicates if radio group has selected button.
	 *
	 * @return {@code true} if radio has selected button and {@code false}
	 *         otherwise.
	 */
	public boolean hasSelectedButton() {
		return getButtons().stream().anyMatch(WebElement::isSelected);
	}

	/**
	 * Selects first radio button that has a value matching the specified
	 * argument.
	 *
	 * @param value
	 *            The value to match against.
	 */
	public void selectByValue(String value) {
		Optional<WebElement> matchingButton = getButtons().stream().filter(b -> value.equals(b.getAttribute("value")))
				.findFirst();

		selectButton(matchingButton.orElseThrow(
				() -> new NoSuchElementException(String.format("Cannot locate radio button with value: %s", value))));
	}

	/**
	 * Selects a radio button by the given index.
	 *
	 * @param index
	 *            Index of a radio button to be selected.
	 */
	public void selectByIndex(int index) {
		List<WebElement> buttons = getButtons();

		if (index < 0 || index >= buttons.size()) {
			throw new NoSuchElementException(String.format("Cannot locate radio button with index: %d", index));
		}

		selectButton(buttons.get(index));
	}

	/**
	 * Selects a radio button if it's not already selected.
	 *
	 * @param button
	 *            {@code WebElement} representing radio button to be selected.
	 */
	private void selectButton(WebElement button) {
		try {
			if (!button.isSelected()) {
				button.click();
			}
		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
		}
	}

	/**
	 * Constructs instance of {@link org.openqa.selenium.support.ui.Select}
	 * class.
	 *
	 * @return {@link org.openqa.selenium.support.ui.Select} class instance.
	 */
	private Select getSelect() {
		try {
			return new Select(element);

		} catch (Exception e) {
			StackTraceElement[] elements = new Throwable().getStackTrace();
			Logger.error(
					elements[1].getMethodName() + " element not found at line number " + elements[1].getLineNumber());
			return null;
		}
	}

	/**
	 * Indicates whether this select element support selecting multiple options
	 * at the same time. This is done by checking the value of the "multiple"
	 * attribute.
	 *
	 * @return {@code true} if select element support selecting multiple options
	 *         and {@code false} otherwise.
	 */
	public boolean isMultiple() {
		return getSelect().isMultiple();
	}

	/**
	 * Returns all options belonging to this select tag.
	 *
	 * @return A list of {@code WebElements} representing options.
	 */
	public List<WebElement> getOptions() {
		return getSelect().getOptions();
	}

	/**
	 * Returns all selected options belonging to this select tag.
	 *
	 * @return A list of {@code WebElements} representing selected options.
	 */
	public List<WebElement> getAllSelectedOptions() {
		return getSelect().getAllSelectedOptions();
	}

	/**
	 * The first selected option in this select tag (or the currently selected
	 * option in a normal select).
	 *
	 * @return A {@code WebElement} representing selected option.
	 */
	public WebElement getFirstSelectedOption() {
		return getSelect().getFirstSelectedOption();
	}

	/**
	 * Indicates if select has at least one selected option.
	 *
	 * @return {@code true} if select has at least one selected option and
	 *         {@code false} otherwise.
	 */
	public boolean hasSelectedOption() {
		return getOptions().stream().anyMatch(WebElement::isSelected);
	}

	/**
	 * Select all options that display text matching the argument. That is, when
	 * given "Bar" this would select an option like:
	 * <p/>
	 * &lt;option value="foo"&gt;Bar&lt;/option&gt;
	 *
	 * @param text
	 *            The visible text to match against
	 */
	public void selectByVisibleText(String text) {
		getSelect().selectByVisibleText(text);
	}

	/**
	 * Clear all selected entries. This is only valid when the SELECT supports
	 * multiple selections.
	 *
	 * @throws UnsupportedOperationException
	 *             If the SELECT does not support multiple selections
	 */
	public void deselectAll() {
		getSelect().deselectAll();
	}

	/**
	 * Deselect all options that have a value matching the argument. That is,
	 * when given "foo" this would deselect an option like:
	 * <p/>
	 * &lt;option value="foo"&gt;Bar&lt;/option&gt;
	 *
	 * @param value
	 *            The value to match against
	 */
	public void deselectByValue(String value) {
		getSelect().deselectByValue(value);
	}

	/**
	 * Deselect the option at the given index. This is done by examining the
	 * "index" attribute of an element, and not merely by counting.
	 *
	 * @param index
	 *            The option at this index will be deselected
	 */
	public void deselectByIndex(int index) {
		getSelect().deselectByIndex(index);
	}

	/**
	 * Deselect all options that display text matching the argument. That is,
	 * when given "Bar" this would deselect an option like:
	 * <p/>
	 * &lt;option value="foo"&gt;Bar&lt;/option&gt;
	 *
	 * @param text
	 *            The visible text to match against
	 */
	public void deselectByVisibleText(String text) {
		getSelect().deselectByVisibleText(text);
	}
}
