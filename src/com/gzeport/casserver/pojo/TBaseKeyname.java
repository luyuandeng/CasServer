package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBaseKeyname entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_KEYNAME", schema = "PORTAL")
public class TBaseKeyname implements java.io.Serializable {

	// Fields

	private String keyTablename;
	private Long keyValue;

	// Constructors

	/** default constructor */
	public TBaseKeyname() {
	}

	/** minimal constructor */
	public TBaseKeyname(String keyTablename) {
		this.keyTablename = keyTablename;
	}

	/** full constructor */
	public TBaseKeyname(String keyTablename, Long keyValue) {
		this.keyTablename = keyTablename;
		this.keyValue = keyValue;
	}

	// Property accessors
	@Id
	@Column(name = "KEY_TABLENAME", unique = true, nullable = false, length = 40)
	public String getKeyTablename() {
		return this.keyTablename;
	}

	public void setKeyTablename(String keyTablename) {
		this.keyTablename = keyTablename;
	}

	@Column(name = "KEY_VALUE", precision = 16, scale = 0)
	public Long getKeyValue() {
		return this.keyValue;
	}

	public void setKeyValue(Long keyValue) {
		this.keyValue = keyValue;
	}

}