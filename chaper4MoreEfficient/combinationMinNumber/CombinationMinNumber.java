package chaper4MoreEfficient.combinationMinNumber;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Weybn
 * 思路很简单，先转为字符串，进行字符串的比较，拿到升序的字符串数组然后进行连接就是最小的了
 * @motto Rare in the world you're worth it.
 * @time 2020/1/9 8:32
 */
public class CombinationMinNumber {
  public String CombinationNumber(int[] numberArray) {
    String[] numStringArr = new String[numberArray.length];
    for (int i = 0; i < numberArray.length; i++) {
      numStringArr[i] = ((Integer) numberArray[i]).toString();
    }

    Arrays.sort(numStringArr, (str1, str2) -> {
      int len1 = str1.length();
      int len2 = str2.length();
      char str1Char, str2Char;


      for (int i = 0; i < len1 || i < len2; i++) {
        if (i >= len1) {
          str1Char = str1.charAt(len1 - 1);
        } else {
          str1Char = str1.charAt(i);
        }

        if (i >= len2) {
          str2Char = str2.charAt(len2 - 1);
        } else {
          str2Char = str2.charAt(i);
        }

        if (str1Char > str2Char) {
          return 1;
        } else if (str1Char < str2Char) {
          return -1;
        }
      }

      return 0;
    });

    StringBuilder stringBuilder = new StringBuilder();

    for (String str : numStringArr) {
      stringBuilder.append(str);
    }

    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    CombinationMinNumber combinationMinNumber = new CombinationMinNumber();
    int[] arr = new int[]{32, 321, 3};
    System.out.println(combinationMinNumber.CombinationNumber(arr));
  }
}
