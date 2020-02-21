package algorithms.stack.singleStack.nextCircleBiggerNumber2;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/18 0:30
 */
public class NextBiggerNumber2 {
  public static int[] getCircleNextBiggerNumber(int[] arr) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }

    int[] result = new int[arr.length];
    Stack<Integer> singleStack = new Stack<>();

    for (int i = arr.length - 1; i >= 0; i--) {
      while (!singleStack.isEmpty() && arr[singleStack.peek()] <= arr[i]) {
        singleStack.pop();
      }
      // Serialization
      singleStack.push(i);
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      result[i] = singleStack.isEmpty() ? -1 : arr[singleStack.peek()];

      while (!singleStack.isEmpty() && arr[singleStack.peek()] <= arr[i]) {
        singleStack.pop();
      }

      singleStack.push(i);
    }

    return result;
  }
}
