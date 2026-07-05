package spring_boot_rest.spring_boot_rest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);
    @Around("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(..))")

    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

    Object obj = jp.proceed();

    long start = System.currentTimeMillis();



    long end = System.currentTimeMillis();
    LOGGER.info("Time Taken by : "+ jp.getSignature().getName() + " : "+(end-start)+ "ms");
    return obj;
    }
}
