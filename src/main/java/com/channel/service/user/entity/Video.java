package com.channel.service.user.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.StringArrayType;

import java.sql.Timestamp;
import java.sql.Array;
import java.util.List;


/**
 * The persistent class for the videos database table.
 * 
 */

@TypeDefs({
    @TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
    )
})
@Entity
@Table(name="videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VideoPK id;

	//@Column(length=255)
	private String category;

	//@Column(length=255)
	private String coordinates;

	//@Column(length=255)
	private String country;

	//@Column(length=255)
	private String description;

	@Column(name="\"dislikes#\"")
	private Integer dislikes_;

	@Column(name="\"likes#\"")
	private Integer likes_;
	
	/*@Type(type = "string-array")
    @Column(
        name = "tags",
        columnDefinition = "text[]"
    )*/
	//private Array tags;

	//@Column(length=255)
	private String thumbniladdress;

	//@Column(length=255)
	private String title;

	private Timestamp uploaddate;

	//@Column(length=255)
	private String url;

	@Column(name="\"views#\"")
	private Integer views_;

	//bi-directional many-to-one association to User
	@ManyToOne	
	@JoinColumns({
		@JoinColumn(name="userid", referencedColumnName="userid",insertable = false, updatable = false),
        @JoinColumn(name = "state", referencedColumnName = "state",insertable = false, updatable = false)
    })
	private User user;

	//bi-directional many-to-one association to Videocomment
	@OneToMany(mappedBy="video")
	private List<Videocomment> videocomments;

	public Video() {
	}

	public VideoPK getId() {
		return this.id;
	}

	public void setId(VideoPK id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDislikes_() {
		return this.dislikes_;
	}

	public void setDislikes_(Integer dislikes_) {
		this.dislikes_ = dislikes_;
	}

	public Integer getLikes_() {
		return this.likes_;
	}

	public void setLikes_(Integer likes_) {
		this.likes_ = likes_;
	}

	/*
	 * public Array getTags() { return this.tags; }
	 * 
	 * public void setTags(Array tags) { this.tags = tags; }
	 */
	public String getThumbniladdress() {
		return this.thumbniladdress;
	}

	public void setThumbniladdress(String thumbniladdress) {
		this.thumbniladdress = thumbniladdress;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUploaddate() {
		return this.uploaddate;
	}

	public void setUploaddate(Timestamp uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getViews_() {
		return this.views_;
	}

	public void setViews_(Integer views_) {
		this.views_ = views_;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Videocomment> getVideocomments() {
		return this.videocomments;
	}

	public void setVideocomments(List<Videocomment> videocomments) {
		this.videocomments = videocomments;
	}

	public Videocomment addVideocomment(Videocomment videocomment) {
		getVideocomments().add(videocomment);
		videocomment.setVideo(this);

		return videocomment;
	}

	public Videocomment removeVideocomment(Videocomment videocomment) {
		getVideocomments().remove(videocomment);
		videocomment.setVideo(null);

		return videocomment;
	}

}