package com.ssu.calories;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class NaverParse {
	public static String getContent(Element element, String tagName)
	{
		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element)list.item(0);

		if(cElement.getFirstChild()!=null){
			return cElement.getFirstChild().getNodeValue();
		}else{
			return "";
		}
	}

	public void parse(String uri, String fruit)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try
		{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(uri);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("item");

			for(int i=0; i<list.getLength();i++){
				Element element = (Element)list.item(i);
				//이부분이 출력 부분입니다.
				ImageDownloader.download(getContent(element, "thumbnail"), "C:/Temp", fruit);
				//System.out.println("책 설명(내용) : "+getContent(element, "description"));
			}
		}
		catch (ParserConfigurationException e){ 
			System.out.println(e);
		}
		catch (SAXException e){ 
			System.out.println(e);
		}
		catch(IOException e){ 
			System.out.println(e); 
		}
	}
}
