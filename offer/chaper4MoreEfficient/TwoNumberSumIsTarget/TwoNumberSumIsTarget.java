package chaper4MoreEfficient.TwoNumberSumIsTarget;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/23 22:28
 */
public class TwoNumberSumIsTarget {
  private static int tempIndex = 0;

  /**
   * @description 在排序数组里面找到所有的两个数之和等于目标数字（时间复杂度小于n^2）
   * 可以使用时间复杂度小于log2n + n的算法,即 a + b = c =>  b = c - a。外层循环整个数组，将数组元素赋值给a，然后用二分查找找b
   * TODO 还有时间复杂度更低的算法（双指针法）思路和这个有点相似，不过不需要二分查找，用双指针法，也就是算法最差的时间复杂度是n
   * @param rawArray
   * @param target
   * @return
   */
  public static int[][] getTwoNumberSumIsN(int[] rawArray, int target) {
    if (rawArray == null || rawArray.length == 0) {
      return new int[0][0];
    }

    // 遍历不需要整个数组遍历，只需要遍历到这个endLimitIndex
    int endLimitIndex = rawArray.length - 1;
    ArrayList<int[]> numberArrayList = new ArrayList<>();

    for (int i = 0; i <= endLimitIndex; i++) {
      int temp = rawArray[i];
      int findNumber = target - temp;

      if (halfFind(rawArray, i, endLimitIndex, findNumber)) {
        // 如果找到了目标数字的话，那么放进数组里面，然后把右边的范围进行缩小（递增，然后从头遍历到尾，左边的数字会找到最右边的数字
        // ，然后i往右挪的话，只会找到limitIndex的左边的数字）
        numberArrayList.add(new int[]{temp, findNumber});
        endLimitIndex = tempIndex + 1;
      }
    }

    return numberArrayList.toArray(new int[0][0]);
  }

  private static boolean halfFind(int[] arr, int start, int end, int target) {
    int mid;

    while (start <= end) {
      mid = (start + end) / 2;

      if (target == arr[mid]) {
        tempIndex = mid;
        return true;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return false;
  }

  public static int[][] getSumNumberArrayBest(int[] rawArray, int target) {
    if (rawArray == null || rawArray.length == 0) {
      return new int[0][0];
    }

    int start = 0;
    int end = rawArray.length - 1;
    int startValue, endValue, tempSum;
    ArrayList<int[]> numberArrayList = new ArrayList<>();

    while (start < end) {
      startValue = rawArray[start];
      endValue = rawArray[end];
      tempSum = startValue + endValue;

      if (tempSum == target) {
        numberArrayList.add(new int[]{startValue, endValue});
        end--;
      } else if (tempSum < target) {
        start++;
      } else {
        end--;
      }
    }

    return numberArrayList.toArray(new int[0][0]);
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    System.out.println(Arrays.deepToString(TwoNumberSumIsTarget.getSumNumberArrayBest(arr, 14)));
  }
}
