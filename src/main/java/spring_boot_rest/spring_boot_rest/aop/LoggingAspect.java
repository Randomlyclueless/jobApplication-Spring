package spring_boot_rest.spring_boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    for applyig to indivisual elements - return type,class name(complete package path), method name,( argument)



    @Before("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(..) ) || execution(* spring_boot_rest.spring_boot_rest.service.JobService.updateJob(..) )")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(..) ) || execution(* spring_boot_rest.spring_boot_rest.service.JobService.updateJob(..) )")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(..) ) || execution(* spring_boot_rest.spring_boot_rest.service.JobService.updateJob(..) )")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method has some issues :  " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* spring_boot_rest.spring_boot_rest.service.JobService.getJob(..) ) || execution(* spring_boot_rest.spring_boot_rest.service.JobService.updateJob(..) )")
    public void logMethodExecutedSuccessfully(JoinPoint jp){
        LOGGER.info("Method Executed Successfully :  " + jp.getSignature().getName());
    }
}
