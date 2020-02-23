package chaper4MoreEfficient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/10 23:54
 */
public class FindLessKNumber {
  /**
   * @description 首先进行划分，再进行查找。划分的话是跟快速排序一样的思路
   * 这道题的目的是找到K个最小的数，那么我们只需要找到第K个最小的数，并且左边已经是排好序的就行了
   * 快排的每个步骤的思路是将比某个数大的数排到右边，比某个数小的排到右边，并且递归进去，直到只有一个数字的时候才结束。
   * 而本题不需要递归进行，因为不要求是升序排序，那么本题的难点在于如何找到这个K位数。
   * <b>采用划分，返回划分结果的下标，如果这个下标在k的左边，那么就要从这个下标开始进行划分（终点在上一次结束的点）</b>
   * <b>采用划分，返回划分结果的下标，如果这个下标在k的右边，那么就要以这个下标结束进行划分（起点在上一个结束的点）</b>
   * @return
   */
  public Integer[] findLessKNumbers(Integer[] intArray, int k) {
    Partition<Integer> partition = new Partition<Integer>();
    int start = 0;
    int end = intArray.length - 1;
    int orderedIndex = partition.partition(intArray, start, end);
    while (orderedIndex != k - 1) {
      if (orderedIndex > k - 1) {
        // 如果划分结束的下标大于K - 1，那么就要从上一个start开始排起
        end = orderedIndex - 1;
        orderedIndex = partition.partition(intArray, start, end);
      } else {
        // 如果在左边的话，那么就要排到上一个end
        start = orderedIndex + 1;
        orderedIndex = partition.partition(intArray, start, end);
      }
    }

    ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(intArray).subList(0, k));
    System.out.println(arrayList.toString());

    return arrayList.toArray(new Integer[0]);
  }

  /**
   * @description 这道题使用容器的思想，创建一个容量只有K的容器，可以是一个数组、一个队列、一个栈。
   * 如果当前容量小于K，那么遇到一个数字就直接把这个数据塞进容器中。
   * 如果当前容量满了，那么遇到一个数字，就将这个数字在这个容器中进行遍历，如果找到一个比这个数字大的数，那么就进行替换。
   * @return
   */
  public Integer[] findLessKNumber2(Integer[] intArray, int k) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (Integer integer : intArray) {
      if (treeSet.size() < k) {
        treeSet.add(integer);
      } else {
        AtomicInteger max = new AtomicInteger();
        max.set(Integer.MIN_VALUE);
        treeSet.forEach((Integer item) -> {
          if (item > integer) {
            max.set(item);
          }
        });
        if (max.get() > Integer.MIN_VALUE) {
          treeSet.remove(max.get());
          treeSet.add(integer);
        }
      }
    }

    System.out.println(Arrays.toString(treeSet.toArray(new Integer[0])));
    return treeSet.toArray(new Integer[0]);
  }

  public static void main(String[] args) {
    FindLessKNumber findLessKNumber = new FindLessKNumber();
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    arrayList.add(4);
    arrayList.add(5);
    arrayList.add(6);
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(17);
    arrayList.add(18);
    arrayList.add(7);
    arrayList.add(8);
    arrayList.add(9);
    arrayList.add(10);
    arrayList.add(13);
    arrayList.add(14);
    arrayList.add(15);
    arrayList.add(16);
    arrayList.add(11);
    arrayList.add(12);
    arrayList.add(19);
    arrayList.add(20);
    findLessKNumber.findLessKNumber2(arrayList.toArray(new Integer[0]), 5);
  }
}
