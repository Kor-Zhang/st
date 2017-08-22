package com.st.back.service;

import java.util.List;

import com.st.back.exception.AdminsException;
import com.st.back.exception.NoticesException;
import com.st.back.pageModel.PageNotices;
import com.st.back.util.BackReturnJSON;
import com.st.model.Admins;





public interface NoticesServiceI {

	void addNotices(Admins onlineAdmin, PageNotices pageModel) throws AdminsException;

	BackReturnJSON<PageNotices> getNoticesDatagrid(Admins onlineAdmin, PageNotices pageModel) throws AdminsException;

	void editNotices(Admins onlineAdmin,
			PageNotices pageModel) throws AdminsException;

	void deleteNotices(Admins onlineAdmin, PageNotices pageModel) throws AdminsException;

	PageNotices getSingleNoticeDatagridById(PageNotices pageModel) throws AdminsException, NoticesException ;

	List<PageNotices> getNoticesList(PageNotices pageModel)
			throws AdminsException;
}
