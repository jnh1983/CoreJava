package com.gs.test.xml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class XMLDataCheck
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        XMLDataCheck test = new XMLDataCheck();
        String xmlData;
        
        xmlData = "aaa<TITLE>Computer Parts</TITLE>";
        System.out.println(test.checkIfXMLIsWellFormed(xmlData)+"\t"+xmlData);
        
        xmlData = "<TITLE>Computer Parts</TITLE>";
        System.out.println(test.checkIfXMLIsWellFormed(xmlData)+"\t"+xmlData);
        
        xmlData = "&lt;ITEM&gt;Motherboard&lt;/ITEM&gt;";
        System.out.println(test.checkIfXMLIsWellFormed(xmlData)+"\t"+xmlData);
        
        xmlData = "AAA&lt;ITEM&gt;Motherboard&lt;/ITEM&gt;";
        System.out.println(test.checkIfXMLIsWellFormed(xmlData)+"\t"+xmlData);
        
    }

    public boolean checkIfXMLIsWellFormed1(String p_xmlData)
    {
        boolean result = false;
        try
        {            
            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            InputStream inputStream = new ByteArrayInputStream(p_xmlData.getBytes());
            InputSource source = new InputSource(inputStream);
            Document document = factory.newDocumentBuilder().parse(source); 

            //System.out.println(p_xmlData + " is well-formed!");
            result = true;

        }
        catch (ParserConfigurationException e)
        {
            //System.out.println(p_xmlData + "Is not well-formed");
        }
        catch (SAXException se)
        {
            //System.out.println("SAXException:"+se.getMessage());
        }
        catch (IOException io)
        {
            //System.out.println("IOException:"+io.getMessage());
        }
        
        return result;

    }
    
    /*
     * The XML data must be well-formed, otherwise SAX will throw exception.
     */
    public boolean checkIfXMLIsWellFormed(String p_xmlData)
    {
        boolean result = false;
        
        String xmlData = p_xmlData;
        if(xmlData.startsWith("&lt;") && xmlData.endsWith("&gt;"))
        {
            xmlData = xmlData.replace("&lt;", "<").replace("&gt;", ">");
        }
        
        try
        {            
            DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
            InputSource source = new InputSource(new ByteArrayInputStream(xmlData.getBytes()));
            factory.newDocumentBuilder().parse(source); 

            result = true;
        }
        catch (Exception e)
        {
        }
        
        return result;
    }
    
    public void checkIfXMLIsWellFormedFromData(String xmlData)
    {
        try
        {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            //InputStream input = new InputStream(xmlData);
            reader.parse(xmlData);
        }
        catch (SAXException e)
        {
            System.out.println(xmlData + "Is not well-formed");
        }
        catch (IOException io)
        {
            System.out.println(io.getMessage());
        }

    }
    
    public void checkIfXMLIsWellFormedFromFileName(String aXml)
    {
        try
        {
            File file = new File(aXml);
            
            if (file.exists())
            {
                XMLReader reader = XMLReaderFactory.createXMLReader();
                reader.parse(aXml);

            }
            else
            {
                System.out.println("File not Found");
            }

        }
        catch (SAXException e)
        {
            System.out.println(aXml + "Is not well-formed");
        }
        catch (IOException io)
        {
            System.out.println(io.getMessage());
        }

    }

}
