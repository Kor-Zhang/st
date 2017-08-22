package com.st.back.service;

import java.util.List;

import com.st.back.exception.AdminsException;
import com.st.back.exception.SystemddlException;
import com.st.back.pageModel.PageSystemddl;
import com.st.back.util.BackReturnJSON;
import com.st.model.Admins;

public interface SystemddlServiceI {

	
  
	List<PageSystemddl> getSystemddlByParentId(Admins onlineAdmin,
			String id) throws AdminsException;

	PageSystemddl addSystemddl(Admins onlineAdmin, String parentId) throws AdminsException,SystemddlException;

	void updateSystemddlText(Admins onlineAdmin, PageSystemddl pageModel)throws Exception;

	void deleteSystemddl(Admins onlineAdmin, PageSystemddl pageModel) throws AdminsException,SystemddlException ;

	void updateSystemddlRank(Admins onlineAdmin, PageSystemddl pageModel) throws Exception ;




}
