package chaper3HeightQuailty;

import jdk.internal.org.objectweb.asm.tree.LineNumberNode;
import model.LinkedListNode;
import org.junit.Test;

public class MyLinkedList<T> {
  LinkedListNode<T> head;

  public MyLinkedList(T val) {
    this.head = new LinkedListNode<>(val);
  }

  public void insert(T val) {
    LinkedListNode<T> temp = head;

    while(temp.getNext() != null) {
      temp = temp.getNext();
    }

    temp.insert(new LinkedListNode<>(val));
  }

  /**
   * @description 得到成环的个数
   * @return
   */
  private int getLeapNodeNumber() {
    if (this.head == null) {
      return 0;
    }

    LinkedListNode<T> p1, p2;
    p1 = head;

    try {
      p2 = p1.getNext().getNext();
    } catch (NullPointerException e) {
      return 0;
    }

    while (p1 != p2 && p2 != null) {
      p1 = p1.getNext();
      try {
        p2 = p2.getNext().getNext();
      } catch (NullPointerException e) {
        return 0;
      }
    }

    int count = 1;
    p1 = p1.getNext();

    try {
      p2 = p2.getNext().getNext();
    } catch (NullPointerException e) {
      return 0;
    }

    while(p1 != p2) {
      p1 = p1.getNext();
      p2 = p2.getNext().getNext();
      count++;
    }

    return count;
  }

  public LinkedListNode<T> getLeapEntryNode() {
    if (this.head == null) {
      return null;
    }

    int leapNodeNumber = this.getLeapNodeNumber();

    if (leapNodeNumber == 0) {
      return null;
    }

    LinkedListNode<T> p1, p2;

    p1 = head;
    p2 = p1.getNext();

    while (true) {
      for (int i = 0; i < leapNodeNumber; i++) {
        if (p1 == p2) {
          return p1;
        }
        p2 = p2.getNext();
      }
      p1 = p1.getNext();
      p2 = p1;
    }
  }

  /**
   * @description 合并两个升序链表，输入的前提是两个升序链表是不成环的。目前使用的是双指针法，一个指向A一个指向B，每次都选出A和B链
   * 表中最小的值作为下一个节点。
   * @param first
   * @param second
   * @return
   */
  public static LinkedListNode<Integer> insertOrderLinkedList(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
    if (first == null) {
      return second;
    }

    if (second == null) {
      return first;
    }

    LinkedListNode<Integer> p1,p2,temp, head;
    p1 = first;
    p2 = second;
    head = null;

    boolean isTheFirst = true;

    while(p1 != null && p2 != null) {
      if (isTheFirst) {
        if (p1.getVal() < p2.getVal()) {
          head = p1;
        } else {
          head = p2;
        }
        isTheFirst = false;
      }

      if (p1.getVal() < p2.getVal()) {
        if (p1.getNext() != null && p1.getNext().getVal() < p2.getVal()) {
          p1 = p1.getNext();
        } else {
          temp = p1;
          p1 = p1.getNext();
          temp.setNext(p2);
        }
      } else {
        if (p2.getNext() != null && p2.getNext().getVal() < p1.getVal()) {
          p2 = p2.getNext();
        } else {
          temp = p2;
          p2 = p2.getNext();
          temp.setNext(p1);
        }
      }
    }

    return head;
  }

  public static void main(String[] args) {
    MyLinkedList<Integer> head = new MyLinkedList<>(1);
    MyLinkedList<Integer> head2 = new MyLinkedList<>(2);
    LinkedListNode<Integer> result = MyLinkedList.insertOrderLinkedList(null, null);

    while(result != null) {
      System.out.println(result.getVal());
      result = result.getNext();
    }
  }

  @Test
  public void test() {
    MyLinkedList<Integer> head = new MyLinkedList<>(1);
    head.insert(4);
    head.insert(7);
    head.insert(8);
    head.insert(9);
    MyLinkedList<Integer> head2 = new MyLinkedList<>(2);
    head.insert(3);
    head.insert(5);
    head.insert(6);
    head.insert(10);
    LinkedListNode<Integer> result = MyLinkedList.insertOrderLinkedList(head.head, head2.head);

    while(result != null) {
      System.out.println(result.getVal());
      result = result.getNext();
    }
  }
}
