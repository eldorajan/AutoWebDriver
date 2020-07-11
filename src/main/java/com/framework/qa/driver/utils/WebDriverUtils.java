package com.framework.qa.driver.utils;

import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.ImeHandler;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.logging.Logs;

import com.framework.qa.suitedata.SuiteData;
import com.framework.qa.suitedata.SuiteDataManager;
import com.framework.qa.webelement.BaseElement;

/**
 * @author eldo_rajan
 */
@SuppressWarnings("deprecation")
public class WebDriverUtils {

    public SuiteData suiteData;
    public WebDriver webdriver;

    public WebDriverUtils() {
        suiteData = SuiteDataManager.getSuiteData();
        webdriver = suiteData.getWebdriver();
    }

    public void get(String url) {
        webdriver.get(url);
    }

    public String getCurrentUrl() {
        return webdriver.getCurrentUrl();
    }

    public String getTitle() {
        return webdriver.getTitle();
    }

    public String getPageSource() {
        return webdriver.getPageSource();
    }

    public void close() {
        webdriver.close();
    }

    public void quit() {
        webdriver.quit();
    }

    public Set<String> getWindowHandles() {
        return webdriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return webdriver.getWindowHandle();
    }

    public Object executeScript(String script, Object... args) {

        if (webdriver instanceof JavascriptExecutor) {
            return ((JavascriptExecutor) webdriver).executeScript(script, args);
        }

        throw new UnsupportedOperationException("Underlying driver instance does not support executing javascript");
    }

    public Object executeAsyncScript(String script, Object... args) {
        if (webdriver instanceof JavascriptExecutor) {
            return ((JavascriptExecutor) webdriver).executeAsyncScript(script, args);
        }

        throw new UnsupportedOperationException("Underlying driver instance does not support executing javascript");
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        if (webdriver instanceof TakesScreenshot) {
            return ((TakesScreenshot) webdriver).getScreenshotAs(target);
        }

        throw new UnsupportedOperationException("Underlying driver instance does not support taking screenshots");
    }

    public TargetLocator switchTo() {
        return webdriver.switchTo();
    }

    public Alert switchToAlert() {
        return switchTo().alert();
    }

    public BaseElement switchToActiveElement() {
        return (BaseElement) switchTo().activeElement();
    }

    public WebDriver switchToDefaultContent() {
        return switchTo().defaultContent();
    }

    public WebDriver switchToFrame(int index) {
        return switchTo().frame(index);
    }

    public WebDriver switchToFrame(String nameOrId) {
        return switchTo().frame(nameOrId);
    }

    public WebDriver switchToFrame(BaseElement frameElement) {
        return switchTo().frame(frameElement);
    }

    public WebDriver switchToParentFrame() {
        return switchTo().parentFrame();
    }

    public WebDriver switchToWindow(String nameOrHandle) {
        return switchTo().window(nameOrHandle);
    }

    public Navigation navigate() {
        return webdriver.navigate();
    }

    public void back() {
        navigate().back();
    }

    public void forward() {
        navigate().forward();
    }

    public void refresh() {
        navigate().refresh();
    }

    public void to(String url) {
        navigate().to(url);
    }

    public void to(URL url) {
        navigate().to(url);
    }

    public Options manage() {
        return webdriver.manage();
    }

    public void addCookie(Cookie cookie) {
        manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie) {
        manage().deleteCookie(cookie);
    }

    public void deleteCookie(String cookieName) {
        manage().deleteCookieNamed(cookieName);
    }

    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }

    public Cookie getCookie(String cookieName) {
        return manage().getCookieNamed(cookieName);
    }

    public Set<Cookie> getCookies() {
        return manage().getCookies();
    }

    public ImeHandler getIme() {
        return manage().ime();
    }

    public Logs getLogs() {
        return manage().logs();
    }

    public Window getWindows() {
        return manage().window();
    }

    public void fullscreen() {
        manage().window().fullscreen();
    }

    public void maximize() {
        manage().window().maximize();
    }

    public Point getPosition() {
        return manage().window().getPosition();
    }

    public Dimension getDimension() {
        return manage().window().getSize();
    }

    public Actions getActions() {
        return new Actions(webdriver);
    }

    public Action build() {
        return getActions().build();
    }

    public Actions click() {
        return getActions().click();
    }

    public Actions click(BaseElement target) {
        return getActions().click(target);
    }

    public Actions clickAndHold() {
        return getActions().clickAndHold();
    }

    public Actions clickAndHold(BaseElement target) {
        return getActions().clickAndHold(target);
    }

    public Actions rightClick() {
        return getActions().contextClick();
    }

    public Actions rightClick(BaseElement target) {
        return getActions().contextClick(target);
    }

    public Actions doubleClick() {
        return getActions().doubleClick();
    }

    public Actions doubleClick(BaseElement target) {
        return getActions().doubleClick(target);
    }

    public Actions dragAndDrop(BaseElement source, BaseElement target) {
        return getActions().dragAndDrop(source, target);
    }

    public Actions dragAndDrop(BaseElement source, int xOffset, int yOffset) {
        return getActions().dragAndDropBy(source, xOffset, yOffset);
    }

    public Actions keyDown(String key) {
        return getActions().keyDown(key);
    }

    public Actions keyDown(BaseElement target, String key) {
        return getActions().keyDown(target, key);
    }

    public Actions keyUp(String key) {
        return getActions().keyUp(key);
    }

    public Actions keyUp(BaseElement target, String key) {
        return getActions().keyUp(target, key);
    }

    public Actions moveByOffset(int xOffset, int yOffset) {
        return getActions().moveByOffset(xOffset, yOffset);
    }

    public Actions moveToElement(BaseElement target) {
        return getActions().moveToElement(target);
    }

    public Actions moveToElement(BaseElement target, int xOffset, int yOffset) {
        return getActions().moveToElement(target, xOffset, yOffset);
    }

    public Actions pause(Duration duration) {
        return getActions().pause(duration);
    }

    public Actions pause(long duration) {
        return getActions().pause(duration);
    }

    public void perform() {
        getActions().perform();
    }

    public Actions release() {
        return getActions().release();
    }

    public Actions release(BaseElement target) {
        return getActions().release(target);
    }

    public Actions type(String keys) {
        return getActions().sendKeys(keys);
    }

    public Actions type(BaseElement target, String keys) {
        return getActions().sendKeys(target, keys);
    }

    public Keyboard getKeyboard() {
        if (webdriver instanceof HasInputDevices) {
            return ((HasInputDevices) webdriver).getKeyboard();
        } else {
            throw new UnsupportedOperationException(
                    "Underlying driver does not implement advanced" + " user interactions yet.");
        }
    }

    public Mouse getMouse() {
        if (webdriver instanceof HasInputDevices) {
            return ((HasInputDevices) webdriver).getMouse();
        } else {
            throw new UnsupportedOperationException(
                    "Underlying driver does not implement advanced" + " user interactions yet.");
        }
    }

    public TouchScreen getTouch() {
        if (webdriver instanceof HasTouchScreen) {
            return ((HasTouchScreen) webdriver).getTouch();
        } else {
            throw new UnsupportedOperationException(
                    "Underlying driver does not implement advanced" + " user interactions yet.");
        }
    }

}
