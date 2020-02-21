package leetcode;

import java.util.HashSet;

public class LongestConsecutive {
  public int longestConsecutive(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int num : nums) {
      set.add(num);
    }

    int longestPath = 0;

    for (int num : nums) {
      if (!set.contains(num - 1)) {
        // 如果set不存在num的上一个数字的时候，这个条件判断是为了过滤掉能够成串的数字的子串
        int currentLongestPath = 1;

        while(set.contains(num + 1)) {
          num++;
          currentLongestPath++;
        }

        longestPath = Math.max(longestPath, currentLongestPath);
      }
    }

    return longestPath;
  }
}
