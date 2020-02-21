package chaper4MoreEfficient;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/11 12:43
 */
public class Partition<T extends Comparable<T>> {
  Random random = new Random();

  public int partition(T[] data, int start, int end) {
    if (data == null || data.length == 0 || start < 0 || end >= data.length) {
      return -1;
    }
    int index = RandomUtils.nextInt(start, end);
    this.swap(data, index, end);
    int small = start - 1;
    for (int i = start; i < end; ++i) {
      if (data[i].compareTo(data[end]) < 0) {
        ++small;
        if (small != i) {
          this.swap(data, i, small);
        }
      }
    }
    ++small;
    this.swap(data, small, end);
    return small;
  }

  private void swap(T[] data, int i, int j) {
    T temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }
}
