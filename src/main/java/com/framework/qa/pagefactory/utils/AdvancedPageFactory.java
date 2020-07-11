package com.framework.qa.pagefactory.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.qa.pageobjects.BasePage;

/**
 * @author eldo_rajan
 */
public class AdvancedPageFactory {

    /**
     * @param driver
     * @param klass
     * @return
     */
    public static <T extends BasePage> T getPageObject(WebDriver driver, Class<T> klass) {
        return PageFactory.initElements(driver, klass);
    }

}
