package algorithms.dynamic.fiber;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/25 20:38
 */
public class Fiber {
  public static int getFiber(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n <= 2) {
      return 1;
    }

    int[][] base = new int[][]{{1, 1}, {1, 0}};
    int[][] res = getFiberByMatrix(base, n - 2);
    return res[0][0] + res[1][0];
  }

  private static int[][] getFiberByMatrix(int[][] base, int n) {
    int[][] singleMatrix = new int[base.length][base[0].length];

    for (int i = 0; i < singleMatrix.length; i++) {
      singleMatrix[i][i] = 1;
    }

    int[][] temp = base;

    for (; n != 0; n >>= 1) {
      if ((n & 1) != 0) {
        singleMatrix = matrixMutilate(singleMatrix, temp);
      }
      temp = matrixMutilate(temp, temp);
    }

    return singleMatrix;
  }

  private static int[][] matrixMutilate(int[][] a, int[][] b) {
    int[][] result = new int[a.length][b[0].length];

    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        for (int k = 0; k < result.length && k < result[0].length; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(getFiber(75));
  }
}
