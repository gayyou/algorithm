package chaper4MoreEfficient.subMaxArr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 0:00
 */
public class SubMaxArr {
  public static int getSubMaxArr(int[] arr, int num) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    Deque<Integer> singleAddQueue = new ArrayDeque<>();
    Deque<Integer> singleSubQueue = new ArrayDeque<>();
    int left = 0;
    int right = 0;
    int res = 0;

    while (left < arr.length) {
      while (right < arr.length) {
        // 右边先停止移动，所以右指针放在里面遍历
        while (!singleAddQueue.isEmpty() && arr[singleAddQueue.getLast()] <= arr[right]) {
          singleAddQueue.removeLast();
        }
        singleAddQueue.add(right);

        while (!singleSubQueue.isEmpty() && arr[singleSubQueue.getLast()] >= arr[right]) {
          singleSubQueue.removeLast();
        }
        singleSubQueue.add(right);

        if (arr[singleSubQueue.getFirst()] - arr[singleAddQueue.getFirst()] > num) {
          // 如果超出的话，那么右指针就不需要往右移动
          break;
        }
        right++;
      }

      if (!singleAddQueue.isEmpty() && left == singleAddQueue.peekFirst()) {
        singleAddQueue.removeFirst();
      }

      if (!singleSubQueue.isEmpty() && left == singleSubQueue.peekFirst()) {
        singleSubQueue.removeFirst();
      }

      res += right - left;
      left++;
    }


    return res;
  }

  public static void main(String[] args) {
    System.out.println(SubMaxArr.getSubMaxArr(new int[]{3, 5, 4, 6, 7}, 2));
  }
}
