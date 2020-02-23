package chaper2DataStruction;

import org.junit.Test;

public class NumberOf1 {
  public static int getNumberOf1(int number) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
      int temp = number & flag;
      if (temp != 0) {
        count++;
      }
      flag = flag << 1;
    }
    return count;
  }

  public static int theBestWay(int number) {
    int counter = 0;
    while (number != 0) {
      counter += number & 1;
      number >>>= 1;  // 进行无符号右移
    }
    return counter;
  }

  @Test
  public void test01() {
    System.out.println(NumberOf1.theBestWay(0xFFFFFFFF));
  }
}
