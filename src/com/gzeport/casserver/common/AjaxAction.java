package com.gzeport.casserver.common;

import java.util.Map;

public class AjaxAction {
	
	private String action;
	
	private Integer rowId;
	
	private String img;
	
	public AjaxAction(String message,String action,Integer rowId,String img,Map key) {
		this.action = action;
		this.rowId = rowId;
		this.img = img;
	}
	
	public AjaxAction() {
	}	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

}
