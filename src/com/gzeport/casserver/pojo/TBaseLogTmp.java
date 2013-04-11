package com.gzeport.casserver.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TBaseLogTmp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_BASE_LOG_TMP", schema = "PORTAL")
public class TBaseLogTmp implements java.io.Serializable {

	// Fields

	private TBaseLogTmpId id;

	// Constructors

	/** default constructor */
	public TBaseLogTmp() {
	}

	/** full constructor */
	public TBaseLogTmp(TBaseLogTmpId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "logCode", column = @Column(name = "LOG_CODE", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "logName", column = @Column(name = "LOG_NAME", length = 30)),
			@AttributeOverride(name = "logType", column = @Column(name = "LOG_TYPE", length = 2000)),
			@AttributeOverride(name = "loginId", column = @Column(name = "LOGIN_ID", precision = 12, scale = 0)),
			@AttributeOverride(name = "loginName", column = @Column(name = "LOGIN_NAME", length = 50)),
			@AttributeOverride(name = "companyId", column = @Column(name = "COMPANY_ID", length = 20)),
			@AttributeOverride(name = "companyName", column = @Column(name = "COMPANY_NAME", length = 200)),
			@AttributeOverride(name = "operateDate", column = @Column(name = "OPERATE_DATE", length = 7)),
			@AttributeOverride(name = "functionCode", column = @Column(name = "FUNCTION_CODE", length = 100)),
			@AttributeOverride(name = "functionName", column = @Column(name = "FUNCTION_NAME", length = 50)),
			@AttributeOverride(name = "functionArg", column = @Column(name = "FUNCTION_ARG", length = 4000)),
			@AttributeOverride(name = "functionResult", column = @Column(name = "FUNCTION_RESULT", length = 4000)),
			@AttributeOverride(name = "operateComputer", column = @Column(name = "OPERATE_COMPUTER", length = 50)),
			@AttributeOverride(name = "logRemark", column = @Column(name = "LOG_REMARK", length = 10)) })
	public TBaseLogTmpId getId() {
		return this.id;
	}

	public void setId(TBaseLogTmpId id) {
		this.id = id;
	}

}