package com.st.front.officialwebsite.pc.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.dao.ServiceFrontDaoI;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageServiceFront;
import com.st.front.officialwebsite.pc.service.ServiceFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.model.OfficialwebsiteService;
@Service(value="serviceFrontService")
public class ServiceFrontServiceImpl implements ServiceFrontServiceI{
	//注入serviceFrontDao
	private ServiceFrontDaoI serviceFrontDao;
	
	public ServiceFrontDaoI getServiceFrontDao() {
		return serviceFrontDao;
	}
	@Autowired
	public void setServiceFrontDao(ServiceFrontDaoI serviceFrontDao) {
		this.serviceFrontDao = serviceFrontDao;
	}
	@Override
	public List<PageServiceFront> getService(PageServiceFront pageModel)
			throws OfficialwebsiteFrontException {
		try {
			//定义查询记录及其记录条数的语句
			StringBuffer rowsHqlStringBuffer = new StringBuffer("from "+OwFrontStatic.OW_HQL_TABLE_NAME_SERVICE+" t where t.isDelete=false and t.status=1 ");
			//设置条件
			OwFrontTools.setFilterCondition(OwFrontTools.getArrayList(new StringBuffer[]{rowsHqlStringBuffer})
							, pageModel);
			//添加排序语句
			rowsHqlStringBuffer.append(" order by "+pageModel.getSort()+" "+pageModel.getOrder()+" ");
			//获取记录无需分页
			List<OfficialwebsiteService> tableRows = serviceFrontDao.get(rowsHqlStringBuffer.toString(),pageModel.getPage(),pageModel.getRows());
			//模型转化
			List<PageServiceFront> rows = OwFrontTools.copyPropertiesList(tableRows, PageServiceFront.class);
			//设置记录
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OfficialwebsiteFrontException();
		}
	}
	@Override
	public PageServiceFront getServiceById(PageServiceFront pageModel)
			throws OfficialwebsiteFrontException {
		PageServiceFront model = new PageServiceFront();
		OfficialwebsiteService service = serviceFrontDao.findById(OfficialwebsiteService.class, pageModel.getId());
		BeanUtils.copyProperties(service, model);
		return model;
	}
	

}
