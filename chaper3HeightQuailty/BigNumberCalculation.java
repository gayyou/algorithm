package chaper3HeightQuailty;

import org.junit.Test;

public class BigNumberCalculation {
  public String addition(String number1, String number2) {
    if (number1.length() == 0 && number2.length() == 0) {
      return "0";
    }

    if (number1.length() == 0) {
      return number2;
    }

    if (number2.length() == 0) {
      return number1;
    }

    boolean number1IsNavigate = number1.charAt(0) == '-';
    boolean number2IsNavigate = number2.charAt(0) == '-';

    if (number1IsNavigate ^ number2IsNavigate) {
      // 两个运算符号不同的时候
      return number1IsNavigate ? this.subtract(number2, number1) : this.subtract(number1, number2);
    } else {
      // 两个运算符同符号的时候
      return this.add(number1, number2);
    }
  }

  private String add(String number1, String number2) {
    boolean isNavigate = false;
    if (number1.charAt(0) == '-' && number2.charAt(0) == '-') {
      number1 = number1.substring(1);
      number2 = number2.substring(1);
      isNavigate = true;
    }
    int num1Length = number1.length();
    int num2Length = number2.length();
    int maxLength = Math.max(num1Length, num2Length);
    char[] result = new char[maxLength + 1];
    int num1Index = num1Length - 1, num2Index = num2Length - 1, resultIndex = maxLength;

    for (int i = 0; i < maxLength + 1; i++) {
      result[i] = '0';
    }

    while (num1Index >= 0 || num2Index >= 0) {
      if (num1Index < 0 || num2Index < 0) {
        char temp;
        if (num1Index < 0) {
          temp = (char) (number2.charAt(num2Index) - '0' + result[resultIndex]);
          num2Index--;
        } else {
          temp = (char) (number1.charAt(num1Index) - '0' + result[resultIndex]);
          num1Index--;
        }

        if (temp > '9') {
          temp = (char) ('0' + (temp - '9' - 1));
          result[resultIndex - 1] = '1';
        }

        result[resultIndex] = temp;
      } else {
        char temp = (char) ((number1.charAt(num1Index) - '0') + (number2.charAt(num2Index) - '0') + result[resultIndex]);

        if (temp > '9') {  // 进位
          temp = (char) ('0' + (temp - '9' - 1));
          result[resultIndex - 1] = '1';
        }

        result[resultIndex] = temp;
        num1Index--;
        num2Index--;
      }

      resultIndex--;
    }

    String resultString;

    if (isNavigate) {
      result[0] = '-';
      resultString = result[1] == '0' ? '-' + new String(result).substring(2) : new String(result);
    } else {
      resultString = result[0] == '0' ? new String(result).substring(1) : new String(result);
    }

    return resultString;
  }

  private String subtract(String number1, String number2) {
    number2 = number2.substring(1);
    int maxLength = Math.max(number1.length(), number2.length());
    number2 = this.getComplement(number2, maxLength);

    String resultString = this.add(number1, number2);

    if (resultString.length() > maxLength) {
      resultString = resultString.substring(1);
    }

    return this.reverseComplement(resultString);
  }

  private String reverseComplement(String number) {
    if (number.charAt(0) == '9') {
      System.out.println(number);
      char[] newChars = new char[number.length() + 1];
      boolean isOverflow = false;
      boolean isSubtract = true;
      for (int i = number.length() - 1; i >= 0; i--) {
        if (isSubtract) {
          if (number.charAt(i) == '0') {
            if (isOverflow) {
              newChars[i + 1] = '8';
            }
            newChars[i + 1] = '9';
            isOverflow = true;
          } else {
            if (isOverflow) {
              newChars[i + 1] = (char) ('9' - number.charAt(i) - 1 + '0');
            }
            newChars[i + 1] = (char) ('9' - number.charAt(i) + '0');
            isSubtract = false;
          }
        } else {
          newChars[i + 1] = (char) ('0' + '9' - number.charAt(i));
        }
      }

      newChars[0] = '-';

      return new String(newChars);
    } else {
      int index = 0;
      while (number.charAt(index) == '0') {
        index++;
      }

      return number.substring(index);
    }
  }

  private String getComplement(String number2, int len) {
    char[] complement = new char[len];
    int numLen = number2.length();
    int startOperate = len - numLen;

    for (int i = 0; i < len; i++) {
      if (i >= startOperate) {
        complement[i] = (char) ('0' + '9' - number2.charAt(i - startOperate));
      } else {
        complement[i] = '9';
      }
    }

    return this.add(new String(complement), "1");
  }

  @Test
  public void test01() {
    BigNumberCalculation bigNumberCalculation = new BigNumberCalculation();
    System.out.println(bigNumberCalculation.addition("-10000", "1"));
  }
}
