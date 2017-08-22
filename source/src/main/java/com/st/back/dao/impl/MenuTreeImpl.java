package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.MenuTreeDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Menutree;

@Repository("menuTreeDao")
public class MenuTreeImpl extends BaseDaoImpl<Menutree> implements MenuTreeDaoI {
	
}
