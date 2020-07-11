package com.framework.qa.pagefactory.utils;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * @author eldo_rajan
 */
public final class BrowserElementLocatorFactory implements ElementLocatorFactory {
    private final SearchContext searchContext;

    public BrowserElementLocatorFactory(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new AjaxElementLocator(searchContext, field, 10) {
            @Override
            protected long sleepFor() {
                return 1000;
            }
        };
    }

}