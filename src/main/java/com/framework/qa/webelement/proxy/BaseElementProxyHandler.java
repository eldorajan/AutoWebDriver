package com.framework.qa.webelement.proxy;

import java.lang.reflect.Method;

import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

/**
 * @author eldo_rajan
 */
public class BaseElementProxyHandler extends LocatingElementHandler {
    public BaseElementProxyHandler(ElementLocator locator) {
        super(locator);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        return super.invoke(o, method, objects);
    }
}