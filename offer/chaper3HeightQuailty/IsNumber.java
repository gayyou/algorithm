package chaper3HeightQuailty;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @description 这道题的解题思路是从小到大模块化实现，分别实现以下数字
 * 1.整数  1.1 有符号整数  1.2 无符号整数
 * 2.小数
 * 3.用e来表示数字
 *
 * 或者可以用正则表达式进行匹配
 */
public class IsNumber {
  public boolean isNumber(String str) {
    if (str.length() == 0) {
      return false;
    }

    if (str.indexOf('e') >= 0 || str.indexOf('E') >= 0) {
      // 存在指数的情况下
      int eIndex = -1;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
          if (eIndex >= 0) {
            // 出现多次e,那么并不是一个整数
            return false;
          }
          eIndex = i;
        }
      }

      boolean leftIsLegal = (eIndex == 0)  // 当e是第一位的时候，说明系数为1
              || ((str.charAt(0) == '-' || str.charAt(0) == '+') && eIndex == 1)  // e是第二位的时候，省略系数1
              || (isInteger(str.substring(0, eIndex)) || isDecimal(str.substring(0, eIndex)));  // 左边是整数或者小数

      boolean rightIsLegal = (eIndex < str.length() - 1)  // 这个的条件是右边必须是正整数才有效
              && (isUnsignedInteger(str.substring(eIndex + 1))  // 右边是无符号整数
                  || (str.length() > eIndex + 2
                    && isSignedInteger(str.substring(eIndex + 1))));   // 右边是有符号正整数

      return leftIsLegal && rightIsLegal;
    } else {
      // 不存在指数的情况下
      return isInteger(str) || isDecimal(str);
    }

  }

  private boolean isInteger(String str) {
    return isSignedInteger(str) || isUnsignedInteger(str);
  }

  /**
   * @description 是一个无符号的整数
   * @param str
   * @return
   */
  private boolean isUnsignedInteger(String str) {
    if (str.length() == 0) {
      return false;
    }

    if (str.charAt(0) == '0' && str.length() > 1) {
      return false;
    }

    return isAllNumberInString(str);
  }

  /**
   * @description 字符串的每个下标都是数字
   * @param str
   * @return
   */
  private boolean isAllNumberInString(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) > '9' || str.charAt(i) < '0') {
        return false;
      }
    }

    return true;
  }

  /**
   * @description 是一个有符号的整数
   * @param str
   * @return
   */
  private boolean isSignedInteger(String str) {
    if (str.length() <= 1
            || (str.charAt(0) != '+' && str.charAt(0) != '-')
            || (str.charAt(1) == '0' && str.length() > 2)) {
      return false;
    }

    return isAllNumberInString(str.substring(1));
  }

  private boolean isDecimal(String str) {
    int pointIndex = -1;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '.') {
        if (pointIndex != -1) {
          // 当pointIndex不为-1的时候，说明存在两个以上的小数点
          return false;
        }
        pointIndex = i;
      }
    }

    if (pointIndex == -1) {
      return false;
    }

    boolean leftIsLegal = (pointIndex == 0)  // 小数点是第一位，则是符合的小数
            || ((str.charAt(0) == '+' || str.charAt(0) == '-') && pointIndex == 1)  // 小数的整数部分没有数字，但是有符号
            || isInteger(str.substring(0, pointIndex));  // 整数部分应当是一个整数

    boolean rightIsLegal = (pointIndex < str.length() - 1)  // 小数点右边必须有数字并且是无符号的整数
            && isUnsignedInteger(str.substring(pointIndex + 1));

    return rightIsLegal && leftIsLegal;
  }

  @Test
  public void testDecimal() {
    IsNumber isNumber = new IsNumber();
    System.out.println(isNumber.isDecimal("-.123"));
    System.out.println(isNumber.isDecimal("-.123"));
    System.out.println(isNumber.isDecimal("-2.123"));
    System.out.println(isNumber.isDecimal("+.123"));
    System.out.println(isNumber.isDecimal(".123"));
    System.out.println(isNumber.isDecimal("-0.123"));
    System.out.println(isNumber.isDecimal("0.123"));
    System.out.println(isNumber.isDecimal("2.123"));
    System.out.println(isNumber.isDecimal("2.1.23"));
    System.out.println(isNumber.isDecimal("2.-123"));
    System.out.println(isNumber.isDecimal("2.+123"));
    System.out.println(isNumber.isDecimal("00.123"));
    System.out.println(isNumber.isDecimal("-00.123"));
  }

  @Test
  public void testInteger() {
    IsNumber isNumber = new IsNumber();
    System.out.println(isNumber.isInteger("-1"));
    System.out.println(isNumber.isInteger("+1"));
    System.out.println(isNumber.isInteger("+0"));
    System.out.println(isNumber.isInteger("+1.2"));
    System.out.println(isNumber.isInteger("1.2"));
    System.out.println(isNumber.isInteger("-1e1"));
    System.out.println("___");
    System.out.println(isNumber.isInteger("-1"));
    System.out.println(isNumber.isInteger("1"));
    System.out.println(isNumber.isInteger("0"));
    System.out.println(isNumber.isInteger("+1.2"));
    System.out.println(isNumber.isInteger("1.2"));
    System.out.println(isNumber.isInteger("-1e1"));
  }



  @Test
  public void testIsNumber() {
    IsNumber isNumber = new IsNumber();
    System.out.println(isNumber.isNumber("-e+16"));
    System.out.println(isNumber.isNumber("-1e+16"));
    System.out.println(isNumber.isNumber("-0e+16"));

    System.out.println(isNumber.isNumber(".222e+16"));
    System.out.println(isNumber.isNumber("e+16"));
    System.out.println(isNumber.isNumber("-.2e16"));
    System.out.println(isNumber.isNumber("-e0"));
    System.out.println("_____");
    System.out.println(isNumber.isNumber("-.222e+1.6"));
    System.out.println(isNumber.isNumber("-e-16"));
    System.out.println(isNumber.isNumber("1.1.1.1."));
    System.out.println(isNumber.isNumber("ee"));
    System.out.println(isNumber.isNumber("e"));
    System.out.println(isNumber.isNumber("1.6e1.6"));
    System.out.println(isNumber.isNumber("+-e16"));
    System.out.println(isNumber.isNumber("+-"));
    System.out.println(isNumber.isNumber("-e-16"));
  }
}
