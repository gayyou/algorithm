package algorithms.binaryTree.zipzagPrint;

import model.BinaryNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/25 19:28
 */
public class ZigZagPrint {
  public static void zigZagPrint(BinaryNode<Integer> root) {
    if (root == null) {
      return ;
    }

    Deque<BinaryNode<Integer>> deque = new LinkedList<>();
    BinaryNode<Integer> pre = root, post = null;
    boolean ls = true;
    deque.add(root);
    LinkedList<Integer> list = new LinkedList<>();

    while (!deque.isEmpty()) {
      BinaryNode<Integer> temp;
      if (ls) {
        temp = deque.removeFirst();

        if (temp.getLeft() != null) {
          deque.add(temp.getLeft());
          post = post == null ? temp.getLeft() : post;
        }

        if (temp.getRight() != null) {
          deque.add(temp.getRight());
          post = post == null ? temp.getRight() : post;
        }
      } else {
        temp = deque.removeLast();

        if (temp.getRight() != null) {
          deque.push(temp.getRight());
          post = post == null ? temp.getRight() : post;
        }

        if (temp.getLeft() != null) {
          deque.push(temp.getLeft());
          post = post == null ? temp.getLeft() : post;
        }
      }

      list.add(temp.getVal());

      if (pre == temp) {
        pre = post;
        ls = !ls;
        post = null;
      }
    }

    System.out.println(list);
  }

  public static void main(String[] args) {
    BinaryNode<Integer> binaryNode1 = new BinaryNode<>(6);
    BinaryNode<Integer> binaryNode2 = new BinaryNode<>(1);
    BinaryNode<Integer> binaryNode3 = new BinaryNode<>(12);
    BinaryNode<Integer> binaryNode4 = new BinaryNode<>(0);
    BinaryNode<Integer> binaryNode5 = new BinaryNode<>(3);
    BinaryNode<Integer> binaryNode6 = new BinaryNode<>(10);
    BinaryNode<Integer> binaryNode7 = new BinaryNode<>(13);
    BinaryNode<Integer> binaryNode8 = new BinaryNode<>(4);
    BinaryNode<Integer> binaryNode9 = new BinaryNode<>(14);
    BinaryNode<Integer> binaryNode10 = new BinaryNode<>(20);
    BinaryNode<Integer> binaryNode11 = new BinaryNode<>(16);
    BinaryNode<Integer> binaryNode12 = new BinaryNode<>(2);
    BinaryNode<Integer> binaryNode13 = new BinaryNode<>(5);
    BinaryNode<Integer> binaryNode14 = new BinaryNode<>(11);
    BinaryNode<Integer> binaryNode15 = new BinaryNode<>(15);
    binaryNode1.setLeft(binaryNode2);
    binaryNode1.setRight(binaryNode3);
    binaryNode2.setLeft(binaryNode4);
    binaryNode2.setRight(binaryNode5);
    binaryNode3.setLeft(binaryNode6);
    binaryNode3.setRight(binaryNode7);
    binaryNode6.setLeft(binaryNode8);
    binaryNode6.setRight(binaryNode9);
    binaryNode7.setRight(binaryNode11);
    binaryNode7.setLeft(binaryNode10);
    binaryNode8.setLeft(binaryNode12);
    binaryNode8.setRight(binaryNode13);
    binaryNode9.setLeft(binaryNode14);
    binaryNode9.setRight(binaryNode15);
    zigZagPrint(binaryNode1);
  }
}
