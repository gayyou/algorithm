package chaper2DataStruction;

import org.junit.Test;

/**
 * @
 */
public class RebuildBinaryTree {
  static class Node {
    int val;
    Node lc;
    Node rc;

    public Node (int val) {
      this.val = val;
    }
  }

  public static Node rebuildBinaryTree(int[] preTra, int[] midTra) throws Exception {
    if (preTra == null || midTra == null) {
      throw new Exception("节点为空错误");
    }
    return rebuildBinaryTree(preTra, 0, midTra, 0, midTra.length - 1);
  }

  private static Node rebuildBinaryTree(int[] preTra, int index, int[] midTra, int left, int right) throws Exception {
    if (index >= preTra.length || left > right) return null;  // 这里第二个条件不能够加等于号，因为如果加等于号的话会漏掉最后一个元素
    int tempRoot = preTra[index];
    Node newNode = null;

    for (int i = left; i <= right; i++) {
      if (midTra[i] == tempRoot) {
        newNode = new Node(tempRoot);
        newNode.lc = rebuildBinaryTree(preTra, index + 1, midTra, left, i - 1);
        newNode.rc = rebuildBinaryTree(preTra, index + i - left + 1, midTra, i + 1, right);
      }
    }

    if (newNode == null) {
      throw new Exception("前序遍历和中序遍历不能构成树");
    }

    return newNode;
  }

  public static Node postMiddleRebuildBinaryTree(int[] postTra, int[] midTra) throws Exception {
    if (postTra == null || midTra == null) {
      throw new Exception("空指针异常");
    }
    return postMiddleRebuildBinaryTree(postTra, postTra.length - 1, midTra, 0, midTra.length - 1);
  }

  private static Node postMiddleRebuildBinaryTree(int[] postTra, int index, int[] midTra, int left, int right) throws Exception {
    if (index < 0 || left > right) return null;

    int temp = postTra[index];
    Node newNode = null;

    for (int i = right; i >= left; i--) {
      if (temp == midTra[i]) {
        newNode = new Node(temp);
        newNode.rc = postMiddleRebuildBinaryTree(postTra, index - 1, midTra, i + 1, right);
        newNode.lc = postMiddleRebuildBinaryTree(postTra, index - (right - i + 1), midTra, left, i - 1);
      }
    }

    if (newNode == null) {
      throw new Exception("输入错误");
    }

    return newNode;
  }

  public static void print(Node p) {
    if (p == null) return ;
    System.out.println(p.val);
    print(p.lc);
    print(p.rc);
  }

  @Test
  public void test1() {
    int[] leftTra = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
    int[] rightTra = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(leftTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test2() {
    int[] leftTra = new int[]{1, 2, 4, 5, 3, 6, 7};
    int[] rightTra = new int[]{4, 2, 5, 1, 3, 6, 7};
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(leftTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test3() {
    int[] leftTra = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] rightTra = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(leftTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test4() {
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(null, null);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test5() {
    int[] leftTra = new int[]{11, 2, 3, 4, 6, 11, -1, 3, 2, 1};
    int[] rightTra = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(leftTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test6() {
    int[] leftTra = new int[]{10};
    int[] rightTra = new int[]{10};
    Node root = null;
    try {
      root = RebuildBinaryTree.rebuildBinaryTree(leftTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }

  @Test
  public void test7() {
    int[] postTra = new int[]{4, 5, 2, 6, 3, 7, 1};
    int[] rightTra = new int[]{4, 2, 5, 1, 3, 6, 7};
    Node root = null;

    try {
      root = RebuildBinaryTree.postMiddleRebuildBinaryTree(postTra, rightTra);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    RebuildBinaryTree.print(root);
  }
}
