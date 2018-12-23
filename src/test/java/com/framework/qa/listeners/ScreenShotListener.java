package com.framework.qa.listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.framework.qa.constants.FrameworkConstants;
import com.framework.qa.logger.Logger;
import com.framework.qa.suitedata.SuiteData;

/**
 * 
 * @author eldo_rajan
 *
 */
public class ScreenShotListener extends TestListenerAdapter implements ISuiteListener {
	@Override
	public void onStart(ISuite iSuite) {

		try {
			File screenShotFolder = new File(FrameworkConstants.SCREENSHOT_PATH);
			if (screenShotFolder.exists()) {
			} else {
				screenShotFolder.mkdir();
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		File failureImageFile = null;
		SuiteData suiteData = (SuiteData) iTestResult.getTestContext().getAttribute("suiteData");
		WebDriver webDriver = suiteData.getWebdriver();
		try {
			if (!iTestResult.isSuccess()) {
				File imageFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
				String failureImageFileName = iTestResult.getMethod().getMethodName() + "_"
						+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
				failureImageFile = new File(FrameworkConstants.SCREENSHOT_PATH + File.separator + failureImageFileName);
				try {
					FileUtils.copyFile(imageFile, failureImageFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (Exception e) {
			Logger.info("Failed to take screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {

	}

	@Override
	public void onFinish(ITestContext iTestContext) {

	}

	@Override
	public void onFinish(ISuite suite) {
		File screenShotFolder = new File(FrameworkConstants.SCREENSHOT_PATH);
		try {
			createZipFile(screenShotFolder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * delete directory
	 * 
	 * @param path
	 */
	public void deleteDirectory(File path) {
		if (path == null)
			return;
		if (path.exists()) {
			for (File f : path.listFiles()) {
				if (f.isDirectory()) {
					deleteDirectory(f);
					f.delete();
				} else {
					f.delete();
				}
			}
			path.delete();
		}
	}

	public List<String> getFileNames(File folder) {
		List<String> fileName = new ArrayList<String>();
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				fileName.addAll(getFileNames(fileEntry));
			} else {
				if (fileEntry.getName().contains(".png")) {
					fileName.add(fileEntry.getName());
				}
			}
		}
		return fileName;
	}

	public void cleanupFile(String filename) {
		try {
			Logger.info("Deleting file " + filename);
			File file = new File(filename);
			if (!file.isDirectory()) {
				file.delete();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createZipFile(File path) throws Exception {
		File screenShotFolder = new File(FrameworkConstants.SCREENSHOT_PATH);

		String zipFile = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".zip";
		List<String> sourceFiles = getFileNames(screenShotFolder);

		if (sourceFiles.size() > 0) {
			byte[] buffer = new byte[1024];
			FileOutputStream fout = new FileOutputStream(FrameworkConstants.SCREENSHOT_PATH + File.separator + zipFile);
			ZipOutputStream zout = new ZipOutputStream(fout);

			for (String sourceFile : sourceFiles) {
				Logger.info("Adding file " + sourceFile);
				FileInputStream fin = new FileInputStream(
						FrameworkConstants.SCREENSHOT_PATH + File.separator + sourceFile);

				zout.putNextEntry(new ZipEntry(FrameworkConstants.SCREENSHOT_PATH + File.separator + sourceFile));
				int length;
				while ((length = fin.read(buffer)) > 0) {
					zout.write(buffer, 0, length);
				}
				zout.closeEntry();
				fin.close();

			}
			zout.close();
			Logger.info("Zip file has been created!!");
			for (String sourceFile : sourceFiles) {
				cleanupFile(FrameworkConstants.SCREENSHOT_PATH + File.separator + sourceFile);
			}
		} else {
			Logger.info("No image files to be archived!!");
		}

	}

}
