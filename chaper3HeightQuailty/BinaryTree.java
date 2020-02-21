package chaper3HeightQuailty;

import org.junit.Test;
import sun.misc.Queue;

import java.util.ArrayList;

/**
 * @description 平衡二叉树，进行判断是否是平衡二叉树的子树。是否具有相同的树状结构
 */
public class BinaryTree {

  static class BinaryNode {
    public BinaryNode(int val) {
      this.val = val;
    }

    int val;
    BinaryNode leftChild;
    BinaryNode rightChild;
  }

  BinaryNode root;

  public static boolean isChildTree(BinaryTree parent, BinaryTree child) throws InterruptedException {
    if (parent == null || child == null) {
      return false;
    }

    Queue<BinaryNode> queue = new Queue<>();
    BinaryNode temp;
    queue.enqueue(parent.root);

    while (!queue.isEmpty()) {
      temp = queue.dequeue();

      if (checkSameStruct(temp, child.root)) {
        return true;
      }

      if (temp.leftChild != null) {
        queue.enqueue(temp.leftChild);
      }

      if (temp.rightChild != null) {
        queue.enqueue(temp.rightChild);
      }
    }

    return false;
  }

  private static boolean checkSameStruct(BinaryNode targetA, BinaryNode targetB) {
    if (targetA == null) {
      return targetB == null;
    }

    if (targetB == null) {
      return true;
    }

    if (targetA.val != targetB.val) {
      return false;
    }

    return checkSameStruct(targetA.leftChild, targetB.leftChild) && checkSameStruct(targetA.rightChild, targetB.rightChild);
  }

  /**
   * @description  得到镜像的二叉树
   * @param target
   * @return
   */
  public static BinaryTree getMirrorTree(BinaryTree target) {
    if (target.root == null) {
      return null;
    }
    BinaryTree resultTree = new BinaryTree();
    resultTree.root = new BinaryNode(target.root.val);
    getMirrorNode(target.root, resultTree.root);
    return resultTree;
  }

  private static void getMirrorNode(BinaryNode target, BinaryNode result) {
    if (target == null) {
      return ;
    }

    if (target.leftChild != null) {
      result.rightChild = new BinaryNode(target.leftChild.val);
      getMirrorNode(target.leftChild, result.rightChild);
    }

    if (target.rightChild != null) {
      result.leftChild = new BinaryNode(target.rightChild.val);
      getMirrorNode(target.rightChild, result.leftChild);
    }
  }

  public void print(BinaryNode p) {
    if (p == null) {
      return ;
    }

    System.out.println(p.val);
    print(p.leftChild);
    print(p.rightChild);
  }

  public static boolean isSymmetricalTree(BinaryTree target) {
    if (target == null || target.root == null) {
      return false;
    }

    return mirrorTravel(target.root.leftChild, target.root.rightChild);
  }

  private static boolean mirrorTravel(BinaryNode leftPoint, BinaryNode rightPoint) {
    if (leftPoint == null || rightPoint == null) {
      return leftPoint == null && rightPoint == null;
    }

    if (leftPoint.val != rightPoint.val) {
      return false;
    }

    if (leftPoint.leftChild != null && mirrorTravel(leftPoint.leftChild, rightPoint.rightChild)) {
      return true;
    } else if (rightPoint.rightChild != null) {
      return false;
    }

    if (leftPoint.rightChild != null && mirrorTravel(leftPoint.rightChild, rightPoint.leftChild)) {
      return true;
    } else if (rightPoint.leftChild != null) {
      return false;
    }

    return true;
  }

  public BinaryNode getMaxDoubleDirectionNode(BinaryNode binaryNode) {
    BinaryNode temp;
    if (binaryNode.rightChild != null) {
      // 先去右边找最小的，然后连接起来
      temp = this.getMinDoubleDirectionNode(binaryNode.rightChild);
      binaryNode.rightChild = temp;
      temp.leftChild = binaryNode;
    }
    if (binaryNode.leftChild != null) {
      // 然后在左边拿到最大的，连接起来
      temp = this.getMaxDoubleDirectionNode(binaryNode.leftChild);
      temp.rightChild = binaryNode;
      binaryNode.leftChild = temp;
    }
    // 最后遍历到最小的节点，进行返回。
    // todo 我觉得如果可以减少这一步骤，会更好
    while(binaryNode.rightChild != null) {
      binaryNode = binaryNode.rightChild;
    }

    return binaryNode;
  }

  public BinaryNode getMinDoubleDirectionNode(BinaryNode binaryNode) {
    BinaryNode temp;
    if (binaryNode.rightChild != null) {
      // 先去右边找最小的，然后连接起来
      temp = this.getMinDoubleDirectionNode(binaryNode.rightChild);
      binaryNode.rightChild = temp;
      temp.leftChild = binaryNode;
    }
    if (binaryNode.leftChild != null) {
      // 然后在左边拿到最大的，连接起来
      temp = this.getMaxDoubleDirectionNode(binaryNode.leftChild);
      temp.rightChild = binaryNode;
      binaryNode.leftChild = temp;
    }
    // 最后遍历到最小的节点，进行返回。
    // todo 我觉得如果可以减少这一步骤，会更好
    while(binaryNode.leftChild != null) {
      binaryNode = binaryNode.leftChild;
    }

    return binaryNode;
  }

  public void serialization(BinaryNode node, ArrayList<Integer> arrayList) {
    if (node == null) {
      arrayList.add(-1);
      return ;
    }
    arrayList.add(node.val);
    serialization(node.leftChild, arrayList);
    serialization(node.rightChild, arrayList);
  }

  public BinaryNode deserialization(ArrayList<Integer> arrayList) {
    if (arrayList.size() == 0) {
      return null;
    }
    int val = arrayList.remove(0);
    if (val == -1) {
      return null;
    }
    BinaryNode binaryNode = new BinaryNode(val);
    binaryNode.leftChild = this.deserialization(arrayList);
    binaryNode.rightChild = this.deserialization(arrayList);
    return binaryNode;
  }

  public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    BinaryNode binaryNode1 = new BinaryNode(1);
    BinaryNode binaryNode2 = new BinaryNode(2);
    BinaryNode binaryNode3 = new BinaryNode(3);
    BinaryNode binaryNode4 = new BinaryNode(4);
    BinaryNode binaryNode5 = new BinaryNode(5);
    BinaryNode binaryNode6 = new BinaryNode(6);
    BinaryNode binaryNode7 = new BinaryNode(7);
    BinaryNode binaryNode8 = new BinaryNode(8);
    binaryNode5.leftChild = binaryNode3;
    binaryNode5.rightChild = binaryNode7;
    binaryNode3.leftChild = binaryNode2;
    binaryNode3.rightChild = binaryNode4;
    binaryNode2.leftChild = binaryNode1;
    binaryNode7.leftChild = binaryNode6;
    binaryNode7.rightChild = binaryNode8;
    binaryTree.root = binaryNode5;
    ArrayList<Integer> arrayList = new ArrayList<>();
    binaryTree.serialization(binaryNode5, arrayList);
    System.out.println(arrayList.toString());
    BinaryNode binaryNode = binaryTree.deserialization(arrayList);
    binaryTree.print(binaryNode);
  }
}
