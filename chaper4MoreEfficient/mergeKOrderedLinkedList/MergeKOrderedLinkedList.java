package chaper4MoreEfficient.mergeKOrderedLinkedList;

import dataStructure.SingleNode;
import sun.misc.Queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/5 11:00
 */
public class MergeKOrderedLinkedList {
  public static SingleNode<Integer> mergeKOrderLinkedList(ArrayList<SingleNode<Integer>> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    // 使用折半合并
    int max =  lists.size() - 1;
    int middle = (int) Math.ceil((double) lists.size() / 2);

    while (max >= 1) {
      for (int i = 0; i < middle; i++) {
        lists.set(i, MergeKOrderedLinkedList.merge2OrderLinkedList(lists.get(i), lists.get(max - i)));
      }

      max = middle - 1;
      middle = (int) Math.ceil((double) middle / 2);
    }

    return lists.get(0);
  }

  private static SingleNode<Integer> merge2OrderLinkedList(SingleNode<Integer> list1, SingleNode<Integer> list2) {
    if (list1 == null) {
      return list2;
    }

    if (list2 == null) {
      return list1;
    }

    if (list1.getVal() > list2.getVal()) {
      SingleNode<Integer> temp = list1;
      list1 = list2;
      list2 = temp;
    }

    SingleNode<Integer> node1 = list1.getNext();
    SingleNode<Integer> node2 = list2;
    SingleNode<Integer> temp1 = list1, temp2 = list2;

    while (node1 != null && node2 != null) {
      if (node2.getVal() <= node1.getVal()) {
        // temp2小于temp1的时候，，temp2往后挪
        temp2 = node2;
        node2 = node2.getNext();
      } else if (list2 == node2) {
        temp1 = node1;
        node1 = node1.getNext();
      } else {
        temp1.setNext(list2);
        temp2.setNext(node1);
        list2 = node2;
      }
    }

    if (node2 == null) {
      temp2.setNext(node1.getNext());
      node1.setNext(temp2);
    } else {
      temp1.setNext(list2);
    }

    return list1;
  }

  public static void printList(SingleNode<Integer> head) {
    while (head != null) {
      System.out.print(head.getVal());
      System.out.print(" ");
      head = head.getNext();
    }
  }

  public static void main(String[] args) {
    int[] intArray = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
    Integer[] integers = new Integer[intArray.length];
    int i = 0;
    for (int temp : intArray) {
      integers[i++] = temp;
    }
    int[] intArray2 = new int[]{ 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] integers2 = new Integer[intArray2.length];
    i = 0;
    for (int temp : intArray2) {
      integers2[i++] = temp;
    }
    SingleNode<Integer> singleNode2 = new SingleNode<>(integers2);
    SingleNode<Integer> singleNode1 = new SingleNode<Integer>(integers);
    ArrayList<SingleNode<Integer>> singleNodeArrayList = new ArrayList<>();
    singleNodeArrayList.add(singleNode1);
    singleNodeArrayList.add(singleNode2);
    MergeKOrderedLinkedList.printList(MergeKOrderedLinkedList.mergeKOrderLinkedList(singleNodeArrayList));
  }
}
