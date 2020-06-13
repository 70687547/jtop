/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package top.jianx.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 日志，切面处理类
 *
 * @author Jianx jianx70687547@gmail.com
 */
@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(top.jianx.common.annotation.Log)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		System.out.println(point.getSignature().getName()+"執行時間：" + time);
		//保存日志
//		saveSysLog(point, time);

		return result;
	}

//	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
//		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//		Method method = signature.getMethod();
//
//		SysLogEntity sysLog = new SysLogEntity();
//		SysLog syslog = method.getAnnotation(SysLog.class);
//		if(syslog != null){
//			//注解上的描述
//			sysLog.setOperation(syslog.value());
//		}
//
//		//请求的方法名
//		String className = joinPoint.getTarget().getClass().getName();
//		String methodName = signature.getName();
//		sysLog.setMethod(className + "." + methodName + "()");
//
//		//请求的参数
//		Object[] args = joinPoint.getArgs();
//		try{
//			String params = new Gson().toJson(args);
//			sysLog.setParams(params);
//		}catch (Exception e){
//
//		}
//
//		//获取request
//		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//		//设置IP地址
//		sysLog.setIp(IPUtils.getIpAddr(request));
//
//		//用户名
//		String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();
//		sysLog.setUsername(username);
//
//		sysLog.setTime(time);
//		sysLog.setCreateDate(new Date());
//		//保存系统日志
//		sysLogService.save(sysLog);
//	}
}
