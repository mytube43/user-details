package com.channel.service.user.framework.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class MTResponseStatus {

	@JsonProperty("responseCode")
	private String responseCode = "0000";
	
	@JsonProperty("responseStatus")
	private String responseStatus= "Success";
	
	
}
