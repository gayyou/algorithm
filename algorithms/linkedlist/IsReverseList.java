package algorithms.linkedlist;

import model.LinkedListNode;

import java.util.ArrayList;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 18:19
 * 1. 使用额外的n长度的数组来存储，然后进行遍历
 * 2. 使用额外1空间来存储，但是
 */
public class IsReverseList {
  public static boolean isReverseList(LinkedListNode<Integer> head) {
    if (head == null) {
      throw new NullPointerException("不能为空链表");
    }

    ArrayList<LinkedListNode<Integer>> arrayList = new ArrayList<>();

    while (head != null) {
      arrayList.add(head);
      head = head.getNext();
    }

    int len = arrayList.size();

    for (int i = 0; i < len / 2; i++) {
      if (!arrayList.get(i).getVal().equals(arrayList.get(len - i - 1).getVal())) {
        return false;
      }
    }

    return true;
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
    System.out.println(isReverseList(linkedListNode1));
  }
}
