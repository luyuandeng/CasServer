package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TBaseCompanyAttachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_COMPANY_ATTACHMENT", schema = "PORTAL")
public class TBaseCompanyAttachment implements java.io.Serializable {

	// Fields

	private Long id;
	private TBaseCompany TBaseCompany;
	private String menType;
	private String menName;
	private String cardType;
	private String cardId;
	private String tlePhone;
	private String fax;
	private String mobilePhone;
	private String EMail;

	// Constructors

	/** default constructor */
	public TBaseCompanyAttachment() {
	}

	/** minimal constructor */
	public TBaseCompanyAttachment(Long id, TBaseCompany TBaseCompany,
			String menType) {
		this.id = id;
		this.TBaseCompany = TBaseCompany;
		this.menType = menType;
	}

	/** full constructor */
	public TBaseCompanyAttachment(Long id, TBaseCompany TBaseCompany,
			String menType, String menName, String cardType, String cardId,
			String tlePhone, String fax, String mobilePhone, String EMail) {
		this.id = id;
		this.TBaseCompany = TBaseCompany;
		this.menType = menType;
		this.menName = menName;
		this.cardType = cardType;
		this.cardId = cardId;
		this.tlePhone = tlePhone;
		this.fax = fax;
		this.mobilePhone = mobilePhone;
		this.EMail = EMail;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	public TBaseCompany getTBaseCompany() {
		return this.TBaseCompany;
	}

	public void setTBaseCompany(TBaseCompany TBaseCompany) {
		this.TBaseCompany = TBaseCompany;
	}

	@Column(name = "MEN_TYPE", nullable = false, length = 1)
	public String getMenType() {
		return this.menType;
	}

	public void setMenType(String menType) {
		this.menType = menType;
	}

	@Column(name = "MEN_NAME", length = 15)
	public String getMenName() {
		return this.menName;
	}

	public void setMenName(String menName) {
		this.menName = menName;
	}

	@Column(name = "CARD_TYPE", length = 1)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "CARD_ID", length = 15)
	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name = "TLE_PHONE", length = 15)
	public String getTlePhone() {
		return this.tlePhone;
	}

	public void setTlePhone(String tlePhone) {
		this.tlePhone = tlePhone;
	}

	@Column(name = "FAX", length = 15)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "MOBILE_PHONE", length = 15)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "E_MAIL", length = 50)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

}