//package com.noriteo.delinori.board.aop;
//
//import lombok.extern.log4j.Log4j2;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Log4j2
//@Component
//public class TimeLogAspect {
//
//    {
//        log.info("--------------로그로그로그로그-------------");
//        log.info("--------------로그로그로그로그-------------");
//        log.info("--------------로그로그로그로그-------------");
//        log.info("--------------로그로그로그로그-------------");
//        log.info("--------------로그로그로그로그-------------");
//    }
//
//    @Before("execution(* com.noriteo.delinori.board.service.*.*(..))")//*은 접근제한자
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("logBefore.........................");
//
//        log.info(joinPoint.getTarget());//실제 객체
//        log.info(Arrays.toString(joinPoint.getArgs()));//파라미터 값도 가져오는거같은데 모르겠다다
//   }
//
//    @AfterReturning("execution(* com.noriteo.delinori.board.service.*.*(..))")//*은 접근제한자
//    public void logAfter() {
//        log.info("logAfter.........................");
//    }
//}
