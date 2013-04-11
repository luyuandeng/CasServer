package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBaseConfigInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_CONFIG_INFO", schema = "PORTAL")
public class TBaseConfigInfo implements java.io.Serializable {

	// Fields

	private Long configId;
	private String servicerId;
	private String parameType;
	private String sendCustomsCodes;
	private String companyMailId;
	private String receiveCode;
	private String sendCode;
	private String representativePerson;
	private String ediReceiver;
	private String ediSendCode;
	private String docSendType;
	private String receiptMailId;

	// Constructors

	/** default constructor */
	public TBaseConfigInfo() {
	}

	/** minimal constructor */
	public TBaseConfigInfo(Long configId, String servicerId, String parameType,
			String sendCode, String representativePerson, String ediReceiver,
			String ediSendCode) {
		this.configId = configId;
		this.servicerId = servicerId;
		this.parameType = parameType;
		this.sendCode = sendCode;
		this.representativePerson = representativePerson;
		this.ediReceiver = ediReceiver;
		this.ediSendCode = ediSendCode;
	}

	/** full constructor */
	public TBaseConfigInfo(Long configId, String servicerId, String parameType,
			String sendCustomsCodes, String companyMailId, String receiveCode,
			String sendCode, String representativePerson, String ediReceiver,
			String ediSendCode, String docSendType, String receiptMailId) {
		this.configId = configId;
		this.servicerId = servicerId;
		this.parameType = parameType;
		this.sendCustomsCodes = sendCustomsCodes;
		this.companyMailId = companyMailId;
		this.receiveCode = receiveCode;
		this.sendCode = sendCode;
		this.representativePerson = representativePerson;
		this.ediReceiver = ediReceiver;
		this.ediSendCode = ediSendCode;
		this.docSendType = docSendType;
		this.receiptMailId = receiptMailId;
	}

	// Property accessors
	@Id
	@Column(name = "CONFIG_ID", unique = true, nullable = false, precision = 15, scale = 0)
	public Long getConfigId() {
		return this.configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	}

	@Column(name = "SERVICER_ID", nullable = false, length = 32)
	public String getServicerId() {
		return this.servicerId;
	}

	public void setServicerId(String servicerId) {
		this.servicerId = servicerId;
	}

	@Column(name = "PARAME_TYPE", nullable = false, length = 1)
	public String getParameType() {
		return this.parameType;
	}

	public void setParameType(String parameType) {
		this.parameType = parameType;
	}

	@Column(name = "SEND_CUSTOMS_CODES", length = 512)
	public String getSendCustomsCodes() {
		return this.sendCustomsCodes;
	}

	public void setSendCustomsCodes(String sendCustomsCodes) {
		this.sendCustomsCodes = sendCustomsCodes;
	}

	@Column(name = "COMPANY_MAIL_ID", length = 50)
	public String getCompanyMailId() {
		return this.companyMailId;
	}

	public void setCompanyMailId(String companyMailId) {
		this.companyMailId = companyMailId;
	}

	@Column(name = "RECEIVE_CODE", length = 32)
	public String getReceiveCode() {
		return this.receiveCode;
	}

	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}

	@Column(name = "SEND_CODE", nullable = false, length = 32)
	public String getSendCode() {
		return this.sendCode;
	}

	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	@Column(name = "REPRESENTATIVE_PERSON", nullable = false, length = 50)
	public String getRepresentativePerson() {
		return this.representativePerson;
	}

	public void setRepresentativePerson(String representativePerson) {
		this.representativePerson = representativePerson;
	}

	@Column(name = "EDI_RECEIVER", nullable = false, length = 32)
	public String getEdiReceiver() {
		return this.ediReceiver;
	}

	public void setEdiReceiver(String ediReceiver) {
		this.ediReceiver = ediReceiver;
	}

	@Column(name = "EDI_SEND_CODE", nullable = false, length = 32)
	public String getEdiSendCode() {
		return this.ediSendCode;
	}

	public void setEdiSendCode(String ediSendCode) {
		this.ediSendCode = ediSendCode;
	}

	@Column(name = "DOC_SEND_TYPE", length = 1)
	public String getDocSendType() {
		return this.docSendType;
	}

	public void setDocSendType(String docSendType) {
		this.docSendType = docSendType;
	}

	@Column(name = "RECEIPT_MAIL_ID", length = 50)
	public String getReceiptMailId() {
		return this.receiptMailId;
	}

	public void setReceiptMailId(String receiptMailId) {
		this.receiptMailId = receiptMailId;
	}

}