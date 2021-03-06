package com.st.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseDaoI<T>{
	/**
	 * 添加新纪录
	 * @author Jhon
	 * @param obj
	 * @return
	 */
	public Serializable save(T obj);
	/**
	 * 按id删除记录
	 * @author Jhon
	 * @param obj
	 */
	public void delete(T obj);
	/**
	 * 查询一条记录
	 * @author Jhon
	 * @param obj
	 * @return
	 */
	public T find(String hql);
	/**
	 * 查询一条记录
	 * @author Jhon
	 * @param obj
	 * @return
	 */
	@Deprecated  
	public T find(String hql,Object[] params);
	/**
	 * 查询一条记录
	 * @author Jhon
	 * @param obj
	 * @return
	 */
	public T find(String hql,Map<String,Object> params);
	/**
	 * 通过id查询一条记录
	 * @author Jhon
	 * @param class1
	 * @param id
	 * @return
	 */
	public T findById(Class<T> clazz,Serializable id);
	/**
	 * 
	 * 查询记录集合
	 * @author Jhon
	 * @param hql
	 * @return
	 */
	public List<T> get(String hql);
	/**
	 * 
	 * 查询记录集合
	 * @author Jhon
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> get(String hql,Map<String,Object> params);
	/**
	 * 分页查询，传递条件
	 * @author Jhon
	 * @param hql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> get(String hql,Map<String,Object> params,Integer page,Integer rows);
	/**
	 * 分页查询，不传递条件
	 * @author Jhon
	 * @param hql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<T> get(String hql,Integer page,Integer rows);
	/**
	 * 
	 * 获取记录数，传递参数
	 * @author Jhon
	 * @param hql
	 * @return
	 */
	public Integer length(String hql);
	/**
	 * 
	 * 获取记录数，传递参数
	 * @author Jhon
	 * @param hql
	 * @param params
	 * @return
	 */
	public Integer length(String hql,Map<String,Object> params);
	/**
	 * 更新一条记录
	 * @author Jhon
	 * @param obj
	 */
	public void update(T obj);
	/**
	 * 存在该条记录则更新，不存在则添加
	 * @author Jhon
	 * @param obj
	 */
	public void saveOrUpdate(T obj);
	/**
	 * 执行hql语句
	 * @author Jhon
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql);
	
	/**
	 * 执行hql语句，携带参数
	 * @author Jhon
	 * @param hql
	 * @param params
	 * @return
	 */
	public Integer executeHql(String hql,Map<String,Object> params);
	/**
	 * 执行sql语句
	 * @author Jhon
	 * @param sql
	 * @return
	 */
	public Integer executeSql(String sql);
	
	/**
	 * 执行sql语句，携带参数
	 * @author Jhon
	 * @param sql
	 * @param params
	 * @return
	 */
	public Integer executeSql(String sql,Map<String,Object> params);
}
