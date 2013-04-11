package com.gzeport.casserver.pojo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ROLE", schema = "PORTAL")
public class TRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String companyId;
	private String roleName;
	private String sysType;
	private String parnetRoleId;
	private String roleEnable;
	private String roleResume;
	private String levelType;
	private BigDecimal attachmentid;
	private String filePath;

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Long roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public TRole(Long roleId, String companyId, String roleName,
			String sysType, String parnetRoleId, String roleEnable,
			String roleResume, String levelType, BigDecimal attachmentid,
			String filePath) {
		this.roleId = roleId;
		this.companyId = companyId;
		this.roleName = roleName;
		this.sysType = sysType;
		this.parnetRoleId = parnetRoleId;
		this.roleEnable = roleEnable;
		this.roleResume = roleResume;
		this.levelType = levelType;
		this.attachmentid = attachmentid;
		this.filePath = filePath;
	}

	// Property accessors
	@Id
	@Column(name = "ROLE_ID", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "COMPANY_ID", length = 20)
	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "ROLE_NAME", length = 30)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "SYS_TYPE", length = 2)
	public String getSysType() {
		return this.sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	@Column(name = "PARNET_ROLE_ID", length = 200)
	public String getParnetRoleId() {
		return this.parnetRoleId;
	}

	public void setParnetRoleId(String parnetRoleId) {
		this.parnetRoleId = parnetRoleId;
	}

	@Column(name = "ROLE_ENABLE", length = 1)
	public String getRoleEnable() {
		return this.roleEnable;
	}

	public void setRoleEnable(String roleEnable) {
		this.roleEnable = roleEnable;
	}

	@Column(name = "ROLE_RESUME", length = 1000)
	public String getRoleResume() {
		return this.roleResume;
	}

	public void setRoleResume(String roleResume) {
		this.roleResume = roleResume;
	}

	@Column(name = "LEVEL_TYPE", length = 1)
	public String getLevelType() {
		return this.levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	@Column(name = "ATTACHMENTID", precision = 22, scale = 0)
	public BigDecimal getAttachmentid() {
		return this.attachmentid;
	}

	public void setAttachmentid(BigDecimal attachmentid) {
		this.attachmentid = attachmentid;
	}

	@Column(name = "FILE_PATH", length = 100)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}