package algorithms.array.searchRotateArray;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/17 21:33
 */
public class SearchRotateArray {
  public int searchElem(int[] arr, int tar) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int left = 0;
    int right = arr.length - 1;
    int mid = 0;
    int rotateIndex = 0;

    while (true) {
      mid = (left + right) / 2;

      if (arr[left] > arr[mid]) {
        right = mid;
      } else {
        if (arr[left] > arr[mid + 1]) {
          rotateIndex = mid;
          break;
        }

        left = mid;
      }
    }

    if (tar < arr[0]) {
      return halfFind(arr, tar, rotateIndex + 1, arr.length - 1);
    } else {
      return halfFind(arr, tar, 0, rotateIndex);
    }
  }

  public int halfFind(int[] arr, int tar, int left, int right) {
    int mid;
    while (left <= right) {
      mid = (left + right) / 2;

      if (tar == arr[mid]) {
        return mid;
      } else if (tar < arr[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {

  }
}
