package algorithms.binaryTree.findSumIsTarget;

import model.BinaryNode;

import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/23 20:12
 * 题目： 再二叉搜索树中，查找最大路径和为目标数字的路径（根节点可能为负数，也可能会正数）
 */
public class FindMaxLenInBT2 {
  public static int getMax(BinaryNode<Integer> root, int targetNum) {
    if (root == null) {
      return 0;
    }

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(0, 0);

    return preOrder(hashMap, root, 0, targetNum, 0, 1);
  }

  private static int preOrder(HashMap<Integer, Integer> hashMap,
                              BinaryNode<Integer> temp, int maxLen,
                              int sum, int preSum, int level) {
    if (temp == null) {
      return 0;
    }

    int curSum = preSum + temp.getVal();

    if (!hashMap.containsKey(curSum)) {
      hashMap.put(curSum, level);
    }

    if (hashMap.containsKey(curSum - sum)) {
      maxLen = Math.max(level - hashMap.get(curSum - sum), maxLen);
    }

    maxLen = preOrder(hashMap, temp.getLeft(), maxLen, sum, curSum, level + 1);
    maxLen = preOrder(hashMap, temp.getRight(), maxLen, sum, curSum, level + 1);

    // 能不能删除这一段判断语句的代码？不行，因为有可能不等于这一层。
    if (hashMap.get(curSum) == level) {
      hashMap.remove(curSum);
    }

    return maxLen;
  }
}
