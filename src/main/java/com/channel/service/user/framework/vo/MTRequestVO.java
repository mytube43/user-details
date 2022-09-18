package com.channel.service.user.framework.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


public class MTRequestVO {
	@JsonProperty("RequestMap")
	private Map<String, Object> requestMap;

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
	
	
}
