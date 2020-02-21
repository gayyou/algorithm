package algorithms.dynamic.gif;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/9 9:57
 */
public class Gif {
  public int getMaxValue(int[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int[] tempValueArr = new int[matrix[0].length];

    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j == 0) {
          tempValueArr[j] += + ints[j];
        } else {
          tempValueArr[j] = Integer.max(tempValueArr[j], tempValueArr[j - 1]) + ints[j];
        }
      }
    }

    return tempValueArr[tempValueArr.length - 1];
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
            {1, 10, 3, 8},
            {12, 2, 9, 6},
            {5, 7, 4, 11},
            {3, 7, 16, 5}
    };
    Gif gif = new Gif();
    System.out.println(gif.getMaxValue(matrix));
  }
}
