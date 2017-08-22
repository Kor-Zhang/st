package com.st.back.officialwebsite.service;

import com.st.back.officialwebsite.pageModel.PageOwNewsBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;


public interface OwNewsBackServiceI {

	void uploadTextNews(Admins onlineAdmin, PageOwNewsBack pageModel) throws Exception;

	OwBackReturnJSON<PageOwNewsBack> getDatagrid(Admins onlineAdmin,
			PageOwNewsBack pageModel) throws Exception;

	void deleteNews(Admins onlineAdmin, PageOwNewsBack pageModel) throws Exception;

	void updateTextNews(Admins onlineAdmin, PageOwNewsBack pageModel)
			throws Exception;

	

}
