package leetcode.detectCycle;

import dataStructure.SingleNode;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/11 23:25
 */
public class DetectCycle {
  public SingleNode<Integer> detectCycle(SingleNode<Integer> head) {
    if (head == null) {
      return null;
    }
    SingleNode<Integer> temp1 = head, temp2 = head;

    // 如果有成环，那么得到两个temp1 = temp2.如果没有成环，那么就返回false
    do {
      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
      if (temp2 == null) {
        return null;
      }
      temp2 = temp2.getNext();
    } while (temp1 != temp2 && temp2 != null);

    if (temp2 == null) {
      return null;
    }

    // 接下来是得到环的大小
    int count = 0;

    do {
      temp1 = temp1.getNext();
      temp2 = temp2.getNext().getNext();
      count++;
    } while (temp1 != temp2);

    temp1 = temp2 = head;

    while (count-- != 0) {
      temp2 = temp2.getNext();
    }

    while (temp1 != temp2) {
      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
    }
    
    return temp1;
  }
}
