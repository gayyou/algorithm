package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 21:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryNode<T extends Comparable<T>> {
  T val;
  BinaryNode<T> left;
  BinaryNode<T> right;

  public BinaryNode(T val) {
    this.val = val;
  }

  public void midPrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;
    List<BinaryNode<T>> list = new ArrayList<>();

    while (temp != null || !stack.isEmpty()) {
      while (temp != null) {
        stack.add(temp);
        temp = temp.left;
      }

      BinaryNode<T> temp2 = stack.pop();
      list.add(temp2);
      temp = temp2.getRight();
    }

    for (BinaryNode<T> item : list) {
      System.out.print(item.getVal() + " ");
    }
  }

  public void prePrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;
    List<BinaryNode<T>> list = new ArrayList<>();

    while (temp != null || !stack.isEmpty()) {
      while (temp != null) {
        list.add(temp);
        stack.push(temp);
        temp = temp.getLeft();
      }

      BinaryNode<T> temp2 = stack.pop();
      temp = temp2.getRight();
    }

    for (BinaryNode<T> item : list) {
      System.out.print(item.getVal() + " ");
    }
  }

  public void postPrintTree() {
    Stack<BinaryNode<T>> stack = new Stack<>();
    BinaryNode<T> temp = this;
    BinaryNode<T> visited = null;
    List<BinaryNode<T>> list = new ArrayList<>();

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
          list.add(temp);
          temp = null;
        }
      }
    }

    for (BinaryNode<T> item : list) {
      System.out.print(item.getVal() + " ");
    }
  }

  public void levelPrintTree() {
    List<BinaryNode<T>> list = new ArrayList<>();
    Queue<BinaryNode<T>> queue = new ArrayDeque<>();
    queue.add(this);

    while (!queue.isEmpty()) {
      BinaryNode<T> temp = queue.poll();
      list.add(temp);

      if (temp.getLeft() != null) {
        queue.add(temp.getLeft());
      }

      if (temp.getRight() != null) {
        queue.add(temp.getRight());
      }
    }

    for (BinaryNode<T> item : list) {
      System.out.print(item.getVal() + " ");
    }
  }

  public void levelPrintTreeByLevel() {
    Queue<BinaryNode<T>> queue = new ArrayDeque<>();
    queue.add(this);
    BinaryNode<T> pre = this, last = this;

    while (!queue.isEmpty()) {
      BinaryNode<T> temp = queue.poll();

      System.out.print(temp.getVal() + " ");

      if (temp.getLeft() != null) {
        queue.add(temp.getLeft());
        last = temp.getLeft();
      }

      if (pre.getRight() != null) {
        queue.add(temp.getRight());
        last = temp.getRight();
      }

      if (pre == temp) {
        System.out.println();
        pre = last;
      }
    }
  }
}
