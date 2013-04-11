package com.gzeport.casserver.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TBaseSearchLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_SEARCH_LOG", schema = "PORTAL")
public class TBaseSearchLog implements java.io.Serializable {

	// Fields

	private TBaseSearchLogId id;

	// Constructors

	/** default constructor */
	public TBaseSearchLog() {
	}

	/** full constructor */
	public TBaseSearchLog(TBaseSearchLogId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "SId", column = @Column(name = "S_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "searchRoot", column = @Column(name = "SEARCH_ROOT", length = 200)),
			@AttributeOverride(name = "fieldName", column = @Column(name = "FIELD_NAME", nullable = false, length = 50)),
			@AttributeOverride(name = "fieldTxt", column = @Column(name = "FIELD_TXT", length = 50)),
			@AttributeOverride(name = "fieldType", column = @Column(name = "FIELD_TYPE", length = 1)),
			@AttributeOverride(name = "ajaxMethod", column = @Column(name = "AJAX_METHOD", length = 200)),
			@AttributeOverride(name = "andor", column = @Column(name = "ANDOR", length = 10)),
			@AttributeOverride(name = "sortby", column = @Column(name = "SORTBY", precision = 2, scale = 0)),
			@AttributeOverride(name = "fieldValue", column = @Column(name = "FIELD_VALUE", length = 200)),
			@AttributeOverride(name = "condition", column = @Column(name = "CONDITION", length = 10)) })
	public TBaseSearchLogId getId() {
		return this.id;
	}

	public void setId(TBaseSearchLogId id) {
		this.id = id;
	}

}