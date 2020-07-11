package com.framework.qa.action.common;

import com.framework.qa.driver.utils.WebDriverUtils;
import com.framework.qa.driver.utils.WebDriverWaitUtils;
import com.framework.qa.pageloader.PageLoader;

/**
 * @author eldo_rajan
 */
public class CommonAction {

    protected WebDriverUtils wdUtils;
    protected PageLoader pageLoader;
    protected WebDriverWaitUtils wait;

    public CommonAction() {
        wdUtils = new WebDriverUtils();
        pageLoader = new PageLoader(wdUtils);
        wait = new WebDriverWaitUtils(wdUtils);
        // wait.waitPageIsActive();
    }
}
