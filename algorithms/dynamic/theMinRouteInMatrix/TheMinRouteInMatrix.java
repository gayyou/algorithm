package algorithms.dynamic.theMinRouteInMatrix;

import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/26 19:24
 */
public class TheMinRouteInMatrix {
  public static int getMinSumInRouteOfMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }

    int[] dp = new int[matrix.length];
    dp[0] = matrix[0][0];

    for (int i = 1; i < matrix.length; i++) {
      dp[i] = dp[i - 1] + matrix[0][i];
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j == 0) {
          dp[j] += matrix[i][j];
        } else {
          dp[j] = Math.min(dp[j], dp[j - 1]) + matrix[i][j];
        }
      }
    }

    return dp[matrix.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(getMinSumInRouteOfMatrix(new int[][]{
            {1, 3, 5, 9},
            {8, 1, 3, 4},
            {5, 0, 6, 1},
            {8, 8, 4, 0}
    }));
  }
}
