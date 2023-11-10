package kr.co.dong.common;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//advice : 공통업무를 지원하는 클래스

@Component
@Aspect
public class LoggerAspect {  
	protected Logger log = LoggerFactory.getLogger(LoggerAspect.class);
	  
	//컨트롤러 시작전과 후에 타이머를 작동 시키자
	@Around("execution(* kr.co.dong.controller.*Controller.*(..))")   
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		//핵심업무(Controller가 하는일) 실행전
		Object result = null;
		long start = System.currentTimeMillis();
		
		//핵심업무 실행
		result = joinPoint.proceed();
		
		//핵심업무 실행후
		long end = System.currentTimeMillis();
		log.info("-> 수행시간 " + (end-start) + "밀리초");
		return result;
	}
}
