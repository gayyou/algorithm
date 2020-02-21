package test;

import org.junit.Test;

public class HanoiTower {
  private int[] numberCacheArray;

  public HanoiTower() {}

  public HanoiTower(int n) {
    this.numberCacheArray = new int[n];
  }

  public int getCount(int n) {
    if (n == 1) return 1;

    return 2 * this.getCount(n - 1) + 1;
  }
}
