package chaper2DataStruction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description 思路是先从对角线上进行查找最接近的一个数值，然后进行广度优先算法搜索并且进行剪枝
 */
public class FindIn2DArray {
  private HashMap<String, Boolean> isVisit = new HashMap<>();
  // 这是我一开始的思路
  private boolean isExist(int[][] target, int row, int col, int key) {
    if (target == null || row < 0 || col < 0 || row >= target.length) {
      return false;
    }
    if (target[0] != null && col >= target[0].length) {
      return false;
    }
    boolean isFind = false;

    if (this.isVisit.get(Arrays.toString(new int[]{row, col})) != null) {
      return false;
    }

    if (target[row][col] == key) {
      return true;
    }

    this.isVisit.put(Arrays.toString(new int[]{row, col}), true);

    if (target[row][col] > key) {
      isFind = this.isExist(target, row - 1, col, key);
      if (isFind) {
        return true;
      }
      isFind = this.isExist(target, row, col - 1, key);
    } else {
      isFind = this.isExist(target, row + 1, col, key);
      if (isFind) {
        return true;
      }
      isFind = this.isExist(target, row, col + 1, key);
    }

    return isFind;
  }

  /**
   * @description 根据规律利用排除法进行筛选，从右上角排除到最下角，直到找到目标
   */
  private boolean filterWay(int[][] arr, int key) {
    if (arr == null) return false;
    if (arr.length == 0) return false;
    if (arr[0].length == 0) return false;

    int rowLine = 0;
    int colLine = arr[0].length - 1;

    while(rowLine < arr.length && colLine >= 0) {
      if (arr[rowLine][colLine] == key) {
        // 找到目标
        return true;
      }
      if (arr[rowLine][colLine] > key) {
        // 右上角的值大于目标值，说明最右边的列不存在目标值
        colLine--;
      } else {
        // 右上角的值小于目标值，说明最上边的行不存在目标值
        rowLine++;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[][] arr = new int[][]{{1, 2, 3}, {2, 3, 4}, {4, 6, 7}};
    int start = 0;
    for (; start < arr.length; start++) {
      if (arr[start][start] >= 4 || start + 1 == arr.length) {
        break;
      }
    }
    FindIn2DArray tar = new FindIn2DArray();
    System.out.println(tar.isExist(arr, start, start, 11));
    System.out.println(tar.isVisit.toString());
    System.out.println(tar.filterWay(arr, 11));
  }
}
