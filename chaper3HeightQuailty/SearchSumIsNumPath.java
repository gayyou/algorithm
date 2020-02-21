package chaper3HeightQuailty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description 输入一棵二叉树和一个整数，打印出二叉树中节点的值的和为输入整数的所有路径.思路是使用深度优先遍历，然后使用
 * 私有方法，用一个ArrayList的空间进行存储路径。
 * TODO 目前只考虑全都是正数的情况，如果是存在负数的话，那么截止只能是访问了叶子节点
 */
public class SearchSumIsNumPath {
  private ArrayList<ArrayList<Integer>> result;

  private SearchSumIsNumPath() {
    this.result = new ArrayList<>();
  }

  public ArrayList<ArrayList<Integer>> getTheSumPath(Node root, int target) {
    if (root == null) {
      return null;
    }
    this.getTheSumPath(root, 0, target, new ArrayList<>());

    return this.result;
  }

  private void getTheSumPath(Node root, int currentSum, int target, ArrayList<Integer> currentPath) {
    if (root.left == null && root.right == null) {
      int tempSum = currentSum + root.val;
      if (tempSum == target) {
        // 如果
        currentPath.add(root.val);
        this.result.add((ArrayList<Integer>) currentPath.clone());
        currentPath.remove(currentPath.size() - 1);
      }
      return ;
    }

    if (currentSum + root.val >= target) {
      return ;
    }

    currentPath.add(root.val);

    if (root.left != null) {
      this.getTheSumPath(root.left, currentSum + root.val, target, currentPath);
    }

    if (root.right != null) {
      this.getTheSumPath(root.right, currentSum + root.val, target, currentPath);
    }

    currentPath.remove(currentPath.size() - 1);
  }

  public static void main(String[] args) {
    Node root = new Node();
    root.val = 10;
    root.left = new Node();
    root.left.val = 5;
    root.left.left = new Node();
    root.left.left.val = 4;
    root.left.right = new Node();
    root.left.right.val = 7;
    root.right = new Node();
    root.right.val = 12;

    System.out.println(new SearchSumIsNumPath().getTheSumPath(root, 22));
  }
}
