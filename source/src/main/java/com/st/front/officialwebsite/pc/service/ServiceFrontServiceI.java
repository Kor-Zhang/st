package com.st.front.officialwebsite.pc.service;

import java.util.List;

import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageServiceFront;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;

public interface ServiceFrontServiceI {

	List<PageServiceFront> getService(PageServiceFront pageModel) throws OfficialwebsiteFrontException;

	PageServiceFront getServiceById(PageServiceFront pageModel) throws OfficialwebsiteFrontException;

}
