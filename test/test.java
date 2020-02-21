package test;

import org.junit.Test;

import java.util.Arrays;

public class test {
  public long getSum(int times, int[] countArray) {
    Arrays.sort(countArray);

    int startIndex = 0;
    int endIndex = times * 2 - 1;
    long sum = 0;

    while(startIndex <= endIndex) {
      sum += countArray[startIndex] * countArray[endIndex];
      startIndex++;
      endIndex--;
    }

    return sum;
  }

  @Test
  public void test01() {
    test test = new test();
  }
}
