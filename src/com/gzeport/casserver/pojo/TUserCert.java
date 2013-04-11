package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TUserCert entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_CERT", schema = "PORTAL")
public class TUserCert implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String userid;
	private String pwd;
	private String certThumbprint;
	private String systemType;
	private String userCode;
	private String companyid;
	private String cardType;

	// Constructors

	/** default constructor */
	public TUserCert() {
	}

	/** minimal constructor */
	public TUserCert(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public TUserCert(BigDecimal id, String userid, String pwd,
			String certThumbprint, String systemType, String userCode,
			String companyid, String cardType) {
		this.id = id;
		this.userid = userid;
		this.pwd = pwd;
		this.certThumbprint = certThumbprint;
		this.systemType = systemType;
		this.userCode = userCode;
		this.companyid = companyid;
		this.cardType = cardType;
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

	@Column(name = "USERID", length = 128)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "PWD", length = 128)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "CERT_THUMBPRINT", length = 128)
	public String getCertThumbprint() {
		return this.certThumbprint;
	}

	public void setCertThumbprint(String certThumbprint) {
		this.certThumbprint = certThumbprint;
	}

	@Column(name = "SYSTEM_TYPE", length = 32)
	public String getSystemType() {
		return this.systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	@Column(name = "USER_CODE", length = 128)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "COMPANYID", length = 128)
	public String getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}

	@Column(name = "CARD_TYPE", length = 1)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}