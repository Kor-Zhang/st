package com.st.front.service;

import java.util.List;

import com.st.front.pageModel.PageSystemddlFront;



public interface SystemddlFrontServiceI {


	List<PageSystemddlFront> querySystemddlByParentId(String id) throws Exception;

	PageSystemddlFront querySystemddlById(String id) throws Exception;





}
