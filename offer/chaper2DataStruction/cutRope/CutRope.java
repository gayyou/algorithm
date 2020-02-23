package chaper2DataStruction.cutRope;

import org.junit.Test;

public class CutRope {
  private int[] cutRopeBestResolve;

  public int theBestResult(int num) {
    if (num <= 0) {
      return 0;
    }

    this.cutRopeBestResolve = new int[num + 1];

    return this.getTheBestResolve(num);
  }

  private int getTheBestResolve(int num) {
    if (this.cutRopeBestResolve[num] != 0) {
      return this.cutRopeBestResolve[num];
    }

    if (num == 1 || num == 0) {
      return 1;
    }

    int max = 0;

    for (int i = 1; i <= num; i++) {
      int temp = this.getTheBestResolve(num - i) * i;  // 这里i是可以到达num的，目的是只有一段绳子的时候的最佳解

      max = Math.max(temp, max);
    }

    this.cutRopeBestResolve[num] = max;

    return max;
  }

  /**
   * @description 使用贪婪法进行寻求最优解，使得每个数字里面分解出来的3尽可能多。并且如果倒数第二次剩下四的时候，不要继续分解出三，而是分解成2 * 2
   * @param num
   * @return
   */
  public int getTheBestResultByGreedy(int num) {
    if (num <= 0) {
      return 0;
    }

    if (num == 1) {
      return 1;
    }

    if (num == 2) {
      return 2;
    }

    int timesOf3 = num / 3;
    int timesOf2 = 0;

    if (num % 3 == 1) {
      timesOf3--;
      timesOf2 = 2;
    } else if (num % 3 == 2) {
      timesOf2 = 1;
    }

    return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
  }

  @Test
  public void test01() {
    CutRope cutRope = new CutRope();
    System.out.println(cutRope.theBestResult(8));
    System.out.println(cutRope.getTheBestResultByGreedy(8));
  }
}
