package main;

import chapter06.Calculator;
import chapter06.RecCalculator;
import config.AppConfig;
import config.AppContextWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContextWithCache.class);

    Calculator calculator = ctx.getBean("calculator", Calculator.class);
    calculator.factorial(7);
    calculator.factorial(7);
    calculator.factorial(5);
    calculator.factorial(5);
    ctx.close();

  }

}