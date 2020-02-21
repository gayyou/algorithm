package algorithms.dynamic.packageQuestion.completePackage;

import algorithms.dynamic.packageQuestion.Thing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/10 15:41
 */
public class CompletePackage {
  public static int getMaxValue(List<Thing> list, int capacity) {
    int tempCount;
    int rawLength = list.size();

    // 将完全背包问题转化为01背包问题
    for (int i = 0; i < rawLength; i++) {
      tempCount = 2;
      Thing tempThing = list.get(i);
      tempThing.setCount(1);

      while (tempCount <= (capacity / tempThing.getWeight())) {
        list.add(new Thing(tempThing, tempCount));
        tempCount = tempCount * 2;
      }
    }

    int dp[] = new int[capacity + 1];

    for (Thing thing : list) {
      for (int i = capacity; i > 0; i--) {
        if (i >= (thing.getCount() * thing.getWeight())) {
          dp[i] = Integer.max(dp[i - (thing.getCount() * thing.getWeight())] + (thing.getCount() * thing.getValue()), dp[i]);
        }
      }
    }

    return dp[capacity];
  }

  public static int getMaxValue2(List<Thing> list, int capacity) {
    if (list.size() == 0) {
      return 0;
    }

    int[] dp = new int[capacity + 1];

    for (Thing thing : list) {
      for (int j = 1; j < dp.length; j++) {
        if (j >= thing.getWeight()) {
          dp[j] = Math.max(dp[j - thing.getWeight()] + thing.getValue(), dp[j]);
        }
      }
    }

    return dp[capacity];
  }

  public static void main(String[] args) {
    ArrayList<Thing> list = new ArrayList<>();

    list.add(new Thing(6, 2));
    list.add(new Thing(18, 5));
    list.add(new Thing(22, 6));
    list.add(new Thing(1, 1));
    list.add(new Thing(28, 7));

    System.out.println(CompletePackage.getMaxValue2(list, 13));
  }
}
