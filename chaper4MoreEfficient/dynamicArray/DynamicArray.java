package chaper4MoreEfficient.dynamicArray;

import dataStructure.Heap;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/13 20:11
 * @description 本题目的要求是在数据流中求得这个数据流的中位数。
 * <span>重点是流动、中位数</span>
 * 流动，我们是不知道这个数据流的
 */
public class DynamicArray {
  Heap bigHeap;
  Heap smallHeap;
  boolean isLeft;

  {
    bigHeap = new Heap(true);
    smallHeap = new Heap(false);
    isLeft = false;
  }

  public float getMiddleNumber(int[] intArray) {
    for (int i = 0; i < intArray.length; i++) {
      if (isLeft) {
        // 当下标为偶数的时候，放到大顶堆中
        if (intArray[i] > smallHeap.getHeapTop()) {
          // 如果发现插入的值大于小顶堆的堆头，那么这时候要将小顶堆的堆头拿出来，放到大顶堆中，然后小顶堆插入这个数
          bigHeap.insert(smallHeap.popHeapTop());
          smallHeap.insert(intArray[i]);
        } else {
          // 正常情况的插入操作
          bigHeap.insert(intArray[i]);
        }
      } else {
        // 当下标为奇数的时候，放到小顶堆中
        if (intArray[i] < bigHeap.getHeapTop()) {
          // 如果发现插入的值大于小顶堆的堆头，那么这时候要将大顶堆的堆头拿出来，放到小顶堆中，然后大顶堆插入这个数
          smallHeap.insert(bigHeap.popHeapTop());
          bigHeap.insert(intArray[i]);
        } else {
          smallHeap.insert(intArray[i]);
        }
      }
      isLeft = !isLeft;
    }

    if (bigHeap.size() == smallHeap.size()) {
      return ((float) (bigHeap.getHeapTop() + smallHeap.getHeapTop())) / 2;
    } else {
      return bigHeap.size() > smallHeap.size() ? (float) bigHeap.getHeapTop() : (float) smallHeap.getHeapTop();
    }
  }

  public static void main(String[] args) {
    int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 18};
    DynamicArray dynamicArray = new DynamicArray();
    System.out.println(dynamicArray.getMiddleNumber(intArray));
    int[] ints = new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
    System.out.println(dynamicArray.getMiddleNumber(ints));
    System.out.println(dynamicArray.bigHeap.size());
    System.out.println(dynamicArray.smallHeap.size());
  }
}
