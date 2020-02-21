package algorithms.stack.singleStack.circleHeightestMountain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/20 23:15
 */
public class CircleHeightMountain {
  public static int[][] getSeesMountain(int[] mountains) {
    if (mountains == null || mountains.length == 0) {
      return new int[0][0];
    }

    ArrayList<int[]> result = new ArrayList<>();
    Stack<Integer> singleStack = new Stack<>();

    for (int i = 0; i < mountains.length * 2; i++) {
      if (i >= mountains.length) {
        result.add(new int[]{mountains[i % mountains.length], mountains[singleStack.peek() % mountains.length]});
      }

      while (!singleStack.isEmpty() && mountains[singleStack.peek() % mountains.length] <= mountains[i % mountains.length]) {
        singleStack.pop();
      }

      singleStack.add(i);
    }

//    for (int i = (mountains.length * 2) - 1; i >= 0; i--) {
////      if (i < mountains.length) {
////        result.add(new int[]{mountains[i], mountains[singleStack.peek() % mountains.length]});
////      }
////
////      while (!singleStack.isEmpty() && mountains[singleStack.peek() % mountains.length] <= mountains[i % mountains.length]) {
////        singleStack.pop();
////      }
////
////      singleStack.add(i);
////    }

    return result.toArray(new int[0][0]);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(CircleHeightMountain.getSeesMountain(new int[]{1, 5, 4, 3, 2})));
  }
}
