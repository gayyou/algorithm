package algorithms.linkedlist;

import model.LinkedListNode;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 15:38

 */
public class ReserseLinkedList {
  public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
    if (head == null) {
      return null;
    }

    LinkedListNode<Integer> temp1, temp2, temp3;
    temp1 = head.getNext();
    temp2 = head;
    head.setNext(null);

    while (temp1 != null) {
      temp3 = temp2;
      temp2 = temp1;
      temp1 = temp1.getNext();
      temp2.setNext(temp3);
    }

    return temp2;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> linkedListNode1 = new LinkedListNode<>(1);
    LinkedListNode<Integer> linkedListNode2 = new LinkedListNode<>(2);
    LinkedListNode<Integer> linkedListNode3 = new LinkedListNode<>(3);
    LinkedListNode<Integer> linkedListNode4 = new LinkedListNode<>(4);
    LinkedListNode<Integer> linkedListNode5 = new LinkedListNode<>(5);
    LinkedListNode<Integer> linkedListNode6 = new LinkedListNode<>(6);
    LinkedListNode<Integer> linkedListNode7 = new LinkedListNode<>(7);
    LinkedListNode<Integer> linkedListNode8 = new LinkedListNode<>(8);
    linkedListNode1.setNext(linkedListNode2);
    linkedListNode2.setNext(linkedListNode3);
    linkedListNode3.setNext(linkedListNode4);
    linkedListNode4.setNext(linkedListNode5);
    linkedListNode5.setNext(linkedListNode6);
    linkedListNode6.setNext(linkedListNode7);
    linkedListNode7.setNext(linkedListNode8);
    LinkedListNode<Integer> newHead = ReserseLinkedList.reverseLinkedList(linkedListNode1);
    while (newHead != null) {
      System.out.println(newHead.getVal());
      newHead = newHead.getNext();
    }
  }
}
