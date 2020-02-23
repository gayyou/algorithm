package chaper4MoreEfficient.theResultNumberOfCircle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.PagesPerMinute;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/27 13:01
 */
public class TheResultNumberOfCircle {
  @Data
  @NoArgsConstructor
  static class LinkedNode {
    int val;
    LinkedNode next;

    public LinkedNode(int val) {
      this.val = val;
    }
  }
  // 第一种解法，形成一个环状链表，然后进行循环遍历，直到剩下最后一个元素就是剩下的数字，那么所需要遍历的次数是
  // n * k
  public static int getTheResultNumberOfCircle(int[] array, int k) {
    LinkedNode head = new LinkedNode();
    LinkedNode temp = head, newNode;

    for (int item : array) {
      newNode = new LinkedNode(item);
      temp.setNext(newNode);
      temp = temp.getNext();
    }

    temp.setNext(head.getNext());
    LinkedNode temp2;

    temp = head.getNext();
    temp2 = temp;

    while (head.getNext() != head.getNext().getNext()) {
      int i = k;

      while (--i != 0) {
        temp2 = temp;
        temp = temp.getNext();
      }

      if (head.getNext() == temp) {
        head.setNext(temp.getNext());
      }
      temp2.setNext(temp.getNext());

      temp = temp.getNext();
    }

    return head.getNext().getVal();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{0, 1, 2, 3, 4};
    System.out.println(TheResultNumberOfCircle.getTheResultNumberOfCircle(arr, 3));
  }
}
