package com.st.front.officialwebsite.phone.service;

import java.util.List;

import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageNewsFront;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;

public interface NewsFrontServiceI {

	List<PageNewsFront> getNews(PageNewsFront pageModel) throws OfficialwebsiteFrontException;

	PageNewsFront getNewsById(PageNewsFront pageModel) throws OfficialwebsiteFrontException;

}
