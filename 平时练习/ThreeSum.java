package 平时练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/3/6 13:39
 */
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);

    int c, lastNum = Integer.MIN_VALUE, lastSecNum = Integer.MIN_VALUE;
    int len = nums.length;
    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < len - 2; i++) {
      if (nums[i] > 0) {
        break;
      }
      if (nums[i] == lastNum) {
        continue;
      }

      for (int j = i + 1; j < len - 1; j++) {
        if (nums[j] == lastSecNum) {
          continue;
        }
        if (lastNum != Integer.MIN_VALUE && lastNum == nums[j]) {
          continue;
        }

        c = nums[i] + nums[j];
        int index = halfFind(nums, j + 1, len, -c);

        if (index != -1) {
          // 去重操作  hash ？ 额外空间
          // 什么情况会出现相同？当且仅当两个数字相同，那么就会出现重复，然后我这边是进行排序，那么有两种情况会出现相同的
          // 1. 连续三个数是相同的，可能会出现相同，  2. 目标值出现
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[j]);
          temp.add(nums[index]);
          list.add(temp);
        }

        lastNum = nums[i];
        lastSecNum = nums[j];
      }
    }

    return list;
  }

  public int halfFind(int[] nums, int left, int right, int tar) {
    int i = left, j = right, mid;

    while (i < j) {
      mid = (i + j) / 2;

      if (nums[mid] == tar) {
        return mid;
      }

      if (nums[mid] < tar) {
        i = mid + 1;
      } else {
        j = mid;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 0}));
  }
}
