package com.channel.service.user.framework.vo;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @author Amit Kumar
 *
 *
 */


public class MTResponseBody {
	
	private MTPage page = new MTPage();

	public MTPage getPage() {
		return this.page;
	}
	
	public void setPage(MTPage page) {
		this.page = page;
	}
	
	
	
}
