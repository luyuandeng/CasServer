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
 * TUserTBaseClient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_T_BASE_CLIENT", schema = "PORTAL")
public class TUserTBaseClient implements java.io.Serializable {

	// Fields

	private TUserTBaseClientId id;
	private TBaseClient TBaseClient;
	private TBaseUser TBaseUser;

	// Constructors

	/** default constructor */
	public TUserTBaseClient() {
	}

	/** full constructor */
	public TUserTBaseClient(TUserTBaseClientId id, TBaseClient TBaseClient,
			TBaseUser TBaseUser) {
		this.id = id;
		this.TBaseClient = TBaseClient;
		this.TBaseUser = TBaseUser;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "clientId", column = @Column(name = "CLIENT_ID", nullable = false, length = 10)) })
	public TUserTBaseClientId getId() {
		return this.id;
	}

	public void setId(TUserTBaseClientId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID", nullable = false, insertable = false, updatable = false)
	public TBaseClient getTBaseClient() {
		return this.TBaseClient;
	}

	public void setTBaseClient(TBaseClient TBaseClient) {
		this.TBaseClient = TBaseClient;
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