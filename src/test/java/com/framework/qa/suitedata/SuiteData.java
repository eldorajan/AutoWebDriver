package com.framework.qa.suitedata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionId;

/**
 * 
 * @author eldo_rajan
 *
 */
public class SuiteData {

	private WebDriver webdriver;
	private SessionId sessionId;

	private String browserName;
	private String osName;
	private String webdriverMode;
	private String eventFiringWebDriver;
	private String headlessMode;

	private String chromePath;
	private String iePath;
	private String edgePath;
	private String firefoxPath;
	private String phantomJSPath;

	private String envName;
	private String username;
	private String password;

	private String saasAppName;
	private String saasAppUsername;
	private String saasAppPassword;

	private String loginUrl;
	private String dashboardUrl;
	private String host;
	private String port;
	private String scheme;
	private String referer;
	private String apiServerHost;
	private String uiServerHost;
	private String apiBaseVersion;

	/**
	 * @return the webdriver
	 */
	public WebDriver getWebdriver() {
		return webdriver;
	}

	/**
	 * @param webdriver
	 *            the webdriver to set
	 */
	public void setWebdriver(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	/**
	 * @return the sessionId
	 */
	public SessionId getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(SessionId sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}

	/**
	 * @param browserName
	 *            the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	/**
	 * @return the osName
	 */
	public String getOSName() {
		return osName;
	}

	/**
	 * @param osName
	 *            the osName to set
	 */
	public void setOSName(String osName) {
		this.osName = osName;
	}

	/**
	 * @return the webdriverMode
	 */
	public String getWebdriverMode() {
		return webdriverMode;
	}

	/**
	 * @param webdriverMode
	 *            the webdriverMode to set
	 */
	public void setWebdriverMode(String webdriverMode) {
		this.webdriverMode = webdriverMode;
	}

	/**
	 * @return the chromePath
	 */
	public String getChromePath() {
		return chromePath;
	}

	/**
	 * @param chromePath
	 *            the chromePath to set
	 */
	public void setChromePath(String chromePath) {
		this.chromePath = chromePath;
	}

	/**
	 * @return the edgePath
	 */
	public String getEdgePath() {
		return edgePath;
	}

	/**
	 * @param edgePath
	 *            the edgePath to set
	 */
	public void setEdgePath(String edgePath) {
		this.edgePath = edgePath;
	}

	/**
	 * @return the iePath
	 */
	public String getIEPath() {
		return iePath;
	}

	/**
	 * @param iePath
	 *            the iePath to set
	 */
	public void setIEPath(String iePath) {
		this.iePath = iePath;
	}

	/**
	 * @return the firefoxPath
	 */
	public String getFirefoxPath() {
		return firefoxPath;
	}

	/**
	 * @param firefoxPath
	 *            the firefoxPath to set
	 */
	public void setFirefoxPath(String firefoxPath) {
		this.firefoxPath = firefoxPath;
	}

	/**
	 * @return the phantomJSPath
	 */
	public String getPhantomJSPath() {
		return phantomJSPath;
	}

	/**
	 * @param phantomJSPath
	 *            the phantomJSPath to set
	 */
	public void setPhantomJSPath(String phantomJSPath) {
		this.phantomJSPath = phantomJSPath;
	}

	/**
	 * @return the envName
	 */
	public String getEnvName() {
		return envName;
	}

	/**
	 * @param envName
	 *            the envName to set
	 */
	public void setEnvName(String envName) {
		this.envName = envName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the saasAppName
	 */
	public String getSaasAppName() {
		return saasAppName;
	}

	/**
	 * @param saasAppName
	 *            the saasAppName to set
	 */
	public void setSaasAppName(String saasAppName) {
		this.saasAppName = saasAppName;
	}

	/**
	 * @return the saasAppUsername
	 */
	public String getSaasAppUsername() {
		return saasAppUsername;
	}

	/**
	 * @param saasAppUsername
	 *            the saasAppUsername to set
	 */
	public void setSaasAppUsername(String saasAppUsername) {
		this.saasAppUsername = saasAppUsername;
	}

	/**
	 * @return the saasAppPassword
	 */
	public String getSaasAppPassword() {
		return saasAppPassword;
	}

	/**
	 * @param saasAppPassword
	 *            the saasAppPassword to set
	 */
	public void setSaasAppPassword(String saasAppPassword) {
		this.saasAppPassword = saasAppPassword;
	}

	/**
	 * @return the loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}

	/**
	 * @param loginUrl
	 *            the loginUrl to set
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * @return the dashboardUrl
	 */
	public String getDashboardUrl() {
		return dashboardUrl;
	}

	/**
	 * @param dashboardUrl
	 *            the dashboardUrl to set
	 */
	public void setDashboardUrl(String dashboardUrl) {
		this.dashboardUrl = dashboardUrl;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the scheme
	 */
	public String getScheme() {
		return scheme;
	}

	/**
	 * @param scheme
	 *            the scheme to set
	 */
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

	/**
	 * @param referer
	 *            the referer to set
	 */
	public void setReferer(String referer) {
		this.referer = referer;
	}

	/**
	 * @return the apiServerHost
	 */
	public String getApiServerHost() {
		return apiServerHost;
	}

	/**
	 * @param apiServerHost
	 *            the apiServerHost to set
	 */
	public void setApiServerHost(String apiServerHost) {
		this.apiServerHost = apiServerHost;
	}

	/**
	 * @return the uiServerHost
	 */
	public String getUiServerHost() {
		return uiServerHost;
	}

	/**
	 * @param uiServerHost
	 *            the uiServerHost to set
	 */
	public void setUiServerHost(String uiServerHost) {
		this.uiServerHost = uiServerHost;
	}

	/**
	 * @return the apiBaseVersion
	 */
	public String getApiBaseVersion() {
		return apiBaseVersion;
	}

	/**
	 * @param apiBaseVersion
	 *            the apiBaseVersion to set
	 */
	public void setApiBaseVersion(String apiBaseVersion) {
		this.apiBaseVersion = apiBaseVersion;
	}

	/**
	 * @return the eventFiringWebDriver
	 */
	public String getEventFiringWebDriver() {
		return eventFiringWebDriver;
	}

	/**
	 * @param eventFiringWebDriver
	 *            the eventFiringWebDriver to set
	 */
	public void setEventFiringWebDriver(String eventFiringWebDriver) {
		this.eventFiringWebDriver = eventFiringWebDriver;
	}

	/**
	 * @return the osName
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * @param osName
	 *            the osName to set
	 */
	public void setOsName(String osName) {
		this.osName = osName;
	}

	/**
	 * @return the iePath
	 */
	public String getIePath() {
		return iePath;
	}

	/**
	 * @param iePath
	 *            the iePath to set
	 */
	public void setIePath(String iePath) {
		this.iePath = iePath;
	}

	/**
	 * @return the headlessMode
	 */
	public String getHeadlessMode() {
		return headlessMode;
	}

	/**
	 * @param headlessMode
	 *            the headlessMode to set
	 */
	public void setHeadlessMode(String headlessMode) {
		this.headlessMode = headlessMode;
	}
}