package algorithms.linkedlist;

import model.LinkedListNode;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 15:25
 *
 * 1. 使用两个栈分别存储压进来的数据，然后出栈的时候进行比较两个栈出栈的内容从而判断是否是相同的节点来进行，时间复杂度是2n
 * 2. 使用双指针法，时间复杂度是n ^ 2
 */
public class FindSameNodes {
  public static LinkedListNode<Integer> printSameNodes(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    if (head1 == null || head2 == null) {
      return null;
    }

    Stack<LinkedListNode<Integer>> stack1 = new Stack<>();
    Stack<LinkedListNode<Integer>> stack2 = new Stack<>();
    LinkedListNode<Integer> loop = null;

    while (head1 != null) {
      stack1.push(head1);
      head1 = head1.getNext();
    }

    while (head2 != null) {
      stack2.push(head2);
      head2 = head2.getNext();
    }

    while (stack1.peek() == stack2.peek()) {
      // 需要用地址来证明
      loop = stack1.peek();
      stack1.pop();
      stack2.pop();
    }

    return loop;
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
    linkedListNode3.setNext(linkedListNode4);
    linkedListNode2.setNext(linkedListNode5);
    linkedListNode4.setNext(linkedListNode5);
    linkedListNode5.setNext(linkedListNode6);
    printSameNodes(linkedListNode1, linkedListNode3);
  }
}
