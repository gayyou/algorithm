package chaper2DataStruction;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class FindPath {
  class Location {

    Location(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public int hashCode() {
      return this.row * 1000 + this.col;
    }

    @Override
    public boolean equals(Object obj) {
      Location target = (Location) obj;
      return this.row == target.row && this.col == target.col;
    }

    int row;
    int col;
  }

  public boolean hasPath(char[][] matrix, String target) {
    if (matrix == null || matrix.length == 0 || target.equals("")) return false;

    this.currentIndex = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == target.charAt(0)) {
          if (hasPath(matrix, i, j, target)) {
            return true;
          }

          this.currentIndex = 0;
          hashMap = new HashMap<>();
        }
      }
    }

    return false;
  }

  private HashMap<Location, Boolean> hashMap = new HashMap<>();

  private int currentIndex = 0;

  private boolean hasPath(char[][] matrix, int rows, int cols, String target) {
    if (rows >= matrix.length || cols >= matrix[0].length) return false;

    if (target.charAt(currentIndex) != matrix[rows][cols]) {
      // 如果当前指向的下标并不是想要找的下标，那么就返回false
      return false;
    }

    hashMap.put(new Location(rows, cols), true);  // 使用hashMap进行存储

    currentIndex++;  // 先让target的下标 + 1;

    if (currentIndex >= target.length()) {
      // 如果currentIndex大于字符串的下标，那边说明已经找到并且结束了
      return true;
    }

    // 对上下左右进行搜索看看有没有能够找到的
    if (rows - 1 >= 0 && hashMap.get(new Location(rows - 1, cols)) == null && hasPath(matrix, rows - 1, cols, target)) {
      return true;
    }

    if (cols - 1 >= 0 && hashMap.get(new Location(rows, cols - 1)) == null && hasPath(matrix, rows, cols - 1, target)) {
      return true;
    }

    if (rows + 1 < matrix.length && hashMap.get(new Location(rows + 1, cols)) == null && hasPath(matrix, rows + 1, cols, target)) {
      return true;
    }

    if (cols + 1 < matrix[0].length && hashMap.get(new Location(rows, cols + 1)) == null && hasPath(matrix, rows, cols + 1, target)) {
      return true;
    }

    // 没找到匹配的路径
    return false;
  }

  @Test
  public void test01() {
    FindPath findPath = new FindPath();
    char[][] matrix = new char[][]{{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
    String target = "bfce";

    System.out.println(findPath.hasPath(matrix, target));
  }
}
