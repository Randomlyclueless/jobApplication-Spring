package spring_boot_rest.spring_boot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(int)) && args(postId)")
    public Object validateAndUpdate(
            ProceedingJoinPoint jp,
            int postId
    ) throws Throwable {

        LOGGER.info("ValidationAspect called with PostId: " + postId);

        if (postId < 0) {

            LOGGER.info("PostId is negative, updating it");

            postId = Math.abs(postId);

            LOGGER.info("New Value: " + postId);
        }

        return jp.proceed(new Object[]{postId});
    }
}