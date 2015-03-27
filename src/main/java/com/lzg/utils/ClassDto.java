/**
 * Project Name:FreemarkerCode
 * File Name:ClassDto.java
 * Package Name:com.lzg.utils
 * Date:2015年3月25日下午10:41:33
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.lzg.utils;
/**
 * ClassName:ClassDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年3月25日 下午10:41:33 <br/>
 * @author   king
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ClassDto {

	private String className;
	private String type;
	private String mode;
	
	public ClassDto() {
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMode() {
		return className.replaceFirst(className.substring(0, 1),className.substring(0, 1).toUpperCase());
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
}

