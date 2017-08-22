package com.st.back.officialwebsite.service;

import com.st.back.officialwebsite.pageModel.PageOwMembersBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;


public interface OwMembersBackServiceI {

	void uploadMembers(Admins onlineAdmin, PageOwMembersBack pageModel) throws Exception;

	void updateMembers(Admins onlineAdmin, PageOwMembersBack pageModel) throws Exception;

	void deleteMembers(Admins onlineAdmin, PageOwMembersBack pageModel)
			throws Exception;

	OwBackReturnJSON<PageOwMembersBack> getDatagrid(Admins onlineAdmin,
			PageOwMembersBack pageModel) throws Exception;


}
