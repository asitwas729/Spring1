package chapter06;

public class ImpleCalculator implements Calculator{

  @Override
  public long factorial(long num) {
    long result = 1;
    for(long i=1; i<= num; i++) {
      result *= i;
    }
    return result;
  }
}