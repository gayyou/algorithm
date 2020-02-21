package chaper4MoreEfficient.getContinuousSum;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/13 21:15
 */
public class ContinuousSum {
  public int getContinuousSum(int[] arr) {
    int max = Integer.MIN_VALUE;
    int temp = 0;
    for (int item : arr) {
      if (temp <= 0) {
        temp = item;
      } else {
        temp += item;
      }

      max = Math.max(max, temp);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] ints = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
    ContinuousSum continuousSum = new ContinuousSum();
    System.out.println(continuousSum.getContinuousSum(ints));
  }
}
