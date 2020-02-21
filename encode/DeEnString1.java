package encode;
/**
 * 异或运算对字符串进行加解密
 * 改善功能：密钥和加密内容均由用户自己输入
 * auther Xjt
 */
import java.util.Scanner;

public class DeEnString1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请输入一个英文字符串或解密字符串:");
    String str = scan.nextLine();   //获取用户输入
    StringBuffer str2 = new StringBuffer();  //存储加密后的字符串
    StringBuffer str3 = new StringBuffer();  //存储解密后的字符串
    Scanner scan1 = new Scanner(System.in);
    System.out.println("请输入密钥KEY");
    int KEY = scan1.nextInt();   //获取用户输入

    //加密过程
    for(int i=0;i<str.length();i++)
    {
      char c = (char)(str.charAt(i) ^ KEY);
      str2.append(c);
    }

    //解密过程
    for(int i=0;i<str2.length();i++)
    {
      char c = (char)(str2.charAt(i) ^ KEY);
      str3.append(c);
    }
    System.out.println("原始 的字符串为:" + str);
    System.out.println("加密后 的字符串为:" + str2);
    System.out.println("解密后 的字符串为:" + str3);
  }
}
