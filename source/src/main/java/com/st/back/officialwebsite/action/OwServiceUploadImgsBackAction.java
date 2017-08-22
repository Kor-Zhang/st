package com.st.back.officialwebsite.action;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.officialwebsite.OwBackStatic;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwServiceBack;
import com.st.back.officialwebsite.service.OwImgsAndInfoBackServiceI;
import com.st.back.officialwebsite.service.OwImgsBackServiceI;
import com.st.back.officialwebsite.service.OwServiceBackServiceI;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
public class OwServiceUploadImgsBackAction extends OfficialwebsiteBackBaseAction  implements ModelDriven<PageOwServiceBack>{
	private OwServiceBackServiceI owServiceBackService;
	//注入owServiceBackService
	public OwServiceBackServiceI getOwServiceBackService() {
		return owServiceBackService;
	}
	@Autowired
	public void setOwServiceBackService(
			OwServiceBackServiceI owServiceBackService) {
		this.owServiceBackService = owServiceBackService;
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
	private PageOwServiceBack pageModel = new PageOwServiceBack();
	@Override
	public PageOwServiceBack getModel() {
		return pageModel;
	}

	
	/**
	 * 上传新闻的图片
	 */
	public void uploadServiceImgs(){
		OwBackReturnJSON<PageOwServiceBack> retJSON = new OwBackReturnJSON<PageOwServiceBack>();
		try {
			//copy属性
			PageOwImgsAndInfoBack pModel = new PageOwImgsAndInfoBack();
			BeanUtils.copyProperties(pageModel, pModel);
			//path
			String path = OwBackStatic.OW_PATH_SERVICE_IMG;
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
