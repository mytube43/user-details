package com.channel.service.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.channel.service.user.framework.MTServiceController;
import com.channel.service.user.framework.vo.FeedResponseVO;
import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseBody;
import com.channel.service.user.framework.vo.MTResponseStatus;
import com.channel.service.user.framework.vo.MTResponseVO;

@RestController
@RequestMapping("feed/v1")
public class VideoFeedServiceController extends MTServiceController{

	Logger log = LoggerFactory.getLogger(VideoFeedServiceController.class);

	@PostMapping("getVideoFeed")
	public @ResponseBody MTResponseVO getLatestFeeds(@RequestBody MTRequestVO requestVO){
		log.info("Starting VideoFeedController >>>>>>>>>>>");
		MTResponseVO responseVO= execute(requestVO, "feedService", "getHomeFeed");
		
		return responseVO;
	}
	
	
}
