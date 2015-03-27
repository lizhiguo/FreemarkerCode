/**
 * Project Name:FreemarkerCode
 * File Name:ProjectXMLReader.java
 * Package Name:com.lzg.utils
 * Date:2015年3月25日下午10:45:33
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.lzg.utils;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ClassName:ProjectXMLReader <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年3月25日 下午10:45:33 <br/>
 * @author   king
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ProjectXMLReader {

	public List<ClassDto> readFileXml(String fileName,List<ClassDto> dtos) throws DocumentException{
		// 创建saxReader对象  
        SAXReader reader = new SAXReader();  
        // 通过read方法读取一个文件 转换成Document对象  
        Document document = reader.read(new File(this.getClass().getResource("/").getPath()+fileName));  
        //获取根节点元素对象  
        Element node = document.getRootElement();
        //获得根节点下的所有节点
        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();
        //遍历所有的元素节点  
//        listNodes(node,dtos);
     // 遍历  
        ClassDto dto;
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();
            dto = new ClassDto();
            // 对节点的属性取值
            // 获取当前节点的所有属性节点  
            List<Attribute> list = e.attributes();
            for (Attribute attr : list) {
				if("className".equals(attr.getName())){
					dto.setClassName(attr.getValue());
				}else if("type".equals(attr.getName())){
					dto.setType(attr.getValue());
				}
			}
            dtos.add(dto);
        }
		return dtos;
	}
	
	/** 
     * 遍历当前节点元素下面的所有(元素的)子节点 
     *  
     * @param node 
     */  
    public void listNodes(Element node,List<ClassDto> dtos) {  
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {
        	
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  
  
        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  
  
        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();  
        // 遍历  
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e,dtos);  
        }  
    }  
}

