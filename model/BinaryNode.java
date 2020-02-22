package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 21:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryNode<T> {
  T val;
  BinaryNode<T> left;
  BinaryNode<T> right;

  public BinaryNode(T val) {
    this.val = val;
  }

  public void midPrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;

    while (temp != null || !stack.isEmpty()) {
      while (temp != null) {
        stack.add(temp);
        temp = temp.left;
      }

      BinaryNode<T> temp2 = stack.pop();
      System.out.println(temp2.getVal());
      temp = temp2.getRight();
    }
  }

  public void prePrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;

    while (temp != null || !stack.isEmpty()) {
      while (temp != null) {
        System.out.println(temp.getVal());
        stack.push(temp);
        temp = temp.getLeft();
      }

      BinaryNode<T> temp2 = stack.pop();
      temp = temp2.getRight();
    }
  }

  public void postPrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;
    BinaryNode<T> visited = null;

    while (temp != null || !stack.isEmpty()) {
      if (temp != null) {
        stack.push(temp);
        temp = temp.getLeft();
      } else {
        temp = stack.pop();

        if (temp.getRight() != null && temp.getRight() != visited) {
          stack.push(temp);
          temp = temp.getRight();
        } else {
          visited = temp;
          System.out.println(temp.getVal());
          temp = null;
        }
      }
    }
  }

  static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
