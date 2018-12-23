package com.framework.qa.driver.capabilities;

import java.util.ArrayList;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariOptions;

import com.framework.qa.constants.FrameworkConstants;
import com.framework.qa.driver.browser.WebBrowser;
import com.framework.qa.suitedata.SuiteData;

/**
 * 
 * @author eldo_rajan
 *
 */
public class DriverCapabilities {

	public DesiredCapabilities getDesiredCapabilities(SuiteData suiteData) {
		WebBrowser browser = WebBrowser.getBrowserType(suiteData.getBrowserName());

		switch (browser) {
		case Firefox: {
			return getFirefoxCapabilities(suiteData);
		}
		case Edge: {
			return getEdgeCapabilities(suiteData);
		}
		case InternetExplorer: {
			return getIECapabilities(suiteData);
		}
		case Chrome: {
			return getChromeCapabilities(suiteData);
		}
		case Opera: {
			return getOperaCapabilities(suiteData);
		}
		case Safari: {
			return getSafariCapabilities(suiteData);
		}
		case PhantomJS: {
			return getPhantomJSCapabilities(suiteData);
		}
		case HtmlUnit: {
			return getHtmlUnitCapabilities(suiteData);
		}
		default: {
			return null;
		}
		}
	}

	protected DesiredCapabilities addDefaultCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		return desiredCapabilities;
	}

	protected DesiredCapabilities getFirefoxCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability("elementScrollBehavior", 1);
		desiredCapabilities.setCapability("marionette", true);

		return desiredCapabilities;
	}

	@SuppressWarnings("deprecation")
	protected DesiredCapabilities getIECapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredCapabilities.setCapability("ignoreProtectedModeSettings", true);
		desiredCapabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, false);
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
		desiredCapabilities.setCapability("javascriptEnabled", true);
		desiredCapabilities.setCapability("autoAcceptAlerts", true);
		desiredCapabilities.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.DISMISS);
		desiredCapabilities.setCapability("handlesAlerts", "dismissAlerts");
		desiredCapabilities.setCapability("requireWindowFocus", true);
		desiredCapabilities.setCapability("ie.ensureCleanSession", true);
		desiredCapabilities.setBrowserName("internet explorer");
		desiredCapabilities.setVersion("11");

		return desiredCapabilities;
	}

	@SuppressWarnings("deprecation")
	protected DesiredCapabilities getEdgeCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.edge();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredCapabilities.setCapability("ignoreProtectedModeSettings", true);
		desiredCapabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, false);
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
		desiredCapabilities.setCapability("javascriptEnabled", true);
		desiredCapabilities.setCapability("autoAcceptAlerts", true);
		desiredCapabilities.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.DISMISS);
		desiredCapabilities.setCapability("handlesAlerts", "dismissAlerts");
		desiredCapabilities.setCapability("requireWindowFocus", true);
		/*
		 * desiredCapabilities.setCapability("ie.ensureCleanSession", true);
		 * desiredCapabilities.setBrowserName("internet explorer");
		 */
		desiredCapabilities.setVersion("11");

		return desiredCapabilities;
	}

	protected DesiredCapabilities getChromeCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
		desiredCapabilities.setCapability("elementScrollBehavior", 1);

		return desiredCapabilities;
	}

	protected DesiredCapabilities getSafariCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.safari();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
		desiredCapabilities.setCapability("javascriptEnabled", true);
		desiredCapabilities.setCapability("autoAcceptAlerts", true);
		desiredCapabilities.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.DISMISS);
		desiredCapabilities.setCapability("handlesAlerts", "dismissAlerts");
		desiredCapabilities.setCapability("safari.options.dataDir", FrameworkConstants.DOWNLOADS_FOLDER);

		return desiredCapabilities;
	}

	@SuppressWarnings("deprecation")
	protected DesiredCapabilities getOperaCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.opera();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
		desiredCapabilities.setCapability("opera.arguments", "-nowin -nomail -fullscreen");

		return desiredCapabilities;
	}

	protected DesiredCapabilities getPhantomJSCapabilities(SuiteData suiteData) {
		@SuppressWarnings("deprecation")
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.phantomjs();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));

		ArrayList<String> cliArgsDesiredCapabilities = new ArrayList<String>();
		cliArgsDesiredCapabilities.add("--web-security=false");
		cliArgsDesiredCapabilities.add("--ssl-protocol=any");
		cliArgsDesiredCapabilities.add("--ignore-ssl-errors=true");
		cliArgsDesiredCapabilities.add("--web-security=no");
		cliArgsDesiredCapabilities.add("--ignore-ssl-errors=yes");
		desiredCapabilities.setCapability("takesScreenshot", true);
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsDesiredCapabilities);
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS,
				new String[] { "--logLevel=2" });
		desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				suiteData.getPhantomJSPath());
		desiredCapabilities.setJavascriptEnabled(true);

		return desiredCapabilities;
	}

	protected DesiredCapabilities getHtmlUnitCapabilities(SuiteData suiteData) {
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.htmlUnit();
		desiredCapabilities.merge(addDefaultCapabilities(suiteData));
		desiredCapabilities.setCapability("takesScreenshot", true);
		desiredCapabilities.setJavascriptEnabled(true);

		return desiredCapabilities;
	}

	public FirefoxOptions getFireFoxOptions(SuiteData suiteData) {
		FirefoxOptions options = new FirefoxOptions(/*
													 * getFirefoxCapabilities(
													 * suiteData)
													 */);
		options.setProfile(getFirefoxProfile(suiteData));
		options.setLogLevel(FirefoxDriverLogLevel.INFO);
		if (Boolean.parseBoolean(suiteData.getHeadlessMode())) {
			options.addArguments("--headless");
		}

		return options;
	}

	public EdgeOptions getEdgeOptions(SuiteData suiteData) {
		EdgeOptions options = new EdgeOptions();
		return options;
	}

	public InternetExplorerOptions getIEOptions(SuiteData suiteData) {
		InternetExplorerOptions options = new InternetExplorerOptions(getIECapabilities(suiteData));
		return options;
	}

	public SafariOptions getSafariOptions(SuiteData suiteData) {
		SafariOptions options = new SafariOptions(getSafariCapabilities(suiteData));
		return options;
	}

	public ChromeOptions getChromeOptions(SuiteData suiteData) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("allow-running-insecure-content");
		options.addArguments("ignore-certificate-errors");
		options.addArguments("--profile-directory=Default");
		options.addArguments("--start-maximized");

		if (Boolean.parseBoolean(suiteData.getHeadlessMode())) {
			options.addArguments("--headless");
		}

		return options;
	}

	public FirefoxProfile getFirefoxProfile(SuiteData suiteData) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		// profile.setEnableNativeEvents(true);

		profile.setPreference("browser.download.folderList", 1);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.useDownloadDir", true);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.closeWhenDone", true);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/pdf,application/vnd.ms-powerpoint,application/octet-stream,application/msword,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.spreadsheetml.template,application/vnd.openxmlformats-officedocument.presentationml.template,application/vnd.openxmlformats-officedocument.presentationml.slideshow,application/vnd.openxmlformats-officedocument.presentationml.presentation,application/vnd.openxmlformats-officedocument.presentationml.slide,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/vnd.openxmlformats-officedocument.wordprocessingml.template,application/vnd.ms-excel.addin.macroEnabled.12,application/vnd.ms-excel.sheet.binary.macroEnabled.12,application/vnd.ms-word.document.macroEnabled.12,application/vnd.ms-word.template.macroEnabled.12,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.template,application/vnd.ms-excel.sheet.macroEnabled.12,application/vnd.ms-excel.template.macroEnabled.12,application/vnd.openxmlformats-officedocument.presentationml.template,application/vnd.ms-powerpoint.addin.macroEnabled.12,application/vnd.ms-powerpoint.presentation.macroEnabled.12,application/vnd.ms-powerpoint.template.macroEnabled.12,application/vnd.ms-powerpoint.slideshow.macroEnabled.12");
		profile.setPreference("security.mixed_content.block_active_content", false);
		profile.setPreference("security.mixed_content.block_display_content", true);
		profile.setPreference("capability.policy.default.Window.QueryInterface", "allAccess");
		profile.setPreference("capability.policy.default.Window.frameElement.get", "allAccess");

		return profile;
	}
}
