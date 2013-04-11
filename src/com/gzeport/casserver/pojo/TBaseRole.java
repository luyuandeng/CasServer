package com.gzeport.casserver.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBaseRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_ROLE", schema = "PORTAL")
public class TBaseRole implements java.io.Serializable {

	// Fields

	private Long roleId;
	private TBaseCompany TBaseCompany;
	private String roleName;
	private String sysType;
	private String parnetRoleId;
	private String roleEnable;
	private String roleResume;
	private String levelType;
	private String createUser;
	private String createCompany;
	private Date createDate;
	private String roleType;
	private Set<TRoleFuncmodel> TRoleFuncmodels = new HashSet<TRoleFuncmodel>(0);
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);

	// Constructors

	/** default constructor */
	public TBaseRole() {
	}

	/** minimal constructor */
	public TBaseRole(Long roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public TBaseRole(Long roleId, TBaseCompany TBaseCompany, String roleName,
			String sysType, String parnetRoleId, String roleEnable,
			String roleResume, String levelType, String createUser,
			String createCompany, Date createDate, String roleType,
			Set<TRoleFuncmodel> TRoleFuncmodels, Set<TUserRole> TUserRoles) {
		this.roleId = roleId;
		this.TBaseCompany = TBaseCompany;
		this.roleName = roleName;
		this.sysType = sysType;
		this.parnetRoleId = parnetRoleId;
		this.roleEnable = roleEnable;
		this.roleResume = roleResume;
		this.levelType = levelType;
		this.createUser = createUser;
		this.createCompany = createCompany;
		this.createDate = createDate;
		this.roleType = roleType;
		this.TRoleFuncmodels = TRoleFuncmodels;
		this.TUserRoles = TUserRoles;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID")
	public TBaseCompany getTBaseCompany() {
		return this.TBaseCompany;
	}

	public void setTBaseCompany(TBaseCompany TBaseCompany) {
		this.TBaseCompany = TBaseCompany;
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

	@Column(name = "CREATE_USER", length = 30)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CREATE_COMPANY", length = 30)
	public String getCreateCompany() {
		return this.createCompany;
	}

	public void setCreateCompany(String createCompany) {
		this.createCompany = createCompany;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ROLE_TYPE", length = 1)
	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseRole")
	public Set<TRoleFuncmodel> getTRoleFuncmodels() {
		return this.TRoleFuncmodels;
	}

	public void setTRoleFuncmodels(Set<TRoleFuncmodel> TRoleFuncmodels) {
		this.TRoleFuncmodels = TRoleFuncmodels;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseRole")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

}