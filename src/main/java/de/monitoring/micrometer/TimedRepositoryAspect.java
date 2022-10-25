package de.monitoring.micrometer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("!test")
public class TimedRepositoryAspect {

    @Autowired
    private MeterRegistry meterRegistry;


    @Around("@annotation(de.monitoring.micrometer.TimedRepositoryMethod)")
    public Object timedMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        var sample = Timer.start();
        var result = proceedingJoinPoint.proceed();
        var timer = meterRegistry.timer("monitoring.demo.repository.invocations.seconds",
                "repository", methodSignature.getDeclaringType().getSimpleName(),
                "method", methodSignature.getMethod().getName()
        );
        sample.stop(timer);
        return result;
    }

}
