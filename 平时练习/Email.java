package 平时练习;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/3/6 15:27
 */
public class Email {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }
        int max = 0;
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        //至少放一封
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (inRange(envelopes[j], envelopes[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    private boolean inRange(int[] envelop1, int[] envelop2) {
        return envelop1[0] < envelop2[0] && envelop1[1] < envelop2[1];
    }

    public int myResolve(int[][] envelopes) {
      if (envelopes == null || envelopes.length == 0) {
        return 0;
      }

      // 尽可能从小往大排序
      Arrays.sort(envelopes, (o1, o2) -> {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }

        return o1[0] - o2[0];
      });

      // 然后记录每个信封能够装多少子信封，使用动态规划，从最小的信封开始
      int[] dp = new int[envelopes.length];
      int len = envelopes.length;
      // 每个信封至少装一封信
      Arrays.fill(dp, 1);
      int max = Integer.MIN_VALUE;

      // 从小到大
      for (int i = 0; i < len; i++) {
        // 从当前信封往里面的信封找起
        for (int j = i - 1; j >= 0; j--) {
          if (inRange(envelopes[j], envelopes[i])) {
            dp[i] = Math.max(dp[j] + 1, dp[i]);
          }
        }

        max = Math.max(dp[i], max);
      }

      return max;
    }

  public static void main(String[] args) {
    System.out.println(Arrays.binarySearch(new int[] {0, 2, 3}, 7));
  }
}
