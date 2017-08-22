package com.st.back.officialwebsite.service;

import com.st.back.officialwebsite.exception.OwImgsAndInfoBackException;
import com.st.back.officialwebsite.pageModel.PageOwImgsAndInfoBack;
import com.st.back.officialwebsite.pageModel.PageOwImgsBack;
import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;



public interface OwImgsAndInfoBackServiceI {

	OwBackReturnJSON<PageOwImgsAndInfoBack> getImgsByInfoId(Admins onlineAdmin,
			PageOwImgsAndInfoBack pageModel) throws OwImgsAndInfoBackException;

	void deleteImgsByImgsAndInfoId(
			Admins onlineAdmin, PageOwImgsAndInfoBack pageModel) throws OwImgsAndInfoBackException;

	void uploadImgs(PageOwImgsAndInfoBack pageModel, String path) throws OwImgsAndInfoBackException;

	void UpdateImgMainByImgsAndInfoId(Admins onlineAdmin,
			String imgsAndInfoId) throws OwImgsAndInfoBackException;





}
