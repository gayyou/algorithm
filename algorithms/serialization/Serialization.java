package algorithms.serialization;

import algorithms.array.searchRotateArray.SearchRotateArray;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/18 17:44
 */
public class Serialization {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static String serializeTree(TreeNode root) {
    if (root == null) {
      return "";
    }

    StringBuilder result = new StringBuilder();
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    result.append(root.val).append(",");

    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();

      if (temp.left == null) {
        result.append("null,");
      } else {
        result.append(temp.left.val).append(",");
        queue.add(temp.left);
      }

      if (temp.right == null) {
        result.append("null,");
      } else {
        result.append(temp.right.val).append(",");
        queue.add(temp.right);
      }
    }

    result.setLength(result.length() - 1);
    System.out.println(result.toString());

    for (int i = result.length() - 5; i >= 0; i -= 5) {
      if (!result.substring(i, i + 5).equals(",null")) {
        result.setLength(i == result.length() - 6 ? i : i + 5);
        break;
      }
    }

    return result.toString();
  }

  public static String a(TreeNode root) {
    if (root == null) {
      return "[]";
    }
    final String start = "[";
    final String end = "]";
    StringBuilder strBuilder = new StringBuilder(start);
    Deque<TreeNode> queue = new ArrayDeque<>();
    int rareNodes = 1;
    //下一层实际节点数
    int nextLevelNodes = 0;
    //下一层需要追加null的数量；
    int nextAppendNulls = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode headNode = queue.pollFirst();
      //append
      strBuilder.append(headNode.val + ",");
      rareNodes--;
      if (headNode.left != null) {
        nextLevelNodes++;
        queue.add(headNode.left);
      } else {
        nextAppendNulls++;
      }
      if (headNode.right != null) {
        nextLevelNodes++;
        queue.add(headNode.right);
      } else {
        nextAppendNulls++;
      }
      if (rareNodes == 0) {
        for (int i = 0; i < nextAppendNulls && nextLevelNodes != 0; i++) {
          strBuilder.append("null,");
        }
        rareNodes = nextLevelNodes;
        nextLevelNodes = 0;
      }
    }
    //切除最后一个,即可
    strBuilder.deleteCharAt(strBuilder.lastIndexOf(","));
    strBuilder.append(end);
    return strBuilder.toString();
  }

  public static void main(String[] args) {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);
    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode6;
    treeNode3.left = treeNode4;
    treeNode3.right = treeNode5;
    System.out.println(Serialization.serializeTree(treeNode1));
  }
}
