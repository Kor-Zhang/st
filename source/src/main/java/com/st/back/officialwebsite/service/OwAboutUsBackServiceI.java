package com.st.back.officialwebsite.service;

import com.st.back.exception.AdminsException;
import com.st.back.officialwebsite.exception.OfficialwebsiteBackException;
import com.st.back.officialwebsite.pageModel.PageOwAboutUsBack;
import com.st.back.officialwebsite.util.OwBackReturnJSON;
import com.st.model.Admins;


public interface OwAboutUsBackServiceI {

	OwBackReturnJSON<PageOwAboutUsBack> getDatagrid(Admins onlineAdmin,PageOwAboutUsBack pageModel) throws OfficialwebsiteBackException;

	void uploadAboutUs(Admins onlineAdmin,
			PageOwAboutUsBack pageModel) throws OfficialwebsiteBackException;

	void deleteAboutUs(Admins onlineAdmin, PageOwAboutUsBack pageModel)throws OfficialwebsiteBackException;

	void updateAboutUs(Admins onlineAdmin,
			PageOwAboutUsBack pageModel)throws AdminsException,OfficialwebsiteBackException, Exception;

	
}
