package chaper4MoreEfficient.travelTreeOperation;

import dataStructure.BinaryTreeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/22 11:02
 */
public class TravelTreeOperation {
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  private static class TempDepth {
    int depth;
  }

  public static boolean isBalance(BinaryTreeNode root) {
    TempDepth tempDepth = new TempDepth(0);
    return TravelTreeOperation.isBalance(root, tempDepth);
  }

  private static boolean isBalance(BinaryTreeNode root, TempDepth tempDepth) {
    if (root == null) {
      tempDepth.setDepth(0);
      return true;
    }

    TempDepth left = new TempDepth(0);
    TempDepth right = new TempDepth(0);

    if (TravelTreeOperation.isBalance(root.getLeft(), left) && TravelTreeOperation.isBalance(root.getRight(), right)) {
      int temp = left.getDepth() - right.getDepth();

      if (temp >= -1 && temp <= 1) {
        tempDepth.setDepth(1 + (Math.max(left.getDepth(), right.getDepth())));
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(1);
    BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(1);
    binaryTreeNode1.setLeft(binaryTreeNode2);
    binaryTreeNode1.setRight(binaryTreeNode3);
    binaryTreeNode2.setLeft(binaryTreeNode4);
    binaryTreeNode2.setRight(binaryTreeNode5);
    binaryTreeNode3.setLeft(binaryTreeNode6);
    binaryTreeNode3.setRight(binaryTreeNode7);
    binaryTreeNode4.setLeft(binaryTreeNode8);
    binaryTreeNode4.setRight(binaryTreeNode9);
    binaryTreeNode8.setLeft(binaryTreeNode10);
    System.out.println(TravelTreeOperation.isBalance(binaryTreeNode1));
  }
}
