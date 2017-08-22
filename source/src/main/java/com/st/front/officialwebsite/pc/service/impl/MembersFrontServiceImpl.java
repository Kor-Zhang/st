package com.st.front.officialwebsite.pc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.front.officialwebsite.pc.OwFrontStatic;
import com.st.front.officialwebsite.pc.dao.MembersFrontDaoI;
import com.st.front.officialwebsite.pc.exception.OfficialwebsiteFrontException;
import com.st.front.officialwebsite.pc.pageModel.PageMembersFront;
import com.st.front.officialwebsite.pc.service.MembersFrontServiceI;
import com.st.front.officialwebsite.pc.util.OwFrontReturnJSON;
import com.st.front.officialwebsite.pc.util.OwFrontTools;
import com.st.model.OfficialwebsiteMembers;
@Service(value="membersFrontService")
public class MembersFrontServiceImpl implements MembersFrontServiceI{
	//注入membersFrontDao
	private MembersFrontDaoI membersFrontDao;
	
	public MembersFrontDaoI getMembersFrontDao() {
		return membersFrontDao;
	}
	@Autowired
	public void setMembersFrontDao(MembersFrontDaoI membersFrontDao) {
		this.membersFrontDao = membersFrontDao;
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
		List<OfficialwebsiteMembers> tempRows = membersFrontDao.get(rowsHqlStirng);
		List<PageMembersFront> rows = OwFrontTools.copyPropertiesList(tempRows, PageMembersFront.class);

		//获取记录条数
		Integer total = membersFrontDao.length(lengthHqlStirng);

		retJSON.setRows(rows);
		retJSON.setTotal(total);
		return retJSON;
	}
	@Override
	public PageMembersFront getMembersById(PageMembersFront pageModel)
			throws OfficialwebsiteFrontException {
		OfficialwebsiteMembers members = membersFrontDao.findById(OfficialwebsiteMembers.class, pageModel.getId());
		PageMembersFront pageMembers = new PageMembersFront();
		BeanUtils.copyProperties(members, pageMembers);
		return pageMembers;
	}
	

}
