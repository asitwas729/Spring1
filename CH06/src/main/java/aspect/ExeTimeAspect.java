package aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {
  @Pointcut("execution(public * chapter06..*(..))")
  private void publicTarget() {
  }

  @Around("publicTarget()")
  public Object main(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.nanoTime();

    try {
      Object result = joinPoint.proceed();
      //Object result = ProceedingJoinPoint.proceed();
      return result;
    } finally {
      long end = System.nanoTime();
      Signature sig = joinPoint.getSignature();
      System.out.printf("%s.%s(%s) 실행 시간 : %d ns\n",
          joinPoint.getTarget().getClass().getSimpleName(),
          sig.getName(),
          Arrays.toString(joinPoint.getArgs()),
          (end - start));
    }
  }
}