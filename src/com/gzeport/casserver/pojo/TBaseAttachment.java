package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBaseAttachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_ATTACHMENT", schema = "PORTAL")
public class TBaseAttachment implements java.io.Serializable {

	// Fields

	private Long attaId;
	private String attaName;
	private String attaType;
	private BigDecimal attaSize;
	private Date attaUploaddate;
	private String attaContent;

	// Constructors

	/** default constructor */
	public TBaseAttachment() {
	}

	/** minimal constructor */
	public TBaseAttachment(Long attaId) {
		this.attaId = attaId;
	}

	/** full constructor */
	public TBaseAttachment(Long attaId, String attaName, String attaType,
			BigDecimal attaSize, Date attaUploaddate, String attaContent) {
		this.attaId = attaId;
		this.attaName = attaName;
		this.attaType = attaType;
		this.attaSize = attaSize;
		this.attaUploaddate = attaUploaddate;
		this.attaContent = attaContent;
	}

	// Property accessors
	@Id
	@Column(name = "ATTA_ID", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getAttaId() {
		return this.attaId;
	}

	public void setAttaId(Long attaId) {
		this.attaId = attaId;
	}

	@Column(name = "ATTA_NAME", length = 254)
	public String getAttaName() {
		return this.attaName;
	}

	public void setAttaName(String attaName) {
		this.attaName = attaName;
	}

	@Column(name = "ATTA_TYPE", length = 40)
	public String getAttaType() {
		return this.attaType;
	}

	public void setAttaType(String attaType) {
		this.attaType = attaType;
	}

	@Column(name = "ATTA_SIZE", precision = 32, scale = 0)
	public BigDecimal getAttaSize() {
		return this.attaSize;
	}

	public void setAttaSize(BigDecimal attaSize) {
		this.attaSize = attaSize;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ATTA_UPLOADDATE", length = 7)
	public Date getAttaUploaddate() {
		return this.attaUploaddate;
	}

	public void setAttaUploaddate(Date attaUploaddate) {
		this.attaUploaddate = attaUploaddate;
	}

	@Column(name = "ATTA_CONTENT")
	public String getAttaContent() {
		return this.attaContent;
	}

	public void setAttaContent(String attaContent) {
		this.attaContent = attaContent;
	}

}