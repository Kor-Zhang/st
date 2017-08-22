package com.st.front.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.BackStatic;
import com.st.back.util.BackTools;
import com.st.front.dao.SystemddlFrontDaoI;
import com.st.front.pageModel.PageSystemddlFront;
import com.st.front.service.SystemddlFrontServiceI;
import com.st.front.util.FrontTools;
import com.st.model.Systemddl;



@Service(value = "systemddlFrontService")
public class SystemddlFrontServiceImpl implements SystemddlFrontServiceI {
	private SystemddlFrontDaoI systemddlFrontDao;

	
	
	public SystemddlFrontDaoI getSystemddlFrontDao() {
		return systemddlFrontDao;
	}


	@Autowired
	public void setSystemddlFrontDao(SystemddlFrontDaoI systemddlFrontDao) {
		this.systemddlFrontDao = systemddlFrontDao;
	}



	@Override
	public List<PageSystemddlFront> querySystemddlByParentId(String id) throws Exception{
		//储存查询到的子节点
		List<Systemddl> childrens = systemddlFrontDao.get("from "+BackStatic.HQL_TABLE_NAME_SYSTEMDDL+" t where t.systemddl.id = :id order by t.rank asc"
						,FrontTools.getHashMap(new String[]{"id"},new Object[]{id}));
				
			
		List<PageSystemddlFront> retChildrens = FrontTools.copyPropertiesList(childrens, PageSystemddlFront.class);
		return retChildrens;
	}


	@Override
	public PageSystemddlFront querySystemddlById(String id) throws Exception {
		PageSystemddlFront pageSystemddl = new PageSystemddlFront();
		Systemddl systemddl = systemddlFrontDao.findById(Systemddl.class, id);
		BeanUtils.copyProperties(systemddl, pageSystemddl);
		return pageSystemddl;
	}
	
	
	
}
