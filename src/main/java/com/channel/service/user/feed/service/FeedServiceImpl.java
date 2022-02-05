package com.channel.service.user.feed.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channel.service.user.framework.MTApplicationContext;
import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.FeedResponseVO;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseVO;

/**
 * 
 * @author HP
 *
 */
@Component("feedService")
public class FeedServiceImpl implements IFeedService{

	@Autowired
	MTApplicationContext appContext;
	@Override
	public void getHomeFeed( MTRequestVO requestVO,WorkflowContextMap contextMap) {
		MTResponseVO responseVO = contextMap.getMTResponse("responseVO");
		responseVO.getResponseBody().getPage().setPageType(FeedServicePageType.HOME_FEED_SERVICE_PAGETYPE);
		List<FeedResponseVO> videoFeedList = new ArrayList<FeedResponseVO>();
		
		videoFeedList.add(getFeedRespObject("1001"));
		videoFeedList.add(getFeedRespObject("1002"));
		videoFeedList.add(getFeedRespObject("1003"));
		videoFeedList.add(getFeedRespObject("1004"));
		videoFeedList.add(getFeedRespObject("1005"));
		videoFeedList.add(getFeedRespObject("1006"));
		videoFeedList.add(getFeedRespObject("1007"));
		videoFeedList.add(getFeedRespObject("1008"));
		videoFeedList.add(getFeedRespObject("1009"));
		videoFeedList.add(getFeedRespObject("10010"));
		responseVO.getResponseBody().getPage().getPageMap().put("feedList", videoFeedList);
		return ;
	}
	
	private FeedResponseVO getFeedRespObject(String videoId) {
		FeedResponseVO feedRespVO = new FeedResponseVO();
		feedRespVO.setUrl("http://google.com");
		feedRespVO.setCategory("public");
		feedRespVO.setThumbniladdress("http://google.com");
		feedRespVO.setDescription("This is my Test Video");
		feedRespVO.setTitle("Good Video");
		feedRespVO.setLikes(110L);
		feedRespVO.setDislikes(0L);
		feedRespVO.setUploaddate("1Day");
		feedRespVO.setVideoid(videoId);
		return feedRespVO;
	}
}
