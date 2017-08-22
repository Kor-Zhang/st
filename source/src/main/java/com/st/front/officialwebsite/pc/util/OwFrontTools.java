package com.st.front.officialwebsite.pc.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.util.FrontTools;
import com.st.util.PubTools;

public class OwFrontTools extends FrontTools{
	/**
	 * 将pageModel中的条件添加到hqls中，采用“或”拼凑条件
	 * @param hqls：需要过滤的条件
	 * @param pageModel：
	 */
	public static <T> void setFilterCondition(List<StringBuffer> hqls,T pageModel){
		try {
			// 保存搜索的条件的集合
			Map<String, Object> eqMap = PubTools.getHashMap();

			// 获取非检索字段
			Field[] fields = pageModel.getClass().getDeclaredFields();

			// 遍历字段，收集参数
			for (int j = 0; j < fields.length; j++) {
				fields[j].setAccessible(true);
				// 当前字段名
				String fieldName = fields[j].getName();
				// 以search，eq，min，max开头的字段，便是需要检索的字段
				if ( fieldName.indexOf("eq") == 0) {
					// 数据库中该字段的列名
					String searchTableColName = "";
					if (fieldName.indexOf("eq") == 0) {
						searchTableColName = fieldName.replaceAll("eq", "");
						// 将第一个字母小写
						searchTableColName = PubTools
								.firstLetterToLowerCase(searchTableColName);
						// 获取对象指定字段的值，即需要搜索字段的值
						Object fieldValue = PubTools.getFieldValue(fields[j],
								pageModel);
						// 放入集合
						eqMap.put(searchTableColName, fieldValue);
						
					}

				}
			}

			// 将所有的map条件添加到hql语句
			// eq条件添加到hql
			Set<String> fieldNames = eqMap.keySet();
			for (String fieldName : fieldNames) {
				Object fieldValue = eqMap.get(fieldName);
				if (fieldValue != null) {

					// 采取何种查询
					for (StringBuffer hql : hqls) {
						// 将类型转化为varchar进行查询

						
					
						// 填写参数
						String[] pas = fieldValue.toString().split(",");
						int index= 0;
						hql.append(" and (");
						for(index= 0;index<pas.length;index++){
							String str = pas[index];
							hql.append(" t." + fieldName + " LIKE '%%,"+str+",%%' or t." + fieldName + " LIKE '%%,"+str+"' or t." + fieldName + " LIKE '"+str+",%%'  or t." + fieldName + " = '"+str+"'");
							if(index+1<pas.length){
								hql.append(" or ");
							}else{

								hql.append(") ");
							}
						}
						
						
						
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
