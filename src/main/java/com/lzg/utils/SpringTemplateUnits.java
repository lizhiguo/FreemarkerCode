package com.lzg.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * ClassName:SpringTemplateUnits <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年3月25日 下午6:33:44 <br/>
 * 
 * @author king
 * @version
 * @since JDK 1.8
 * @see
 */
public class SpringTemplateUnits {

	public static String pageEncoding = "UTF-8";

	@SuppressWarnings("unchecked")
	public static boolean templateAppend(String ftlName, String targetFileName,
			Map map, String relPath) throws IOException, TemplateException {
		init(ftlName, targetFileName, map, relPath);
		return true;
	}

	public static void init(String ftl, String targetName, Map map,
			String relPath) throws IOException, TemplateException {
		Configuration freemarkerCfg = new Configuration();
		freemarkerCfg.setDirectoryForTemplateLoading(new File(relPath));
		freemarkerCfg.setEncoding(Locale.getDefault(), pageEncoding);
		Template template = freemarkerCfg.getTemplate(ftl, pageEncoding);
		template.setEncoding("UTF-8");
		File temp = new File(targetName);
		String dir = targetName.substring(0, targetName.lastIndexOf("/") + 1);
		File dirs = new File(dir);
		if (!dirs.exists()) {
			dirs.mkdirs();
		}
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(temp), pageEncoding));
		template.process(map, out);
		out.flush();
		out.close();
	}
}