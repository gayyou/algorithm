package chaper4MoreEfficient.findValueEqualsIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/22 9:49
 */
public class FindValueEqualsIndex {
  public static Object[] findValueEqualsIndex(int[] rawArray) {
    int start = 0;
    int end = rawArray.length - 1;
    int mid;
    ArrayList<Integer> arrayList = new ArrayList<>();

    mid = (start + end) / 2;

    while (mid != rawArray[mid]) {
      if (rawArray[mid] > mid) {
        end = mid;
      } else {
        start = mid;
      }

      mid = (start + end) / 2;
    }

    int index = mid;

    while (index >= 0 && rawArray[index] == index) {
      arrayList.add(index);
      index--;
    }

    index = mid + 1;

    while (index < rawArray.length && rawArray[index] == index) {
      arrayList.add(index);
      index++;
    }

    arrayList.sort(Comparator.naturalOrder());

    return arrayList.toArray(new Integer[0]);
  }

  public static void main(String[] args) {
    int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.toString(FindValueEqualsIndex.findValueEqualsIndex(arr)));
    arr = new int[]{0, 2, 3, 4, 5};
    System.out.println(Arrays.toString(FindValueEqualsIndex.findValueEqualsIndex(arr)));
    arr = new int[]{1, 2, 3};
    System.out.println(Arrays.toString(FindValueEqualsIndex.findValueEqualsIndex(arr)));
    arr = new int[]{-1, 0, 2, 3, 5};
    System.out.println(Arrays.toString(FindValueEqualsIndex.findValueEqualsIndex(arr)));
  }
}
