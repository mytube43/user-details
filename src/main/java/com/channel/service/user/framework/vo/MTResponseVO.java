package com.channel.service.user.framework.vo;


import com.fasterxml.jackson.annotation.JsonProperty;


public class MTResponseVO{

	@JsonProperty("ResponseInfo")
	private MTResponseStatus responseInfo;
	
	@JsonProperty("ResponseBody")
	private MTResponseBody responseBody;
	
	public MTResponseVO(MTResponseStatus responseInfo,MTResponseBody responseBody) {
		this.responseInfo=responseInfo;
		this.responseBody = responseBody;
	}
	
	public MTResponseVO(MTResponseStatus responseInfo) {
		this.responseInfo=responseInfo;
	
	}
	
	public MTResponseVO() {
		this.responseInfo= new MTResponseStatus();
		this.responseBody = new MTResponseBody();
	}

	public MTResponseStatus getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(MTResponseStatus responseInfo) {
		this.responseInfo = responseInfo;
	}

	public MTResponseBody getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(MTResponseBody responseBody) {
		this.responseBody = responseBody;
	}
	
	
	
}
