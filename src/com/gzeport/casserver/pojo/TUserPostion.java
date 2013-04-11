package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TUserPostion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_POSTION", schema = "PORTAL")
public class TUserPostion implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private BigDecimal userId;
	private BigDecimal postionId;

	// Constructors

	/** default constructor */
	public TUserPostion() {
	}

	/** full constructor */
	public TUserPostion(BigDecimal id, BigDecimal userId, BigDecimal postionId) {
		this.id = id;
		this.userId = userId;
		this.postionId = postionId;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Column(name = "POSTION_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPostionId() {
		return this.postionId;
	}

	public void setPostionId(BigDecimal postionId) {
		this.postionId = postionId;
	}

}