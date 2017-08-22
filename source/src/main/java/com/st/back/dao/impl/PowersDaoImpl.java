package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.PowersDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Powers;

@Repository("powersDao")
public class PowersDaoImpl extends BaseDaoImpl<Powers> implements PowersDaoI{
	
}
