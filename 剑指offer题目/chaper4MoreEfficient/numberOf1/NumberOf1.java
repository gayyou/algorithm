package chaper4MoreEfficient.numberOf1;

import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/8 9:12
 */
public class NumberOf1 {
  int[] cacheCount;

  public int getNumberOf1(int n) {
    int len = ((Integer) n).toString().length();
    this.preSetCache(len);
    int tempCount;
    int sumOf1 = 0;
    int targetNumber = n;

    // 这个循环的思路是从10位开始，取出每一位的数字（这个数字除了最高位之外，其余都为0）
    for (int i = 1; i <= len; i++) {
      // 从个位数开始拿到当前位数的数字
      tempCount = n % ((int) Math.pow(10, i)) / (int) Math.pow(10, i - 1);


      sumOf1 += this.cacheCount[i - 1] * tempCount;     // cacheCount就是比当前位数小一位的数字的最高位中存在1的个数，（如999中存在1的个数）

      if (tempCount > 1) {
        // 如果当前最高位大于1，那么要考虑到1开头的数字中含有  10的i-1次方个1
        sumOf1 += (int) Math.pow(10, i - 1);
      } else if (tempCount == 1) {
        // 如果最高为位1的话，1出现的次数就是后面数字的次数
        sumOf1 += targetNumber - n + 1;
      }

      n = n / (int) Math.pow(10, i) * (int) Math.pow(10, i);
    }

    return sumOf1;
  }

  private void preSetCache(int len) {
    if (len <= 0) {
      return ;
    }

    this.cacheCount = new int[len];
    this.cacheCount[0] = 0;

    for (int i = 1; i < len; i++) {
      this.cacheCount[i] = this.cacheCount[i - 1] * 10 + (int) Math.pow(10, i - 1);
    }

    System.out.println(Arrays.toString(this.cacheCount));
  }

  public static void main(String[] args) {
    NumberOf1 numberOf1 = new NumberOf1();
    System.out.println(numberOf1.getNumberOf1(21345));
  }
}
