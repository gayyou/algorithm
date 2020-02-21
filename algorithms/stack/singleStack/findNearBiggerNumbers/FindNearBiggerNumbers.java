package algorithms.stack.singleStack.findNearBiggerNumbers;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/19 22:10
 */
public class FindNearBiggerNumbers {
  public static int[][] getNearBiggerNumbers(int[] arr) {
    if (arr == null || arr.length == 0) {
      return new int[0][0];
    }

    Stack<Integer> singleStack = new Stack<>();
    int[][] result = new int[arr.length][2];

    for (int i = 0; i < arr.length; i++) {
      while (!singleStack.isEmpty() && arr[singleStack.peek()] >= arr[i]) {
        int targetIdx = singleStack.pop();
        int leftIdx = singleStack.isEmpty() ? -1 : singleStack.peek();
        result[targetIdx][0] = leftIdx;
        result[targetIdx][1] = i;
      }

      singleStack.push(i);
    }

    while (!singleStack.isEmpty()) {
      int singlePoint = singleStack.pop();
      result[singlePoint][0] = -1;
      result[singlePoint][1] = singleStack.isEmpty() ? -1 : singleStack.peek();
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(FindNearBiggerNumbers.getNearBiggerNumbers(new int[]{4, 3, 5, 2, 1})));
  }
}
