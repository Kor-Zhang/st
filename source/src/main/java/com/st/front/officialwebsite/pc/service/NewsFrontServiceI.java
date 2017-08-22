package com.st.front.officialwebsite.pc.service;

import java.util.List;

import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageNewsFront;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;

public interface NewsFrontServiceI {

	List<PageNewsFront> getNews(PageNewsFront pageModel) throws OfficialwebsiteFrontException;

	PageNewsFront getNewsById(PageNewsFront pageModel) throws OfficialwebsiteFrontException;


}
