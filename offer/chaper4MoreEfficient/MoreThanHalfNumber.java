package chaper4MoreEfficient;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/10 18:25
 */
public class MoreThanHalfNumber {
  public static class TargetNumber {
    int number;
    int count;

    public TargetNumber(int number) {
      this.number = number;
    }
  }

  public int getMoreThanHalfNumber(int[] intArray) {
    TargetNumber targetNumber = new TargetNumber(Integer.MIN_VALUE);
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] != targetNumber.number) {
        if (targetNumber.count == 0) {
          targetNumber.number = intArray[i];
          targetNumber.count = 1;
        } else {
          targetNumber.count--;
        }
      } else {
        targetNumber.count++;
      }
    }

    return targetNumber.number;
  }

  public static void main(String[] args) {
    MoreThanHalfNumber moreThanHalfNumber = new MoreThanHalfNumber();
    int[] ints = new int[]{1, 2, 1, 1, 1, 3, 4, 1, 5, 5, 5, 5, 1, 1, 1};
    System.out.println(moreThanHalfNumber.getMoreThanHalfNumber(ints));
  }
}
