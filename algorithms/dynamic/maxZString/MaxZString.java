package algorithms.dynamic.maxZString;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/16 17:29
 */
public class MaxZString {
  public static String getMaxZString(String target) {
    if (target == null || target.length() == 0) {
      return "";
    }

    char[] targetCharArray = target.toCharArray();
    int len = target.length();
    boolean[][] dp = new boolean[len][len];
    int maxLen = 0, maxStart = 0, maxEnd = 0;

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }

    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (targetCharArray[i] == targetCharArray[j]) {
          if (j - i < 3) {
            // 如果两者之间是没有任何距离的，那么就直接设为true
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && (j - i + 1) > maxLen) {
          maxLen = j - i + 1;
          maxStart = i;
          maxEnd = j;
        }
      }
    }

    return target.substring(maxStart, maxEnd + 1);
  }

  public static String getMaxZString2(String target) {
    if (target == null || target.length() == 0) {
      return "";
    }

    char[] targetCharArray = target.toCharArray();
    int len = target.length();
    boolean[] dp = new boolean[len];
    int maxLen = 0, maxStart = 0, maxEnd = 0;

    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        // 需要进行初始化
        dp[i] = false;

        if (targetCharArray[i] == targetCharArray[j]) {
          if (j - i < 3) {
            dp[i] = true;
          } else {
            dp[i] = dp[i + 1];
          }
        }

        if (dp[i] && maxLen < (j - i + 1)) {
          maxLen = j - i + 1;
          maxStart = i;
          maxEnd = j;
        }
      }
    }

    return target.substring(maxStart, maxEnd + 1);
  }

  public static void main(String[] args) {
    System.out.println(MaxZString.getMaxZString2("dabcbaeeeeee"));
  }
}
