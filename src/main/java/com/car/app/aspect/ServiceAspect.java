package com.car.app.aspect;


import java.lang.reflect.Method;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.car.app.common.BaseRequest;
import com.car.app.common.BaseResponse;
import com.car.app.common.ResponseCode;
import com.car.app.common.ResponseException;

/**
 * 操作log记录
 * requestId补偿赋值
 * 接口花费时间
 *
 * @author lbc
 */
//@Aspect
//@Component
public class ServiceAspect {

    private static final Logger logger = LogManager.getLogger(ServiceAspect.class);
    private static final Logger operateLogger = LogManager.getLogger("operateLog");
    //	@Value(value = "${asd.log4j.dir}")
    private String LOG_DIR;


    @Pointcut("execution(* com.alicloud.aso.apiadapter.service.*Service.*(..))")
    public void all_service() {
    }

    @Around("all_service()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//		logger.info("==============Around Before !! ================");
        try {
            return proceed(pjp);
        } finally {
//			CallerContext.setContext(null);
//			logger.info("==============Around After !!================");
        }

    }

    /**
     * 处理注解
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    private Object proceed(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Object returnValue = null;
        long start = System.currentTimeMillis();
        Method method = getInvocationMethod(pjp.getTarget(), pjp.getSignature()
                .getName());
//		CheckPermission anno = method.getAnnotation(CheckPermission.class);
        if (args.length > 0 && args[0] instanceof Object) {
//            BaseRequest request = (BaseRequest) args[0];
//            if (request.getRequestId() == null) {
//                request.setRequestId(UUID.randomUUID().toString());
//            }
//            String action = "erms:" + method.getName();
//            request.setAction(action);
////			if (anno == null || anno.ignore()) {
////				return pjp.proceed();
////			}
////			action = anno.action();
//            request.setAction(action);
            BaseResponse response = null;
            Class<?> returnType = method.getReturnType();
            if ((ResponseEntity.class.equals(returnType))) {
                //如果是下载请求直接返回结果
                return pjp.proceed();
            }
            try {
                returnValue = returnType.newInstance();
//				response = authService.authUserPermission(request);
//				response.setCost(System.currentTimeMillis() - start);
//				if (!response.isSuccess()) {
//					// 无权操作，直接放回验权结果
//					BeanCopyUtil.copy(response, returnValue);
//					return returnValue;
//				}
                // 有权操作
                // returnValue 问原来的方法返回值
                returnValue = pjp.proceed();
                if (returnValue instanceof BaseResponse) {
                    response = (BaseResponse) returnValue;
//                    response.setRequestId(request.getRequestId());
                    response.setCost(System.currentTimeMillis() - start);
                }
                return returnValue;
            } catch (Throwable e) {
                logger.error(e.getMessage(), e);
                response = (BaseResponse) returnValue;
                response.setCost(System.currentTimeMillis() - start);
                if (e instanceof ResponseException) {
                    ResponseException ee = (ResponseException) e;
                    response.copy(ee.getResponse());
                    return response;
                }
                response.setErrorResponse(ResponseCode.InternalServerError_$$,
                        e.getClass().getName(), e.getMessage());
                return response;
            } finally {
                // 记录操作日志
//                operateLog(request, response);
            }
        }
        // 参数未有BeseRequest直接调用
        return pjp.proceed();
    }

    private Method getInvocationMethod(Object target, String methodName) {
        Class<? extends Object> clazz = target.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    private void operateLog(BaseRequest request, BaseResponse response) {
        //TODO oplog格式需要优化完善
        String oplog = String.format("action:%s, requestId:%s, code:%s, cost:%d", request.getAction(), request.getRequestId(), response.getCode(), response.getCost());
        operateLogger.info(oplog);
    }



}


