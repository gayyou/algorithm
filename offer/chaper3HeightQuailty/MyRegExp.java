package chaper3HeightQuailty;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyRegExp {
  public boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }

    boolean firstMatched = (!text.isEmpty()) &&
            (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2)))
              || (firstMatched && isMatch(text.substring(1), pattern));
    }

    return firstMatched && isMatch(text.substring(1), pattern.substring(1));
  }

  @Test(timeout = 4000)
  public void test00() {
    MyRegExp myRegExp = new MyRegExp();

    System.out.println(myRegExp.isMatch("aabccsdfdsafdsf", ".*f"));
  }
}
