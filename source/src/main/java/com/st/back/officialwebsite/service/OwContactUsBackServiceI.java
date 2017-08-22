package com.st.back.officialwebsite.service;

import com.st.back.officialwebsite.pageModel.PageOwContactUsBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;



public interface OwContactUsBackServiceI {


	OwBackReturnJSON<PageOwContactUsBack> getDatagrid(Admins onlineAdmin,
			PageOwContactUsBack pageModel) throws Exception;

	void deleteContactUs(Admins onlineAdmin, PageOwContactUsBack pageModel) throws Exception;

	void UpdateContactUsStatus(Admins onlineAdmin, PageOwContactUsBack pageModel)
			throws Exception;



}
