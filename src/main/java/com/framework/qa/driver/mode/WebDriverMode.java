package com.framework.qa.driver.mode;

/**
 * @author eldo_rajan
 */
public enum WebDriverMode {
    Local("local"), Grid("grid"), Cloud("cloud");

    private String webdriverMode;

    WebDriverMode(final String webdriverMode) {
        this.webdriverMode = webdriverMode;
    }

    /**
     * get driver type
     *
     * @param driverType
     * @return
     */
    public static WebDriverMode getWebDriverMode(final String webdriverMode) {
        WebDriverMode mode = null;
        try {
            if (webdriverMode.equalsIgnoreCase("local")) {
                mode = WebDriverMode.Local;
            } else if (webdriverMode.equalsIgnoreCase("grid")) {
                mode = WebDriverMode.Grid;
            } else if (webdriverMode.equalsIgnoreCase("cloud")) {
                mode = WebDriverMode.Cloud;
            } else {
                mode = WebDriverMode.Local;
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return mode;
    }

    /**
     * get driver type
     *
     * @return
     */
    public String getWebDriverMode() {
        return this.webdriverMode;
    }

}
