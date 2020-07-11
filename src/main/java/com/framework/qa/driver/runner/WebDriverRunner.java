package com.framework.qa.driver.runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.framework.qa.driver.factory.WebDriverFactory;
import com.framework.qa.driver.mode.WebDriverMode;
import com.framework.qa.logger.Logger;
import com.framework.qa.suitedata.SuiteData;

/**
 * @author eldo_rajan
 */
public class WebDriverRunner {

    // Separate driver instance for each thread
    protected ThreadLocal<WebDriver> localdriver = new ThreadLocal<WebDriver>();
    protected ThreadLocal<RemoteWebDriver> remotedriver = new ThreadLocal<RemoteWebDriver>();
    protected ThreadLocal<String> sessionId = new ThreadLocal<String>();

    public WebDriver startBrowser(SuiteData suiteData) {
        try {
            WebDriverMode mode = WebDriverMode.getWebDriverMode(suiteData.getWebdriverMode());
            switch (mode) {
                case Local: {
                    localdriver.set(new WebDriverFactory().setUpLocalDriver(suiteData));
                    break;
                }
                case Grid: {
                    remotedriver.set(new WebDriverFactory().setUpRemoteDriver(suiteData));
                    break;
                }

                default:
                    try {
                        Logger.error("Fail to intialize the driver, please check mode parameter.");
                        throw new Exception("Fail to intialize the driver, please check mode parameter.");
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }

            getWebDriver(suiteData).get(suiteData.getLoginUrl());
            getWebDriver(suiteData).manage().window().maximize();
            getWebDriver(suiteData).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            /*
             * throw new RuntimeException("Exception during browser startup: ", e);
             */
        }

        return getWebDriver(suiteData);
    }

    public void stopBrowser(SuiteData suiteData) {
        Logger.info("Closing the browser session after the method gets executed in progress");
        if (localdriver.get() != null) {
            getWebDriver(suiteData).quit();
            localdriver.remove();
        } else if (remotedriver.get() != null) {
            getWebDriver(suiteData).quit();
            remotedriver.remove();
        } else {
            getWebDriver(suiteData).quit();
        }

        Logger.info("Closed the browser session after the method gets executed");
    }

    /**
     * gets webdriver instance
     *
     * @return
     */
    public WebDriver getWebDriver(SuiteData suiteData) {
        WebDriver driver = null;

        WebDriverMode mode = WebDriverMode.getWebDriverMode(suiteData.getWebdriverMode());
        switch (mode) {
            case Local: {
                driver = localdriver.get();
                break;
            }
            case Grid: {
                driver = remotedriver.get();
                break;
            }
            default:
                try {
                    Logger.error("Failed to intialize the driver, please check mode parameter.");
                    throw new Exception("Failed to intialize the driver, please check mode parameter.");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        return driver;

    }

    /**
     * gets session id
     *
     * @return
     */
    public SessionId getSessionId(SuiteData suiteData) {
        try {
            return ((RemoteWebDriver) getWebDriver(suiteData)).getSessionId();
        } catch (Exception e) {
            Logger.error("Failed to fetch session id");
            return null;
        }
    }

}
