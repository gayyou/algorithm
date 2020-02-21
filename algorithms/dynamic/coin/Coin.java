package algorithms.dynamic.coin;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/15 21:58
 */
public class Coin {
  int[] moneys;
  int[] coins;

  public Coin(int[] coins) {
    this.coins = coins;
    this.moneys = new int[coins.length];
  }

  /**
   * @description 将问题从0开始，得出每个长度的最优解，然后最优解的结合就能得到最大的最优解。
   * 硬币串分成两种，一种是包含最后一个硬币的硬币串，一种是不包含最后一个硬币的硬币串。每个长
   * 度硬币的最优解是由上面两种硬币结合情况产生的，所以得出公式f(n) = max{coins[n] + f(n - 2), f(n - 1)}
   */
  public int getMaxMoney(int index) {
    if (index < 0) {
      return 0;
    }
    if (index == 0) {
      moneys[0] = coins[0];
      return coins[0];
    }
    if (moneys[index] != 0) {
      return moneys[index];
    }
    int money = Math.max(coins[index] + getMaxMoney(index - 2), getMaxMoney(index - 1));
    moneys[index] = money;
    return money;
  }

  public static void main(String[] args) {
    int[] coins = new int[]{5, 1, 2, 10, 6, 2, 12, 13};
    Coin coin = new Coin(coins);
    System.out.println(coin.getMaxMoney(coins.length - 1));
  }
}
