package leetcode.LRUCache;

import lombok.Data;

import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/12 0:12
 */
public class LRUCache<K, V> {
  @Data
  private class SingleNode<K, V> {
    V val;
    K key;

    SingleNode<K, V> next;

    public SingleNode(K key, V val) {
      this.val = val;
      this.key = key;
      this.next = null;
    }
  }

  SingleNode<K, V> head, tail;
  HashMap<K, SingleNode<K, V>> hashMap;
  int capacity;
  int currentSize;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.currentSize = 0;
    this.hashMap = new HashMap<>();
    head = null;
    tail = null;
  }

  public V get(K key) {
    if (!hashMap.containsKey(key)) {
      return null;
    }

    removeToLast(key);

    return hashMap.get(key).getVal();
  }

  public void set(K key, V val) {
    if (this.hashMap.containsKey(key)) {
      // 存在key值，进行更新
      this.hashMap.get(key).setVal(val);
      removeToLast(key);
    } else {
      // 不存的时候，进行插入操作
      if (currentSize == capacity) {
        // 如果容器满了，那么此时要进行移除操作
        hashMap.remove(head.getKey());
        head = head.getNext();
        currentSize--;
      }

      SingleNode<K, V> newNode = new SingleNode<>(key, val);
      if (head == null) {
        head = newNode;
      } else {
        tail.setNext(newNode);
      }

      tail = newNode;
      currentSize++;
      hashMap.put(key, newNode);
    }
  }

  private void removeToLast(K key) {
    SingleNode<K, V> temp1, temp2 = null;
    temp1 = head;

    // 如果只有一个节点的话，是不需要进行改动的
    if (head.getNext() == null) {
      return ;
    }

    while (temp1 != null && !temp1.getKey().equals(key)) {
      // 找到目标节点
      temp2 = temp1;
      temp1 = temp1.getNext();
    }

    if (temp1 == null) {
      // 如果temp1为空（一般不会出现）
      return ;
    }

    if (temp1 == head) {
      // 目标的head的时候，head移动到下一个，然后将temp放到最末尾
      head = temp1.getNext();
    } else if (temp1 == tail) {
      tail = temp2;
    } else {
      // 否则就先去掉目标节点
      temp2.setNext(temp1.getNext());
    }

    tail.setNext(temp1);
    tail = temp1;
    temp1.setNext(null);
  }

  public void print() {
    System.out.println("最大容量:" + this.capacity);
    System.out.println("当前容量:" + this.currentSize);
    SingleNode<K, V> singleNode = head;
    while (singleNode != null) {
      System.out.println("键值为: " + singleNode.getKey() + " 值为: " + singleNode.getVal());
      singleNode = singleNode.getNext();
    }
  }

  public static void main(String[] args) {
    LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
    lruCache.set(2, 1);
    lruCache.set(3, 2);
    lruCache.get(3);
    lruCache.get(2);
    lruCache.set(4, 3);
    lruCache.print();
    lruCache.get(2);
    lruCache.get(3);
    lruCache.get(4);
  }
}
