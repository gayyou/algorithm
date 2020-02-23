package chaper2DataStruction;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * TODO 地上有一个m行n列的方格，机器人在其中的坐标为(x, y)，它每次可以上下左右进行运动，但是它运动
 *       的坐标的每一位数提取出来的和不能大于指定值。如(35, 38) = 3 + 5 + 3 + 8 = 19 > 18 不满足
 *       但是(35, 37) = 3 + 5 + 3 + 7 = 18 == 18 满足。求出这个机器人的最大运动格数
 * TODO 思路：采用深度优先遍历进行遍历，并且采用用boolean一元数组进行记录走过的路径（而不采用HashMap，
 *      原因是一元数组的访问要比HashMap快）。
 */
public class MovingCount {
  private int getNumberSplitSum(int num) {
    ArrayList<Integer> result = new ArrayList<>();
    while(num > 0) {
      result.add(num % 10);
      num /= 10;
    }

    int sum = 0;

    for (int item : result) {
      sum += item;
    }

    return sum;
  }

  private HashMap<String, Boolean> hashMap = new HashMap<>();

  private boolean[] isVisited = null;

  private int length;
  private int width;

  public int robotMoveBox(int length, int width, int maxNumber) {
    if (length <= 0 || width <= 0 || maxNumber <= 0) return 0;

    this.length = length;
    this.width = width;
    this.isVisited = new boolean[length * width];  // 生成记录的数组

    return robotMoveBoxCore(0, 0, maxNumber);
  }

  private int robotMoveBoxCore(int row, int col, int maxNumber) {
    int sum = getNumberSplitSum(row) + getNumberSplitSum(col);
    int boxNumber = 0;

    if (sum > maxNumber) {
      return 0;
    }

    this.isVisited[row * length + col] = true;  // 记录走过的路径
    boxNumber++;

    if (row - 1 >= 0 && !this.isVisited[(row - 1) * length + col]) {
      boxNumber += robotMoveBoxCore(row - 1, col, maxNumber);
    }

    if (col - 1 >= 0 && !this.isVisited[row * length + (col - 1)]) {
      boxNumber += robotMoveBoxCore(row, col - 1, maxNumber);
    }

    if (row + 1 < this.width && !this.isVisited[(row + 1) * length + col]) {
      boxNumber += robotMoveBoxCore(row + 1, col, maxNumber);
    }

    if (col + 1 < this.length && !this.isVisited[row * length + (col + 1)]) {
      boxNumber += robotMoveBoxCore(row, col + 1, maxNumber);
    }

    return boxNumber;
  }

  @Test
  public void test01() {
    MovingCount movingCount = new MovingCount();
    int count = movingCount.robotMoveBox(35, 37, 18);
    System.out.println(count);
  }
}
