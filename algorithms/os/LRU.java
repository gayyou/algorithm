package algorithms.os;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/28 17:47
 */
public class LRU {
  private class ListNode {
    int val;
    int key;
    ListNode next;
    ListNode pre;

    public ListNode(int key, int val) {
      this.val = val;
      this.key = key;
    }
  }

  HashMap<Integer, ListNode> cache;
  ListNode head;
  ListNode tail;
  int count;
  int cap;

  public LRU(int capacity) {
    this.cache = new HashMap<>();
    this.cap = capacity;
    this.count = 0;
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }

    // 进行调整
    ListNode temp = this.head;
    ListNode tar = cache.get(key);

    if (temp == tar) {
      return tar.val;
    }

    while (temp != tar) {
      temp = temp.next;
    }

    temp.pre.next = temp.next;

    head.pre = temp;
    temp.next = head;
    head = temp;

    return tar.val;
  }

  public void put(int key, int value) {
    ListNode tar = cache.get(key);

    if (tar == null) {
      // 如果不存在，则进行创建节点
      if (count == cap) {
        cache.remove(tail.key);
        tail = tail.pre;
        tail.next = null;
        count--;
      }

      tar = new ListNode(key, value);
      cache.put(key, tar);

      count++;
    } else {
      // 如果存在节点的话，那么要进行处理
      if (tar == tail) {
        tail = tail.pre;
        tail.next = null;
      } else {
        tar.pre.next = tar.next;
        tar.next.pre = tar.pre;
      }
      tar.val = value;
    }

    if (head == null) {
      tail = head = tar;
    } else {
      tar.val = value;
      tar.next = head;
      head.pre = tar;
      head = tar;
    }
  }

  public static void main(String[] args) {
    LRU lru = new LRU(3);
    lru.put(1, 1);
    lru.put(2, 2);
    lru.put(3, 3);
    lru.put(4, 3);
    System.out.println(lru.count);
    System.out.println(lru.get(1));
    System.out.println(lru.tail.val);
  }
}