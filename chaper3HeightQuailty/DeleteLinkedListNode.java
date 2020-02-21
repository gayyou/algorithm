package chaper3HeightQuailty;

import org.junit.Test;

public class DeleteLinkedListNode {
  Node head;

  static class Node {
    Node next;
    int val;

    public Node(int val) {
      this.val = val;
    }
  }

  public DeleteLinkedListNode(int val) {
    this.head = new Node(val);
  }

  public boolean deleteNode(Node target) {
    if (target == null) {
      return false;
    }

    if (this.head == target) {
      this.head = null;
      return true;
    }

    if (target.next == null) {
      // 作为最后一个节点，此时要从头到尾进行遍历
      Node temp = this.head;

      while(temp.next != target) {
        if (temp.next == null) {
          // 找不到节点
          return false;
        }

        temp = temp.next;
      }

      temp.next = null;
    } else {
      // 将本节点的下一个节点放到本节点上，然后跳过下一个节点
      target.val = target.next.val;
      target.next = target.next.next;
    }

    return true;
  }

  public void insert(int val) {
    Node newNode = new Node(val);

    Node temp = this.head;

    while(temp.next != null) {
      temp = temp.next;
    }

    temp.next = newNode;
  }

  public void print() {
    Node temp = this.head;

    while(temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    DeleteLinkedListNode deleteLinkedListNode = new DeleteLinkedListNode(1);
    deleteLinkedListNode.head.next = new Node(2);
    deleteLinkedListNode.head.next.next = new Node(3);
    Node target = new Node(4);
    deleteLinkedListNode.head.next.next.next = target;
    System.out.println(deleteLinkedListNode.deleteNode(target));
    deleteLinkedListNode.print();

    System.out.println();
    DeleteLinkedListNode deleteLinkedListNode1 = new DeleteLinkedListNode(2);
    deleteLinkedListNode1.deleteNode(deleteLinkedListNode1.head);
    deleteLinkedListNode1.print();

    System.out.println();
    DeleteLinkedListNode deleteLinkedListNode2 = new DeleteLinkedListNode(3);
    deleteLinkedListNode2.insert(2);
    deleteLinkedListNode2.insert(3);
    deleteLinkedListNode2.deleteNode(deleteLinkedListNode2.head.next);
    deleteLinkedListNode2.print();
  }
}
