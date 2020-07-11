package com.framework.qa.webelement.proxy;

import java.lang.reflect.Method;

import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

/**
 * @author eldo_rajan
 */
public class BaseElementListProxyHandler extends LocatingElementListHandler {
    public BaseElementListProxyHandler(ElementLocator locator) {
        super(locator);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return super.invoke(o, method, objects);
    }
}