package chaper4MoreEfficient.slideWindow;

import java.util.*;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/25 17:29
 */
public class SlideWindow {
  public static int[] getTheMaxSlideNumber(int[] nums, int k) {
    if (nums == null || nums.length == 0 || nums.length < k) {
      return new int[0];
    }

    Deque<Integer> deque = new ArrayDeque<>();
    int[] resultArray = new int[nums.length - k + 1];
    int resultIndex = 0;

    for (int i = 0; i < k; i++) {
      int temp = nums[i];

      while (!deque.isEmpty() && nums[deque.getLast()] < temp) {
        deque.removeLast();
      }

      deque.add(i);
    }

    resultArray[resultIndex++] = nums[deque.getFirst()];

    for (int i = k; i < nums.length; i++) {
      if (deque.getFirst() <= i - k) {
        deque.removeFirst();
      }

      int temp = nums[i];
      while (!deque.isEmpty() && nums[deque.getLast()] < temp) {
        deque.removeLast();
      }

      deque.add(i);

      resultArray[resultIndex++] = nums[deque.getFirst()];
    }

    return resultArray;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, -1};
    System.out.println(Arrays.toString(SlideWindow.getTheMaxSlideNumber(arr, 1)));
  }
}
