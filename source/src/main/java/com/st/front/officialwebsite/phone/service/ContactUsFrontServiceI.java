package com.st.front.officialwebsite.phone.service;

import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageContactUsFront;

public interface ContactUsFrontServiceI {

	void addContactUs(PageContactUsFront pageModel) throws OfficialwebsiteFrontException;

}
