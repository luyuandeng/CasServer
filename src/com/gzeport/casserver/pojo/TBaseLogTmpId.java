package com.gzeport.casserver.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TBaseLogTmpId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TBaseLogTmpId implements java.io.Serializable {

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
	public TBaseLogTmpId() {
	}

	/** minimal constructor */
	public TBaseLogTmpId(Long logCode) {
		this.logCode = logCode;
	}

	/** full constructor */
	public TBaseLogTmpId(Long logCode, String logName, String logType,
			Long loginId, String loginName, String companyId,
			String companyName, Date operateDate, String functionCode,
			String functionName, String functionArg, String functionResult,
			String operateComputer, String logRemark) {
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

	@Column(name = "LOG_CODE", nullable = false, precision = 12, scale = 0)
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TBaseLogTmpId))
			return false;
		TBaseLogTmpId castOther = (TBaseLogTmpId) other;

		return ((this.getLogCode() == castOther.getLogCode()) || (this
				.getLogCode() != null
				&& castOther.getLogCode() != null && this.getLogCode().equals(
				castOther.getLogCode())))
				&& ((this.getLogName() == castOther.getLogName()) || (this
						.getLogName() != null
						&& castOther.getLogName() != null && this.getLogName()
						.equals(castOther.getLogName())))
				&& ((this.getLogType() == castOther.getLogType()) || (this
						.getLogType() != null
						&& castOther.getLogType() != null && this.getLogType()
						.equals(castOther.getLogType())))
				&& ((this.getLoginId() == castOther.getLoginId()) || (this
						.getLoginId() != null
						&& castOther.getLoginId() != null && this.getLoginId()
						.equals(castOther.getLoginId())))
				&& ((this.getLoginName() == castOther.getLoginName()) || (this
						.getLoginName() != null
						&& castOther.getLoginName() != null && this
						.getLoginName().equals(castOther.getLoginName())))
				&& ((this.getCompanyId() == castOther.getCompanyId()) || (this
						.getCompanyId() != null
						&& castOther.getCompanyId() != null && this
						.getCompanyId().equals(castOther.getCompanyId())))
				&& ((this.getCompanyName() == castOther.getCompanyName()) || (this
						.getCompanyName() != null
						&& castOther.getCompanyName() != null && this
						.getCompanyName().equals(castOther.getCompanyName())))
				&& ((this.getOperateDate() == castOther.getOperateDate()) || (this
						.getOperateDate() != null
						&& castOther.getOperateDate() != null && this
						.getOperateDate().equals(castOther.getOperateDate())))
				&& ((this.getFunctionCode() == castOther.getFunctionCode()) || (this
						.getFunctionCode() != null
						&& castOther.getFunctionCode() != null && this
						.getFunctionCode().equals(castOther.getFunctionCode())))
				&& ((this.getFunctionName() == castOther.getFunctionName()) || (this
						.getFunctionName() != null
						&& castOther.getFunctionName() != null && this
						.getFunctionName().equals(castOther.getFunctionName())))
				&& ((this.getFunctionArg() == castOther.getFunctionArg()) || (this
						.getFunctionArg() != null
						&& castOther.getFunctionArg() != null && this
						.getFunctionArg().equals(castOther.getFunctionArg())))
				&& ((this.getFunctionResult() == castOther.getFunctionResult()) || (this
						.getFunctionResult() != null
						&& castOther.getFunctionResult() != null && this
						.getFunctionResult().equals(
								castOther.getFunctionResult())))
				&& ((this.getOperateComputer() == castOther
						.getOperateComputer()) || (this.getOperateComputer() != null
						&& castOther.getOperateComputer() != null && this
						.getOperateComputer().equals(
								castOther.getOperateComputer())))
				&& ((this.getLogRemark() == castOther.getLogRemark()) || (this
						.getLogRemark() != null
						&& castOther.getLogRemark() != null && this
						.getLogRemark().equals(castOther.getLogRemark())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLogCode() == null ? 0 : this.getLogCode().hashCode());
		result = 37 * result
				+ (getLogName() == null ? 0 : this.getLogName().hashCode());
		result = 37 * result
				+ (getLogType() == null ? 0 : this.getLogType().hashCode());
		result = 37 * result
				+ (getLoginId() == null ? 0 : this.getLoginId().hashCode());
		result = 37 * result
				+ (getLoginName() == null ? 0 : this.getLoginName().hashCode());
		result = 37 * result
				+ (getCompanyId() == null ? 0 : this.getCompanyId().hashCode());
		result = 37
				* result
				+ (getCompanyName() == null ? 0 : this.getCompanyName()
						.hashCode());
		result = 37
				* result
				+ (getOperateDate() == null ? 0 : this.getOperateDate()
						.hashCode());
		result = 37
				* result
				+ (getFunctionCode() == null ? 0 : this.getFunctionCode()
						.hashCode());
		result = 37
				* result
				+ (getFunctionName() == null ? 0 : this.getFunctionName()
						.hashCode());
		result = 37
				* result
				+ (getFunctionArg() == null ? 0 : this.getFunctionArg()
						.hashCode());
		result = 37
				* result
				+ (getFunctionResult() == null ? 0 : this.getFunctionResult()
						.hashCode());
		result = 37
				* result
				+ (getOperateComputer() == null ? 0 : this.getOperateComputer()
						.hashCode());
		result = 37 * result
				+ (getLogRemark() == null ? 0 : this.getLogRemark().hashCode());
		return result;
	}

}