package chaper4MoreEfficient.countOfReserve;

import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/12 20:04
 */
public class CountOfReserve {
  public static int resolution(int[] numArray) {
    if (numArray == null || numArray.length == 0) {
      return 0;
    }

    int[] copyArray = Arrays.copyOf(numArray, numArray.length);

    return resolution(copyArray, 0, copyArray.length - 1);
  }

  private static int resolution(int[] numArray, int left, int right) {
    if (left >= right) {
      return 0;
    }

    // 跟归并排序一样进行递归拆分和合并
    int splitLine = (right + left) / 2;
    int leftCount = resolution(numArray, left, splitLine);
    int rightCount = resolution(numArray, splitLine + 1, right);

    int i = splitLine;
    int[] cache = new int[right - left + 1];
    int cacheIndex = right - left;
    int j;
    int count = 0;
    // 核心代码，获取合并数组的时候每层的逆序个数并且进行排序
    while (i >= left) {
      j = right;
      while (j > splitLine) {
        if (numArray[i] > numArray[j]) {
          // 如果左边的数大于右边的数，那么存在一个逆序
          count++;
        } else {
          // 如果右边的数大于左边的数，那么要把右边的数放进cache里面。因为接下来的遍历不会出现这个数据了
          cache[cacheIndex] = numArray[j];
          right--;
          cacheIndex--;
        }

        j--;
      }

      // 左边的数遍历完成了，它是最大的数
      cache[cacheIndex] = numArray[i];
      cacheIndex--;
      i--;
    }

    j = right;
    // 接下来是将右边还没有遍历的数据进行放进cache里面，同时将cache放到copyArray中
    while (j > splitLine) {
      cache[cacheIndex] = numArray[j];
      cacheIndex--;
      j--;
    }

    for (i = left; i <= right; i++) {
      numArray[i] = cache[i - left];
    }

    count += leftCount + rightCount;

    return count;
  }

  public static void main(String[] args) {
    System.out.println(CountOfReserve.resolution(new int[]{7, 5, 6 ,4, 3}));
  }
}
