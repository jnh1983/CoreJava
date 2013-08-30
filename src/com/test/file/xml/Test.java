package com.test.file.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;

public class Test {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Element theBook = null, theElem = null, root = null;
		try {
			factory.setIgnoringElementContentWhitespace(true);

			DocumentBuilder db = factory.newDocumentBuilder();
			Document xmldoc = db.parse(new File("F:\\private\\Task\\GBS-2275\\book.xml"));
			root = xmldoc.getDocumentElement();

			String name = "Larry Niven";
			theBook = (Element) selectSingleNode("//book[author='" + name + "']", root);
			System.out.println(theBook);

//			theBook.getElementsByTagName("price").item(0).setTextContent("测试成功");
//			theBook.getElementsByTagName("memo").item(0).setTextContent("测试成功");
//			// getElementsByTagName返回的是NodeList，所以要跟上item(0)。另外，getElementsByTagName_r("price")相当于xpath的".//price"。
//			output(theBook);

//			saveXml("test1.xml", xmldoc);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void output(Node node) {// 将node的XML字符串输出到控制台
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty("encoding", "gb2312");
			transformer.setOutputProperty("indent", "yes");

			DOMSource source = new DOMSource();
			source.setNode(node);
			StreamResult result = new StreamResult();
			result.setOutputStream(System.out);

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static Node selectSingleNode(String express, Object source) {// 查找节点，并返回第一个符合条件节点
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static NodeList selectNodes(String express, Object source) {// 查找节点，返回符合条件的节点集。
		NodeList result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void saveXml(String fileName, Document doc) {// 将Document输出到文件
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty("indent", "yes");

			DOMSource source = new DOMSource();
			source.setNode(doc);
			StreamResult result = new StreamResult();
			result.setOutputStream(new FileOutputStream(fileName));

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
