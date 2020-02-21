package test.suffix;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * 1.public必测
 * 2.>= <= = 必定考虑 <= >= =
 * 3.必定考虑临界值
 * 4.字符串、对象、数组必定考虑 空指针、空
 * 5.若是没有特殊规定的字符串一律乱码
 * 6.数值必定考虑正负零
 */
public class SuffixArrayTest {
  @Test
  public void test1() {
    int[] sa = new int[]{-1, 0, 1};
    int[] s = new int[4];
    int[] LCP = new int[3];
    try {
      SuffixArray.makeLCPArray(s, sa, LCP);
      fail("Expecting exception: ArrayIndexOutOfBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test2() {
    int[] sa = new int[]{0, 1, 2};
    int[] s = new int[4];
    int[] LCP = new int[3];
    try {
      SuffixArray.makeLCPArray(s, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test3() {
    int[] sa = new int[]{0, 0, 0};
    int[] s = new int[4];
    int[] LCP = new int[3];
    try {
      SuffixArray.makeLCPArray(s, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test4() {
    int[] sa = new int[]{0, 1, 2};
    int[] s = new int[]{0, 0, 0, 0};
    int[] LCP = new int[3];
    try {
      SuffixArray.makeLCPArray(s, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test5() {
    String str = "";
    int[] sa = new int[]{1, 2, 3, 4, 5};
    int[] LCP = new int[4];

    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test
  public void test5a() {
    String str = "1234";
    int[] sa = new int[]{0, 1, 2, 3};
    int[] LCP = new int[4];
    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
    } catch (Exception e) {

    }
  }

  @Test(timeout = 4000)
  public void test6() {
    String str = "!@#？%G";
    int[] sa = new int[]{1, 2, 3, 4, 5};
    int[] LCP = new int[4];

    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
      fail("Exception ArrayIndexOutofBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test7() {
    String str = "@!as2sf";
    int[] sa = new int[]{-1, 0, 0, 0, 0};
    int[] LCP = new int[9];

    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
      fail("Exception ArrayIndexOutofBoundsException");
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test8() {
    String str = "@!a'2sf";
    int[] sa = new int[]{-1, -2, 0, -3, 4, 5, 6, 7, 0, 0};
    int[] LCP = new int[10];

    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test9() {
    String str = "@!b'esd";
    int[] sa = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] LCP = new int[10];

    try {
      SuffixArray.createSuffixArray(str, sa, LCP);
    } catch (ArrayIndexOutOfBoundsException e) {

    }
  }

  @Test(timeout = 4000)
  public void test10() {
    int[] s = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] SA = new int[13];
    int n = 10;
    int K = 256;

    try {
      SuffixArray.makeSuffixArray(s, SA, n, K);
    } catch (Exception e) {

    }
  }

  @Test(timeout = 4000)
  public void test11() {
    int[] s = new int[10];
    s[1] = 1;
    s[2] = 3;
    s[5] = 4;
    s[9] = -10;
    s[0] = 1;
    int[] SA = new int[13];
    int n = 10;
    int K = 256;

    try {
      SuffixArray.makeSuffixArray(s, SA, n, K);
    } catch (Exception e) {

    }
  }

  @Test(timeout = 4000)
  public void test12() {
    int[] s = new int[10];
    s[1] = 1;
    s[2] = 3;
    s[3] = 11;
    s[4] = 19;
    s[5] = 4;
    s[9] = 10;
    s[0] = 1;
    int[] SA = new int[13];
    int n = 10;
    int K = 256;

    try {
      SuffixArray.makeSuffixArray(s, SA, n, K);
    } catch (Exception e) {

    }
  }

  @Test(timeout = 4000)
  public void test13() {
    try {
      SuffixArray.createSuffixArray((String) null, (int[]) null, null);
    } catch (Exception e) {

    }

    try {
      SuffixArray.makeSuffixArray(null, null, 0, 0);
    } catch (Exception e) {

    }
  }

  @Test(timeout = 4000)
  public void test14() {
    int[] s = new int[]{1, 2, 3, 4, 5, 6};
    int[] SA = new int[10];
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }

  @Test
  public void test15() {
    int[] SA = new int[10];
    int[] s = new int[]{0,0,0,0,0,0};
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }
  @Test
  public void test16() {
    int[] SA = new int[10];
    int[] s = new int[]{1,1,2,2,3,3};
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }

  @Test
  public void test17() {
    int[] SA = new int[10];
    int[] s = new int[]{1,1,1,2,2,2,3,3,3};
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }

  @Test
  public void test18() {
    int[] SA = new int[10];
    int[] s = new int[]{1,1,1,1,2,2,2,2,3,3,3,3};
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }

  @Test
  public void test19() {
    int[] SA = new int[20];
    int[] s = new int[]{1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3};
    int n = s.length;
    SuffixArray.makeSuffixArray(s, SA, n - 3, 256);
  }

  @Test
  public void test20() {
    int[] a = new int[]{1, 2, 3, 4, 5};
    String comment = ">!@#<^!$GM<BDGT";
    SuffixArray.printV(a, comment);
  }

  @Test
  public void test21() {
    int[] SA = new int[]{1, 2, 3};
    try {
      SuffixArray.isPermutation(SA, 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void test21a() {
    int[] SA = new int[]{0, 1, 2};
    try {
      SuffixArray.isPermutation(SA, 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void test21c() {
    int[] SA = new int[]{0, 1, 1};
    try {
      SuffixArray.isPermutation(SA, 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void test21b() {
    int[] SA = new int[]{1, 2, 3};
    try {
      SuffixArray.isPermutation(null, 3);
    } catch (Exception e) {

    }
  }

  @Test
  public void test22() {
    int[] s1 = new int[]{1, 2, 3, 4 ,5, 6, 7, 8, 9};
    int[] s2 = new int[]{1, 2, 3, 4 ,5, 6, 7, 8, 9};
    try {
      SuffixArray.sleq(s1, 0, s2, 0);
      fail("数组越界");
    } catch (Exception e) {

    }
  }

  @Test
  public void test23() {
    int[] s1 = new int[]{0, 1, 2, 3, 4 ,5, 6, 7, 8, 9};
    int[] s2 = new int[]{1, 2, 3, 4 ,5, 6, 7, 8, 9};
    try {
      SuffixArray.sleq(s1, 0, s2, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test24() {
    int[] s1 = new int[]{1, 2, 3, 4 ,5, 6, 7, 8, 9};
    int[] s2 = new int[]{0, 1, 2, 3, 4 ,5, 6, 7, 8, 9};
    try {
      SuffixArray.sleq(s1, 0, s2, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test25() {
    int[] SA = new int[]{0, 1};
    int[] s = new int[]{1, 2};
    try {
      SuffixArray.isSorted(SA, s, 2);
    } catch (Exception e) {

    }
  }

  @Test
  public void test26() {
    int[] SA = new int[]{1, 0};
    int[] s = new int[]{1, 2};
    try {
      SuffixArray.isSorted(SA, s, 2);
    } catch (Exception e) {

    }
  }

  @Test
  public void test27() {
    String a = "abc";
    String b = "ab";
    try {
      SuffixArray.computeLCP(a, b);
    } catch (Exception e) {

    }
  }

  @Test
  public void test28() {
    String a = "abc";
    String b = "abcd";
    try {
      SuffixArray.computeLCP(a, b);
    } catch (Exception e) {

    }
  }

  @Test
  public void test29() {
    String a = "abd";
    String b = "abcd";
    try {
      SuffixArray.computeLCP(a, b);
    } catch (Exception e) {

    }
  }

  @Test
  public void test30() {
    String a = "abc";
    String b = "abed";
    try {
      SuffixArray.computeLCP(a, b);
    } catch (Exception e) {

    }
  }

  @Test
  public void test31() {
    String a = "!@TFG";
    String b = "GDSG!@";
    try {
      SuffixArray.computeLCP(a, b);
    } catch (Exception e) {

    }
  }

  @Test
  public void test32() {
    String str = "12";
    int[] SA = new int[]{1, 2};
    int[] LCP = new int[]{1, 2};
    try {
      SuffixArray.createSuffixArraySlow(str, SA, LCP);
    } catch (Exception e) {

    }
  }

  @Test
  public void test33() {
    String str = "1";
    int[] SA = new int[]{1, 2};
    int[] LCP = new int[]{1, 2};
    try {
      SuffixArray.createSuffixArraySlow(str, SA, LCP);
    } catch (Exception e) {

    }
  }

  @Test
  public void test34() {
    String str = "1";
    int[] SA = new int[]{2};
    int[] LCP = new int[]{1, 2};
    try {
      SuffixArray.createSuffixArraySlow(str, SA, LCP);
    } catch (Exception e) {

    }
  }

  @Test
  public void test35() {
    String str = "1";
    int[] SA = new int[]{1, 2};
    int[] LCP = new int[]{1};
    try {
      SuffixArray.createSuffixArraySlow(str, SA, LCP);
    } catch (Exception e) {

    }
  }

  @Test
  public void test36() {
    try {
      SuffixArray.makeLCPArray(null, null, null);
    } catch (Exception e) {

    }
  }
  @Test
  public void test37() {
    try {
      SuffixArray.makeLCPArray(new int[]{-1}, new int[]{}, null);
    } catch (Exception e) {

    }
  }

  @Test
  public void test38() {
    try {
      SuffixArray.createSuffixArray("", null, null);
    } catch (Exception e) {

    }
  }

  @Test
  public void test39() {
    try {
      SuffixArray.createSuffixArray("", new int[]{-1, 0, 1}, null);
    } catch (Exception e) {

    }
  }

  @Test
  public void test40() {
    try {
      SuffixArray.makeSuffixArray(null, null, -1, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test41() {
    try {
      SuffixArray.makeSuffixArray(new int[]{-1, 0, 1, 2}, new int[]{-1, 0, 1, 2}, 4, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test42() {
    try {
      SuffixArray.makeSuffixArray(new int[]{-1, 0, 1, 2}, new int[]{-1, 0, 1, 2}, 2, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test43() {
    try {
      SuffixArray.makeSuffixArray(new int[]{-1, 0, 1, 2}, new int[]{-1, 0, 1, 2}, 4, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test44() {
    try {
      SuffixArray.makeSuffixArray(new int[]{-1, 0, 1, 2}, new int[]{-1, 0, 1, 2}, 4, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test45() {
    try {
      SuffixArray.printV(null, "");
    } catch (Exception e) {

    }
  }
}