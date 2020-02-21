package algorithms.stack.singleStack.nextBiggerNumber;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 23:59
 */
public class NextBiggerNumber {
  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0) {
      return null;
    }

    if (nums2 == null || nums2.length == 0) {
      return new int[0];
    }

    Stack<Integer> singleStack = new Stack<>();
    int[] result = new int[nums2.length];

    for (int i = nums1.length - 1; i >= 0; i--) {
      while (!singleStack.isEmpty() && nums1[singleStack.peek()] <= nums1[i]) {
        singleStack.pop();
      }

      for (int j = 0; j < nums2.length; j++) {
        if (nums2[j] == nums1[i]) {
          result[j] = singleStack.isEmpty() ? -1 : nums1[singleStack.peek()];
        }
      }

      singleStack.push(i);
    }

    return result;
  }
}
