package algorithms.linkedlist;

import model.LinkedListNode;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 19:34
 * 将问题分为三种情况
 * 1. 两条链表无环，则使用栈来进行查找相交点
 * 2. 链条链表存在环，那么有两种情况：成环前相交，成环后相交
 */
public class FindTwoCircleList {
  public static LinkedListNode<Integer> findTwoList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    if (head1 == null || head2 == null) {
      return null;
    }

    LinkedListNode<Integer> loop1 = findLoopNode(head1);
    LinkedListNode<Integer> loop2 = findLoopNode(head2);

    if (loop1 == null || loop2 == null) {
      return FindSameNodes.printSameNodes(head1, head2);
    }

    return findBothLoop(head1, head2, loop1, loop2);
  }

  private static LinkedListNode<Integer> findBothLoop(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2, LinkedListNode<Integer> loop1, LinkedListNode<Integer> loop2) {
    if (loop1 == loop2) {
      // 使用栈结构来找到相交点，跟无环一样解法
      Stack<LinkedListNode<Integer>> stack1 = new Stack<>();
      Stack<LinkedListNode<Integer>> stack2 = new Stack<>();

      LinkedListNode<Integer> temp1 = head1, temp2 = head2;

      while (temp1 != loop1) {
        stack1.push(temp1);
        temp1 = temp1.getNext();
      }

      while (temp2 != loop1) {
        stack2.push(temp2);
        temp2 = temp2.getNext();
      }


      while (stack1.peek() == stack2.peek()) {
        LinkedListNode<Integer> result = stack1.pop();
        stack2.pop();
        if (stack1.peek() != stack2.peek()) {
          return result;
        }
      }
    }

    LinkedListNode<Integer> temp1 = loop1.getNext();

    while (temp1 != loop2) {
      if (temp1 == loop1) {
        return null;
      }

      temp1 = temp1.getNext();
    }

    return loop2;
  }

  private static LinkedListNode<Integer> findLoopNode(LinkedListNode<Integer> head) {
    if (head == null) {
      return null;
    }
    if (head.getNext() == null) {
      return null;
    }
    LinkedListNode<Integer> temp1 = head.getNext(), temp2 = head.getNext().getNext();

    while (temp1 != temp2) {
      if (temp1.getNext() == null || temp1.getNext().getNext() == null) {
        return null;
      }
      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
      temp2 = temp2.getNext();
    }

    temp1 = head;
    while (temp1 != temp2) {
      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
    }

    return temp1;
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
    linkedListNode8.setNext(linkedListNode3);
    LinkedListNode<Integer> linkedListNode9 = new LinkedListNode<>(3);
    LinkedListNode<Integer> linkedListNode10 = new LinkedListNode<>(2);
    LinkedListNode<Integer> linkedListNode11 = new LinkedListNode<>(2);
    linkedListNode9.setNext(linkedListNode10);
    linkedListNode10.setNext(linkedListNode11);
    linkedListNode11.setNext(linkedListNode6);
    System.out.println(FindTwoCircleList.findTwoList(linkedListNode1, linkedListNode9).getVal());
  }
}