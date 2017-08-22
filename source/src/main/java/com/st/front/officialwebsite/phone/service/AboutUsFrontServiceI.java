package com.st.front.officialwebsite.phone.service;

import java.util.List;

import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;

public interface AboutUsFrontServiceI {

	OwFrontReturnJSON<PageAboutUsFront> getCarousels(PageAboutUsFront pageModel) throws OfficialwebsiteFrontException;

}
