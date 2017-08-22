package com.st.back.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;
import com.st.back.pageModel.PageMenuTree;
import com.st.back.service.MenuTreeServiceI;

@Action(value = "menuTreeAction")
public class MenuTreeAction extends BackBaseAction implements
		ModelDriven<PageMenuTree> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MenuTreeAction.class);

	PageMenuTree pageMenuTree = new PageMenuTree();
	private MenuTreeServiceI menuTreeService;

	public PageMenuTree getPageMenuTree() {
		return pageMenuTree;
	}

	public void setPageMenuTree(PageMenuTree pageMenuTree) {
		this.pageMenuTree = pageMenuTree;
	}

	public MenuTreeServiceI getMenuTreeService() {
		return menuTreeService;
	}

	@Autowired
	public void setMenuTreeService(MenuTreeServiceI menuTreeService) {
		this.menuTreeService = menuTreeService;
	}

	@Override
	public PageMenuTree getModel() {
		return pageMenuTree;
	}

	public void getTree() {
		List<PageMenuTree> mTree = menuTreeService.getTree(pageMenuTree.getId());
		super.writeJSON(mTree);

	}

}
