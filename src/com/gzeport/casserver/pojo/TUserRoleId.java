package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TUserRoleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TUserRoleId implements java.io.Serializable {

	// Fields

	private Long userId;
	private Long roleId;

	// Constructors

	/** default constructor */
	public TUserRoleId() {
	}

	/** full constructor */
	public TUserRoleId(Long userId, Long roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	// Property accessors

	@Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "ROLE_ID", nullable = false, precision = 12, scale = 0)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserRoleId))
			return false;
		TUserRoleId castOther = (TUserRoleId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null
						&& castOther.getRoleId() != null && this.getRoleId()
						.equals(castOther.getRoleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		return result;
	}

}