package com.st.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.st.back.util.BackTools;
/**
 * 放置于application的一个map集合
 * @author Jhon
 *
 * @param <K>
 * @param <V>
 */
public class SessionMap<K,V>{
	private Map<K,V> sessionMap = null;
	private ServletContext app = null;
	private String mapName = "";
	
	
	
	public SessionMap(String mapName) {
		this.mapName = mapName;
		this.app = BackTools.getSession().getServletContext();
		//如果app中含有sessionmap，那么获取
		Map<K,V> sessionMap = (Map<K, V>) this.app.getAttribute(mapName);
		if(sessionMap==null){
			//初始化map
			this.sessionMap = new HashMap<K,V>();
			//存入map到app
			this.app.setAttribute(mapName, this.sessionMap);
		}else{
			//初始化map
			this.sessionMap = sessionMap;
			
		}
		
	}
	

	/**
	 * 获取app中的map
	 * @return
	 */
	private Map<K, V> getSessionMap(String mapName) {
		return (Map<K, V>) app.getAttribute(mapName);
	}

	/**
	 * 设置map到app
	 * @param mapName
	 */
	private void setSessionMap(String mapName,Map<K, V> sessionMap) {
		app.removeAttribute(mapName);
		app.setAttribute(mapName,sessionMap);
	}

	/**
	 * 添加参数
	 * @param key
	 * @param value
	 */
	public void addAttribute(K key,V value){
		Map<K,V> sessionMap = this.getSessionMap(this.mapName);
		sessionMap.put(key, value);
		this.setSessionMap(mapName, sessionMap);
		
	}
	/**
	 * 移除参数
	 * @param key
	 */
	public void removeAttribute(String key){
		Map<K,V> sessionMap = this.getSessionMap(this.mapName);
		sessionMap.remove(key);
		this.setSessionMap(mapName, sessionMap);
		
	}
	/**
	 * 获取参数
	 * @param key
	 * @return
	 */
	public V getAttribute(String key){
		Map<K,V> sessionMap = this.getSessionMap(this.mapName);
		V value = sessionMap.get(key);
		return value;
	}
	/**
	 * 查看是否包含元素
	 * @param key
	 * @return
	 */
	public <K,V> boolean containKey(K key){
		Map<K, V> sessionMap = (Map<K, V>) this.getSessionMap(this.mapName);
		V value = sessionMap.get(key);
		if(value!=null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取sessionmap的所有values
	 * @return
	 */
	public List<V> getValues(){
		Map<K, V> sessionMap = (Map<K, V>) this.getSessionMap(this.mapName);
		Set<K> keysSet = sessionMap.keySet();
		List<V> list = BackTools.getArrayList();
		for (K k : keysSet) {
			list.add(sessionMap.get(k));
		}
		return list;
		
	}
	/**
	 * 获取sessionmap的所有key
	 * @return
	 */
	public List<K> getKeys(){
		Map<K, V> sessionMap = (Map<K, V>) this.getSessionMap(this.mapName);
		Set<K> keysSet = sessionMap.keySet();
		List<K> list = BackTools.getArrayList();
		for (K k : keysSet) {
			list.add(k);
		}
		return list;
		
	}
}
