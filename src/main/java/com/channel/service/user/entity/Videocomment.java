package com.channel.service.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the videocomments database table.
 * 
 */
@Entity
@Table(name="videocomments")
@NamedQuery(name="Videocomment.findAll", query="SELECT v FROM Videocomment v")
public class Videocomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=255)
	private String commentid;

	//@Column(length=255)
	private String comment;

	private Timestamp commentdate;

	//@Column(length=255)
	private String coordinates;

	//@Column(length=255)
	private String country;

	@Column(nullable=false, insertable = false, updatable = false)
	private String state;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="userid", referencedColumnName="userid",insertable = false, updatable = false),
        @JoinColumn(name = "state", referencedColumnName = "state",insertable = false, updatable = false)
    })
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne	
	@JoinColumns({
		@JoinColumn(name="videoid", referencedColumnName="videoid"),
        @JoinColumn(name = "state", referencedColumnName = "state")
    })
	private Video video;

	public Videocomment() {
	}

	public String getCommentid() {
		return this.commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCommentdate() {
		return this.commentdate;
	}

	public void setCommentdate(Timestamp commentdate) {
		this.commentdate = commentdate;
	}

	public String getCoordinates() {
		return this.coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}