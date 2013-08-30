package com.test.file.xml;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.globalsight.everest.webapp.pagehandler.PageHandler;
import com.sun.org.apache.xerces.internal.dom.AttributeMap;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

/*
 * XPath Tutorial
 * http://www.w3school.com.cn/xpath/xpath_syntax.asp
 * 
 * Java Tutorial
 * http://www.ibm.com/developerworks/library/x-javaxpathapi/index.html
 */
public class XPathExample {

	private static final Logger log = Logger.getLogger(XPathExample.class);
	private static Element root;
	
	public static Element getRoot() {
		if (root == null) {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder;
			Document doc;
			try {
				builder = domFactory.newDocumentBuilder();
				doc = builder.parse("F:\\private\\Task\\GBS-2275\\book.xml");
				root = doc.getDocumentElement();
			} catch (Exception e) {
				log.error(e);
			}
		}
		return root;
	}
	
	public static void testIBM() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//book[author='Neal Stephenson']/title/text()");

		Object result = expr.evaluate(getRoot(), XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
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
	
	public static String getNodePath(Node p_node){
		String tag = "-->";
		StringBuilder result = new StringBuilder();
		result.insert(0, tag + p_node.getNodeName());
		
		for(Node parent=p_node.getParentNode(); parent!=null && !parent.getNodeName().equals("#document"); parent=parent.getParentNode()){
			result.insert(0, tag + parent.getNodeName());
		}
		
//		System.out.println(result.substring(tag.length()));
		return result.substring(tag.length());
	}
	
	public static String getNodeAttribute(Node p_node){
		StringBuilder result = new StringBuilder();
		AttributeMap map = (AttributeMap) p_node.getAttributes();
		for(int i=0; i<map.getLength(); i++){
			result.append(map.item(i) + ", ");
		}

		if (result.length() == 0) {
			return "[]";
		} else {
			return "[" + result.substring(0, result.lastIndexOf(",")) + "]";
		}
	}
	
	public static void printNodePath(Node p_node){
		StringBuilder result = new StringBuilder();
		result.append(getNodePath(p_node));
		switch (p_node.getNodeType()) {
		case Node.TEXT_NODE:
			result.append(p_node);
			break;
		default:
			result.append(getNodeAttribute(p_node));
		}
		
		System.out.println(result);
	}
	
	public static void testXPath(){
		String express;
		express = "/configuration";
		express = "/configuration/book";
		express = "//book";
		express = "//book[@year='2000']";
		express = "//title";
		express = "//title/text()";

		NodeList nodes = selectNodes(express, getRoot());
		for(int i=0; i<nodes.getLength(); i++){
			Node node = nodes.item(i);
			printNodePath(node);
		}
	}
	
	public static void testGetAttribute(String p_express, String p_attName) {
		Node node = selectSingleNode(p_express, getRoot());
		Node attNode = node.getAttributes().getNamedItem(p_attName);
		if (attNode != null) {
//			System.out.println("Node:" + attNode);
			System.out.println("NodeValue:" + attNode.getNodeValue());
			System.out.println("NodeName:" + attNode.getNodeName());
			System.out.println("NodeType:" + getNodeTypeName(attNode));
		} else {
			System.out.println("All Attributies are " + getNodeAttribute(node));
		}
	}
	
	public static String getNodeTypeName(Node p_node){
		switch(p_node.getNodeType()){
		case Node.ELEMENT_NODE:
			return "ELEMENT_NODE";
		case Node.ATTRIBUTE_NODE:
			return "ATTRIBUTE_NODE";
		case Node.TEXT_NODE:
			return "TEXT_NODE";
		case Node.CDATA_SECTION_NODE:
			return "CDATA_SECTION_NODE";
		default: 
			return "Else";
		}
	}
	
	public static void testGetText(){
		String express;
		express = "//title/text()";
		express = "//files/file/text()";
		NodeList nodes = selectNodes(express, getRoot());
		for(int i=0; i<nodes.getLength(); i++){
			Node node = nodes.item(i);
			printNodeValue(node);
		}
	}
	
	public static void printNodeValue(Node p_node){
		switch (p_node.getNodeType()) {
		case Node.TEXT_NODE:
			System.out.println("["+p_node.getParentNode().getNodeName()+"="+p_node.getNodeValue()+"]");
			break;
		default:
			System.out.println(p_node);
		}
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {

		/*DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse("F:\\private\\Task\\GBS-2275\\book.xml");

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		XPathExpression expr = xpath.compile("//book[author='Neal Stephenson']/title/text()");

		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}*/
		
//		testXPath();
//		testGetText();
		testGetAttribute( "//config", "isRun");
	}
}