package com.framework.qa.pageloader;

import com.framework.qa.driver.utils.WebDriverUtils;

/**
 * 
 * @author eldo_rajan
 *
 */
public class PageLoader {
	public WebDriverUtils wdUtils;

	public PageLoader() {
		wdUtils = new WebDriverUtils();
	}

	public PageLoader(WebDriverUtils wdUtils) {
		this.wdUtils = wdUtils;
	}

	public void openUrl(String url) {
		wdUtils.get(url);
	}

	public void openRelativeUrl(String url) {
		wdUtils.get(wdUtils.suiteData.getLoginUrl() + url);
	}

}