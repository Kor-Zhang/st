package com.st.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.st.PubStatic;
import com.st.back.util.BackTools;
import com.st.util.PubTools;


@ParentPackage(value = "basePackage")
@Namespace("/")
public class BaseAction extends ActionSupport {
	/**
	 * 返回json数据
	 * @param o
	 */
	public void writeJSON(Object o) {
		PubTools.writeJSON(o);
	}
	
	/**
	 * 返回二进制图片
	 * @param imgFile ：需要写到response的图片文件
	 */
	public void writeImg(File imgFile){
		
		PubTools.writeImg(imgFile);
	}
	/**
	 * 将指定的文件写入返回流，相对于writeImg，多出了对异常的处理
	 * @param owPathNewsImg
	 * @param imgName
	 */
	public void writeImgByPath(String path, String imgName) {
		PubTools.writeImgByPath(path,imgName);
		
	}
	
}
