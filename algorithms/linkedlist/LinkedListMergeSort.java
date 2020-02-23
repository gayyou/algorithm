package algorithms.linkedlist;

import model.LinkedListNode;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/22 13:43
 */
public class LinkedListMergeSort {
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public ListNode sortList(ListNode head) {
    // 归并排序
    if (head == null || head.next == null) {
      return head;
    }

    // 使用快慢法来进行寻找中间节点
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // 寻找到中间节点然后拆分链表
    ListNode right = sortList(slow.next);
    slow.next = null;
    ListNode left = sortList(head);

    // 接下来是合并两个有序链表的操作
    ListNode newHead;

    if (left.val < right.val) {
      newHead = left;
    } else {
      newHead = right;
      ListNode temp = left;
      left = right;
      right = temp;
    }

    ListNode pre = left, next;

    while (left != null && right != null) {
      if (left.val <= right.val) {
        pre = left;
        left = left.next;
      } else {
        pre.next = right;
        next = right.next;
        right.next = left;
        pre = right;
        right = next;
      }
    }

    pre.next = left == null ? right : left;

    return newHead;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(4);
    ListNode listNode2 = new ListNode(19);
    ListNode listNode3 = new ListNode(14);
    ListNode listNode4 = new ListNode(5);
    ListNode listNode5 = new ListNode(-3);
    ListNode listNode6 = new ListNode(1);
    ListNode listNode7 = new ListNode(8);
    ListNode listNode8 = new ListNode(5);
    ListNode listNode9 = new ListNode(11);
    ListNode listNode10 = new ListNode(15);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode7.next = listNode8;
    listNode8.next = listNode9;
    listNode9.next = listNode10;
    LinkedListMergeSort linkedListMergeSort = new LinkedListMergeSort();
    System.out.println(linkedListMergeSort.sortList(listNode1).next);
  }
}
