package com.gzeport.casserver.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TRoleFuncmodel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ROLE_FUNCMODEL", schema = "PORTAL")
public class TRoleFuncmodel implements java.io.Serializable {

	// Fields

	private TRoleFuncmodelId id;
	private TBaseRole TBaseRole;
	private TBaseFuncmodel TBaseFuncmodel;

	// Constructors

	/** default constructor */
	public TRoleFuncmodel() {
	}

	/** full constructor */
	public TRoleFuncmodel(TRoleFuncmodelId id, TBaseRole TBaseRole,
			TBaseFuncmodel TBaseFuncmodel) {
		this.id = id;
		this.TBaseRole = TBaseRole;
		this.TBaseFuncmodel = TBaseFuncmodel;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "funcId", column = @Column(name = "FUNC_ID", nullable = false, length = 12)) })
	public TRoleFuncmodelId getId() {
		return this.id;
	}

	public void setId(TRoleFuncmodelId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
	public TBaseRole getTBaseRole() {
		return this.TBaseRole;
	}

	public void setTBaseRole(TBaseRole TBaseRole) {
		this.TBaseRole = TBaseRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUNC_ID", nullable = false, insertable = false, updatable = false)
	public TBaseFuncmodel getTBaseFuncmodel() {
		return this.TBaseFuncmodel;
	}

	public void setTBaseFuncmodel(TBaseFuncmodel TBaseFuncmodel) {
		this.TBaseFuncmodel = TBaseFuncmodel;
	}

}