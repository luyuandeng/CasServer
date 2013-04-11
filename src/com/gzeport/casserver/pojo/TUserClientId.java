package com.gzeport.casserver.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TUserClientId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TUserClientId implements java.io.Serializable {

	// Fields

	private Long userId;
	private String clientId;

	// Constructors

	/** default constructor */
	public TUserClientId() {
	}

	/** full constructor */
	public TUserClientId(Long userId, String clientId) {
		this.userId = userId;
		this.clientId = clientId;
	}

	// Property accessors

	@Column(name = "USER_ID", nullable = false, precision = 12, scale = 0)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "CLIENT_ID", nullable = false, length = 10)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TUserClientId))
			return false;
		TUserClientId castOther = (TUserClientId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(
				castOther.getUserId())))
				&& ((this.getClientId() == castOther.getClientId()) || (this
						.getClientId() != null
						&& castOther.getClientId() != null && this
						.getClientId().equals(castOther.getClientId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getClientId() == null ? 0 : this.getClientId().hashCode());
		return result;
	}

}