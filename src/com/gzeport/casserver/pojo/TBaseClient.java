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
 * TBaseClient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_CLIENT", schema = "PORTAL")
public class TBaseClient implements java.io.Serializable {

	// Fields

	private String clientId;
	private TBaseCompany TBaseCompany;
	private String name;
	private String enName;
	private String address;
	private String postcode;
	private String contact;
	private String tel;
	private String email;
	private String valid;
	private Date validDate;
	private Date createDate;
	private String createBy;
	private String ediPath;
	private String recPath;
	private String cliType;
	private Set<TUserTBaseClient> TUserTBaseClients = new HashSet<TUserTBaseClient>(
			0);

	// Constructors

	/** default constructor */
	public TBaseClient() {
	}

	/** minimal constructor */
	public TBaseClient(String clientId, TBaseCompany TBaseCompany) {
		this.clientId = clientId;
		this.TBaseCompany = TBaseCompany;
	}

	/** full constructor */
	public TBaseClient(String clientId, TBaseCompany TBaseCompany, String name,
			String enName, String address, String postcode, String contact,
			String tel, String email, String valid, Date validDate,
			Date createDate, String createBy, String ediPath, String recPath,
			String cliType, Set<TUserTBaseClient> TUserTBaseClients) {
		this.clientId = clientId;
		this.TBaseCompany = TBaseCompany;
		this.name = name;
		this.enName = enName;
		this.address = address;
		this.postcode = postcode;
		this.contact = contact;
		this.tel = tel;
		this.email = email;
		this.valid = valid;
		this.validDate = validDate;
		this.createDate = createDate;
		this.createBy = createBy;
		this.ediPath = ediPath;
		this.recPath = recPath;
		this.cliType = cliType;
		this.TUserTBaseClients = TUserTBaseClients;
	}

	// Property accessors
	@Id
	@Column(name = "CLIENT_ID", unique = true, nullable = false, length = 10)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	public TBaseCompany getTBaseCompany() {
		return this.TBaseCompany;
	}

	public void setTBaseCompany(TBaseCompany TBaseCompany) {
		this.TBaseCompany = TBaseCompany;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EN_NAME", length = 100)
	public String getEnName() {
		return this.enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTCODE", length = 6)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "CONTACT", length = 20)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "TEL", length = 8)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "EMAIL", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "VALID", length = 1)
	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VALID_DATE", length = 7)
	public Date getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", length = 7)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_BY", length = 8)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "EDI_PATH", length = 60)
	public String getEdiPath() {
		return this.ediPath;
	}

	public void setEdiPath(String ediPath) {
		this.ediPath = ediPath;
	}

	@Column(name = "REC_PATH", length = 60)
	public String getRecPath() {
		return this.recPath;
	}

	public void setRecPath(String recPath) {
		this.recPath = recPath;
	}

	@Column(name = "CLI_TYPE", length = 1)
	public String getCliType() {
		return this.cliType;
	}

	public void setCliType(String cliType) {
		this.cliType = cliType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseClient")
	public Set<TUserTBaseClient> getTUserTBaseClients() {
		return this.TUserTBaseClients;
	}

	public void setTUserTBaseClients(Set<TUserTBaseClient> TUserTBaseClients) {
		this.TUserTBaseClients = TUserTBaseClients;
	}

}