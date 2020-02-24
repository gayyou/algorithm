package algorithms.binaryTree.findSumIsTarget;

import model.BinaryNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/23 13:56
 * 1.这里处理的结果会可能是两个子数组的集合，也就是如果是  想到结果是 2  那么 1 -> 1 是结果，1 -> 1 -> -1 -> 1也是结果
 */
public class FindMaxLenThatSumIsTarget {
  public static int getMaxLen(BinaryNode<Integer> root, int targetNum) {
    if (root == null) {
      return 0;
    }

    HashMap<Integer, Integer> hashMap = new HashMap<>();
    if (root.getVal() == targetNum) {
      hashMap.put(0, 1);
    } else {
      hashMap.put(0, 0);
    }

    preOrder(root.getLeft(), hashMap, 1, root.getVal(), targetNum);
    preOrder(root.getRight(), hashMap, 1, root.getVal(), targetNum);

    int max = -1;
    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (entry.getValue() > 0) {
        max = Math.max(entry.getKey() + 1, max);
      }
    }

    return max;
  }

  private static void preOrder(BinaryNode<Integer> temp, HashMap<Integer, Integer> hashMap,
                               int level, int preSum, int target) {
    if (temp == null) {
      return ;
    }

    if (!hashMap.containsKey(level)) {
      hashMap.put(level, 0);
    }

    int curSum = preSum + temp.getVal();

    if (preSum + temp.getVal() == target) {
      hashMap.put(level, hashMap.get(level) + 1);
    }

    preOrder(temp.getLeft(), hashMap, level + 1, curSum, target);
    preOrder(temp.getRight(), hashMap, level + 1, curSum, target);
  }

  public static void main(String[] args) {
    BinaryNode<Integer> binaryNode1 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode2 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode3 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode4 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode5 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode6 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode7 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode8 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode9 = new BinaryNode<>(-1);
    BinaryNode<Integer> binaryNode10 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode11 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode12 = new BinaryNode<>(1);
    binaryNode6.setLeft(binaryNode2);
    binaryNode6.setRight(binaryNode3);
    binaryNode2.setLeft(binaryNode1);
    binaryNode2.setRight(binaryNode4);
    binaryNode3.setRight(binaryNode5);
    binaryNode5.setRight(binaryNode7);
    binaryNode4.setRight(binaryNode8);
    binaryNode4.setLeft(binaryNode9);
    binaryNode9.setLeft(binaryNode10);
    binaryNode10.setLeft(binaryNode11);
    binaryNode5.setLeft(binaryNode12);
    System.out.println(FindMaxLenThatSumIsTarget.getMaxLen(binaryNode6, 4));
  }
}
