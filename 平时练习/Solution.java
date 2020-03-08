package 平时练习;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/3/7 23:43
 */
public class Solution {
   public int firstMissingPositive(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 1;
        }
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            while (inRange(numbers[i], length) && (numbers[numbers[i] - 1] != numbers[i])) {
                swap(numbers, numbers[i] - 1, i);
            }
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] != i + 1) {
                return i + 1;
            } else if (numbers[i] == numbers.length - 1) {
              return numbers.length + 1;
            }
        }

        return 1;
    }
     private boolean inRange(int length, int i) {
        return i > 0 && i <= length;
    }
    private void swap(int[] numbers, int i, int j) {
        numbers[i] ^= numbers[j];
        numbers[j] ^= numbers[i];
        numbers[i] ^= numbers[j];
    }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.firstMissingPositive(new int[]{3, 4, 1, -1}));
  }
}
