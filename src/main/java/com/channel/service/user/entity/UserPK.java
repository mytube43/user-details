package com.channel.service.user.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the users database table.
 * 
 */
@Embeddable
public class UserPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private String userid;

	@Column(unique=true, nullable=false)
	private String state;

	public UserPK() {
	}
	public String getUserid() {
		return this.userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserPK)) {
			return false;
		}
		UserPK castOther = (UserPK)other;
		return 
			this.userid.equals(castOther.userid)
			&& this.state.equals(castOther.state);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid.hashCode();
		hash = hash * prime + this.state.hashCode();
		
		return hash;
	}
}