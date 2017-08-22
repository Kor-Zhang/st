package com.st.back.service;

import com.st.back.exception.AdminsException;
import com.st.back.exception.AboutUsException;
import com.st.back.pageModel.PageAboutUs;
import com.st.back.pageModel.PageAboutUsUpload;
import com.st.back.util.BackReturnJSON;
import com.st.model.Admins;

public interface IndexCarouselsServiceI {

	BackReturnJSON<PageAboutUs> getCarouselsDatagrid(Admins onlineAdmin,
			PageAboutUs pageModel) throws AdminsException;

	void indexCarouselsService(Admins onlineAdmin, PageAboutUs pageModel) throws AdminsException;

	void carouselsUpload(Admins onlineAdmin, PageAboutUsUpload pageModel) throws AdminsException, AboutUsException;
}
