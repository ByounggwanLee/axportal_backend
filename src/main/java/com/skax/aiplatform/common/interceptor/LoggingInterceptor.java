package com.skax.aiplatform.common.interceptor;

import com.skax.aiplatform.common.util.TraceUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 로깅 인터셉터 (AOP)
 * 
 * <p>컨트롤러, 서비스, 레포지토리 메서드의 실행을 자동으로 추적하고 로깅합니다.
 * 메서드 실행 시간, 파라미터, 결과를 구조화된 형태로 기록합니다.</p>
 * 
 * @author ByounggwanLee
 * @since 2025-08-01
 * @version 1.0.0
 */
@Slf4j
@Aspect
@Component
public class LoggingInterceptor {

    /**
     * 컨트롤러 메서드 실행 로깅
     * 
     * @param joinPoint 조인 포인트
     * @return 메서드 실행 결과
     * @throws Throwable 메서드 실행 중 발생한 예외
     */
    @Around("execution(* com.skax.aiplatform.controller..*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        return logMethodExecution(joinPoint, "CONTROLLER");
    }

    /**
     * 서비스 메서드 실행 로깅
     * 
     * @param joinPoint 조인 포인트
     * @return 메서드 실행 결과
     * @throws Throwable 메서드 실행 중 발생한 예외
     */
    @Around("execution(* com.skax.aiplatform.service..*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        return logMethodExecution(joinPoint, "SERVICE");
    }

    /**
     * 레포지토리 메서드 실행 로깅
     * 
     * @param joinPoint 조인 포인트
     * @return 메서드 실행 결과
     * @throws Throwable 메서드 실행 중 발생한 예외
     */
    @Around("execution(* com.skax.aiplatform.repository..*(..))")
    public Object logRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        return logMethodExecution(joinPoint, "REPOSITORY");
    }

    /**
     * Feign Client 메서드 실행 로깅
     * 
     * @param joinPoint 조인 포인트
     * @return 메서드 실행 결과
     * @throws Throwable 메서드 실행 중 발생한 예외
     */
    @Around("execution(* com.skax.aiplatform.client..*(..))")
    public Object logFeignClient(ProceedingJoinPoint joinPoint) throws Throwable {
        return logApiCall(joinPoint);
    }

    /**
     * 메서드 실행 로깅 공통 로직
     * 
     * @param joinPoint 조인 포인트
     * @param layer 레이어 타입 (CONTROLLER, SERVICE, REPOSITORY)
     * @return 메서드 실행 결과
     * @throws Throwable 메서드 실행 중 발생한 예외
     */
    private Object logMethodExecution(ProceedingJoinPoint joinPoint, String layer) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // 새로운 스팬 ID 생성
        String parentSpanId = TraceUtils.getSpanId();
        String currentSpanId = TraceUtils.generateSpanId();
        TraceUtils.setSpanId(currentSpanId);
        TraceUtils.setParentSpanId(parentSpanId);

        long startTime = System.currentTimeMillis();

        // 메서드 시작 로그
        log.info("{}|METHOD_START|{}|{}|args={}", 
                layer, className, methodName, formatArgs(args));

        try {
            // 메서드 실행
            Object result = joinPoint.proceed();

            long duration = System.currentTimeMillis() - startTime;

            // 메서드 완료 로그
            log.info("{}|METHOD_END|{}|{}|duration={}ms|result={}", 
                    layer, className, methodName, duration, formatResult(result));

            return result;

        } catch (Throwable throwable) {
            long duration = System.currentTimeMillis() - startTime;

            // 메서드 오류 로그
            TraceUtils.logError("메서드 실행 중 오류 발생", throwable, 
                    "layer", layer,
                    "class", className,
                    "method", methodName,
                    "duration", duration + "ms");

            throw throwable;

        } finally {
            // 스팬 ID 복원
            TraceUtils.setSpanId(parentSpanId);
            TraceUtils.removeParentSpanId();
        }
    }

    /**
     * API 호출 로깅 (Feign Client)
     * 
     * @param joinPoint 조인 포인트
     * @return API 호출 결과
     * @throws Throwable API 호출 중 발생한 예외
     */
    private Object logApiCall(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        // API 호출 시작 로그
        TraceUtils.logApiCallStart(className, methodName, formatArgs(args));

        long startTime = System.currentTimeMillis();

        try {
            // API 호출 실행
            Object result = joinPoint.proceed();

            long duration = System.currentTimeMillis() - startTime;

            // API 호출 완료 로그
            TraceUtils.logApiCallEnd(className, methodName, duration, formatResult(result));

            return result;

        } catch (Throwable throwable) {
            long duration = System.currentTimeMillis() - startTime;

            // API 호출 오류 로그
            TraceUtils.logError("API 호출 중 오류 발생", throwable,
                    "client", className,
                    "method", methodName,
                    "duration", duration + "ms");

            throw throwable;
        }
    }

    /**
     * 메서드 파라미터 포맷팅
     * 
     * @param args 메서드 파라미터 배열
     * @return 포맷팅된 파라미터 문자열
     */
    private String formatArgs(Object[] args) {
        if (args == null || args.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(formatValue(args[i]));
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * 메서드 실행 결과 포맷팅
     * 
     * @param result 메서드 실행 결과
     * @return 포맷팅된 결과 문자열
     */
    private String formatResult(Object result) {
        return formatValue(result);
    }

    /**
     * 객체 값 포맷팅 (민감한 정보 마스킹)
     * 
     * @param value 포맷팅할 객체
     * @return 포맷팅된 문자열
     */
    private String formatValue(Object value) {
        if (value == null) {
            return "null";
        }

        String valueStr = value.toString();
        String lowerValue = valueStr.toLowerCase();

        // 민감한 정보 마스킹
        if (lowerValue.contains("password") || 
            lowerValue.contains("pwd") || 
            lowerValue.contains("secret") ||
            lowerValue.contains("token") ||
            lowerValue.contains("key")) {
            return "[MASKED]";
        }

        // 긴 문자열 truncate
        if (valueStr.length() > 200) {
            return valueStr.substring(0, 200) + "...";
        }

        return valueStr;
    }
}
