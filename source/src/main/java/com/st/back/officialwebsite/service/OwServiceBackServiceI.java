package com.st.back.officialwebsite.service;

import com.st.back.officialwebsite.pageModel.PageOwServiceBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;


public interface OwServiceBackServiceI {

	OwBackReturnJSON<PageOwServiceBack> getDatagrid(Admins onlineAdmin,
			PageOwServiceBack pageModel) throws Exception;

	void uploadTextService(Admins onlineAdmin, PageOwServiceBack pageModel) throws Exception;

	void updateTextService(Admins onlineAdmin, PageOwServiceBack pageModel) throws Exception;

	void deleteService(Admins onlineAdmin, PageOwServiceBack pageModel) throws Exception;

	

	
}
