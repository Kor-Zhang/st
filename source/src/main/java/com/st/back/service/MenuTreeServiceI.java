package com.st.back.service;

import java.util.List;

import com.st.back.pageModel.PageMenuTree;

public interface MenuTreeServiceI {

	List<PageMenuTree> getTree(String id);
	
}
