package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBaseCustoms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_CUSTOMS", schema = "PORTAL")
public class TBaseCustoms implements java.io.Serializable {

	// Fields

	private String customsCode;
	private String customsName;
	private String customsSName;
	private String PCustomsCode;
	private String customsClass;
	private String customsAddress;
	private String customsTel;
	private String customsCat;

	// Constructors

	/** default constructor */
	public TBaseCustoms() {
	}

	/** minimal constructor */
	public TBaseCustoms(String customsCode, String customsName) {
		this.customsCode = customsCode;
		this.customsName = customsName;
	}

	/** full constructor */
	public TBaseCustoms(String customsCode, String customsName,
			String customsSName, String PCustomsCode, String customsClass,
			String customsAddress, String customsTel, String customsCat) {
		this.customsCode = customsCode;
		this.customsName = customsName;
		this.customsSName = customsSName;
		this.PCustomsCode = PCustomsCode;
		this.customsClass = customsClass;
		this.customsAddress = customsAddress;
		this.customsTel = customsTel;
		this.customsCat = customsCat;
	}

	// Property accessors
	@Id
	@Column(name = "CUSTOMS_CODE", unique = true, nullable = false, length = 4)
	public String getCustomsCode() {
		return this.customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	@Column(name = "CUSTOMS_NAME", nullable = false, length = 200)
	public String getCustomsName() {
		return this.customsName;
	}

	public void setCustomsName(String customsName) {
		this.customsName = customsName;
	}

	@Column(name = "CUSTOMS_S_NAME", length = 32)
	public String getCustomsSName() {
		return this.customsSName;
	}

	public void setCustomsSName(String customsSName) {
		this.customsSName = customsSName;
	}

	@Column(name = "P_CUSTOMS_CODE", length = 4)
	public String getPCustomsCode() {
		return this.PCustomsCode;
	}

	public void setPCustomsCode(String PCustomsCode) {
		this.PCustomsCode = PCustomsCode;
	}

	@Column(name = "CUSTOMS_CLASS", length = 1)
	public String getCustomsClass() {
		return this.customsClass;
	}

	public void setCustomsClass(String customsClass) {
		this.customsClass = customsClass;
	}

	@Column(name = "CUSTOMS_ADDRESS", length = 128)
	public String getCustomsAddress() {
		return this.customsAddress;
	}

	public void setCustomsAddress(String customsAddress) {
		this.customsAddress = customsAddress;
	}

	@Column(name = "CUSTOMS_TEL", length = 15)
	public String getCustomsTel() {
		return this.customsTel;
	}

	public void setCustomsTel(String customsTel) {
		this.customsTel = customsTel;
	}

	@Column(name = "CUSTOMS_CAT", length = 15)
	public String getCustomsCat() {
		return this.customsCat;
	}

	public void setCustomsCat(String customsCat) {
		this.customsCat = customsCat;
	}

}