package algorithms.tencent2020;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/12 15:07
 */
public class No1 {
  public String resolve(String str) {
    if (str.length() == 0) {
      return "";
    }

    StringBuilder newString = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    boolean isInQuote = false;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '[') {
        isInQuote = true;
        stack.push(i);
      } else if (str.charAt(i) == ']') {
        int leastIndex = stack.pop();
        if (stack.isEmpty()) {
          newString.append(getZipString(str.substring(leastIndex + 1, i)));
          isInQuote = false;
        }
      } else if (!isInQuote) {
        newString.append(str.charAt(i));
      }
    }

    return newString.toString();
  }

  private String getZipString(String str) {
    int splitLine = str.indexOf("|");
    int number = Integer.parseInt(str.substring(0, splitLine));
    String value = str.substring(splitLine + 1);
    StringBuilder result = new StringBuilder();
    String temp = this.resolve(value);

    while (number-- != 0) {
      result.append(temp);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    No1 no1 = new No1();
    System.out.println(no1.resolve("HG[3|B[2|CA]]F"));
  }
}
