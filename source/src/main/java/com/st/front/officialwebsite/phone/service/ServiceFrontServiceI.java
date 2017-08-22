package com.st.front.officialwebsite.phone.service;

import java.util.List;

import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageServiceFront;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;

public interface ServiceFrontServiceI {

	List<PageServiceFront> getService(PageServiceFront pageModel) throws OfficialwebsiteFrontException;

	PageServiceFront getServiceById(PageServiceFront pageModel) throws OfficialwebsiteFrontException;

}
