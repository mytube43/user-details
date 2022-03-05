package com.channel.service.user.framework.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @author Amit Kumar
 * This class will hold the property that is responsible for showing the Page on device
 *
 */


public class MTPage {

	private String pageType;
	private Map<String,Object> pageMap= new HashMap<>();
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public Map<String, Object> getPageMap() {
		return pageMap;
	}
	public void setPageMap(Map<String, Object> pageMap) {
		this.pageMap = pageMap;
	}
	
	
	
}
