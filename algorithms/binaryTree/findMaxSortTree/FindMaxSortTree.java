package algorithms.binaryTree.findMaxSortTree;

import model.BinaryNode;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/23 21:18
 * 思路：
 * 1. 树型dp遍历问题解决思路：
 *    a. 从根节点触发，进行分析问题存在的可能性：左边子树可能存在最大搜索树，右边也可能存在，同时根节点也可能是
 *    b. 获取解决问题的关键元素，如这道题中有左子树中最大的二叉搜索树头部，左边最大二叉搜索树的最大大小，左边最大二叉搜索树的最大值，最小值，
 *    同理右边也有
 *    c. 进行设计存储类，因为本题型是自底向上来进行创建的，所以要用到后序遍历，即左中右
 *    d. 进行设计递归，设计递归的话，需要从a来进行条件判断。
 * 2. 本题例子
 *    a. 左子树存在两种情况，一种是左子树整颗是最大搜索二叉树；左子树中存在子树是最大二叉搜索树；同理右边也是。当且仅当左右子树是最大二叉搜索树的
 *    时候，判断左子树的最大值是不是小于中间的节点，右子树的最大值是不是大于中间节点，从而进行判断这颗树是不是最大搜索二叉树
 *    b. 定义数据类型：最大搜索二叉树的根节点： maxHead；大小：maxSize；最小是：minNum；最大值：maxNum
 *    c. 定义ResultType
 *    d. 设计递归，首先确定自底向上找的话，只能是后序遍历，所以逻辑处理放在后序遍历。然后其他内容查看注释
 */
public class FindMaxSortTree {
  static class ResultType {
    BinaryNode<Integer> maxSortHead;
    int maxSize;
    int maxNum;
    int minNum;

    public ResultType(BinaryNode<Integer> maxSortHead, int maxSize, int maxNum, int minNum) {
      this.maxSortHead = maxSortHead;
      this.maxSize = maxSize;
      this.maxNum = maxNum;
      this.minNum = minNum;
    }
  }

  public static BinaryNode<Integer> getMaxSortTree(BinaryNode<Integer> root) {
    if (root == null) {
      return null;
    }

    return getMaxChildTree(root).maxSortHead;
  }

  private static ResultType getMaxChildTree(BinaryNode<Integer> root) {
    if (root == null) {
      return null;
    }

    ResultType leftResult = getMaxChildTree(root.getLeft());
    ResultType rightResult = getMaxChildTree(root.getRight());

    // 左右返回类型不为空的情况
    if (leftResult != null && rightResult != null) {
      if (leftResult.maxSortHead == root.getLeft()
              && leftResult.maxNum < root.getVal()
              && rightResult.maxNum > root.getVal()
              && rightResult.maxSortHead == root.getRight()) {
        // 如果左子树最大树是整棵树，有子树的最大是整颗树，那么进行比较左子树的最大值是否小于当前树，右子树的最小是否小于当前值
          return new ResultType(root, leftResult.maxSize + rightResult.maxSize + 1,
                  rightResult.maxNum, leftResult.minNum);


      }

      return leftResult.maxSize > rightResult.maxSize ? leftResult : rightResult;
    }

    // 左子树不为空，右子树为空
    if (leftResult != null) {
      return leftResult;
    }

    // 左子树为空，右子树不为空
    if (rightResult != null) {
      return rightResult;
    }

    // 叶子节点。
    return new ResultType(root, 1, root.getVal(), root.getVal());
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
    getMaxSortTree(binaryNode1).levelPrintTreeByLevel();
  }
}
