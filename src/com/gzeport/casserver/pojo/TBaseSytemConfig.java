package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TBaseSytemConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_SYTEM_CONFIG", schema = "PORTAL", uniqueConstraints = @UniqueConstraint(columnNames = "SYS_FUNC_CODE"))
public class TBaseSytemConfig implements java.io.Serializable {

	// Fields

	private String funcId;
	private String sysFuncCode;
	private String contextPath;
	private String sysName;
	private BigDecimal sysSeq;
	private String imgUrl;

	// Constructors

	/** default constructor */
	public TBaseSytemConfig() {
	}

	/** minimal constructor */
	public TBaseSytemConfig(String funcId) {
		this.funcId = funcId;
	}

	/** full constructor */
	public TBaseSytemConfig(String funcId, String sysFuncCode,
			String contextPath, String sysName, BigDecimal sysSeq, String imgUrl) {
		this.funcId = funcId;
		this.sysFuncCode = sysFuncCode;
		this.contextPath = contextPath;
		this.sysName = sysName;
		this.sysSeq = sysSeq;
		this.imgUrl = imgUrl;
	}

	// Property accessors
	@Id
	@Column(name = "FUNC_ID", unique = true, nullable = false, length = 50)
	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	@Column(name = "SYS_FUNC_CODE", unique = true, length = 50)
	public String getSysFuncCode() {
		return this.sysFuncCode;
	}

	public void setSysFuncCode(String sysFuncCode) {
		this.sysFuncCode = sysFuncCode;
	}

	@Column(name = "CONTEXT_PATH", length = 512)
	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@Column(name = "SYS_NAME", length = 100)
	public String getSysName() {
		return this.sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	@Column(name = "SYS_SEQ", precision = 22, scale = 0)
	public BigDecimal getSysSeq() {
		return this.sysSeq;
	}

	public void setSysSeq(BigDecimal sysSeq) {
		this.sysSeq = sysSeq;
	}

	@Column(name = "IMG_URL", length = 50)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}