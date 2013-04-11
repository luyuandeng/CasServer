package com.gzeport.casserver.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBaseLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_LOG", schema = "PORTAL")
public class TBaseLog implements java.io.Serializable {

	// Fields

	private Long logCode;
	private String logName;
	private String logType;
	private Long loginId;
	private String loginName;
	private String companyId;
	private String companyName;
	private Date operateDate;
	private String functionCode;
	private String functionName;
	private String functionArg;
	private String functionResult;
	private String operateComputer;
	private String logRemark;

	// Constructors

	/** default constructor */
	public TBaseLog() {
	}

	/** minimal constructor */
	public TBaseLog(Long logCode) {
		this.logCode = logCode;
	}

	/** full constructor */
	public TBaseLog(Long logCode, String logName, String logType, Long loginId,
			String loginName, String companyId, String companyName,
			Date operateDate, String functionCode, String functionName,
			String functionArg, String functionResult, String operateComputer,
			String logRemark) {
		this.logCode = logCode;
		this.logName = logName;
		this.logType = logType;
		this.loginId = loginId;
		this.loginName = loginName;
		this.companyId = companyId;
		this.companyName = companyName;
		this.operateDate = operateDate;
		this.functionCode = functionCode;
		this.functionName = functionName;
		this.functionArg = functionArg;
		this.functionResult = functionResult;
		this.operateComputer = operateComputer;
		this.logRemark = logRemark;
	}

	// Property accessors
	@Id
	@Column(name = "LOG_CODE", unique = true, nullable = false, precision = 12, scale = 0)
	public Long getLogCode() {
		return this.logCode;
	}

	public void setLogCode(Long logCode) {
		this.logCode = logCode;
	}

	@Column(name = "LOG_NAME", length = 30)
	public String getLogName() {
		return this.logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	@Column(name = "LOG_TYPE", length = 2000)
	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Column(name = "LOGIN_ID", precision = 12, scale = 0)
	public Long getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	@Column(name = "LOGIN_NAME", length = 50)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "COMPANY_ID", length = 20)
	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_NAME", length = 200)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPERATE_DATE", length = 7)
	public Date getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	@Column(name = "FUNCTION_CODE", length = 100)
	public String getFunctionCode() {
		return this.functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	@Column(name = "FUNCTION_NAME", length = 50)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "FUNCTION_ARG", length = 4000)
	public String getFunctionArg() {
		return this.functionArg;
	}

	public void setFunctionArg(String functionArg) {
		this.functionArg = functionArg;
	}

	@Column(name = "FUNCTION_RESULT", length = 4000)
	public String getFunctionResult() {
		return this.functionResult;
	}

	public void setFunctionResult(String functionResult) {
		this.functionResult = functionResult;
	}

	@Column(name = "OPERATE_COMPUTER", length = 50)
	public String getOperateComputer() {
		return this.operateComputer;
	}

	public void setOperateComputer(String operateComputer) {
		this.operateComputer = operateComputer;
	}

	@Column(name = "LOG_REMARK", length = 10)
	public String getLogRemark() {
		return this.logRemark;
	}

	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}

}