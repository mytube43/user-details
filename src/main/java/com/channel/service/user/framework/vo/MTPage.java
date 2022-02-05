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

@Data
public class MTPage {

	private String pageType;
	private Map<String,Object> pageMap= new HashMap<>();
}
