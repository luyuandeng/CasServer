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
 * TUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_ROLE", schema = "PORTAL")
public class TUserRole implements java.io.Serializable {

	// Fields

	private TUserRoleId id;
	private TBaseUser TBaseUser;
	private TBaseRole TBaseRole;

	// Constructors

	/** default constructor */
	public TUserRole() {
	}

	/** full constructor */
	public TUserRole(TUserRoleId id, TBaseUser TBaseUser, TBaseRole TBaseRole) {
		this.id = id;
		this.TBaseUser = TBaseUser;
		this.TBaseRole = TBaseRole;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false, precision = 12, scale = 0)) })
	public TUserRoleId getId() {
		return this.id;
	}

	public void setId(TUserRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public TBaseUser getTBaseUser() {
		return this.TBaseUser;
	}

	public void setTBaseUser(TBaseUser TBaseUser) {
		this.TBaseUser = TBaseUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
	public TBaseRole getTBaseRole() {
		return this.TBaseRole;
	}

	public void setTBaseRole(TBaseRole TBaseRole) {
		this.TBaseRole = TBaseRole;
	}

}