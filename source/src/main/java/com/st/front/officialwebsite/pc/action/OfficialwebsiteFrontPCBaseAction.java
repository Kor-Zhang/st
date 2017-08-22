package com.st.front.officialwebsite.pc.action;

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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.st.action.BaseAction;
import com.st.back.util.BackTools;

@ParentPackage(value = "owFrontPackage")
@Namespace("/front/ow/pc")
public class OfficialwebsiteFrontPCBaseAction extends BaseAction{
	
}
