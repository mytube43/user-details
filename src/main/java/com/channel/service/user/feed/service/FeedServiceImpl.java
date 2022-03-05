package com.channel.service.user.feed.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channel.service.user.entity.Video;
import com.channel.service.user.framework.MTApplicationContext;
import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.FeedResponseVO;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseVO;
import com.channel.service.user.repository.VideoFeedRepository; 

/**
 * 
 * @author HP
 *
 */
@Component("feedService")
public class FeedServiceImpl implements IFeedService{

	Logger log = LoggerFactory.getLogger(FeedServiceImpl.class);
	@Autowired
	MTApplicationContext appContext;

	@Autowired
	VideoFeedRepository feedRepository;

	@Override
	public void getHomeFeed( MTRequestVO requestVO,WorkflowContextMap contextMap) {
		try {
			MTResponseVO responseVO = contextMap.getMTResponse("responseVO");
			responseVO.getResponseBody().getPage().setPageType(FeedServicePageType.HOME_FEED_SERVICE_PAGETYPE);
			List<FeedResponseVO> videoFeedList = getVideoList();
			responseVO.getResponseBody().getPage().getPageMap().put("feedList", videoFeedList);
			
		}catch(Exception e) {
			log.error("Exception while preparing Video Feed Response!!",e);
		}
	}

	private List<FeedResponseVO> getVideoList(){
		Iterable<Video> videoFeedIterator = feedRepository.findAll();
		List<FeedResponseVO> feedList = new ArrayList<FeedResponseVO>();
		try {
			if(null!=videoFeedIterator) {
				for(Video video:videoFeedIterator) {
					if(null!=video) {
						FeedResponseVO feedResp = new FeedResponseVO();
						feedResp.setTitle(video.getTitle());
						feedResp.setCategory(video.getCategory());
						feedResp.setThumbniladdress(video.getThumbniladdress());
						//feedResp.setTags((String[])video.getTags().getArray());
						feedResp.setVideoid(video.getId().getVideoid());
						feedResp.setCountry(video.getCountry());
						feedResp.setDescription(video.getDescription());
						feedResp.setUrl(video.getUrl());
						feedResp.setLikes(Long.parseLong(String.valueOf(video.getLikes_())));
						feedResp.setDislikes(Long.parseLong(String.valueOf(video.getDislikes_())));
						//feedResp.setUploaddate(video.getUploaddate());
						feedResp.setUserid(video.getUser().getName());
						feedList.add(feedResp);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedList;
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
