package chaper2DataStruction;

public class FindRepeatByNoChange {
  private int countRange(int[] arr, int start, int end) {
    if (arr == null) {
      return 0;
    }

    int count = 0;
    for (int value : arr) {
      if (value >= start && value <= end) {
        count++;
      }
    }

    return count;
  }

  private int getRepeatTime(int[] arr, int start, int end) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int count = 0;

    if (start <= end) {
      int middle = (end + start) >> 1;
      int leftCount = this.countRange(arr, start, middle);

      if (start == end) {
        if (leftCount > 1) {
          return leftCount - 1;
        } else {
          return 0;
        }
      }

      if (leftCount >= middle - start + 1) {
        count += this.getRepeatTime(arr, start, middle);
      } else {
        count += this.getRepeatTime(arr, middle + 1, end);
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] arg = new int[]{0, 1, 2, 1, 2, 4, 3, 4, 0, 5, 6, 9, 9};
    System.out.println(new FindRepeatByNoChange().getRepeatTime(arg, 1, arg.length - 1));
  }

}
