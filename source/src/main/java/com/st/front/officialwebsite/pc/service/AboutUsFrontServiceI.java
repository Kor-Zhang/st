package com.st.front.officialwebsite.pc.service;

import java.util.List;

import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;

public interface AboutUsFrontServiceI {

	OwFrontReturnJSON<PageAboutUsFront> getCarousels(PageAboutUsFront pageModel) throws OfficialwebsiteFrontException;

}
