package com.st.back.service;

import java.util.List;

import com.st.back.exception.AdminsException;
import com.st.back.pageModel.PagePowers;
import com.st.model.Admins;





public interface PowersServiceI {

	List<PagePowers> getPowerTree(Admins onlineAdmin, PagePowers pageModel) throws AdminsException;

	void updatePowers(Admins onlineAdmin, PagePowers pageModel) throws AdminsException;

}
