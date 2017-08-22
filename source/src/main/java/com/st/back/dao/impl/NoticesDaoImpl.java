package com.st.back.dao.impl;

import org.springframework.stereotype.Repository;

import com.st.back.dao.NoticesDaoI;
import com.st.dao.impl.BaseDaoImpl;
import com.st.model.Notices;

@Repository("noticesDao")
public class NoticesDaoImpl extends BaseDaoImpl<Notices> implements NoticesDaoI{
	
}
