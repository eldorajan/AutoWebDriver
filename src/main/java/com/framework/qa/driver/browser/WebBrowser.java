package com.framework.qa.driver.browser;

/**
 * @author eldo_rajan
 */
public enum WebBrowser {
    Firefox("firefox"), InternetExplorer("ie"), Edge("edge"), Chrome("chrome"), HtmlUnit("htmlunit"), Safari("safari"),
    Opera("opera"), Android("android"), IPhone("iphone"), IPad("ipad"), PhantomJS("phantomjs");

    private String webBrowser;

    WebBrowser(final String type) {
        this.webBrowser = type;
    }

    public static WebBrowser getBrowserType(final String browser) {
        WebBrowser webBrowser = null;
        try {
            if (browser.equalsIgnoreCase("firefox")) {
                webBrowser = WebBrowser.Firefox;
            } else if (browser.equalsIgnoreCase("ie")) {
                webBrowser = WebBrowser.InternetExplorer;
            } else if (browser.equalsIgnoreCase("edge")) {
                webBrowser = WebBrowser.Edge;
            } else if (browser.equalsIgnoreCase("chrome")) {
                webBrowser = WebBrowser.Chrome;
            } else if (browser.equalsIgnoreCase("htmlunit")) {
                webBrowser = WebBrowser.HtmlUnit;
            } else if (browser.equalsIgnoreCase("safari")) {
                webBrowser = WebBrowser.Safari;
            } else if (browser.equalsIgnoreCase("android")) {
                webBrowser = WebBrowser.Android;
            } else if (browser.equalsIgnoreCase("iphone")) {
                webBrowser = WebBrowser.IPhone;
            } else if (browser.equalsIgnoreCase("ipad")) {
                webBrowser = WebBrowser.IPad;
            } else if (browser.equalsIgnoreCase("opera")) {
                webBrowser = WebBrowser.Opera;
            } else if (browser.equalsIgnoreCase("phantomjs")) {
                webBrowser = WebBrowser.PhantomJS;
            } else {
                webBrowser = WebBrowser.Firefox;
            }
        } catch (Exception e) {
        }

        return webBrowser;
    }

    public String getWebBrowser() {
        return this.webBrowser;
    }

}
