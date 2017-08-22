package com.st.back.officialwebsite.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.PubStatic;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.back.officialwebsite.service.OwNewsBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.back.officialwebsite.util.OwBackTools;
import com.st.model.Imgs;
import com.st.model.ImgsAndInfo;
public class OwNewsUploadImgsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwNewsBack>{
	private OwNewsBackServiceI owNewsBackService;
	//注入owNewsBackService
	public OwNewsBackServiceI getOwNewsBackService() {
		return owNewsBackService;
	}
	@Autowired
	public void setOwNewsBackService(
			OwNewsBackServiceI owNewsBackService) {
		this.owNewsBackService = owNewsBackService;
	}
	//注入owImgsBackService
	private OwImgsBackServiceI owImgsBackService;
	
	public OwImgsBackServiceI getOwImgsBackService() {
		return owImgsBackService;
	}
	@Autowired
	public void setOwImgsBackService(OwImgsBackServiceI owImgsBackService) {
		this.owImgsBackService = owImgsBackService;
	}
	//注入owImgsAndInfoBackService
	private OwImgsAndInfoBackServiceI owImgsAndInfoBackService;
	
	public OwImgsAndInfoBackServiceI getOwImgsAndInfoBackService() {
		return owImgsAndInfoBackService;
	}
	@Autowired
	public void setOwImgsAndInfoBackService(OwImgsAndInfoBackServiceI owImgsAndInfoBackService) {
		this.owImgsAndInfoBackService = owImgsAndInfoBackService;
	}
	//注入pageModel
	private PageOwNewsBack pageModel = new PageOwNewsBack();
	@Override
	public PageOwNewsBack getModel() {
		return pageModel;
	}

	
	/**
	 * 上传新闻的图片
	 */
	public void uploadNewsImgs(){
		OwBackReturnJSON<PageOwNewsBack> retJSON = new OwBackReturnJSON<PageOwNewsBack>();
		try {
			//copy属性
			PageOwImgsAndInfoBack pModel = new PageOwImgsAndInfoBack();
			BeanUtils.copyProperties(pageModel, pModel);
			//path
			String path = OwBackStatic.OW_PATH_NEWS_IMG;
			owImgsAndInfoBackService.uploadImgs(pModel,path);
			retJSON.setError(0);
			retJSON.setSuccess(true);
			retJSON.setMsg("上传成功");
		}catch (Exception e) {
			retJSON.setError(1);
			retJSON.setMsg("上传失败！");
			e.printStackTrace();
		}finally{
			super.writeJSON(retJSON);
		}
		
	}
}
