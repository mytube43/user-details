package com.channel.service.user.framework;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.channel.service.user.framework.vo.MTRequestVO;
import com.channel.service.user.framework.vo.MTResponseStatus;
import com.channel.service.user.framework.vo.MTResponseVO;

@Component
public abstract class MTServiceController {

	Logger log = LoggerFactory.getLogger(MTServiceController.class);
	
	@Autowired
	@Qualifier("MTApplicationContext")
	private MTApplicationContext mtApplicationContext;
	
	protected MTResponseVO execute(MTRequestVO requestVO,String serviceName,String methodName) {
		try {
			if(StringUtils.isNoneBlank(serviceName) && StringUtils.isNotBlank(methodName)) {
				Object serviceBean =  mtApplicationContext.getMTApplicationContext().getBean(serviceName);
				Method[] methodArray= serviceBean.getClass().getMethods();
				//MTResponseVO responseVO = new MTResponseVO()
				WorkflowContextMap contextMap = (WorkflowContextMap)RequestContextHolder.getRequestAttributes().getAttribute("contextMap", RequestAttributes.SCOPE_REQUEST);
				Method serviceMethod=serviceBean.getClass().getMethod(methodName, MTRequestVO.class, WorkflowContextMap.class);
				if(null==serviceMethod) {
					throw new Exception();
				}
				serviceMethod.invoke(serviceBean, requestVO,contextMap);
				return contextMap.getMTResponse("responseVO");
			}else {
				log.info("ServiceName || method name missing in executing workflow! Please fix!");
				throw new Exception();
			}
		}catch(Exception e) {
			log.info("Exception ::",e);
		}
		return null;
	}
}
