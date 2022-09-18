package com.channel.service.user.util;

import com.channel.service.user.framework.vo.MTPage;
import com.channel.service.user.framework.vo.MTResponseBody;
import com.channel.service.user.framework.vo.MTResponseStatus;
import com.channel.service.user.framework.vo.MTResponseVO;

public class MTResponseUtil {

	public static MTResponseVO getResponseVO(String pageType) {
		MTResponseVO responseVO = new MTResponseVO();
		MTResponseStatus responseStatus = new MTResponseStatus();
		MTPage page = new MTPage();
		page.setPageType(pageType);
		MTResponseBody responseBody = new MTResponseBody();
		responseBody.setPage(page);
		responseVO.setResponseBody(responseBody);
		return responseVO;
	}
}
