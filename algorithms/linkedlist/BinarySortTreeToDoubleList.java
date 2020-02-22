package algorithms.linkedlist;

import chaper3HeightQuailty.BinaryTree;
import model.BinaryNode;
import model.DoubleLinkedListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 21:05
 */
public class BinarySortTreeToDoubleList {
  public static BinaryNode<Integer> binaryTreeToDoubleList(BinaryNode<Integer> root) {
    if (root == null) {
      return null;
    }

    Queue<BinaryNode<Integer>> queue = new ArrayDeque<>();
    binaryTreeToDoubleList(root, queue);
    BinaryNode<Integer> head = queue.peek();
    BinaryNode<Integer> pre = queue.poll();
    assert pre != null;
    pre.setLeft(null);

    for (BinaryNode<Integer> item : queue) {
      pre.setRight(item);
      item.setLeft(pre);
      pre = item;
    }

    pre.setRight(null);

    return head;
  }

  private static void binaryTreeToDoubleList(BinaryNode<Integer> temp,
                                                                      Queue<BinaryNode<Integer>> queue) {
    if (temp == null) {
      return ;
    }

    binaryTreeToDoubleList(temp.getLeft(), queue);
    queue.add(temp);
    binaryTreeToDoubleList(temp.getRight(), queue);
  }
}
