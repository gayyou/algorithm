package leetcode;

import org.junit.Test;

public class JumpGame {
  public static boolean canJump(int[] nums) {
    if (nums == null) return false;
    if (nums.length <= 1) return true;
    if (nums[0] == 0) return false;

    int widestLength = nums[0];
    int index = 0;
    int tempMaxLength = 0;
    int numsLength = nums.length;

    if (widestLength >= numsLength - 1) {
      return true;
    }

    // index + widestLength 是当前能够活动的最右边的范围
    // 如果在走完这个范围的时候
    for (int i = 1; i <= widestLength; i++) {
      if (tempMaxLength < nums[i] + i) {
        tempMaxLength = nums[i] + i;

        if (tempMaxLength >= numsLength - 1) {
          return true;
        }

        index = i;
      }

      if (i == widestLength && tempMaxLength != 0) {
        widestLength = tempMaxLength;
        // 下标返回来
        i = index;
        // 重置tempMaxLength
        tempMaxLength = 0;
      }
    }

    return false;
  }

  public static int jump(int[] nums) {
    if (nums == null) return 0;
    if (nums.length <= 1) return 0;

    int count = 1;
    int widestLength = nums[0];
    int index = 0;
    int tempMaxLength = 0;
    int numsLength = nums.length;

    if (widestLength >= numsLength - 1) {
      return 1;
    }

    // index + widestLength 是当前能够活动的最右边的范围
    // 如果在走完这个范围的时候
    for (int i = 1; i <= widestLength; i++) {
      if (tempMaxLength < nums[i] + i) {
        tempMaxLength = nums[i] + i;

        if (tempMaxLength >= numsLength - 1) {
          count++;  // 这里是找到目的地了，执行最后一跳
          return count;
        }

        index = i;
      }

      if (i == widestLength && tempMaxLength != 0) {
        count++;  // 这里是找到目前为止最优解，那么要跳一下继续寻找
        widestLength = tempMaxLength;
        // 下标返回来
        i = index;
      }
    }

    return count;
  }


  @Test
  public void test01() {
//    System.out.println(JumpGame.canJump(new int[]{3,2,1,0,4}));
    System.out.println(JumpGame.jump(new int[]{1, 2, 1, 1, 1}));
  }
}
