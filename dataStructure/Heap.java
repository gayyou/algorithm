package dataStructure;

import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/13 16:46
 */
public class Heap {
  public boolean isBigHeap;
  public LinkedList<Integer> heapArray;

  {
    heapArray = new LinkedList<>();
  }

  public Heap(boolean isBigHeap) {
    this.isBigHeap = isBigHeap;
  }

  public int getHeapTop() {
    if (this.heapArray.size() == 0) {
      return isBigHeap ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    return this.heapArray.get(0);
  }

  public int popHeapTop() {
    if (this.heapArray.size() == 0) {
      return isBigHeap ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    return this.heapArray.remove(0);
  }

  public void insert(int elem) {
    this.heapArray.add(elem);
    this.sort();
  }

  public int compare(int i, int j) {
    if (i == j) {
      return 0;
    }
    if (isBigHeap) {
      return i > j ? 1 : -1;
    } else {
      return i < j ? 1 : -1;
    }
  }

  public void sort() {
    int lessLength = this.heapArray.size() / 2 - 1;
    int index;
    while (lessLength >= 0) {
      index = (lessLength) * 2 + 1;
      if (index < heapArray.size() && this.compare(this.heapArray.get(index), this.heapArray.get(lessLength)) > 0) {
        this.swap(index, lessLength);
      }

      index = (lessLength + 1) * 2;
      if (index < heapArray.size() && this.compare(this.heapArray.get(index), this.heapArray.get(lessLength)) > 0) {
        this.swap(index, lessLength);
      }

      lessLength--;
    }
  }

  public void swap(int i, int j) {
    int temp = this.heapArray.get(i);
    this.heapArray.set(i, this.heapArray.get(j));
    this.heapArray.set(j, temp);
  }

  public void print() {
    System.out.println(this.heapArray.toString());
  }

  public int size() {
    return this.heapArray.size();
  }
}
