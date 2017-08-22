package com.st.pagemodel;

import java.io.File;
import java.util.List;

import com.st.back.util.BackTools;

public class BaseReceivePage {
	//基本接受参数
	private Integer total = 0;
	private Integer page = 0;
	private Integer rows = 0;
	private String sort = "id";
	private String order = "desc";
	private String searchId = "";
	private String deleteIds = "";
	//上传文件参数
	private File uploadFile;
	private String uploadFileContentType;
	private File[] uploadFiles;
	private String[] uploadFilesContentType;
	
	public File[] getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(File[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public String[] getUploadFilesContentType() {
		return uploadFilesContentType;
	}
	public void setUploadFilesContentType(String[] uploadFilesContentType) {
		this.uploadFilesContentType = uploadFilesContentType;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getDeleteIds() {
		return deleteIds;
	}
	public void setDeleteIds(String deleteIds) {
		this.deleteIds = deleteIds;
	}
	
}
