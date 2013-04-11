package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TBaseDepment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_DEPMENT", schema = "PORTAL")
public class TBaseDepment implements java.io.Serializable {

	// Fields

	private Long deptmentId;
	private TBaseCompany TBaseCompany;
	private String demtmentName;
	private String deptRemark;

	// Constructors

	/** default constructor */
	public TBaseDepment() {
	}

	/** minimal constructor */
	public TBaseDepment(Long deptmentId, TBaseCompany TBaseCompany) {
		this.deptmentId = deptmentId;
		this.TBaseCompany = TBaseCompany;
	}

	/** full constructor */
	public TBaseDepment(Long deptmentId, TBaseCompany TBaseCompany,
			String demtmentName, String deptRemark) {
		this.deptmentId = deptmentId;
		this.TBaseCompany = TBaseCompany;
		this.demtmentName = demtmentName;
		this.deptRemark = deptRemark;
	}

	// Property accessors
	@Id
	@Column(name = "DEPTMENT_ID", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getDeptmentId() {
		return this.deptmentId;
	}

	public void setDeptmentId(Long deptmentId) {
		this.deptmentId = deptmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	public TBaseCompany getTBaseCompany() {
		return this.TBaseCompany;
	}

	public void setTBaseCompany(TBaseCompany TBaseCompany) {
		this.TBaseCompany = TBaseCompany;
	}

	@Column(name = "DEMTMENT_NAME", length = 50)
	public String getDemtmentName() {
		return this.demtmentName;
	}

	public void setDemtmentName(String demtmentName) {
		this.demtmentName = demtmentName;
	}

	@Column(name = "DEPT_REMARK", length = 300)
	public String getDeptRemark() {
		return this.deptRemark;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

}