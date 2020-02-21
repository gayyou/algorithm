package algorithms.dynamic.packageQuestion.zeroOnePackage;

import algorithms.dynamic.packageQuestion.Thing;

import java.util.*;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/9 13:53
 */
public class ZeroOnePackage {
  public static int getTheBestResult(List<Thing> list, int capacity) {
    if (list.size() == 0) {
      return 0;
    }

    int[][] matrix = new int[list.size() + 1][capacity + 1];

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (j < list.get(i - 1).getWeight()) {
          // 如果装不下新的，就没有进行改变
          matrix[i][j] = matrix[i - 1][j];
        } else {
          // 判断装入的时候
          matrix[i][j] = Math.max((matrix[i - 1][j - list.get(i - 1).getWeight()] + list.get(i - 1).getValue()), matrix[i - 1][j]);
        }
      }
    }
    System.out.println(Arrays.deepToString(matrix));
    return matrix[matrix.length - 1][matrix[0].length - 1];
  }

  public static int getTheBestResult2(List<Thing> list, int capacity) {
    if (list.size() == 0) {
      return 0;
    }

    int[] dp = new int[capacity + 1];

    for (Thing thing : list) {
      int j = dp.length;
      while (j-- != 0) {
        if (j >= thing.getWeight()) {
          dp[j] = Math.max(dp[j - thing.getWeight()] + thing.getValue(), dp[j]);
        }
      }
    }

    return dp[capacity];
  }

  public static int getKstBestResult(List<Thing> list, int capacity, int k) {
    if (list.size() == 0) {
      return 0;
    }

    int[] dp = new int[capacity + 1];
    LinkedList<Integer> linkedList = new LinkedList<>();

    for (Thing thing : list) {
      int j = dp.length;
      while (j-- != 0) {
        if (j >= thing.getWeight()) {
          dp[j] = Math.max(dp[j - thing.getWeight()] + thing.getValue(), dp[j]);
          if (linkedList.indexOf(dp[j]) == -1) {
            linkedList.add(dp[j]);
          }
        }
      }
    }

    System.out.println(Arrays.toString(linkedList.toArray()));

    return dp[capacity];
  }

  public static void main(String[] args) {
    ArrayList<Thing> list = new ArrayList<>();
    list.add(new Thing(18, 5));
    list.add(new Thing(22, 6));
    list.add(new Thing(1, 1));
    list.add(new Thing(6, 2));

    list.add(new Thing(28, 7));
    System.out.println(ZeroOnePackage.getKstBestResult(list, 11, 22));
  }
}
