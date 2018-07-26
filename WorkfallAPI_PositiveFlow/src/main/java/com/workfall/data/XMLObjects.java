package com.workfall.data;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLObjects {

	public static String getLocator(String sLocatorName) {
		try {
			NodeList nodeList;
			FileInputStream file = new FileInputStream(new File("Locators.xml"));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = "//object";
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if (eElement.getAttribute(sLocatorName).equals("")) {
					continue;
				} else {
					return eElement.getAttribute(sLocatorName);
				}
			}
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	public static String getPO_Data(String keyName) {
		try {
			NodeList nodeList = getNodeList("TestData.xml", "//PO_Data");

			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if (eElement.getAttribute(keyName).equals("")) {
					continue;
				} else {
					return eElement.getAttribute(keyName);
				}
			}
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	public static String getCEO_Data(String keyName) {
		try {
			NodeList nodeList = getNodeList("TestData.xml", "//CEO_Data");

			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if (eElement.getAttribute(keyName).equals("")) {
					continue;
				} else {
					return eElement.getAttribute(keyName);
				}
			}
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	public static String getAdmin_Data(String keyName) {
		try {
			NodeList nodeList = getNodeList("TestData.xml", "//Admin_Data");

			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if (eElement.getAttribute(keyName).equals("")) {
					continue;
				} else {
					return eElement.getAttribute(keyName);
				}
			}
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	public static String getDeveloper_Data(String keyName) {
		try {
			NodeList nodeList = getNodeList("TestData.xml", "//Developer_Data");

			for (int iCount = 0; iCount < nodeList.getLength(); iCount++) {
				Node nm = nodeList.item(iCount);
				Element eElement = (Element) nm;
				if (eElement.getAttribute(keyName).equals("")) {
					continue;
				} else {
					return eElement.getAttribute(keyName);
				}
			}
			return "0";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

	private static NodeList getNodeList(String filepath, String xpath) {
		try {
			NodeList nodeList;
			FileInputStream file = new FileInputStream(new File(filepath));
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document xmlDocument = builder.parse(file);
			XPath xPath = XPathFactory.newInstance().newXPath();
			String expression = xpath + "/data";
			nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
			return nodeList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}