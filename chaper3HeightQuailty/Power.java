package chaper3HeightQuailty;

import org.junit.Test;

public class Power {
  public static double power(double base, int exponent) {
    if (exponent == 0) return 1;

    boolean isNegative = exponent < 0;

    double result;

    if (exponent < 0) {
      exponent = -exponent;
    }

    result = getPow(base, exponent);

    if (isNegative) {
      result = 1 / result;
    }

    return result;
  }

  private static double getPow(double base, int exponent) {
    if (exponent == 1) {
      return base;
    }

    double temp = getPow(base, exponent / 2);

    if (exponent % 2 == 0) {
      temp = temp * temp;
    } else {
      temp = temp * temp * base;
    }

    return temp;
  }

  @Test
  public void test01() {
    System.out.println(Power.power(1, 0));
    System.out.println(Power.power(2, 10));
    System.out.println(Power.power(2, -10));
  }
}
