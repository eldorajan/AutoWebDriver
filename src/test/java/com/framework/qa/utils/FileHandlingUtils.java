package com.framework.qa.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.framework.qa.logger.Logger;

/**
 * 
 * @author eldo_rajan
 *
 */
public class FileHandlingUtils {

	/**
	 * @param dataLocationConstant
	 * @return
	 */
	public static String getFileAbsolutePath(String dataLocationConstant) {
		return org.apache.commons.io.FilenameUtils.separatorsToSystem(dataLocationConstant);
	}

	/**
	 * @param relativeFilePath
	 * @return
	 */
	public static Map<String, String> readPropertyFile(String relativeFilePath) {

		Map<String, String> ApiMap = new HashMap<String, String>();
		try {
			File fXmlFile = new java.io.File(
					FilenameUtils.separatorsToSystem(getFileAbsolutePath(relativeFilePath)).trim());
			Reader input = new FileReader(fXmlFile);
			StringWriter output = new StringWriter();
			try {
				IOUtils.copy(input, output);
			} finally {
				input.close();
			}
			String fileContents = output.toString();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setNamespaceAware(true);
			dbf.setFeature("http://xml.org/sax/features/namespaces", false);
			dbf.setFeature("http://xml.org/sax/features/validation", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(fileContents));
			Document doc = dBuilder.parse(inputSource);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("entry");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					ApiMap.put(nNode.getAttributes().getNamedItem("key").getNodeValue(),
							((Element) nNode).getTextContent());
					nNode.getTextContent();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ApiMap;
	}

	public static void makeDriverExectuable(String driverPath) {
		Process p = null;
		try {
			p = Runtime.getRuntime().exec("chmod +x " + driverPath);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = null;
			while ((s = br.readLine()) != null)
				Logger.info("line: " + s);
			p.waitFor();
			Logger.info("exit: " + p.exitValue());

		} catch (Exception e) {

		} finally {
			p.destroy();
		}
	}
}