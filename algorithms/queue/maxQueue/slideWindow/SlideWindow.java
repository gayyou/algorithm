package algorithms.queue.maxQueue.slideWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/18 22:19
 */
public class SlideWindow {
  public static int[] getMaxSlideWindow(int[] arr, int windowSize) {
    int[] result = new int[arr.length];
    if (arr.length < windowSize) {
      int max = 0;
      for (int value : arr) {
        max = Math.max(max, value);
      }

      Arrays.fill(result, max);

      return result;
    }

    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < windowSize; i++) {
      while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }

    for (int i = windowSize; i < arr.length; i++) {
      if (!deque.isEmpty() && deque.peekFirst() < i - windowSize) {
        // 如果少于当前的
        deque.removeFirst();
      }

      result[i - windowSize] = arr[deque.peekFirst()];

      while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
        deque.removeLast();
      }
      deque.addLast(i);
    }

    for (int i = arr.length - windowSize; i < arr.length; i++) {
      result[i] = arr[deque.peekFirst()];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(SlideWindow.getMaxSlideWindow(new int[]{4, 3, 5, 4, 3, 3, 6, 7}, 3)));
  }
}
