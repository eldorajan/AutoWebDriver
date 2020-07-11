package com.framework.qa.logger;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

import com.framework.qa.logger.LoggerEnricher;
import com.framework.qa.logger.LoggerEnricher.EnricherFactory;


/**
 * Logger class
 *
 * @author Eldo Rajan
 */
public class Logger {

    protected static boolean isConfigured = false;
    protected static String loggerDirectory = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator +
            "resources" + File.separator + "logger";
    protected static String loggerFile = File.separator + "log4j.properties";

    /**
     * @return org.apache.log4j.Logger
     */
    public synchronized static org.apache.log4j.Logger getLogger(String logFileName) {
        if (!isConfigured) {
            PropertyConfigurator.configure(loggerDirectory + File.separator + logFileName);
            isConfigured = true;
        }

        return org.apache.log4j.Logger.getLogger(getClassName());
    }

    /**
     * @return org.apache.log4j.Logger
     */
    public synchronized static org.apache.log4j.Logger getLogger() {
        if (!isConfigured) {
            org.apache.log4j.Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);

            //Define log pattern layout
            PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} [%p] %m%n");
            //Add console appender to root logger
            org.apache.log4j.Logger.getRootLogger().addAppender(new ConsoleAppender(layout));

            //Define file appender with layout and output log file name
            RollingFileAppender fileAppender = null;
            try {
                fileAppender = new RollingFileAppender(new org.apache.log4j.HTMLLayout(), "./target/logs/Logs.html");
            } catch (IOException e1) {
            }
            fileAppender.setAppend(true);
            fileAppender.setImmediateFlush(true);

            //Add the appender to root logger
            org.apache.log4j.Logger.getRootLogger().addAppender(fileAppender);

            isConfigured = true;
        }

        return org.apache.log4j.Logger.getLogger(getClassName());
    }


    /**
     * @return the class name as a String object
     */
    public synchronized static String getClassName() {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(Thread.currentThread().getStackTrace()[4].getClassName()).getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";

    }

    /**
     * @param message
     */
    public synchronized static void debug(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.ORANGE, message);
    }

    /**
     * @param message
     * @param enricherType
     */
    public synchronized static void debug(Object message, Object enricherType) {
        if (enricherType instanceof Throwable) {
            getLogger().info(message, (Throwable) enricherType);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        } else {
            getLogger().info(message);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        }
    }

    /**
     * @param message
     */
    public synchronized static void warn(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.DEFAULT, message);
    }

    /**
     * @param message
     * @param enricherType
     */
    public synchronized static void warn(Object message, Object enricherType) {
        if (enricherType instanceof Throwable) {
            getLogger().info(message, (Throwable) enricherType);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        } else {
            getLogger().info(message);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        }
    }

    /**
     * @param message
     */
    public synchronized static void error(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.DEFAULT, message);
    }

    /**
     * @param message
     * @param enricherType
     */
    public synchronized static void error(Object message, Object enricherType) {
        if (enricherType instanceof Throwable) {
            getLogger().info(message, (Throwable) enricherType);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        } else {
            getLogger().info(message);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        }
    }

    /**
     * @param message
     */
    public synchronized static void fatal(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.DEFAULT, message);
    }

    /**
     * @param message
     * @param enricherType
     */
    public synchronized static void fatal(Object message, Object enricherType) {
        if (enricherType instanceof Throwable) {
            getLogger().info(message, (Throwable) enricherType);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        } else {
            getLogger().info(message);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        }
    }

    /**
     * @param message
     */
    public synchronized static void info(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.DEFAULT, message);

    }

    /**
     * @param message
     * @param enricherType
     */
    public synchronized static void info(Object message, Object enricherType) {
        if (enricherType instanceof Throwable) {
            getLogger().info(message, (Throwable) enricherType);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        } else {
            getLogger().info(message);
            LoggerEnricher.enrichReporterLog(enricherType, message);
        }
    }

    /**
     * @param message
     */
    public synchronized static void pass(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.BOLD_GREEN, message);

    }

    /**
     * @param message
     */
    public synchronized static void fail(Object message) {
        getLogger().info(message);
        LoggerEnricher.enrichReporterLog(EnricherFactory.BOLD_RED, message);

    }

    /**
     * @return
     */
    public synchronized static boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    /**
     * @param level
     * @return
     */
    public synchronized static boolean isEnabledFor(Priority level) {
        return getLogger().isEnabledFor(level);
    }

    /**
     * @return
     */
    public synchronized static boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }


    /**
     * @param level
     */
    public synchronized static void setLevel(Level level) {
        getLogger().setLevel(level);
    }

    public static PrintStream getPrintStream() {
        PrintStream myPrintStream = null;
        if (myPrintStream == null) {
            OutputStream output = new OutputStream() {
                private StringBuilder myStringBuilder = new StringBuilder();

                @Override
                public void write(int b) throws IOException {
                    this.myStringBuilder.append((char) b);
                }

                /**
                 * @see java.io.OutputStream#flush()
                 */
                @Override
                public void flush() {
                    if (StringUtils.isNotBlank(this.myStringBuilder.toString())) {
                        getLogger().info(this.myStringBuilder.toString());
                        myStringBuilder = new StringBuilder();
                    }
                }
            };

            myPrintStream = new PrintStream(output, true); // true: autoflush must be set!
        }
        return myPrintStream;
    }

    public static String getStackTrace(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printCredentials(String url, String username, String password) {
        Logger.info("~~~~~~~~~~~~~~~~~~~~ Credentials ~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        Logger.info("Portal URL: " + url);
        Logger.info("Credentials: " + username + "/" + password);
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

    public static void printTestDescription(String description) {
        Logger.info("~~~~~~~~~~~~~~~~~~ Test Description ~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        Logger.info("Description: " + description);
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

    public static void printTestSteps(String[] steps) {
        Logger.info("~~~~~~~~~~~~~~~~~~~~ Test Steps ~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        for (int i = 0; i < steps.length; i++) {
            Logger.info((i + 1) + ". " + steps[i]);
        }
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

    public static void printExpectedOutput(String output) {
        Logger.info("~~~~~~~~~~~~~~~~~~ Expected Output ~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        Logger.info("Expected Output: " + output);
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

    public static void printExpectedOutput(String output, String responseCode) {
        Logger.info("~~~~~~~~~~~~~~~~~~ Expected Output ~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        Logger.info("Expected Output: " + output);
        Logger.info("Expected Response Code: " + responseCode);
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

    public static void printExpectedOutput(String output, String responseCode, String responseBody) {
        Logger.info("~~~~~~~~~~~~~~~~~~ Expected Output ~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
        Logger.info("Expected Output: " + output);
        Logger.info("Expected Response Code: " + responseCode);
        Logger.info("Expected Response Body: " + responseBody);
        Logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", EnricherFactory.BOLD);
    }

}
