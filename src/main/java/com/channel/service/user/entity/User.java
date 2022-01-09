package com.channel.service.user.entity;

import java.io.Serializable;
import javax.persistence.*;
//import java.sql.Timestamp;
import java.util.List;
import java.time.LocalDateTime;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserPK id;

	@Column(name = "address")
	private String address;
	
	
	private Integer age;

	//@Column(length=255)
	private String coordinates;

	//@Column(length=255)
	private String country;

	//@Column(length=255)
	private String email;

	private LocalDateTime lastlogin;

	//@Column(length=255)
	private String name;

	private LocalDateTime registereddate;

	//bi-directional many-to-one association to Video
	@OneToMany(mappedBy="user")
	private List<Video> videos;

	//bi-directional many-to-one association to Videocomment
	@OneToMany(mappedBy="user")
	private List<Videocomment> videocomments;

	public User() {
	}

	public UserPK getId() {
		return this.id;
	}

	public void setId(UserPK id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegistereddate() {
		return this.registereddate;
	}

	public void setRegistereddate(LocalDateTime registereddate) {
		this.registereddate = registereddate;
	}

	public List<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		getVideos().add(video);
		video.setUser(this);

		return video;
	}

	public Video removeVideo(Video video) {
		getVideos().remove(video);
		video.setUser(null);

		return video;
	}

	public List<Videocomment> getVideocomments() {
		return this.videocomments;
	}

	public void setVideocomments(List<Videocomment> videocomments) {
		this.videocomments = videocomments;
	}

	public Videocomment addVideocomment(Videocomment videocomment) {
		getVideocomments().add(videocomment);
		videocomment.setUser(this);

		return videocomment;
	}

	public Videocomment removeVideocomment(Videocomment videocomment) {
		getVideocomments().remove(videocomment);
		videocomment.setUser(null);

		return videocomment;
	}

}