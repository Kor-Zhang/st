package com.st.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.st.dao.BaseDaoI;
@Repository(value="baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T>{
	

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * 获取当前事物的的session
	 * @return
	 */
	private Session getCurrtSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Serializable save(T obj) {
		return this.getCurrtSession().save(obj);
	}

	

	@Override
	public T find(String hql) {
		Query q = this.getCurrtSession().createQuery(hql);
		List<T> list = q.list();
		if(list!=null&&list.size()>=1){
			return list.get(0);
			
		}
		return null;
	}
	@Override
	public T find(String hql, Object[] params) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.length>0){
			Integer index = 0;
			while(index < params.length){

				q.setParameter(index, params[index]);
				index++;
			}
		}
		List<T> list = q.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
			
		}
		return null;
	}
	
	@Override
	public T find(String hql, Map<String, Object> params) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				q.setParameter(key, params.get(key));
			}
			
		}
		List<T> list = q.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
			
		}
		return null;
	}
	
	@Override
	public T findById(Class clazz, Serializable id) {
		
		return (T) this.getCurrtSession().get(clazz, id);
	}
	@Override
	public List<T> get(String hql) {
		Query q = this.getCurrtSession().createQuery(hql);
		return q.list();
	}

	@Override
	public List<T> get(String hql,Map<String,Object> params) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				q.setParameter(key, params.get(key));
			}
			
		}
		return q.list();
	}
	@Override
	public List<T> get(String hql, Map<String, Object> params, Integer page,
			Integer rows) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				q.setParameter(key, params.get(key));
			}
			
		}
		return q.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	

	@Override
	public List<T> get(String hql, Integer page, Integer rows) {
		Query q = this.getCurrtSession().createQuery(hql);
		return q.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
	@Override
	public Integer length(String hql) {
		Query q = this.getCurrtSession().createQuery(hql);
		return Integer.valueOf( q.uniqueResult().toString());
	}
	

	@Override
	public Integer length(String hql, Map<String, Object> params) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				q.setParameter(key, params.get(key));
			}
			
		}
		return Integer.valueOf(q.uniqueResult().toString());
	}

	@Override
	public void update(T obj) {
		this.getCurrtSession().update(obj);
	}
	@Override
	public void delete(T obj) {
		this.getCurrtSession().delete(obj);
	}

	@Override
	public void saveOrUpdate(T obj) {
		this.getCurrtSession().saveOrUpdate(obj);
	}

	@Override
	public Integer executeHql(String hql) {
		Query q = this.getCurrtSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public Integer executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrtSession().createQuery(hql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	

	@Override
	public Integer executeSql(String sql) {
		SQLQuery sqlQuery = this.getCurrtSession().createSQLQuery(sql);
		return sqlQuery.executeUpdate();
	}

	@Override
	public Integer executeSql(String sql, Map<String, Object> params) {
		SQLQuery sqlQuery = this.getCurrtSession().createSQLQuery(sql);
		if(params!=null&&params.size()>0){
			Set<String> set = params.keySet();
			for (String key : set) {
				sqlQuery.setParameter(key, params.get(key));
			}
		}
		return sqlQuery.executeUpdate();
	}

	

	

}
