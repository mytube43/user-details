package com.channel.service.user.framework.vo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MTRequestVO {
	@JsonProperty("RequestMap")
	private Map<String, Object> requestMap;
}
