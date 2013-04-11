package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TRoleFuncmodelId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TRoleFuncmodelId implements java.io.Serializable {

	// Fields

	private Long roleId;
	private String funcId;

	// Constructors

	/** default constructor */
	public TRoleFuncmodelId() {
	}

	/** full constructor */
	public TRoleFuncmodelId(Long roleId, String funcId) {
		this.roleId = roleId;
		this.funcId = funcId;
	}

	// Property accessors

	@Column(name = "ROLE_ID", nullable = false, precision = 12, scale = 0)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "FUNC_ID", nullable = false, length = 12)
	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TRoleFuncmodelId))
			return false;
		TRoleFuncmodelId castOther = (TRoleFuncmodelId) other;

		return ((this.getRoleId() == castOther.getRoleId()) || (this
				.getRoleId() != null
				&& castOther.getRoleId() != null && this.getRoleId().equals(
				castOther.getRoleId())))
				&& ((this.getFuncId() == castOther.getFuncId()) || (this
						.getFuncId() != null
						&& castOther.getFuncId() != null && this.getFuncId()
						.equals(castOther.getFuncId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getFuncId() == null ? 0 : this.getFuncId().hashCode());
		return result;
	}

}