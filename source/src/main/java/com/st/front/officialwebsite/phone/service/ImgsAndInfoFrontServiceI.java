package com.st.front.officialwebsite.phone.service;

import com.st.front.officialwebsite.phone.exception.OwImgsAndInfoFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageImgsAndInfoFront;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.model.Admins;



public interface ImgsAndInfoFrontServiceI {

	OwFrontReturnJSON<PageImgsAndInfoFront> getImgsByInfoId(PageImgsAndInfoFront pageModel) throws OwImgsAndInfoFrontException;

	PageImgsAndInfoFront getMainImgByInfoId(
			PageImgsAndInfoFront pageModel) throws OwImgsAndInfoFrontException;
	

}
