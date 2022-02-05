package com.channel.service.user.feed.service;

import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseVO;

/**
 * 
 * @author HP
 *
 */
public interface IFeedService {

	public void getHomeFeed( MTRequestVO requestVO,WorkflowContextMap contextMap) ;
}
