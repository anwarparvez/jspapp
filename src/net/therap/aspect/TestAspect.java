package net.therap.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 5/1/12
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
@Aspect
public class TestAspect {
    private static final Logger log = LoggerFactory.getLogger(TestAspect.class);

 /*   @Before("execution(public * *.*(..))")
    public void doAccessCheck() {
        log.debug("deliver Checking and authenticating user");
    }*/

    @Around("execution(public * net.therap.*.*.*(..))")
    public Object publicOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object ret = joinPoint.proceed();
        long end = System.nanoTime();
        log.debug(joinPoint.getSignature() + " took " + (end - start) + " nanoseconds");
        return ret;
    }
}
