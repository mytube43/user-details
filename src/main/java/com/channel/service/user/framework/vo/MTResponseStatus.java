package com.channel.service.user.framework.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



public class MTResponseStatus {

	@JsonProperty("responseCode")
	private String responseCode = "0000";
	
	@JsonProperty("responseStatus")
	private String responseStatus= "Success";

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
}
