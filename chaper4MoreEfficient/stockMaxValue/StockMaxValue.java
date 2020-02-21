package chaper4MoreEfficient.stockMaxValue;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/27 16:20
 */
public class StockMaxValue {
  public static int getMaxValue(int[] rawArray) {
    if (rawArray == null || rawArray.length == 0) {
      return 0;
    }

    int maxValue = Integer.MIN_VALUE;
    int minPrice = rawArray[0];

    for (int item : rawArray) {
      if (item < minPrice) {
        minPrice = item;
      } else {
        maxValue = Integer.max(maxValue, item - minPrice);
      }
    }

    return maxValue;
  }

  public static void main(String[] args) {
    int[] rawArray = new int[]{1, 17, 11, 8, 5, 7, 12, 16, 14};
    System.out.println(StockMaxValue.getMaxValue(rawArray));
    System.out.println(StockMaxValue.getMaxValue(new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
    System.out.println(StockMaxValue.getMaxValue(new int[]{1, 10, 2, 12, 3, 18}));
    System.out.println(StockMaxValue.getMaxValue(new int[]{11, 2}));
    System.out.println(StockMaxValue.getMaxValue(null));
  }
}
