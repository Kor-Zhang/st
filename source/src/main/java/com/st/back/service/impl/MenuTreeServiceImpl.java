package com.st.back.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.dao.MenuTreeDaoI;
import com.st.back.pageModel.PageMenuTree;
import com.st.back.service.MenuTreeServiceI;
import com.st.back.util.BackTools;
import com.st.model.Menutree;
@Service(value="menuTreeService")
public class MenuTreeServiceImpl implements MenuTreeServiceI {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(MenuTreeServiceImpl.class);
	
	private MenuTreeDaoI menuTreeDao;

	public MenuTreeDaoI getMenuTreeDao() {
		return menuTreeDao;
	}
	@Autowired
	public void setMenuTreeDao(MenuTreeDaoI menuTreeDao) {
		this.menuTreeDao = menuTreeDao;
	}
	@Override
	public List<PageMenuTree> getTree(String id) {
		List<Menutree> menuTreeList = null;
		if(id==null||id.equals("")||id.equals("null")){
			//获取根节点
			menuTreeList = menuTreeDao.get("from Menutree m where m.menutree is null");
		}else{
			/*获取子节点*/
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("id", id);
			menuTreeList = menuTreeDao.get("from Menutree m where m.menutree.id = :id",map);
			
		}
		List<PageMenuTree> pageMenuTreeList = new ArrayList<PageMenuTree>();
		//判断是否有节点
		if(menuTreeList!=null&&!menuTreeList.isEmpty()){
			//遍历节点,设置其开闭状态和url
			for (Menutree menutree : menuTreeList) {
				PageMenuTree pageMenuTree = new PageMenuTree();
				//获取子节点
				List<Menutree> childrens = menuTreeDao.get("from Menutree t where t.menutree.id=:parentId",BackTools.getHashMap(new String[]{"parentId"}, new Object[]{menutree.getId()}));
				BeanUtils.copyProperties(menutree,pageMenuTree);
				//设置tree节点开闭状态
				if(childrens!=null&&!childrens.isEmpty()){
					pageMenuTree.setState("closed");
				}else{

					pageMenuTree.setState("opend");
				}
				//设置url
				Map<String,Object> attributes = new HashMap<String,Object>();
				attributes.put("url", menutree.getUrl());
				pageMenuTree.setAttrbutes(attributes);
				//添加节点
				pageMenuTreeList.add(pageMenuTree);
			}
		}
		return pageMenuTreeList;
	}
	
}
