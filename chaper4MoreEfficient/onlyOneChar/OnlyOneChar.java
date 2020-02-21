package chaper4MoreEfficient.onlyOneChar;

import java.util.HashMap;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/11 15:35
 */
public class OnlyOneChar {
  public static char getTheOnlyOneInString(String str) {
    HashMap<Character, Integer> hashMap = new HashMap<>();

    char[] charArr = str.toCharArray();

    for (char temp : charArr) {
      if (hashMap.containsKey(temp)) {
        hashMap.put(temp, hashMap.get(temp) + 1);
      } else {
        hashMap.put(temp, 1);
      }
    }

    for (char temp : charArr) {
      if (hashMap.get(temp) == 1) {
        return temp;
      }
    }

    return '\0';
  }

  public static void main(String[] args) {
    String str = "absklfhasfwgwegbe234gnp";
    System.out.println(OnlyOneChar.getTheOnlyOneInString(str));
  }
}
