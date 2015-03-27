package com.lzg.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ClassName:XMLReader <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年3月25日 下午6:22:12 <br/>
 * 
 * @author king
 * @version
 * @since JDK 1.8
 * @see
 */
public class XMLReader {
	private static String fileName = "";
	private static File file = null;

	public XMLReader() {
	}

	public XMLReader(String fileName) {
		this.file = new File(fileName);
	}

	public XMLReader(File file) {
		this.file = file;
	}

	public static String getIdName() {
		String id = null;
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				for (Iterator iterInner = element.elementIterator(); iterInner
						.hasNext();) {
					Element elementInner = (Element) iterInner.next();
					if (elementInner.getName().equals("id")) {
						id = elementInner.attributeValue("name");
						// System.out.println(id);
						break;
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return id;
	}

	public static String getClassFullName() {
		String className = null;
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			for (Iterator iter = root.elementIterator(); iter.hasNext();) {
				Element element = (Element) iter.next();
				if (element.getName().equals("class")) {
					className = element.attributeValue("name");
					// System.out.println(className);
					break;
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return className;
	}

	public static String getClassFullName(File file) {
		XMLReader.file = file;
		return getClassFullName();
	}

	public static String getClassName() {
		String className = getClassFullName();
		if (className != null) {
			className = className.substring(className.lastIndexOf(".") + 1,
					className.length());
		}
		return className;
	}

	public static String getClassName(File file) {
		String className = getClassFullName(file);
		if (className != null) {
			className = className.substring(className.lastIndexOf(".") + 1,
					className.length());
		}
		return className;
	}

	public static List getAllClassName(File filePath) {
		List list = new ArrayList();
		if (filePath.isDirectory()) {
			File[] files = filePath.listFiles();
			for (File file : files) {
				if (file.getName().endsWith(".xml")) {
					list.add(getClassName(file));
				}
			}
		}
		return list;
	}

	public String changeToLower(String string) {
		String temp = new String();
		if (string != null) {
			char oldChar = string.charAt(0);
			char newChar = (oldChar + "").toLowerCase().charAt(0);
			temp = string.replace(oldChar, newChar);
		}
		return new String(temp);
	}

	public String changeToUpper(String string) {
		String temp = new String();
		if (string != null) {
			char oldChar = string.charAt(0);
			char newChar = (oldChar + "").toUpperCase().charAt(0);
			temp = string.replace(oldChar, newChar);
		}
		return new String(temp);
	}

	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		XMLReader.file = file;
	}
}