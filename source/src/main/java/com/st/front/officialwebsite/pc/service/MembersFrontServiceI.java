package com.st.front.officialwebsite.pc.service;

import java.util.List;

import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageAboutUsFront;
import com.st.front.officialwebsite.pc.pageModel.PageMembersFront;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;

public interface MembersFrontServiceI {

	OwFrontReturnJSON<PageMembersFront> getMembersByCondition(PageMembersFront pageModel) throws OfficialwebsiteFrontException;

	PageMembersFront getMembersById(PageMembersFront pageModel) throws OfficialwebsiteFrontException;

}
