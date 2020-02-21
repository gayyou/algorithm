package algorithms.stack.singleStack.findDaysToHighT;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 22:32
 */
public class FindDaysToHighT {
  public static int[] dailyTemperatures(int[] T) {
    if (T == null || T.length == 0) {
      return new int[0];
    }

    Stack<Integer> singleStack = new Stack<>();
    int[] resultArray = new int[T.length];

    Arrays.fill(resultArray, 0);

    for (int i = T.length - 1; i >= 0; i--) {
      while (!singleStack.isEmpty() && T[singleStack.peek()] <= T[i]) {
        singleStack.pop();
      }

      resultArray[i] = singleStack.isEmpty() ? 0 : singleStack.peek() - i;

      singleStack.push(i);
    }

    return resultArray;
  }
}
