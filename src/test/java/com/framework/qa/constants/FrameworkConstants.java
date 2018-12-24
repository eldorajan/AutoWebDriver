package com.framework.qa.constants;

import java.io.File;

/**
 * 
 * @author eldo_rajan
 *
 */
public class FrameworkConstants {

	/* Folders Constants */
	public final static String PROJECT_FOLDER = System.getProperty("user.dir");
	public final static String MAIN_FOLDER = PROJECT_FOLDER + File.separator + "src" + File.separator + "main";
	public final static String TEST_FOLDER = PROJECT_FOLDER + File.separator + "src" + File.separator + "test";
	public final static String MAIN_JAVA_FOLDER = MAIN_FOLDER + File.separator + "java" + File.separator + "com"
			+ File.separator + "framework" + File.separator + "qa";
	public final static String TEST_JAVA_FOLDER = TEST_FOLDER + File.separator + "java" + File.separator + "com"
			+ File.separator + "framework" + File.separator + "qa";
	public final static String MAIN_RESOURCE_FOLDER = MAIN_FOLDER + File.separator + "resources";
	public final static String TEST_RESOURCE_FOLDER = TEST_FOLDER + File.separator + "resources";

	public final static String CONFIG_FOLDER = TEST_RESOURCE_FOLDER + File.separator + "config";
	public final static String CONFIG_DB_FILE = CONFIG_FOLDER + File.separator + "config.xml";

	/* Logger file path */
	public final static String LOGGER_FOLDER = TEST_RESOURCE_FOLDER + File.separator + "logger";

	public final static String LIB_FOLDER = TEST_RESOURCE_FOLDER + File.separator + "lib";

	public final static String LIB_EXE_FOLDER = TEST_RESOURCE_FOLDER + File.separator + "lib" + File.separator
			+ "driver";

	public final static String CHROME_WIN_PATH = LIB_EXE_FOLDER + File.separator + "chromedriver.exe";
	public final static String IE_WIN_PATH = LIB_EXE_FOLDER + File.separator + "IEDriverServer.exe";
	public final static String PHANTOMJS_WIN_PATH = LIB_EXE_FOLDER + File.separator + "phantomjs.exe";
	public final static String GECKO_WIN_PATH = LIB_EXE_FOLDER + File.separator + "geckodriver.exe";
	public final static String EDGE_WIN_PATH = LIB_EXE_FOLDER + File.separator + "MicrosoftWebDriver.exe";

	public final static String CHROME_MAC_PATH = LIB_EXE_FOLDER + File.separator + "chromedriver";
	public final static String PHANTOMJS_MAC_PATH = LIB_EXE_FOLDER + File.separator + "phantomjs";
	public final static String GECKO_MAC_PATH = LIB_EXE_FOLDER + File.separator + "geckodriver";

	public final static String CHROME_LINUX_PATH = LIB_EXE_FOLDER + File.separator + "chromedriver_linux";
	public final static String PHANTOMJS_LINUX_PATH = LIB_EXE_FOLDER + File.separator + "phantomjs_linux";
	public final static String GECKO_LINUX_PATH = LIB_EXE_FOLDER + File.separator + "geckodriver_linux";

	public final static String DOWNLOADS_FOLDER = System.getProperty("user.home") + File.separator + "Downloads";
	public final static String SCREENSHOT_PATH = System.getProperty("user.dir") + File.separator + "screenshots";

	public static int MAX_RETRY_COUNT = 3;
}
