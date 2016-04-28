package cn.jely.cd.exception;

import cn.jely.cd.domain.ActionJsonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AjaxAspect {
    @Pointcut(value = "execution(public cn.jely.cd.domain.ActionJsonResult cn.jely.cd..*Controller.*(..))")
    public void aroundAjax() {
    }
    @Around("aroundAjax()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            ActionJsonResult result = ActionJsonResult.fail(throwable);
            return result;
        }
    }
}
