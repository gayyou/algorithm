package chaper4MoreEfficient.minStack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 15:40
 */
public class MinStack<T extends Comparable<T>> {
  Stack<T> normal;
  Stack<T> minStack;

  public MinStack() {
    this.normal = new Stack<>();
    this.minStack = new Stack<>();
  }

  public T pop() {
    if (normal.isEmpty()) {
      throw new EmptyStackException();
    }

    T item = normal.pop();
    if (minStack.peek().equals(item)) {
      minStack.pop();
    }

    return item;
  }

  public T getMin() {
    return minStack.peek();
  }

  public void push(T elem) {
    while (!minStack.isEmpty() && elem.compareTo(minStack.peek()) < 0) {
      minStack.pop();
    }

    normal.push(elem);
    minStack.push(elem);
  }
}
