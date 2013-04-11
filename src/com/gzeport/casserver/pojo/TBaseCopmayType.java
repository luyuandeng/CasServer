package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBaseCopmayType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_COPMAY_TYPE", schema = "PORTAL")
public class TBaseCopmayType implements java.io.Serializable {

	// Fields

	private BigDecimal typeId;
	private String typeName;

	// Constructors

	/** default constructor */
	public TBaseCopmayType() {
	}

	/** minimal constructor */
	public TBaseCopmayType(BigDecimal typeId) {
		this.typeId = typeId;
	}

	/** full constructor */
	public TBaseCopmayType(BigDecimal typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	// Property accessors
	@Id
	@Column(name = "TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTypeId() {
		return this.typeId;
	}

	public void setTypeId(BigDecimal typeId) {
		this.typeId = typeId;
	}

	@Column(name = "TYPE_NAME", length = 8)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}