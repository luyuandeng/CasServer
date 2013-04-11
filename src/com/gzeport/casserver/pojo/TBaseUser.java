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
import javax.persistence.UniqueConstraint;

/**
 * TBaseUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_USER", schema = "PORTAL", uniqueConstraints = @UniqueConstraint(columnNames = "USER_CODE"))
public class TBaseUser implements java.io.Serializable {

	// Fields

	private Long userId;
	private TBaseCompany TBaseCompany;
	private String userCode;
	private String userName;
	private Date birthday;
	private String userPwd;
	private String userSex;
	private String userDpt;
	private String userDuty;
	private String userLoginType;
	private String workUnit;
	private String userTel;
	private String mobile;
	private String EMail;
	private String certificate;
	private Date createTime;
	private String isModifyPwd;
	private Long attachmentid;
	private String isUse;
	private String cardType;
	private String cardId;
	private String isDel;
	private String createUser;
	private String createCompany;
	private String customsCode;
	private String customsCodeExt;
	private Date lastLoginTime;
	private Date modifyPwdTime;
	private String businessType;
	private String regRoleId;
	
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);
	private Set<TUserTBaseClient> TUserTBaseClients = new HashSet<TUserTBaseClient>(
			0);
	private Set<TUserClient> TUserClients = new HashSet<TUserClient>(0);

	// Constructors

	/** default constructor */
	public TBaseUser() {
	}

	/** minimal constructor */
	public TBaseUser(Long userId, TBaseCompany TBaseCompany,
			String userCode) {
		this.userId = userId;
		this.TBaseCompany = TBaseCompany;
		this.userCode = userCode;
	}

	/** full constructor */
	public TBaseUser(Long userId, TBaseCompany TBaseCompany,
			String userCode, String userName, Date birthday, String userPwd,
			String userSex, String userDpt, String userDuty,
			String userLoginType, String workUnit, String userTel,
			String mobile, String EMail, String certificate, Date createTime,
			String isModifyPwd, Long attachmentid, String isUse,
			String cardType, String cardId, String isDel, String createUser,
			String createCompany, String customsCode, String customsCodeExt,
			Date lastLoginTime, Date modifyPwdTime, String businessType,
			String regRoleId, Set<TUserRole> TUserRoles,
			Set<TUserTBaseClient> TUserTBaseClients,
			Set<TUserClient> TUserClients) {
		this.userId = userId;
		this.TBaseCompany = TBaseCompany;
		this.userCode = userCode;
		this.userName = userName;
		this.birthday = birthday;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.userDpt = userDpt;
		this.userDuty = userDuty;
		this.userLoginType = userLoginType;
		this.workUnit = workUnit;
		this.userTel = userTel;
		this.mobile = mobile;
		this.EMail = EMail;
		this.certificate = certificate;
		this.createTime = createTime;
		this.isModifyPwd = isModifyPwd;
		this.attachmentid = attachmentid;
		this.isUse = isUse;
		this.cardType = cardType;
		this.cardId = cardId;
		this.isDel = isDel;
		this.createUser = createUser;
		this.createCompany = createCompany;
		this.customsCode = customsCode;
		this.customsCodeExt = customsCodeExt;
		this.lastLoginTime = lastLoginTime;
		this.modifyPwdTime = modifyPwdTime;
		this.businessType = businessType;
		this.regRoleId = regRoleId;
		this.TUserRoles = TUserRoles;
		this.TUserTBaseClients = TUserTBaseClients;
		this.TUserClients = TUserClients;
	}

	// Property accessors
	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	public TBaseCompany getTBaseCompany() {
		return this.TBaseCompany;
	}

	public void setTBaseCompany(TBaseCompany TBaseCompany) {
		this.TBaseCompany = TBaseCompany;
	}

	@Column(name = "USER_CODE", unique = true, nullable = false, length = 30)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "USER_NAME", length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 7)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "USER_PWD", length = 50)
	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Column(name = "USER_SEX", length = 1)
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "USER_DPT", length = 40)
	public String getUserDpt() {
		return this.userDpt;
	}

	public void setUserDpt(String userDpt) {
		this.userDpt = userDpt;
	}

	@Column(name = "USER_DUTY", length = 15)
	public String getUserDuty() {
		return this.userDuty;
	}

	public void setUserDuty(String userDuty) {
		this.userDuty = userDuty;
	}

	@Column(name = "USER_LOGIN_TYPE", length = 1)
	public String getUserLoginType() {
		return this.userLoginType;
	}

	public void setUserLoginType(String userLoginType) {
		this.userLoginType = userLoginType;
	}

	@Column(name = "WORK_UNIT", length = 60)
	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	@Column(name = "USER_TEL", length = 30)
	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "MOBILE", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "E_MAIL", length = 80)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@Column(name = "CERTIFICATE")
	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_TIME", length = 7)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "IS_MODIFY_PWD", length = 1)
	public String getIsModifyPwd() {
		return this.isModifyPwd;
	}

	public void setIsModifyPwd(String isModifyPwd) {
		this.isModifyPwd = isModifyPwd;
	}

	@Column(name = "ATTACHMENTID", precision = 12, scale = 0)
	public Long getAttachmentid() {
		return this.attachmentid;
	}

	public void setAttachmentid(Long attachmentid) {
		this.attachmentid = attachmentid;
	}

	@Column(name = "IS_USE", length = 1)
	public String getIsUse() {
		return this.isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	@Column(name = "CARD_TYPE", length = 2)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "CARD_ID", length = 20)
	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	@Column(name = "IS_DEL", length = 1)
	public String getIsDel() {
		return this.isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
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

	@Column(name = "CUSTOMS_CODE", length = 4)
	public String getCustomsCode() {
		return this.customsCode;
	}

	public void setCustomsCode(String customsCode) {
		this.customsCode = customsCode;
	}

	@Column(name = "CUSTOMS_CODE_EXT", length = 600)
	public String getCustomsCodeExt() {
		return this.customsCodeExt;
	}

	public void setCustomsCodeExt(String customsCodeExt) {
		this.customsCodeExt = customsCodeExt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_LOGIN_TIME", length = 7)
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFY_PWD_TIME", length = 7)
	public Date getModifyPwdTime() {
		return this.modifyPwdTime;
	}

	public void setModifyPwdTime(Date modifyPwdTime) {
		this.modifyPwdTime = modifyPwdTime;
	}

	@Column(name = "BUSINESS_TYPE", length = 1)
	public String getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	@Column(name = "REG_ROLE_ID", length = 8)
	public String getRegRoleId() {
		return this.regRoleId;
	}

	public void setRegRoleId(String regRoleId) {
		this.regRoleId = regRoleId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseUser")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseUser")
	public Set<TUserTBaseClient> getTUserTBaseClients() {
		return this.TUserTBaseClients;
	}

	public void setTUserTBaseClients(Set<TUserTBaseClient> TUserTBaseClients) {
		this.TUserTBaseClients = TUserTBaseClients;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseUser")
	public Set<TUserClient> getTUserClients() {
		return this.TUserClients;
	}

	public void setTUserClients(Set<TUserClient> TUserClients) {
		this.TUserClients = TUserClients;
	}

}