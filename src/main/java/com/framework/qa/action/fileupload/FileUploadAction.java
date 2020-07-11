package com.framework.qa.action.fileupload;

import java.io.File;

import com.framework.qa.action.common.CommonAction;
import com.framework.qa.action.interfaces.ActionInterface;
import com.framework.qa.logger.Logger;

/**
 * @author eldo_rajan
 */
public class FileUploadAction extends CommonAction implements ActionInterface {

    /**
     * File upload function for chrome with autoit
     *
     * @param fileName
     */
    public void autoitFileUploadChrome(String fileName) {
        Logger.info("Started the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());

        File fileLocation = new File(System.getProperty("user.dir") + File.separator + "src/test/resources/data");
        String filePath = fileLocation.getAbsolutePath() + "\\" + fileName;
        File scriptLocation = new File("src/test/resources/utils/FileUploadChrome.exe");
        String scriptPath = scriptLocation.getAbsolutePath().replace("\\", "\\\\");
        try {
            new ProcessBuilder(scriptPath, filePath, "Open").start();
            Thread.sleep(10000);
        } catch (Exception e) {
            Logger.info("Failed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + " "
                    + e.toString());
        }
        Logger.info("Completed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * File upload function for firefox with autoit
     *
     * @param fileName
     */
    public void autoitFileUploadFirefox(String fileName) {
        Logger.info("Started the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());

        File fileLocation = new File(System.getProperty("user.dir") + File.separator + "src/test/resources/data");
        String filePath = fileLocation.getAbsolutePath() + "\\" + fileName;
        File scriptLocation = new File("src/test/resources/utils/FileUploadFirefox.exe");
        String scriptPath = scriptLocation.getAbsolutePath().replace("\\", "\\\\");
        try {
            new ProcessBuilder(scriptPath, filePath, "Open").start();
            Thread.sleep(10000);
        } catch (Exception e) {
            Logger.info("Failed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + " "
                    + e.toString());
        }
        Logger.info("Completed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * File upload function for safari with applescript
     *
     * @param fileName
     */
    public void applescriptFileUploadSafari(String fileName) {
        Logger.info("Started the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());

        File fileLocation = new File(System.getProperty("user.dir") + File.separator + "src/test/resources/data");
        String filePath = fileLocation.getAbsolutePath() + "\\" + fileName;
        File scriptLocation = new File("src/test/resources/utils/FileUploadSafari.scpt");
        String scriptPath = scriptLocation.getAbsolutePath().replace("\\", "\\\\");
        try {
            String command = "osascript " + scriptPath + " " + filePath;
            Logger.info(command);
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            Thread.sleep(10000);
        } catch (Exception e) {
            Logger.info("Failed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + " "
                    + e.toString());
        }
        Logger.info("Completed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * File upload function for firefox with applescript
     *
     * @param fileName
     */
    public void applescriptFileUploadFirefox(String fileName) {
        Logger.info("Started the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());

        File fileLocation = new File(System.getProperty("user.dir") + File.separator + "src/test/resources/data");
        String filePath = fileLocation.getAbsolutePath() + "\\" + fileName;
        File scriptLocation = new File("src/test/resources/utils/FileUploadFirefox.scpt");
        String scriptPath = scriptLocation.getAbsolutePath().replace("\\", "\\\\");
        try {
            String command = "osascript " + scriptPath + " " + filePath;
            Logger.info(command);
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            Thread.sleep(10000);
        } catch (Exception e) {
            Logger.info("Failed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + " "
                    + e.toString());
        }
        Logger.info("Completed the method:" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

}
