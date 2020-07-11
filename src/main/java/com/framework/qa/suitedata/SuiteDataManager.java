package com.framework.qa.suitedata;

import java.util.Map;

import org.testng.ITestContext;

import com.framework.qa.constants.FrameworkConstants;
import com.framework.qa.utils.FileHandlingUtils;

/**
 * @author eldo_rajan
 */
public class SuiteDataManager {

    public static SuiteData suiteData = null;
    public Map<String, String> configData = null;

    public SuiteDataManager() {
        configData = FileHandlingUtils.readPropertyFile(FrameworkConstants.CONFIG_DB_FILE);
    }

    public static SuiteData getSuiteData() {
        return suiteData;
    }

    public static void setSuiteData(SuiteData suiteData) {
        SuiteDataManager.suiteData = suiteData;
    }

    public SuiteData setupSuiteData(ITestContext testContext) {

        SuiteData suiteData = new SuiteData();

        suiteData.setBrowserName(getValue(testContext, "browserName", suiteData));
        suiteData.setOSName(System.getProperty("os.name").toLowerCase());
        suiteData.setWebdriverMode(getValue(testContext, "webdriverMode", suiteData));
        suiteData.setEventFiringWebDriver(getValue(testContext, "eventFiringWebDriver", suiteData));
        suiteData.setEnvName(getValue(testContext, "envName", suiteData));
        suiteData.setHeadlessMode(getValue(testContext, "headlessMode", suiteData));

        if (suiteData.getOSName().contains("win")) {
            suiteData.setChromePath(FrameworkConstants.CHROME_WIN_PATH);
            suiteData.setIEPath(FrameworkConstants.IE_WIN_PATH);
            suiteData.setPhantomJSPath(FrameworkConstants.PHANTOMJS_WIN_PATH);
            suiteData.setFirefoxPath(FrameworkConstants.GECKO_WIN_PATH);
            suiteData.setEdgePath(FrameworkConstants.EDGE_WIN_PATH);
        } else if (suiteData.getOSName().contains("mac")) {
            suiteData.setChromePath(FrameworkConstants.CHROME_MAC_PATH);
            suiteData.setPhantomJSPath(FrameworkConstants.PHANTOMJS_MAC_PATH);
            suiteData.setFirefoxPath(FrameworkConstants.GECKO_MAC_PATH);
        } else if (suiteData.getOSName().contains("nix") || suiteData.getOSName().contains("nux")) {
            suiteData.setChromePath(FrameworkConstants.CHROME_LINUX_PATH);
            suiteData.setPhantomJSPath(FrameworkConstants.PHANTOMJS_LINUX_PATH);
            suiteData.setFirefoxPath(FrameworkConstants.GECKO_LINUX_PATH);
        }

        suiteData.setLoginUrl(getValue(testContext, "loginUrl", suiteData));
        suiteData.setDashboardUrl(getValue(testContext, "dashboardUrl", suiteData));
        suiteData.setHost(getValue(testContext, "host", suiteData));
        suiteData.setPort(getValue(testContext, "port", suiteData));
        suiteData.setScheme(getValue(testContext, "scheme", suiteData));
        suiteData.setReferer(getValue(testContext, "referer", suiteData));
        suiteData.setApiServerHost(getValue(testContext, "apiServerHost", suiteData));

        suiteData.setUsername(getValueXml(testContext, "username"));
        suiteData.setPassword(getValueXml(testContext, "password"));

        suiteData.setSaasAppName(getValueXml(testContext, "saasAppName"));
        suiteData.setSaasAppUsername(getValueXml(testContext, "saasAppUsername"));
        suiteData.setSaasAppPassword(getValueXml(testContext, "saasAppPassword"));

        suiteData.setApiBaseVersion(getValue(testContext, "apiBaseVersion"));

        return suiteData;
    }

    public String getValue(ITestContext testContext, String parameterName, SuiteData suiteData) {
        return testContext.getCurrentXmlTest().getParameter(parameterName) != null
                ? testContext.getCurrentXmlTest().getParameter(parameterName).toString()
                : (suiteData.getEnvName() != null
                ? configData.get(new StringBuilder().append(suiteData.getEnvName()).append(".")
                .append(parameterName).toString())
                : configData.get("default.".concat(parameterName)));
    }

    public String getValueXml(ITestContext testContext, String parameterName) {
        return testContext.getCurrentXmlTest().getParameter(parameterName) != null
                ? testContext.getCurrentXmlTest().getParameter(parameterName).toString()
                : null;
    }

    public String getValue(ITestContext testContext, String parameterName) {
        return testContext.getCurrentXmlTest().getParameter(parameterName) != null
                ? testContext.getCurrentXmlTest().getParameter(parameterName).toString()
                : configData.get(parameterName);
    }

}