package com.gzeport.casserver.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TBaseSearch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_SEARCH", schema = "PORTAL")
public class TBaseSearch implements java.io.Serializable {

	// Fields

	private TBaseSearchId id;

	// Constructors

	/** default constructor */
	public TBaseSearch() {
	}

	/** full constructor */
	public TBaseSearch(TBaseSearchId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "SId", column = @Column(name = "S_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "fieldTxt", column = @Column(name = "FIELD_TXT", length = 50)),
			@AttributeOverride(name = "fieldName", column = @Column(name = "FIELD_NAME", nullable = false, length = 50)),
			@AttributeOverride(name = "fieldType", column = @Column(name = "FIELD_TYPE", length = 1)),
			@AttributeOverride(name = "ajaxActive", column = @Column(name = "AJAX_ACTIVE", length = 1)),
			@AttributeOverride(name = "ajaxMethod", column = @Column(name = "AJAX_METHOD", length = 200)),
			@AttributeOverride(name = "sortby", column = @Column(name = "SORTBY", precision = 2, scale = 0)),
			@AttributeOverride(name = "root", column = @Column(name = "ROOT", length = 200)),
			@AttributeOverride(name = "leveltype", column = @Column(name = "LEVELTYPE", length = 10)) })
	public TBaseSearchId getId() {
		return this.id;
	}

	public void setId(TBaseSearchId id) {
		this.id = id;
	}

}