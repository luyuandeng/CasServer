package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBasePosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_POSITION", schema = "PORTAL")
public class TBasePosition implements java.io.Serializable {

	// Fields

	private BigDecimal postionId;
	private String postionName;
	private String remark;

	// Constructors

	/** default constructor */
	public TBasePosition() {
	}

	/** minimal constructor */
	public TBasePosition(BigDecimal postionId) {
		this.postionId = postionId;
	}

	/** full constructor */
	public TBasePosition(BigDecimal postionId, String postionName, String remark) {
		this.postionId = postionId;
		this.postionName = postionName;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "POSTION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPostionId() {
		return this.postionId;
	}

	public void setPostionId(BigDecimal postionId) {
		this.postionId = postionId;
	}

	@Column(name = "POSTION_NAME", length = 30)
	public String getPostionName() {
		return this.postionName;
	}

	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}

	@Column(name = "REMARK", length = 30)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}