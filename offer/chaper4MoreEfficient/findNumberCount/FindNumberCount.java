package chaper4MoreEfficient.findNumberCount;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/20 11:10
 */
public class FindNumberCount {
  public static int getNumberCount(int[] numbers, int keyNumber) {
    if (numbers == null || numbers.length == 0) {
      return 0;
    }
    return FindNumberCount.getNumberCount(numbers, 0, numbers.length - 1, keyNumber);
  }

  private static int getNumberCount(int[] numbers, int start, int end, int keyNumber) {
    if (start >= end) {
      return 0;
    }
    int mid = (start + end) / 2;
    int count = 0;

    if (numbers[mid] == keyNumber) {
      count = FindNumberCount.travelCount(numbers, mid, keyNumber);
    } else {
      count += getNumberCount(numbers, start, mid, keyNumber);
      count += getNumberCount(numbers, mid + 1, end, keyNumber);
    }

    return count;
  }

  public static int travelCount(int[] number, int startIndex, int keyNumber) {
    int count = 0;
    int tempIndex = startIndex;

    while (tempIndex >= 0 && number[tempIndex] == keyNumber) {
      count++;
      tempIndex--;
    }

    tempIndex = startIndex + 1;
    while (tempIndex < number.length && number[tempIndex] == keyNumber) {
      count++;
      tempIndex++;
    }

    return count;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 2, 2, 2, 3, 3, 3, 4, 5 ,6, 6, 6};
    System.out.println(FindNumberCount.getNumberCount(arr, 2));
    int[] arr1 = new int[]{1, 1};
    System.out.println(FindNumberCount.getNumberCount(arr1, 1));
    System.out.println(FindNumberCount.getNumberCount(arr1, 2));
    int[] arr2 = new int[]{};
    System.out.println(FindNumberCount.getNumberCount(arr2, 0));
  }
}
