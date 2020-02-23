package chaper4MoreEfficient.shaizi;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/26 10:20
 */
public class Shaizi {
  public static double[] getNumberProbability(int k) {
    int[] tempArray1 = new int[6 * k];
    int[] tempArray2 = new int[6 * k];
    int startIndex, endIndex;
    int[] swapTemp;

    for (int i = 0; i < 6; i++) {
      tempArray1[i] = 1;
    }

    for (int i = 1; i < 6; i++) {
      startIndex = i;
      endIndex = (i + 1) * 6;

      // 不在上一次的范围内的数字就要清空（也就是上一次不出现，但是上上次会出现的数字）
      for (int j = 0; j < i; j++) {
        tempArray2[j] = 0;
      }

      for (int j = startIndex; j < endIndex; j++) {
        tempArray2[j] = 0;

        for (int o = 1; o <= 6; o++) {
          if (j - o >= 0) {
            tempArray2[j] += tempArray1[j - o];
          }
        }
      }

      swapTemp = tempArray1;
      tempArray1 = tempArray2;
      tempArray2 = swapTemp;
    }

    double[] result = new double[6 * k];
    double total = Math.pow(6, k);
    DecimalFormat decimalFormat = new DecimalFormat("0.000000");
    for (int i = k - 1; i < 6 * k; i++) {
      result[i] = Double.parseDouble(decimalFormat.format(tempArray1[i] / total));
    }

    return result;
  }

  private static void test(int[] arr) {
    int temp = 0;
    for (int i = 0; i < arr.length; i++) {
      temp += arr[i];
    }
    System.out.println(temp);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(Shaizi.getNumberProbability(6)));
  }
}
