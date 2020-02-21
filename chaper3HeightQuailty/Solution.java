package chaper3HeightQuailty;

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.misc.Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.DelayQueue;

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return this.arrayToBST(nums, 0, nums.length - 1);
  }

  private TreeNode arrayToBST(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }

    int mid = (right + left) / 2;

    TreeNode currentNode = new TreeNode(nums[mid]);

    currentNode.left = this.arrayToBST(nums, left, mid - 1);

    currentNode.right = this.arrayToBST(nums, mid + 1, right);

    return currentNode;
  }
}

class TreeNode {
  int val;
  TreeNode left = null;
  TreeNode right = null;

  public TreeNode(int val) {
    this.val = val;
  }
}