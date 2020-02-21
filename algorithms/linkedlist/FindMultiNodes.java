package algorithms.linkedlist;

import model.LinkedListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 20:20
 */
public class FindMultiNodes {
  public static void removeMultiNodes(LinkedListNode<Integer> head) {
    if (head == null) {
      return ;
    }

    HashSet<Integer> hashSet = new HashSet<>();
    LinkedListNode<Integer> temp1 = head, temp2 = head.getNext();
    hashSet.add(temp1.getVal());

    while (temp2 != null) {
      if (hashSet.contains(temp2.getVal())) {
        temp1.setNext(temp2.getNext());
        temp2 = temp1.getNext();
      } else {
        hashSet.add(temp2.getVal());
        temp1 = temp2;
        temp2 = temp2.getNext();
      }
    }
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> linkedListNode1 = new LinkedListNode<>(1);
    LinkedListNode<Integer> linkedListNode2 = new LinkedListNode<>(2);
    LinkedListNode<Integer> linkedListNode3 = new LinkedListNode<>(3);
    LinkedListNode<Integer> linkedListNode4 = new LinkedListNode<>(4);
    LinkedListNode<Integer> linkedListNode5 = new LinkedListNode<>(4);
    LinkedListNode<Integer> linkedListNode6 = new LinkedListNode<>(3);
    LinkedListNode<Integer> linkedListNode7 = new LinkedListNode<>(2);
    LinkedListNode<Integer> linkedListNode8 = new LinkedListNode<>(2);
    linkedListNode1.setNext(linkedListNode2);
    linkedListNode2.setNext(linkedListNode3);
    linkedListNode3.setNext(linkedListNode4);
    linkedListNode4.setNext(linkedListNode5);
    linkedListNode5.setNext(linkedListNode6);
    linkedListNode6.setNext(linkedListNode7);
    linkedListNode7.setNext(linkedListNode8);
    removeMultiNodes(linkedListNode1);
    while (linkedListNode1 != null) {
      System.out.println(linkedListNode1.getVal());
      linkedListNode1 = linkedListNode1.getNext();
    }
  }
}
