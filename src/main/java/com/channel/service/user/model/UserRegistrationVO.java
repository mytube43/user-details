package com.channel.service.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "UserRegistrationVO")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRegistrationVO {

	@JsonProperty("firstName")
	private String  firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("dob")
	private String dob ;
	
	@JsonProperty("email")
	private String email ;
	
	@JsonProperty("password")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserRegistrationVO [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + "]";
	}


}