package chaper4MoreEfficient.spiltLinkedList;

import model.LinkedListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/16 19:56
 */
public class SplitLinkedList {
  public static LinkedListNode<Integer> splitList(LinkedListNode<Integer> head, int k) {
    if (head == null) {
      return null;
    }

    Queue<LinkedListNode<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(LinkedListNode::getVal));
    while (head != null) {
      queue.add(head);
      head = head.getNext();
    }

    head = queue.poll();
    LinkedListNode<Integer> res = head;

    while (!queue.isEmpty() && queue.peek().getVal() < k) {
      assert head != null;
      head.setNext(queue.poll());
      head = head.getNext();
    }

    for (LinkedListNode<Integer> item : queue) {
      assert head != null;
      head.setNext(item);
      head = head.getNext();
    }

    return res;
  }

  public static void main(String[] args) {
    LinkedListNode<Integer> list = new LinkedListNode<>(1);
    list = list.toList(new Integer[]{1, 4, 5, 3, 2, 7, 10});
    LinkedListNode.print(SplitLinkedList.splitList(list, 5));
  }
}
