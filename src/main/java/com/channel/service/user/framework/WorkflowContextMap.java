package com.channel.service.user.framework;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.channel.service.user.framework.vo.MTResponseVO;

public class WorkflowContextMap {

	private static final String RESPONSE_VO = "responseVO";
	private Map<String, Object> contextMap = new HashMap<String, Object>();
	
	public Map<String,Object> get(){
		return contextMap;
	}
	
	public MTResponseVO getMTResponse(String key) {
		if(contextMap.containsKey(RESPONSE_VO)) {
			return (MTResponseVO)contextMap.get(RESPONSE_VO);
		}
		return null;
	}
}
