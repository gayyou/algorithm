package 剑指offer题目.chaper4MoreEfficient.hasMaxQueue;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/25 22:04
 */
@Data
public class HasMaxQueue<T extends Comparable<T>> {
  Deque<T> maxQueue;
  Deque<T> baseQueue;

  public HasMaxQueue() {
    this.maxQueue = new ArrayDeque<>();
    this.baseQueue = new ArrayDeque<>();
  }

  public T getMax() {
    if (this.baseQueue.isEmpty()) {
      return null;
    }

    return maxQueue.getFirst();
  }

  public void push(T elem) {
    while (!maxQueue.isEmpty() && maxQueue.getLast().compareTo(elem) < 0) {
      maxQueue.removeLast();
    }

    maxQueue.addLast(elem);
    baseQueue.addLast(elem);
  }

  public T pop() {
    if (this.baseQueue.isEmpty()) {
      return null;
    }

    if (maxQueue.getFirst().equals(baseQueue.getFirst())) {
      maxQueue.removeFirst();
    }

    return baseQueue.removeFirst();
  }

  public static void main(String[] args) {
    HasMaxQueue<Integer> hasMaxQueue = new HasMaxQueue<>();
    hasMaxQueue.push(1);
    hasMaxQueue.push(13);
    hasMaxQueue.push(22);
    hasMaxQueue.push(11);
    hasMaxQueue.push(6);
    hasMaxQueue.push(2);
    hasMaxQueue.push(5);
    hasMaxQueue.push(3);

    System.out.println(hasMaxQueue.getMax());
    hasMaxQueue.pop();
    System.out.println(hasMaxQueue.getMax());
    System.out.println(hasMaxQueue.getBaseQueue());
  }
}
