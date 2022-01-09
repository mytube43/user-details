package com.channel.service.user.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the videos database table.
 * 
 */
@Embeddable
public class VideoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private String videoid;

	@Column(unique=true, nullable=false)
	private String state;

	public VideoPK() {
	}
	public String getVideoid() {
		return this.videoid;
	}
	public void setVideoid(String videoid) {
		this.videoid = videoid;
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
		if (!(other instanceof VideoPK)) {
			return false;
		}
		VideoPK castOther = (VideoPK)other;
		return 
			this.videoid.equals(castOther.videoid)
			&& this.state.equals(castOther.state);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.videoid.hashCode();
		hash = hash * prime + this.state.hashCode();
		
		return hash;
	}
}