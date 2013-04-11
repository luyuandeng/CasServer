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
 * TUserClient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_CLIENT", schema = "PORTAL")
public class TUserClient implements java.io.Serializable {

	// Fields

	private TUserClientId id;
	private TBaseUser TBaseUser;

	// Constructors

	/** default constructor */
	public TUserClient() {
	}

	/** full constructor */
	public TUserClient(TUserClientId id, TBaseUser TBaseUser) {
		this.id = id;
		this.TBaseUser = TBaseUser;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "clientId", column = @Column(name = "CLIENT_ID", nullable = false, length = 10)) })
	public TUserClientId getId() {
		return this.id;
	}

	public void setId(TUserClientId id) {
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

}