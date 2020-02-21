package algorithms.stack.singleStack.largestRectangleArea;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/20 0:06
 */
public class LargestRectangleArea {
  private static int getLargestRectangleArea(int[] rectangleArray) {
    Stack<Integer> singleStack = new Stack<>();
    int maxArea = 0;
    int[][] heightArea = new int[rectangleArray.length][2];

    for (int i = 0; i < rectangleArray.length; i++) {
      while (!singleStack.isEmpty() && rectangleArray[singleStack.peek()] >= rectangleArray[i]) {
        int targetHeight = rectangleArray[singleStack.pop()];
        int leftIdx = singleStack.isEmpty() ? -1 : singleStack.peek();

        maxArea = Math.max(maxArea, (i - leftIdx - 1) * targetHeight);
      }

      singleStack.push(i);
    }

    while (!singleStack.isEmpty()) {
      int height = rectangleArray[singleStack.pop()];
      int right = singleStack.isEmpty() ? -1 : singleStack.peek();
      maxArea = Integer.max((right) * height, maxArea);
    }

    for (int i = 0; i < rectangleArray.length; i++) {
      int left = heightArea[i][0] == -1 ? i : heightArea[i][0];
      int right = heightArea[i][1] == -1 ? i : heightArea[i][1];

      maxArea = Integer.max((right - left - 1) * rectangleArray[i], maxArea);
    }

    return maxArea;
  }

  public static int getTwoGraph(int[][] area) {
    int maxArea = 0;
    int[] result = new int[area[0].length];

    for (int[] ints : area) {
      for (int j = 0; j < area[0].length; j++) {
        if (ints[j] == 1) {
          result[j] += 1;
        } else {
          result[j] = 0;
        }
      }
      maxArea = Math.max(maxArea, getLargestRectangleArea(result));
    }

    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(LargestRectangleArea.getTwoGraph(new int[][]{{1, 0, 1, 1},{1,1,1,1},{1,1,1,0}}));
  }
}
