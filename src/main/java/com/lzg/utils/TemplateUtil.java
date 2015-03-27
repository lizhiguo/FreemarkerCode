package com.lzg.utils;

/**
 * ClassName:TemplateUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年3月25日 下午6:31:38 <br/>
 * @author   king
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.TemplateException;

public class TemplateUtil {
	private String project = null;// 项目名
	List<String> fileName = new ArrayList<>();// 模板文件名
	private String tempPath = null;// 模板文件存放路径

	public TemplateUtil() {
		setProject();
		setTempPath(null);
		setFileName();
	}

	public TemplateUtil(String tempPath) {
		setProject();
		setTempPath(tempPath);
		setFileName();
	}

	public void setProject() {
		String projectname = System.getProperty("user.dir");
		String pn = projectname.substring(projectname.lastIndexOf('\\') + 1,
				projectname.length());
		project = pn;
	}

	public void setTempPath(String tempPath) {
		if (tempPath == null) {
			this.tempPath = this.getClass().getResource("/").getPath() + "\\template";
//			this.tempPath = System.getProperty("user.dir") + "\\template";
		}
	}

	public String getTempPath() {
		return tempPath;
	}

	public List<String> getFileName() {
		return fileName;
	}

	public void setFileName() {
		File filePath = new File(tempPath);
		if (filePath.isDirectory()) {
			File[] files = filePath.listFiles();
			for (File file : files) {
				fileName.add(file.getName());
			}
		}
	}

	public String getProject() {
		return project;
	}

	public String getSavePath(String type, String project, String className) {
		String newJavaFile = null;
		String projectDir = System.getProperty("user.dir");
		if (type.equalsIgnoreCase("IRepository")) {
			newJavaFile = projectDir + "/src/main/java/com/lzg/" + project + "/repository/"
					+"I"+ className + "Repository.java";
		} else if (type.equalsIgnoreCase("Repository")) {
			newJavaFile = projectDir + "/src/main/java/com/lzg/" + project
					+ "/repository/impl/" + className + "Repository.java";
		} else if (type.equalsIgnoreCase("IService")) {
			newJavaFile = projectDir + "/src/main/java/com/lzg/" + project
					+ "/service/" + "I"+className + "Service.java";
		} else if (type.equalsIgnoreCase("Service")) {
			newJavaFile = projectDir + "/src/main/java/com/lzg/" + project
					+ "/service/impl/" + className + "Service.java";
		}
		return new String(newJavaFile);
	}

	public void processXml(String project) {
		
	}
	@SuppressWarnings({ "static-access", "unchecked" })
	public void process(String project) {
		XMLReader xr = new XMLReader();
		// 类名
		List<String> classNameList = xr.getAllClassName(new File(System
				.getProperty("user.dir")
				+ "\\src\\com\\lhl\\"
				+ project
				+ "\\model"));
		TemplateUtil tu = new TemplateUtil();
		// 模板名
		List<String> tempNameList = tu.getFileName();
		for (int i = 0; i < classNameList.size(); i++) {
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
		}
	}
}
