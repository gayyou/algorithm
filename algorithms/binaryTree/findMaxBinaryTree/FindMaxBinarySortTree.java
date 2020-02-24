package algorithms.binaryTree.findMaxBinaryTree;

import jdk.nashorn.internal.ir.FunctionCall;
import model.BinaryNode;

import java.util.concurrent.Callable;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/24 21:31
 */
public class FindMaxBinarySortTree {
  static interface Strategy {
    boolean cb(BinaryNode<Integer> tempRoot, int fatherVal);
  }
  public static void getMaxBinarySortTree(BinaryNode<Integer> root) {
    if (root == null) {
      return ;
    }

    if (root.getLeft() != null && root.getLeft().getVal() < root.getVal()) {
      getLeftMaxBinarySortTree(root.getLeft(), root.getVal());
    } else {
      root.setLeft(null);
    }

    if (root.getRight() != null && root.getRight().getVal() > root.getVal()) {
      getRightMaxBinarySortTree(root.getRight(), root.getVal());
    } else {
      root.setRight(null);
    }
  }

  private static void getLeftMaxBinarySortTree(BinaryNode<Integer> tempRoot, int fatherVal) {
    if (tempRoot.getLeft() != null && tempRoot.getLeft().getVal() < tempRoot.getVal()) {
      getLeftMaxBinarySortTree(tempRoot.getLeft(), tempRoot.getVal());
    } else {
      tempRoot.setLeft(null);
    }

    if (tempRoot.getRight() != null &&
            tempRoot.getRight().getVal() > tempRoot.getVal() &&
            tempRoot.getRight().getVal() < fatherVal) {
      getRightMaxBinarySortTree(tempRoot.getRight(), tempRoot.getVal());
    } else {
      tempRoot.setRight(null);
    }
  }

  private static void getRightMaxBinarySortTree(BinaryNode<Integer> tempRoot, int fatherVal) {
    if (tempRoot.getRight() != null &&
            tempRoot.getRight().getVal() > tempRoot.getVal()) {
      getRightMaxBinarySortTree(tempRoot.getRight(), tempRoot.getVal());
    } else {
      tempRoot.setRight(null);
    }

    if (tempRoot.getLeft() != null &&
            tempRoot.getLeft().getVal() < tempRoot.getVal() &&
            tempRoot.getLeft().getVal() > fatherVal) {
      getLeftMaxBinarySortTree(tempRoot.getRight(), tempRoot.getVal());
    } else {
      tempRoot.setLeft(null);
    }
  }

  public static void main(String[] args) {
    BinaryNode<Integer> binaryNode1 = new BinaryNode<>(6);
    BinaryNode<Integer> binaryNode2 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode3 = new BinaryNode<>(12);
    BinaryNode<Integer> binaryNode4 = new BinaryNode<>(0);
    BinaryNode<Integer> binaryNode5 = new BinaryNode<>(3);
    BinaryNode<Integer> binaryNode6 = new BinaryNode<>(10);
    BinaryNode<Integer> binaryNode7 = new BinaryNode<>(13);
    BinaryNode<Integer> binaryNode8 = new BinaryNode<>(4);
    BinaryNode<Integer> binaryNode9 = new BinaryNode<>(14);
    BinaryNode<Integer> binaryNode10 = new BinaryNode<>(20);
    BinaryNode<Integer> binaryNode11 = new BinaryNode<>(16);
    BinaryNode<Integer> binaryNode12 = new BinaryNode<>(2);
    BinaryNode<Integer> binaryNode13 = new BinaryNode<>(5);
    BinaryNode<Integer> binaryNode14 = new BinaryNode<>(11);
    BinaryNode<Integer> binaryNode15 = new BinaryNode<>(15);
    binaryNode1.setLeft(binaryNode2);
    binaryNode1.setRight(binaryNode3);
    binaryNode2.setLeft(binaryNode4);
    binaryNode2.setRight(binaryNode5);
    binaryNode3.setLeft(binaryNode6);
    binaryNode3.setRight(binaryNode7);
    binaryNode6.setLeft(binaryNode8);
    binaryNode6.setRight(binaryNode9);
    binaryNode7.setRight(binaryNode11);
    binaryNode7.setLeft(binaryNode10);
    binaryNode8.setLeft(binaryNode12);
    binaryNode8.setRight(binaryNode13);
    binaryNode9.setLeft(binaryNode14);
    binaryNode9.setRight(binaryNode15);
    getMaxBinarySortTree(binaryNode1);
    binaryNode1.levelPrintTreeByLevel();
  }
}
