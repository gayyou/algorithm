package chaper4MoreEfficient.lenOfMaxString;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/10 8:17
 */
public class LenOfMaxString {
  private static HashMap<Character, Integer> indexHashMap = new HashMap<>();

  public static int getNumberOfString(String str) {
    int count = 0;
    int maxCount = 0;
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      char temp = charArray[i];
      if (!indexHashMap.containsKey(temp)) {
        indexHashMap.put(temp, i);
        count++;
      } else {
        maxCount = Integer.max(maxCount, count);
        i = indexHashMap.get(temp);
        count = 0;
        indexHashMap.clear();
      }
    }

    maxCount = Integer.max(maxCount, count);

    return maxCount;
  }

  public static int getSubStringMaxDiffLength(String str) {
    char[] charArray = str.toCharArray();
    int[] charPositionArray = new int[26];

    Arrays.fill(charPositionArray, -1);
    int currentCount = 0;
    int max = 0;

    for (int i = 0; i < charArray.length; i++) {
      // 得到这个字符在charPositionArray的下标，得到上一次出现时候的下标
      int preIndex = charPositionArray[charArray[i] - 'a'];

      if (preIndex < 0) {
        // 当这个字符没有出现的时候，那么直接currentCount
        currentCount++;
      } else if (currentCount > i - preIndex) {
        // 当这个数字之前存在的时候，并且在当前遍历的子串中的时候
        // 如果计数要大于两者之间的距离，说明有必要进行处理
        max = Integer.max(currentCount, max);
        // 重新设定不重复的下标
        currentCount = i - preIndex;
      }

      charPositionArray[charArray[i] - 'a'] = i;  // 重新赋值下标
    }

    return Integer.max(max, currentCount);
  }

  public static void main(String[] args) {
    String str = "aassddopkjl";
    System.out.println(LenOfMaxString.getSubStringMaxDiffLength(str));
  }
}
