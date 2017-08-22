package com.st.front.officialwebsite.phone.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.phone.OwFrontStatic;
import com.st.front.officialwebsite.phone.dao.MembersFrontDaoI;
import com.st.front.officialwebsite.phone.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.phone.pageModel.PageMembersFront;
import com.st.front.officialwebsite.phone.service.MembersFrontServiceI;
import com.st.front.officialwebsite.phone.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.phone.util.OwFrontTools;
import com.st.model.OfficialwebsiteMembers;
@Service(value="membersFrontPhoneService")
public class MembersFrontServiceImpl implements MembersFrontServiceI{
	//注入membersFrontPhoneDao
	private MembersFrontDaoI membersFrontPhoneDao;
	
	
	public MembersFrontDaoI getMembersFrontPhoneDao() {
		return membersFrontPhoneDao;
	}
	@Autowired
	public void setMembersFrontPhoneDao(MembersFrontDaoI membersFrontPhoneDao) {
		this.membersFrontPhoneDao = membersFrontPhoneDao;
	}
	@Override
	public OwFrontReturnJSON<PageMembersFront> getMembersByCondition(PageMembersFront pageModel)
			throws OfficialwebsiteFrontException {
		OwFrontReturnJSON<PageMembersFront> retJSON = new OwFrontReturnJSON<PageMembersFront>();
		//定义查询记录及其记录条数的语句
		StringBuffer rowsHqlStringBuffer = new StringBuffer("from "+OwFrontStatic.OW_HQL_TABLE_NAME_MEMBERS+" t where t.isDelete=false and t.status=1 ");
		StringBuffer lengthHqlStringBuffer = new StringBuffer("select count(*) from "+OwFrontStatic.OW_HQL_TABLE_NAME_MEMBERS+" t where 1=1 ");
		//设置条件
		OwFrontTools.setFilterCondition(OwFrontTools.getArrayList(new StringBuffer[]{lengthHqlStringBuffer,rowsHqlStringBuffer})
				, pageModel);
		String rowsHqlStirng = rowsHqlStringBuffer.toString();
		String lengthHqlStirng = lengthHqlStringBuffer.toString();
		OwFrontStatic.L.info(rowsHqlStirng.toString());
		OwFrontStatic.L.info(lengthHqlStirng.toString());
		//获取记录
		List<OfficialwebsiteMembers> tempRows = membersFrontPhoneDao.get(rowsHqlStirng);
		List<PageMembersFront> rows = OwFrontTools.copyPropertiesList(tempRows, PageMembersFront.class);

		//获取记录条数
		Integer total = membersFrontPhoneDao.length(lengthHqlStirng);

		retJSON.setRows(rows);
		retJSON.setTotal(total);
		return retJSON;
	}
	@Override
	public PageMembersFront getMembersById(PageMembersFront pageModel)
			throws OfficialwebsiteFrontException {
		OfficialwebsiteMembers members = membersFrontPhoneDao.findById(OfficialwebsiteMembers.class, pageModel.getId());
		PageMembersFront pageMembers = new PageMembersFront();
		BeanUtils.copyProperties(members, pageMembers);
		return pageMembers;
	}
	

}
