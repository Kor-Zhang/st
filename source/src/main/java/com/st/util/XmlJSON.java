package com.st.util;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import net.sf.json.xml.XMLSerializer;

import java.io.InputStream;  

import org.apache.commons.io.IOUtils;  


/**
 * 
* <p>Title: JSON-XML转换工具</p>
* <p>desc:
* <p>Copyright: Copyright(c)Gb 2012</p>
* @author http://www.ij2ee.com
* @time 上午8:20:40
* @version 1.0
* @since
 */
public class XmlJSON{

    public static String xml2JSON(String xml){
        return new XMLSerializer().read(xml).toString();
    }
    public static String json2XML(String json){
        JSONObject jobj = JSONObject.fromObject(json);
        String xml =  new XMLSerializer().write(jobj);
        return xml;
    }
    public static JSON getJSONFromXml(String xmlString) {  
        XMLSerializer xmlSerializer = new XMLSerializer();  
        JSON json = xmlSerializer.read(xmlString);  
        return json;  
    } 
  
    public static void main(String[] args) {
		String xml ="<?xml version='1.0' encoding='utf-8' ?>"+"<returnsms>"
   +" <returnstatus>Faild</returnstatus>"
   +" <message>用户名错误</message>"
   +" <remainpoint>0</remainpoint>"
    +"<taskID>0</taskID>"
    +"<successCounts>0</successCounts>"
+"</returnsms>";
		System.out.println(xml);
		System.out.println(xml2JSON(xml));
	}
    
}