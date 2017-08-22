package com.st.back.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.back.BackStatic;
import com.st.back.dao.SystemddlDaoI;
import com.st.back.exception.AdminsException;
import com.st.back.exception.SystemddlException;
import com.st.back.pageModel.PageSystemddl;
import com.st.back.service.SystemddlServiceI;
import com.st.back.util.BackTools;
import com.st.model.Admins;
import com.st.model.Systemddl;

@Service(value = "systemddlService")
public class SystemddlServiceImpl implements SystemddlServiceI {
	// 注入systemddlDao
	private SystemddlDaoI systemddlDao;

	public SystemddlDaoI getSystemddlDao() {
		return systemddlDao;
	}

	@Autowired
	public void setSystemddlDao(SystemddlDaoI systemddlDao) {
		this.systemddlDao = systemddlDao;
	}

	@Override
	public List<PageSystemddl> getSystemddlByParentId(Admins onlineAdmin,
			String id) throws AdminsException {
		// 验证1003权限（查看字典权限）
		if (!BackTools.power(onlineAdmin.getId(),
				BackStatic.POWER_ID_QUERY_SYSTEMDDL)) {
			throw new AdminsException("您没有查看字典权限！");
		}
		// 储存查询到的子节点
		List<Systemddl> childrens = null;

		if (id == null || id.equals("") || id.equals("null")) {
			// 获取根节点
			childrens = systemddlDao.get("from "
					+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL
					+ " t where t.systemddl is null order by t.rank asc");
		} else {
			/* 获取子节点 */
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			childrens = systemddlDao.get("from "
					+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL
					+ " t where t.systemddl.id = :id  order by t.rank asc", map);

		}
		//设置其闭合等状态
		List<PageSystemddl> systemddls = new ArrayList<PageSystemddl>();
		// 判断是否有节点
		if (childrens != null && !childrens.isEmpty()) {
			// 遍历节点,设置其开闭状态和url
			for (Systemddl menutree : childrens) {
				PageSystemddl systemddl = new PageSystemddl();
				// 获取子节点
				List<Systemddl> list = systemddlDao.get("from "+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL+ " t where t.systemddl.id=:parentId  order by t.rank asc", BackTools.getHashMap(new String[] { "parentId" },new Object[] { menutree.getId() }));
				BeanUtils.copyProperties(menutree, systemddl);
				// 设置tree节点开闭状态
				if (list != null && !list.isEmpty()) {
					systemddl.setState("closed");
				} else {

					systemddl.setState("opend");
				}
				// 设置url
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", menutree.getUrl());
				// 设置parentid
				attributes.put("parentId", id);
				// 设置high
				attributes.put("high", menutree.getHigh());
				// 设置currthigh
				attributes.put("currtHigh", menutree.getCurrtHigh());
				systemddl.setAttrbutes(attributes);
				// 添加节点
				systemddls.add(systemddl);
			}
		}
		return systemddls;
	}

	@Override
	public PageSystemddl addSystemddl(Admins onlineAdmin, String parentId)
			throws AdminsException, SystemddlException {
		// 验证1001权限（添加字典权限）
		if (!BackTools.power(onlineAdmin.getId(),
				BackStatic.POWER_ID_ADD_SYSTEMDDL)) {
			throw new AdminsException("您没有添加字典权限！");
		}
		// 获取指定id的父节点
		Systemddl parentSystemddl = systemddlDao.find("from "+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL+ " t where t.id = :parentId order by t.rank asc", BackTools.getHashMap(new String[] { "parentId" }, new Object[] { parentId }));
		Integer high = parentSystemddl.getHigh();
		Integer parentCurrtHigh = parentSystemddl.getCurrtHigh();
		// 如果添加固定节点
		if (parentId.equals("root")) {
			throw new SystemddlException("不能新建固定节点！");
		}
		// 如果超过了规定深度
		if (high < parentCurrtHigh + 1) {
			throw new SystemddlException("不能新建这层深度的节点！");
		}
		
		//获取当前添加的新节点的兄弟节点
		List<Systemddl> childrens = systemddlDao.get("from "+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL+ " t where t.systemddl.id = :parentId order by t.rank asc", BackTools.getHashMap(new String[] { "parentId" }, new Object[] { parentId }));
		//获取兄弟节点中的最大的rank的systemddl
		Systemddl maxRankSystemddl = null;
		if(childrens.size()>0){
			maxRankSystemddl = childrens.get(childrens.size()-1);
		}
		//获取保存新的rank
		Integer newRank = 0;
		if(maxRankSystemddl!=null&&maxRankSystemddl.getRank()!=null){
			newRank = maxRankSystemddl.getRank()+1;
		}
		
		Systemddl newSystemddl = new Systemddl();
		newSystemddl.setCurrtHigh(parentCurrtHigh + 1);
		newSystemddl.setHigh(high);
		newSystemddl.setSystemddl(parentSystemddl);
		newSystemddl.setId(UUID.randomUUID().toString());
		newSystemddl.setText("新节点"+newRank);
		newSystemddl.setRank(newRank);
		systemddlDao.save(newSystemddl);

		// 设置返回参数
		PageSystemddl pageModel = new PageSystemddl();
		BeanUtils.copyProperties(newSystemddl, pageModel);
		Map<String, Object> attrbutes = BackTools.getHashMap();
		attrbutes.put("high", newSystemddl.getHigh());
		attrbutes.put("currtHigh", newSystemddl.getCurrtHigh());
		pageModel.setAttrbutes(attrbutes);
		return pageModel;
	}

	@Override
	public void updateSystemddlText(Admins onlineAdmin, PageSystemddl pageModel)
			throws Exception {
		String oldText = null;
		String newText = null;
		// 验证1004权限（修改字典权限）
		if (!BackTools.power(onlineAdmin.getId(),
				BackStatic.POWER_ID_UPDATE_SYSTEMDDL)) {
			throw new AdminsException("您没有修改字典权限！");
		}
		// 获取指定id的节点
		Systemddl systemddl = systemddlDao.find("from "
				+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL + " t where t.id = :id",
				BackTools.getHashMap(new String[] { "id" },
						new Object[] { pageModel.getId() }));
		// 说明此id的节点为root节点
		if (systemddl == null) {
			throw new SystemddlException("该节点不存在！");
		}
		if (systemddl.getSystemddl() == null) {
			throw new SystemddlException("不能更新根节点！");
		}

		if (systemddl.getSystemddl().getId().equals("root")) {
			throw new SystemddlException("不能更新固定节点！");
		}
		// 记录旧的text
		oldText = systemddl.getText();
		// 记录新的text
		newText = pageModel.getText();
		// 设置新的text
		systemddl.setText(newText);
		systemddlDao.update(systemddl);

		// 更新外键表的信息（更新引用了该字段的表的信息）

		// 获取当前更新节点的父节点，如果某个父节点的currtHigh=1，那么终止，因为在currtHigh=1的节点上含有table和field信息
		Systemddl sd = systemddl.getSystemddl();

		// 获取table和field
		String table = null;
		String field = null;
		while (true) {
			
			// 如果查询到了根节点还是没有查到，那么结束吧
			if (sd == null) {
				break;
			}
			//获取表名
			if(sd.getCurrtHigh()==-1){
				//找到表名，字段名
				table = sd.getTb();
				// 申明sql语句
				String sql = "update " + table + " set "+field+"=replace("+field+",:oldVal,:newVal)";
				// 设置参数
				Map<String, Object> params = BackTools
						.getHashMap(new String[] { "newVal", "oldVal" },
								new Object[] { newText, oldText });
				// 执行语句
				systemddlDao.executeSql(sql, params);
				
			
				break;
			}
			// 获取表的字段名
			if (sd.getCurrtHigh() == 1 ) {
				
				field = sd.getField();
				//继续查找表名
				sd = sd.getSystemddl();
			}
						
		}

	}

	@Override
	public void deleteSystemddl(Admins onlineAdmin, PageSystemddl pageModel)
			throws AdminsException, SystemddlException {
		
		// 验证1002权限（删除字典权限）
		if (!BackTools.power(onlineAdmin.getId(),
				BackStatic.POWER_ID_DELETE_SYSTEMDDL)) {
			throw new AdminsException("您没有删除字典权限！");
		}
		//记录将要删除的记录的顺序
		Integer currtRank = -1;
		// 记录旧的text
		String oldText = null; 
		//记录父节点，限定rank的修改范围为兄弟节点
		String parentId = null;
		Systemddl systemddl = systemddlDao.find("from "
				+ BackStatic.HQL_TABLE_NAME_SYSTEMDDL + " t where t.id = :id",
				BackTools.getHashMap(new String[] { "id" },
						new Object[] { pageModel.getId() }));
		if (systemddl == null) {
			throw new SystemddlException("该节点不存在！");
		}
		// 记录旧的text
		oldText = systemddl.getText();
		
		currtRank = systemddl.getRank();
		parentId = systemddl.getSystemddl().getId();
		systemddlDao.delete(systemddl);
		
		
		
		

		//调整其他记录的顺序（更新rank）；即1变0，2变1。。。。。。
		systemddlDao.executeHql("update "+BackStatic.HQL_TABLE_NAME_SYSTEMDDL +" t set t.rank=t.rank-1 where t.systemddl.id='"+parentId+"' and t.id!='"+pageModel.getId()+"' and t.rank>"+currtRank);
				
		
		
		
		
		
		
		// 删除外键表的信息（删除引用了该字段的表的信息）

		// 获取当前更新节点的父节点，如果某个父节点的currtHigh=1，那么终止，因为在currtHigh=1的节点上含有table和field信息
		Systemddl sd = systemddl.getSystemddl();

		// 储存table和field
		String table = null;
		String field = null;
		while (true) {
			// 如果查询到了根节点还是没有查到，那么结束吧
			if (sd == null) {
				break;
			}
			//获取表名
			if(sd.getCurrtHigh()==-1){
				//找到表名，字段名
				table = sd.getTb();
				
				//清除',oldVal'
				// 申明sql语句
				String sql = "update " + table + " set "+field+"=replace("+field+",',"+oldText+"','')";
				// 执行语句
				systemddlDao.executeSql(sql);
				
				//清除'oldVal,'
				// 申明sql语句
				sql = "update " + table + " set "+field+"=replace("+field+",'"+oldText+",','')";
				// 执行语句
				systemddlDao.executeSql(sql);
				
				//清除'oldVal,'
				sql = "update " + table + " set "+field+"=replace("+field+",'"+oldText+"','')";
				// 执行语句
				systemddlDao.executeSql(sql);
				
			
				break;
			}
			// 获取表的字段名
			if (sd.getCurrtHigh() == 1 ) {
				
				field = sd.getField();
				//继续查找表名
				sd = sd.getSystemddl();
			}
			
		}
		
	}

	@Override
	public void updateSystemddlRank(Admins onlineAdmin, PageSystemddl pageModel)
			throws Exception {
		//记录旧的rank
		Integer oldRank = -1;
		//此处的rank是该节点的新的rank
		//id是新的上位的节点的id
		Integer newRank = pageModel.getRank();
		if(newRank==null||newRank<0){
			newRank = 0;
		}
		Systemddl systemddl = systemddlDao.findById(Systemddl.class, pageModel.getId());
		if(systemddl.getRank()==newRank){
			return;
		}
		oldRank = systemddl.getRank();
		systemddl.setRank(newRank);
		//跟新新的节点
		systemddlDao.update(systemddl);
		//判断移动范围，左加右减
		//向左移动
		if(oldRank>newRank){
			//获取父节点id，限定修改范围只能是兄弟节点
			String parentId = systemddl.getSystemddl().getId();
			//调整其他记录的顺序（更新rank）
			systemddlDao.executeHql("update "+BackStatic.HQL_TABLE_NAME_SYSTEMDDL +" t set t.rank=t.rank+1 where t.systemddl.id='"+parentId+"' and t.id!='"+pageModel.getId()+"' and t.rank>="+newRank +" and t.rank<="+oldRank);

			//向右移动	
		}else if(oldRank<newRank){
			//获取父节点id，限定修改范围只能是兄弟节点
			String parentId = systemddl.getSystemddl().getId();
			//调整其他记录的顺序（更新rank）
			systemddlDao.executeHql("update "+BackStatic.HQL_TABLE_NAME_SYSTEMDDL +" t set t.rank=t.rank-1 where t.systemddl.id='"+parentId+"' and t.id!='"+pageModel.getId()+"' and t.rank<="+newRank +" and t.rank>="+oldRank);
				
		}
		
			
	}

}
