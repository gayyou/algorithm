package algorithms.dynamic.selectCoins;

import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2019/12/16 10:46
 */
public class SelectCoins {
  int[][] coinsMatrix;

  public SelectCoins(int[][] coinsMatrix) {
    this.coinsMatrix = coinsMatrix.clone();
  }

  /**
   * @description 使用递归的方式加上二维数组来进行记录，减少一定的计算量
   * @return
   */
  public int getMaxCoinsNumber() {
    return this.getMaxCoinsNumber(this.coinsMatrix.length - 1, this.coinsMatrix[0].length - 1);
  }

  public int getMaxCoinsNumber(int row, int col) {
    if (coinsMatrix[row][col] >= 1) {
      return coinsMatrix[row][col];
    }

    if (row == 0 && col == 0) {
      return 0;
    }

    if (coinsMatrix[row][col] == -1) {
      return -1;
    }

    int coinsNumber;
    if (row == 0) {
      coinsNumber = getMaxCoinsNumber(row, col - 1);
    } else if (col == 0) {
      coinsNumber = getMaxCoinsNumber(row - 1, col);
    } else {
      coinsNumber = Math.max(getMaxCoinsNumber(row - 1, col), getMaxCoinsNumber(row, col - 1));
    }

    if (coinsNumber == -1) {
      return -1;
    }
    if (coinsMatrix[row][col] == -2) {
      coinsMatrix[row][col] = coinsNumber + 1;
    } else {
      coinsMatrix[row][col] += coinsNumber;
    }

    return coinsMatrix[row][col];
  }

  /**
   * @description 利用循环来解决问题。
   * 使用到额外的一位数组的空间，并且在不改变原来矩阵的情况下进行计算
   * 这个方法采用自底向上的方法，先从小问题进行积累解决，然后由小问题的最优解得出大问题的最优解
   * 使用一维数组
   */
  public static int maxValue(int[][] coinsMatrix){
    if (coinsMatrix == null || coinsMatrix.length == 0) {
      return 0;
    }

    int[] rolMarkList = new int[coinsMatrix.length];

    for (int[] matrix : coinsMatrix) {
      for (int j = 0; j < coinsMatrix[0].length; j++) {
        if (j > 0) {
          rolMarkList[j] = Math.max(rolMarkList[j - 1], rolMarkList[j]) + matrix[j];
        } else {
          rolMarkList[j] += matrix[j];
        }
      }
    }

    return rolMarkList[rolMarkList.length - 1];
  }

  public static void main(String[] args) {
    int[][] coinsMatrix = new int[][]{
            {1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}
    };
    System.out.println(maxValue(coinsMatrix));
  }
}
