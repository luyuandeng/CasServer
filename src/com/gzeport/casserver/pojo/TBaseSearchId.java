package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TBaseSearchId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TBaseSearchId implements java.io.Serializable {

	// Fields

	private Long SId;
	private String fieldTxt;
	private String fieldName;
	private String fieldType;
	private String ajaxActive;
	private String ajaxMethod;
	private Byte sortby;
	private String root;
	private String leveltype;

	// Constructors

	/** default constructor */
	public TBaseSearchId() {
	}

	/** minimal constructor */
	public TBaseSearchId(Long SId, String fieldName) {
		this.SId = SId;
		this.fieldName = fieldName;
	}

	/** full constructor */
	public TBaseSearchId(Long SId, String fieldTxt, String fieldName,
			String fieldType, String ajaxActive, String ajaxMethod,
			Byte sortby, String root, String leveltype) {
		this.SId = SId;
		this.fieldTxt = fieldTxt;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.ajaxActive = ajaxActive;
		this.ajaxMethod = ajaxMethod;
		this.sortby = sortby;
		this.root = root;
		this.leveltype = leveltype;
	}

	// Property accessors

	@Column(name = "S_ID", nullable = false, precision = 12, scale = 0)
	public Long getSId() {
		return this.SId;
	}

	public void setSId(Long SId) {
		this.SId = SId;
	}

	@Column(name = "FIELD_TXT", length = 50)
	public String getFieldTxt() {
		return this.fieldTxt;
	}

	public void setFieldTxt(String fieldTxt) {
		this.fieldTxt = fieldTxt;
	}

	@Column(name = "FIELD_NAME", nullable = false, length = 50)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "FIELD_TYPE", length = 1)
	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Column(name = "AJAX_ACTIVE", length = 1)
	public String getAjaxActive() {
		return this.ajaxActive;
	}

	public void setAjaxActive(String ajaxActive) {
		this.ajaxActive = ajaxActive;
	}

	@Column(name = "AJAX_METHOD", length = 200)
	public String getAjaxMethod() {
		return this.ajaxMethod;
	}

	public void setAjaxMethod(String ajaxMethod) {
		this.ajaxMethod = ajaxMethod;
	}

	@Column(name = "SORTBY", precision = 2, scale = 0)
	public Byte getSortby() {
		return this.sortby;
	}

	public void setSortby(Byte sortby) {
		this.sortby = sortby;
	}

	@Column(name = "ROOT", length = 200)
	public String getRoot() {
		return this.root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	@Column(name = "LEVELTYPE", length = 10)
	public String getLeveltype() {
		return this.leveltype;
	}

	public void setLeveltype(String leveltype) {
		this.leveltype = leveltype;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TBaseSearchId))
			return false;
		TBaseSearchId castOther = (TBaseSearchId) other;

		return ((this.getSId() == castOther.getSId()) || (this.getSId() != null
				&& castOther.getSId() != null && this.getSId().equals(
				castOther.getSId())))
				&& ((this.getFieldTxt() == castOther.getFieldTxt()) || (this
						.getFieldTxt() != null
						&& castOther.getFieldTxt() != null && this
						.getFieldTxt().equals(castOther.getFieldTxt())))
				&& ((this.getFieldName() == castOther.getFieldName()) || (this
						.getFieldName() != null
						&& castOther.getFieldName() != null && this
						.getFieldName().equals(castOther.getFieldName())))
				&& ((this.getFieldType() == castOther.getFieldType()) || (this
						.getFieldType() != null
						&& castOther.getFieldType() != null && this
						.getFieldType().equals(castOther.getFieldType())))
				&& ((this.getAjaxActive() == castOther.getAjaxActive()) || (this
						.getAjaxActive() != null
						&& castOther.getAjaxActive() != null && this
						.getAjaxActive().equals(castOther.getAjaxActive())))
				&& ((this.getAjaxMethod() == castOther.getAjaxMethod()) || (this
						.getAjaxMethod() != null
						&& castOther.getAjaxMethod() != null && this
						.getAjaxMethod().equals(castOther.getAjaxMethod())))
				&& ((this.getSortby() == castOther.getSortby()) || (this
						.getSortby() != null
						&& castOther.getSortby() != null && this.getSortby()
						.equals(castOther.getSortby())))
				&& ((this.getRoot() == castOther.getRoot()) || (this.getRoot() != null
						&& castOther.getRoot() != null && this.getRoot()
						.equals(castOther.getRoot())))
				&& ((this.getLeveltype() == castOther.getLeveltype()) || (this
						.getLeveltype() != null
						&& castOther.getLeveltype() != null && this
						.getLeveltype().equals(castOther.getLeveltype())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result
				+ (getFieldTxt() == null ? 0 : this.getFieldTxt().hashCode());
		result = 37 * result
				+ (getFieldName() == null ? 0 : this.getFieldName().hashCode());
		result = 37 * result
				+ (getFieldType() == null ? 0 : this.getFieldType().hashCode());
		result = 37
				* result
				+ (getAjaxActive() == null ? 0 : this.getAjaxActive()
						.hashCode());
		result = 37
				* result
				+ (getAjaxMethod() == null ? 0 : this.getAjaxMethod()
						.hashCode());
		result = 37 * result
				+ (getSortby() == null ? 0 : this.getSortby().hashCode());
		result = 37 * result
				+ (getRoot() == null ? 0 : this.getRoot().hashCode());
		result = 37 * result
				+ (getLeveltype() == null ? 0 : this.getLeveltype().hashCode());
		return result;
	}

}