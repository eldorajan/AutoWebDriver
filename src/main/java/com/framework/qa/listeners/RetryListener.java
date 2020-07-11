package com.framework.qa.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author eldo_rajan
 */
public class RetryListener implements IAnnotationTransformer {

    @Override
    @SuppressWarnings("rawtypes")
    public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {

        IRetryAnalyzer retry = arg0.getRetryAnalyzer();

        if (retry == null) {

            arg0.setRetryAnalyzer(RetryAnalyzer.class);

        }

    }

}
