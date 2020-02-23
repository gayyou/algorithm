package chaper2DataStruction;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class TurnSpace {
  public static String turnSpace(@NotNull String str) {
    if (str.length() <= 0) return "";

    int spaceCount = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        spaceCount++;
      }
    }

    char[] result = new char[str.length() + (spaceCount * 2)];

    int newLen = str.length() + (spaceCount * 2) - 1;
    int len = str.length();

    while(len-- > 0) {
      if (str.charAt(len) == ' ') {
        result[newLen--] = '0';
        result[newLen--] = '2';
        result[newLen--] = '%';
      } else {
        result[newLen--] = str.charAt(len);
      }
    }

    return new String(result);
  }

  public static void main(String[] args) {
    System.out.println(turnSpace(" 123"));
  }
}
