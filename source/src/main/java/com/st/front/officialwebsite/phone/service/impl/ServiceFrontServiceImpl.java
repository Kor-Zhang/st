package com.st.front.officialwebsite.phone.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.dao.ServiceFrontDaoI;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageServiceFront;
import com.st.front.officialwebsite.phone.service.ServiceFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.phone.util.OwFrontTools;
import com.st.model.OfficialwebsiteService;
@Service(value="serviceFrontPhoneService")
public class ServiceFrontServiceImpl implements ServiceFrontServiceI{
	//注入serviceFrontPhoneDao
	private ServiceFrontDaoI serviceFrontPhoneDao;
	
	
	public ServiceFrontDaoI getServiceFrontPhoneDao() {
		return serviceFrontPhoneDao;
	}
	@Autowired
	public void setServiceFrontPhoneDao(ServiceFrontDaoI serviceFrontPhoneDao) {
		this.serviceFrontPhoneDao = serviceFrontPhoneDao;
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
			List<OfficialwebsiteService> tableRows = serviceFrontPhoneDao.get(rowsHqlStringBuffer.toString(),pageModel.getPage(),pageModel.getRows());
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
		OfficialwebsiteService service = serviceFrontPhoneDao.findById(OfficialwebsiteService.class, pageModel.getId());
		BeanUtils.copyProperties(service, model);
		return model;
	}
	

}
