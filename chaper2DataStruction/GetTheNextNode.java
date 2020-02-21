package chaper2DataStruction;

import org.junit.Test;

public class GetTheNextNode {
  class Node {
    public Node(int val) {
      this.val = val;
    }

    int val;
    Node leftChild;
    Node rightChild;
    Node parent;
  }

  public static Node getNextNodeByPreTravel(Node target) {
    if (target == null) {
      return null;
    }

    if (target.leftChild != null) {
      return target.leftChild;
    } else if (target.rightChild != null) {
      Node right = target.parent.rightChild;

      while(right.leftChild != null) {
        right = right.leftChild;
      }

      return right;
    } else if (target.parent != null) {
      Node lastParent = target.parent;
      while (lastParent != null && lastParent.rightChild == null) {
        lastParent = lastParent.parent;
      }

      if (lastParent == null) {
        return null;
      }

      Node right = lastParent.rightChild;

      while(right.leftChild != null) {
        right = right.leftChild;
      }

      return right;
    }
    return null;
  }

  @Test
  public void test01() {
    Node root = new Node(1);
    Node temp = root.leftChild = new Node(2);
    root.leftChild.parent = root;
    root.leftChild.rightChild = new Node(4);
    Node temp2 = root.leftChild.leftChild = new Node(3);
    temp2.parent = root.leftChild;
    System.out.println(GetTheNextNode.getNextNodeByPreTravel(temp2).val);
  }
}
