package com.channel.service.user.framework.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.channel.service.user.framework.WorkflowContextMap;
import com.channel.service.user.framework.vo.MTResponseVO;

@Component
@Aspect
public class MTCoreAdvice {

	Logger log = LoggerFactory.getLogger(MTCoreAdvice.class);

	@Around("execution(* com.channel.service.user.controller..*(..)))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
	{
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		//Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();
		WorkflowContextMap contextMap = new WorkflowContextMap();
		contextMap.get().put("responseVO", new MTResponseVO());
		RequestContextHolder.getRequestAttributes().setAttribute("contextMap", contextMap, RequestAttributes.SCOPE_REQUEST);
		//Measure method execution time
		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		//Log method execution time
		log.info("Execution time of " + className + "." + methodName + " "
				+ ":: " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}
}
