package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    
    // @Around : aop를 어디에 적용할지 타겟을 지정할 수 있다
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        //joinPoint.proceed() : 다음 메소드로 진행됨joinPoint.proceed()
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try{
        Object result = joinPoint.proceed();
        return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");

        }

    }
    
    
}
