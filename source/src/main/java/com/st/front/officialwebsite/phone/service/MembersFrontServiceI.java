package com.st.front.officialwebsite.phone.service;

import java.util.List;

import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.phone.pageModel.PageMembersFront;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;

public interface MembersFrontServiceI {

	OwFrontReturnJSON<PageMembersFront> getMembersByCondition(PageMembersFront pageModel) throws OfficialwebsiteFrontException;

	PageMembersFront getMembersById(PageMembersFront pageModel) throws OfficialwebsiteFrontException;

}
