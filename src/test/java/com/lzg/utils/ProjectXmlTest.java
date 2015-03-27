/**
 * Project Name:FreemarkerCode
 * File Name:XmlTest.java
 * Package Name:com.lzg.utils
 * Date:2015年3月25日下午10:18:36
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.lzg.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.junit.Test;

import freemarker.template.TemplateException;

/**
 * ClassName:XmlTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年3月25日 下午10:18:36 <br/>
 * @author   king
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ProjectXmlTest {
	@Test  
    public void test() throws Exception {
		/*ProjectXMLReader px = new ProjectXMLReader();
		List<ClassDto> dtos = new ArrayList<>();
		px.readFileXml("demo/demo.xml", dtos);
		for (ClassDto classDto : dtos) {
			System.out.println(classDto.getClassName()+classDto.getType());
		}*/
		process("demo");
    }  
	private void process(String project) {
//		XMLReader xr = new XMLReader();
		ProjectXMLReader pxr = new ProjectXMLReader();
		// 类名
		/*List<String> classNameList = xr.getAllClassName(new File(System
				.getProperty("user.dir")
				+ "\\src\\com\\lhl\\"
				+ project
				+ "\\model"));*/
		List<ClassDto> dtos = new ArrayList<>();
		try {
			pxr.readFileXml("demo/demo.xml", dtos);
		} catch (DocumentException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		TemplateUtil tu = new TemplateUtil();
		// 模板名
		List<String> tempNameList = tu.getFileName();
        for (ClassDto classDto : dtos) {
        	Map<String,String> map = new HashMap<>();
        	map.put("project", "demo");
        	map.put("Name", classDto.getMode());//类名首字母大写
        	map.put("Type", classDto.getType());//实体@ID类型
        	map.put("className", classDto.getClassName());//类名首字母小写
		for (String string : tempNameList) {
			String tempName = string;
			String type = tempName.substring(0, tempName.lastIndexOf("."));
			String newJavaFile = null;
			newJavaFile = tu.getSavePath(type, project, classDto.getMode());
			try {
				SpringTemplateUnits.templateAppend(tempName, newJavaFile,
						map, tu.getTempPath());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
			
		}
        }
		/*for (int i = 0; i < classNameList.size(); i++) {
			String className = classNameList.get(i);
			String idName = xr.getIdName();
			Map<String,String> map = new HashMap<>();
			map.put("project", project);
			map.put("name", xr.changeToLower(className));
			map.put("Name", className);
			map.put("Type", "String");
			map.put("Id", xr.changeToUpper(idName));
			map.put("id", idName);
			for (int j = 0; j < tempNameList.size(); j++) {
				String tempName = tempNameList.get(j);
				String type = tempName.substring(0, tempName.lastIndexOf("."));
				String newJavaFile = null;
				newJavaFile = tu.getSavePath(type, project, className);
				try {
					SpringTemplateUnits.templateAppend(tempName, newJavaFile,
							map, tu.getTempPath());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TemplateException e) {
					e.printStackTrace();
				}
			}
		}*/
	}
   
}

