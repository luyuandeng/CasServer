package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TBaseSearchLogId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TBaseSearchLogId implements java.io.Serializable {

	// Fields

	private Long SId;
	private Long userId;
	private String searchRoot;
	private String fieldName;
	private String fieldTxt;
	private String fieldType;
	private String ajaxMethod;
	private String andor;
	private Byte sortby;
	private String fieldValue;
	private String condition;

	// Constructors

	/** default constructor */
	public TBaseSearchLogId() {
	}

	/** minimal constructor */
	public TBaseSearchLogId(Long SId, Long userId, String fieldName) {
		this.SId = SId;
		this.userId = userId;
		this.fieldName = fieldName;
	}

	/** full constructor */
	public TBaseSearchLogId(Long SId, Long userId, String searchRoot,
			String fieldName, String fieldTxt, String fieldType,
			String ajaxMethod, String andor, Byte sortby, String fieldValue,
			String condition) {
		this.SId = SId;
		this.userId = userId;
		this.searchRoot = searchRoot;
		this.fieldName = fieldName;
		this.fieldTxt = fieldTxt;
		this.fieldType = fieldType;
		this.ajaxMethod = ajaxMethod;
		this.andor = andor;
		this.sortby = sortby;
		this.fieldValue = fieldValue;
		this.condition = condition;
	}

	// Property accessors

	@Column(name = "S_ID", nullable = false, precision = 12, scale = 0)
	public Long getSId() {
		return this.SId;
	}

	public void setSId(Long SId) {
		this.SId = SId;
	}

	@Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "SEARCH_ROOT", length = 200)
	public String getSearchRoot() {
		return this.searchRoot;
	}

	public void setSearchRoot(String searchRoot) {
		this.searchRoot = searchRoot;
	}

	@Column(name = "FIELD_NAME", nullable = false, length = 50)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "FIELD_TXT", length = 50)
	public String getFieldTxt() {
		return this.fieldTxt;
	}

	public void setFieldTxt(String fieldTxt) {
		this.fieldTxt = fieldTxt;
	}

	@Column(name = "FIELD_TYPE", length = 1)
	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Column(name = "AJAX_METHOD", length = 200)
	public String getAjaxMethod() {
		return this.ajaxMethod;
	}

	public void setAjaxMethod(String ajaxMethod) {
		this.ajaxMethod = ajaxMethod;
	}

	@Column(name = "ANDOR", length = 10)
	public String getAndor() {
		return this.andor;
	}

	public void setAndor(String andor) {
		this.andor = andor;
	}

	@Column(name = "SORTBY", precision = 2, scale = 0)
	public Byte getSortby() {
		return this.sortby;
	}

	public void setSortby(Byte sortby) {
		this.sortby = sortby;
	}

	@Column(name = "FIELD_VALUE", length = 200)
	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	@Column(name = "CONDITION", length = 10)
	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TBaseSearchLogId))
			return false;
		TBaseSearchLogId castOther = (TBaseSearchLogId) other;

		return ((this.getSId() == castOther.getSId()) || (this.getSId() != null
				&& castOther.getSId() != null && this.getSId().equals(
				castOther.getSId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null
						&& castOther.getUserId() != null && this.getUserId()
						.equals(castOther.getUserId())))
				&& ((this.getSearchRoot() == castOther.getSearchRoot()) || (this
						.getSearchRoot() != null
						&& castOther.getSearchRoot() != null && this
						.getSearchRoot().equals(castOther.getSearchRoot())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this
						.getFieldName() != null
						&& castOther.getFieldName() != null && this
						.getFieldName().equals(castOther.getFieldName())))
				&& ((this.getFieldTxt() == castOther.getFieldTxt()) || (this
						.getFieldTxt() != null
						&& castOther.getFieldTxt() != null && this
						.getFieldTxt().equals(castOther.getFieldTxt())))
				&& ((this.getFieldType() == castOther.getFieldType()) || (this
						.getFieldType() != null
						&& castOther.getFieldType() != null && this
						.getFieldType().equals(castOther.getFieldType())))
				&& ((this.getAjaxMethod() == castOther.getAjaxMethod()) || (this
						.getAjaxMethod() != null
						&& castOther.getAjaxMethod() != null && this
						.getAjaxMethod().equals(castOther.getAjaxMethod())))
				&& ((this.getAndor() == castOther.getAndor()) || (this
						.getAndor() != null
						&& castOther.getAndor() != null && this.getAndor()
						.equals(castOther.getAndor())))
				&& ((this.getSortby() == castOther.getSortby()) || (this
						.getSortby() != null
						&& castOther.getSortby() != null && this.getSortby()
						.equals(castOther.getSortby())))
				&& ((this.getFieldValue() == castOther.getFieldValue()) || (this
						.getFieldValue() != null
						&& castOther.getFieldValue() != null && this
						.getFieldValue().equals(castOther.getFieldValue())))
				&& ((this.getCondition() == castOther.getCondition()) || (this
						.getCondition() != null
						&& castOther.getCondition() != null && this
						.getCondition().equals(castOther.getCondition())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getSearchRoot() == null ? 0 : this.getSearchRoot()
						.hashCode());
		result = 37 * result
				+ (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		result = 37 * result
				+ (getFieldTxt() == null ? 0 : this.getFieldTxt().hashCode());
		result = 37 * result
				+ (getFieldType() == null ? 0 : this.getFieldType().hashCode());
		result = 37
				* result
				+ (getAjaxMethod() == null ? 0 : this.getAjaxMethod()
						.hashCode());
		result = 37 * result
				+ (getAndor() == null ? 0 : this.getAndor().hashCode());
		result = 37 * result
				+ (getSortby() == null ? 0 : this.getSortby().hashCode());
		result = 37
				* result
				+ (getFieldValue() == null ? 0 : this.getFieldValue()
						.hashCode());
		result = 37 * result
				+ (getCondition() == null ? 0 : this.getCondition().hashCode());
		return result;
	}

}