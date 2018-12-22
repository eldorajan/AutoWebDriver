package com.framework.qa.action.search;

import org.testng.Assert;

import com.framework.qa.action.common.CommonAction;
import com.framework.qa.action.interfaces.SearchActionInterface;
import com.framework.qa.logger.Logger;
import com.framework.qa.pageobjects.SearchPage;

/**
 * 
 * @author eldo_rajan
 *
 */
public class SearchAction extends CommonAction implements SearchActionInterface {

	/**
	 * Sample Action method
	 * 
	 * @param driver
	 * @param text
	 */
	public void searchInGoogle(String searchText) {
		Logger.info("Started the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
		SearchPage searchPage = new SearchPage();

		wait.waitElementToBeVisible(searchPage.searchElement, 5);
		wait.waitElementToBeClickable(searchPage.searchElement, 5);
		wait.waitElementAndType(searchPage.searchElement, searchText, 5);
		searchPage.searchElement.submit();

		wait.delay(5);
		Assert.assertTrue(searchPage.searchResults.size() > 0, "Search results is not present");

		Logger.info("Completed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
