package com.st.front.officialwebsite.pc.service;

import com.st.front.officialwebsite.pc.exception.OwImgsAndInfoFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageImgsAndInfoFront;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.model.Admins;



public interface ImgsAndInfoFrontServiceI {

	OwFrontReturnJSON<PageImgsAndInfoFront> getImgsByInfoId(PageImgsAndInfoFront pageModel) throws OwImgsAndInfoFrontException;

	PageImgsAndInfoFront getMainImgByInfoId(
			PageImgsAndInfoFront pageModel) throws OwImgsAndInfoFrontException;
	

}
