package chaper3HeightQuailty;

import org.junit.Test;

/**
 * @description 这道题看似很简单，但是有一个坑，就是如果需要打印64位的数字，那么用long等都无法表示，因为都会溢出，此时
 * 需要用到字符串来模拟递增来打印实现。
 */
public class PrintToMaxOfDigits {
  public static void print(int n) {
    if (n <= 0) {
      return ;
    }
    StringBuilder counter = new StringBuilder("0");

    StringBuilder max = new StringBuilder();

    for (int i = 0; i < n; i++) {
      max.append('9');
    }

    while(!counter.toString().equals(max.toString())) {
      // 当
      System.out.println(counter.toString());

      int i = counter.length() - 1;  // 获得最后一位的下标

      while (i >= 0) {
        // 当下标大于0的时候，进行操作
        if (counter.charAt(i) == '9') {
          // 如果当前位置是9的话，需要进行进位，并且将当前位置设为0
          counter.setCharAt(i, '0');

          if (i == 0 && counter.length() < n) {
            // 当当前位数小于目标位数的时候，需要再向字符串添加1
            counter = new StringBuilder("1" + counter.toString());
          }
          i--;  // 进位进到下一个循环进行判断
        } else {
          // 没有进位，直接加1后结束
          counter.setCharAt(i, (char) (counter.charAt(i) + 1));
          break ;
        }
      }
    }
    System.out.println(counter.toString());
  }

  @Test
  public void test01() {
    PrintToMaxOfDigits.print(1);
  }
}
