package com.gzeport.casserver.pojo;

import java.util.List;

public class UserCasInfo {
	private String userInfo;
	
	private String companyInfo;
	private List<FuncModel> systemListl;
	private List<FuncModel> systemFuncModel;
	public String getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	public List<FuncModel> getSystemListl() {
		return systemListl;
	}
	public void setSystemListl(List<FuncModel> systemListl) {
		this.systemListl = systemListl;
	}
	public List<FuncModel> getSystemFuncModel() {
		return systemFuncModel;
	}
	public void setSystemFuncModel(List<FuncModel> systemFuncModel) {
		this.systemFuncModel = systemFuncModel;
	}
	

}
