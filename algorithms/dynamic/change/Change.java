package algorithms.dynamic.change;

import java.util.HashSet;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2019/12/15 22:39
 */
public class Change {
  private HashSet<Integer> coinSet;
  int[] moneyList = new int[100];

  {
    coinSet = new HashSet<>();
  }

  public Change(int[] coinsValue) {
    for (int value : coinsValue) {
      coinSet.add(value);
    }
  }

  /**
   * @description 思路是将问题从大到小进行分解，如果需要一个面值为35的硬币，先按已有硬币的面值进行减少一个硬币，进行循环递归调用
   * 如果有5 10面值的硬币，就要进行两次递归调用。
   */
  public int getMinCoins(int money) {
    if (money <= 0) {
      return 0;
    }

    if (coinSet.contains(money)) {
      moneyList[money] = 1;
      return 1;
    }

    if (moneyList[money] != 0) {
      return moneyList[money];
    }

    int count = Integer.MAX_VALUE;
    for (Integer integer : coinSet) {
      if (money - integer > 0) {
        count = Math.min(count, getMinCoins(money - integer) + 1);
      }
    }

    moneyList[money] = count;
    return count;
  }

  public static void main(String[] args) {
    int[] coinsValue = new int[]{1, 2, 5, 10, 20};
    Change change = new Change(coinsValue);
    System.out.println(change.getMinCoins(35));
  }
}
