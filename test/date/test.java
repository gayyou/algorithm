package test.date;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class test {
  @Test
  public void invalidInput() {
    try {
      Day d = new Day(0, new Month(1, new Year(2000)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(13, new Month(1, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(31, new Month(1, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(0, new Month(1, null));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(0, null);
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(0, new Year(2000));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(1, new Year(2000));
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(12, new Year(2000));
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(13, new Year(2000));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(0, new Year(0));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Month m = new Month(1, null);
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception ignored) {

    }

    try {
      Year y = new Year(0);
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(1, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(2, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(3, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(4, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(5, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(6, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(7, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(8, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(9, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(10, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(11, new Year(2000)));
    } catch (Exception ignored) {

    }

    try {
      Day d = new Day(1, new Month(12, new Year(2000)));
    } catch (Exception ignored) {

    }
  }

  @Test
  public void equalsTest() {
    Date d = new Date(1, 1, 1);
    Date d2 = new Date(1, 1, 1);
    d.equals(d2);
    d2.getDay().setDay(1, new Month(2, new Year(2)));
    d.equals(d2);
    d2.getDay().setDay(1, new Month(2, new Year(1)));
    d.equals(d2);
    d2.getDay().setDay(1, new Month(1, new Year(2)));
    d.equals(d2);
    d2.getDay().setDay(2, new Month(2, new Year(2)));
    d.equals(d2);
    d2.getDay().setDay(2, new Month(1, new Year(1)));
    d.equals(d2);
    d2.getDay().setDay(2, new Month(1, new Year(2)));
    d.equals(d2);
    d2.getDay().setDay(2, new Month(2, new Year(1)));
    d.equals(d2);
    d.equals(new Object());
    d.getYear().equals(new Object());
    Day day = new Day(1, new Month(2, new Year(2)));
    day.equals(new Object());
    day.getDay();
    Month m = d.getMonth();
    m.equals(new Object());
    m.getMonth();
    Month m1 = new Month(1, new Year(2019));
    Month m2 = new Month(1, new Year(2019));
    m1.equals(m2);
    m2.setMonth(2, new Year(2018));
    m1.equals(m2);
    m2.setMonth(1, new Year(2018));
    m1.equals(m2);
    m2.setMonth(2, new Year(2019));
    m1.equals(m2);
    d.toString();
    d.printDate();
    Day dd = new Day(1, new Month(1, new Year(1)));
    Day dd2 = new Day(1, new Month(1, new Year(1)));
    dd.equals(dd2);
    dd.equals(new Object());
    dd2.setDay(1, new Month(2, new Year(1)));
    dd.equals(dd2);
    dd2.setDay(2, new Month(2, new Year(1)));
    dd.equals(dd2);
    dd2.setDay(2, new Month(2, new Year(2)));
    dd.equals(dd2);
  }

  @Test
  public void otherTest() {
    Year y = new Year(2000);
    y.isLeap();
    y.setYear(1);
    y.isLeap();
    y.setYear(4);
    y.isLeap();
    y.setYear(300);
    y.isLeap();
    y.isLeap();
    y.setYear(-1);
    y.isLeap();
    y.setYear(-4);
    y.isLeap();
    y.setYear(-300);
    y.isLeap();
    y.setYear(-2000);
    y.isLeap();
    y.getYear();
  }

  @Test
  public void incrementTest() {
    Date d2 = new Date(1, 1, 1);
    d2.increment();
    Date d = new Date(1, 31, 1);
    // 天覆盖
    d = Nextday.nextDay(d);
    d.getDay().setDay(1, new Month(1, new Year(1)));
    d = Nextday.nextDay(d);
    // 月份覆盖
    d = new Date(12, 31, 2019);
    Nextday.nextDay(d);
//    d.increment();
//    Nextday.nextDay(d);
    d.getDay().setDay(1, new Month(1, new Year(-1)));
    Nextday.nextDay(d);
    // 年份经过0
    d.getYear().setYear(-1);
    d.getYear().increment();
    d.getYear().isLeap();
    d.getYear().increment();
    d.getYear().isLeap();
    d.getMonth().setMonth(12, new Year(1));
    d.getMonth().increment();
    d.getMonth().increment();
    // 闰年二月进行测试
    Day day = d.getDay();
    day.setDay(29, new Month(2, new Year(4)));
    day.increment();
    day.setDay(28, new Month(2, new Year(5)));
    day.increment();
    day.increment();
  }

  @Test
  public void test01() {
    try {
      Day day = new Day(-1, new Month(1, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
      day.increment();
    } catch (Exception e) {

    }

  }

  @Test
  public void test02() {
    try {
      Day day = new Day(0, new Month(0, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
      day.increment();
    } catch(Exception e) {

    }
  }

  @Test
  public void test03() {
    try {
      Day day = new Day(1, new Month(0, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
      day.increment();
    } catch(Exception e) {

    }
  }

  @Test
  public void test04() {
    try {
      Day day = new Day(31, new Month(0, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
      day.increment();
    } catch(Exception e) {

    }

  }

  @Test
  public void test05() {
    try {
      Day day = new Day(0, new Month(1, new Year(12)));
      day.increment();
    } catch(Exception e) {

    }

  }

  @Test
  public void test06() {
    try {
      Day day = new Day(0, new Month(12, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }

  }

  @Test
  public void test07() {
    Day day = new Day(31, new Month(1, new Year(12)));
    day.increment();
  }

  @Test
  public void test08() {
    Day day = new Day(28, new Month(2, new Year(12)));
    day.increment();
  }

  @Test
  public void test09() {
    Day day = new Day(29, new Month(2, new Year(12)));
    day.increment();
  }

  @Test
  public void test10() {
    try {
      Day day = new Day(29, new Month(2, new Year(13)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }

  }


  @Test
  public void test11() {
    Day day = new Day(28, new Month(2, new Year(12)));
    day.increment();
  }

  @Test
  public void test12() {
    try {
      new Day(28, new Month(2, new Year(-12)));
    } catch (Exception e) {

    }

    try {
      new Day(8, new Month(6, new Year(-12)));
    } catch (Exception e) {

    }

    try {
      new Day(28, new Month(2142, new Year(122112)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }

    try {
      new Day(28, new Month(221, new Year(-12)));
    } catch (Exception e) {

    }

    try {
      new Day(28, new Month(2, new Year(12)));
    } catch (Exception e) {

    }

    try {
      new Day(1214, new Month(212, new Year(-12)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }

    try {
      new Day(0, new Month(2, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }

    try {
      new Day(2, new Month(2, new Year(12)));
    } catch (Exception e) {

    }

    try {
      new Day(29, new Month(2, new Year(12)));
    } catch (Exception e) {

    }

    try {
      new Day(30, new Month(2, new Year(12)));
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }
  }

  @Test
  public void test13() {
    Day day = new Day(1, new Month(1, new Year(1)));
    day.equals(new Object());
    day.equals(null);
    day.equals(day);
    day.equals(new Day(1, new Month(1, new Year(1))));
    day.equals(new Day(2, new Month(2, new Year(2))));
    day.equals(new Day(1, new Month(1, new Year(2))));
    day.equals(new Day(1, new Month(2, new Year(2))));
    day.equals(new Day(1, new Month(2, new Year(1))));
    day.equals(new Day(2, new Month(1, new Year(1))));
    day.equals(new Day(2, new Month(1, new Year(2))));
    day.equals(new Day(2, new Month(2, new Year(1))));
  }

  @Test
  public void test14() {
    try {
      new Month(0, new Year(1));
      fail("Expecting exception: IllegalArgumentException");
    } catch (IllegalArgumentException e) {

    }

    try {
      new Month(1, new Year(1));
    } catch (Exception e) {

    }

    try {
      new Month(12, new Year(1));
    } catch (Exception e) {

    }

    try {
      new Month(13, new Year(1));
    } catch (Exception e) {

    }

    try {
      new Month(-1, null);
    } catch (Exception e) {

    }

    try {
      new Month(-1, (Year) new Object());
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }
  }

  @Test
  public void test15() {
    try {
      new Year(1);
    } catch (Exception e) {

    }

    try {
      new Year(-1);
    } catch (Exception e) {

    }

    try {
      new Year(0);
      fail("Expecting exception: IllegalArgumentException");
    } catch (Exception e) {

    }
  }

  @Test
  public void test17() {
    try {
      new Month(1, new Year(1)).increment();
    } catch (Exception e) {

    }

    try {
      new Month(2, new Year(4)).increment();
    } catch (Exception e) {

    }

    try {
      new Month(2, new Year(14)).increment();
    } catch (Exception e) {

    }
    try {
      new Month(12, new Year(4)).increment();
    } catch (Exception e) {

    }

    try {
      new Month(22, new Year(4)).increment();
    } catch (Exception e) {

    }
  }

  @Test
  public void test18() {
    Month m = new Month(1, new Year(111));
    assertFalse(m.equals(null));
    assertFalse(m.equals(new Object()));
    assertTrue(m.equals(m));
    assertTrue(m.equals(new Month(1, new Year(111))));
    assertFalse(m.equals(new Month(1, new Year(222))));
  }

  @Test
  public void test20() {
    Year y = new Year(1);
    assertFalse(y.equals(new Object()));
    assertFalse(y.equals(null));
    assertTrue(y.equals(y));
    assertTrue(y.equals(new Year(1)));
    assertFalse(y.equals(new Year(222)));
  }

  @Test
  public void test22() {
    Date date = new Date(1, 2, 3);
    assertFalse(date.equals(null));
    assertTrue(date.equals(new Date(1, 2, 3)));
    assertFalse(date.equals(new Date(1, 2, 4)));
    assertFalse(date.equals(new Date(1, 3, 4)));
    assertFalse(date.equals(new Date(2, 2, 4)));
    assertFalse(date.equals(new Date(2, 3, 4)));
    assertFalse(date.equals(new Date(1, 3, 3)));
    assertFalse(date.equals(new Date(2, 2, 3)));
    assertFalse(date.equals(new Date(2, 3, 3)));
  }

  @Test
  public void test23() {
    Day day = new Day(1, new Month(2, new Year(3)));
    day.setCurrentPos(-1);
    day.increment();
  }

  @Test
  public void test24() {
    Day day = new Day(29, new Month(2, new Year(4)));
    day.setCurrentPos(29);
    day.increment();
  }

  @Test
  public void test25() {
    Day day = new Day(1, new Month(2, new Year(3)));
    assertTrue(day.equals(day));
    assertTrue(day.equals(new Day(1, new Month(2, new Year(3)))));
    assertFalse(day.equals(null));
    assertFalse(day.equals(new Day(1, new Month(3, new Year(3)))));
    assertFalse(day.equals(new Day(2, new Month(2, new Year(3)))));
    assertFalse(day.equals(new Day(2, new Month(3, new Year(3)))));
    assertFalse(day.equals(new Day(1, new Month(2, new Year(4)))));
    assertFalse(day.equals(new Day(1, new Month(3, new Year(4)))));
    assertFalse(day.equals(new Day(2, new Month(2, new Year(4)))));
    assertFalse(day.equals(new Day(2, new Month(3, new Year(4)))));
  }

  @Test(timeout = 4000)
  public void test400()  throws Throwable  {
    Year year0 = new Year(4);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.increment();
    Day day1 = new Day(4, month0);
    boolean boolean0 = day0.equals(day1);
    assertEquals(5, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test401()  throws Throwable  {
    Year year0 = new Year(2);
    Month month0 = new Month(2, year0);
    Day day0 = new Day(28, month0);
    assertEquals(28, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test402()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    day0.setCurrentPos(30);
    boolean boolean0 = day0.increment();
    assertEquals(31, day0.getDay());
    assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test403()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    day0.setCurrentPos((-1));
    day0.increment();
    int int0 = day0.getDay();
    assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test404()  throws Throwable  {
    Year year0 = new Year((-1621));
    Month month0 = new Month(2, year0);
    Day day0 = new Day(2, month0);
    day0.setCurrentPos((-1621));
    int int0 = day0.getDay();
    assertEquals((-1621), int0);
  }

  @Test(timeout = 4000)
  public void test405()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    month0.currentPos = 1906;
    // Undeclared exception!
    try {
      day0.increment();
      fail("Expecting exception: ArrayIndexOutOfBoundsException");

    } catch(ArrayIndexOutOfBoundsException e) {
      //
      // 1905
      //
    }
  }

  @Test(timeout = 4000)
  public void test406()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.isValid();
    assertEquals(4, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test407()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    assertEquals(4, day0.getDay());

    day0.setCurrentPos((-224));
    boolean boolean0 = day0.isValid();
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test408()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.setDay(4, month0);
    assertEquals(4, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test409()  throws Throwable  {
    Year year0 = new Year(2);
    Month month0 = new Month(8, year0);
    Day day0 = new Day(8, month0);
    Month month1 = new Month(2, year0);
    Day day1 = new Day(8, month1);
    boolean boolean0 = day0.equals(day1);
    assertEquals(8, day1.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test410()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    Day day1 = new Day(11, month0);
    boolean boolean0 = day0.equals(day1);
    assertEquals(11, day1.getDay());
    assertFalse(boolean0);
    assertFalse(day1.equals((Object)day0));
  }

  @Test(timeout = 4000)
  public void test411()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    boolean boolean0 = day0.equals(day0);
    assertEquals(4, day0.getDay());
    assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test412()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    boolean boolean0 = day0.equals("");
    assertEquals(1, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test413()  throws Throwable  {
    Year year0 = new Year(1);
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    year0.setCurrentPos(0);
    boolean boolean0 = day0.isValid();
    assertFalse(boolean0);
    assertEquals(1, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test414()  throws Throwable  {
    Day day0 = null;
    try {
      day0 = new Day((-25), (Month) null);
      fail("Expecting exception: IllegalArgumentException");

    } catch(IllegalArgumentException e) {
      //
      // Not a valid day
      //
    }
  }

  @Test(timeout = 4000)
  public void test415()  throws Throwable  {
    Year year0 = new Year((-1621));
    Month month0 = new Month(2, year0);
    Day day0 = new Day(2, month0);
    // Undeclared exception!
    try {
      day0.setDay((-508), month0);
      fail("Expecting exception: IllegalArgumentException");

    } catch(IllegalArgumentException e) {
      //
      // Not a valid day
      //
    }
  }

  @Test(timeout = 4000)
  public void test416()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    month0.increment();
    day0.setCurrentPos(30);
    day0.increment();
    boolean boolean0 = day0.isValid();
    assertEquals(31, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test417()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    int int0 = day0.getDay();
    assertEquals(1, int0);
  }

  @Test
  public void test418() {
    new Year(-1621).isLeap();  // t f t
    new Year(-1620).isLeap();  // f t f
    new Year(-1600).isLeap();  // f t f
    new Year(-1500).isLeap();  // f t f
    new Year(-1601).isLeap();  // t f t
//    new Year(-701).isLeap();  // f f f
    new Year(-5).isLeap();     // t t f
  }

  @Test(timeout = 4000)
  public void test42100()  throws Throwable  {
    Year year0 = new Year(4);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.increment();
    Day day1 = new Day(4, month0);
    boolean boolean0 = day0.equals(day1);
    assertEquals(5, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4021211()  throws Throwable  {
    Year year0 = new Year(2);
    Month month0 = new Month(2, year0);
    Day day0 = new Day(28, month0);
    assertEquals(28, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test42132102()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    day0.setCurrentPos(30);
    boolean boolean0 = day0.increment();
    assertEquals(31, day0.getDay());
    assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test402132133()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    day0.setCurrentPos((-1));
    day0.increment();
    int int0 = day0.getDay();
    assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test43213204()  throws Throwable  {
    Year year0 = new Year((-1621));
    Month month0 = new Month(2, year0);
    Day day0 = new Day(2, month0);
    day0.setCurrentPos((-1621));
    int int0 = day0.getDay();
    assertEquals((-1621), int0);
  }

  @Test(timeout = 4000)
  public void test40215()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    month0.currentPos = 1906;
    // Undeclared exception!
    try {
      day0.increment();
      fail("Expecting exception: ArrayIndexOutOfBoundsException");

    } catch(ArrayIndexOutOfBoundsException e) {
      //
      // 1905
      //

    }
  }

  @Test(timeout = 4000)
  public void test40216()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.isValid();
    assertEquals(4, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test421307()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    assertEquals(4, day0.getDay());

    day0.setCurrentPos((-224));
    boolean boolean0 = day0.isValid();
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test40218()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    day0.setDay(4, month0);
    assertEquals(4, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test21213409()  throws Throwable  {
    Year year0 = new Year(2);
    Month month0 = new Month(8, year0);
    Day day0 = new Day(8, month0);
    Month month1 = new Month(2, year0);
    Day day1 = new Day(8, month1);
    boolean boolean0 = day0.equals(day1);
    assertEquals(8, day1.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4121210()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    Day day1 = new Day(11, month0);
    boolean boolean0 = day0.equals(day1);
    assertEquals(11, day1.getDay());
    assertFalse(boolean0);
    assertFalse(day1.equals((Object)day0));
  }

  @Test(timeout = 4000)
  public void test41212131()  throws Throwable  {
    Year year0 = new Year(11);
    Month month0 = new Month(4, year0);
    Day day0 = new Day(4, month0);
    boolean boolean0 = day0.equals(day0);
    assertEquals(4, day0.getDay());
    assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test41221321()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    boolean boolean0 = day0.equals("");
    assertEquals(1, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test41213213()  throws Throwable  {
    Year year0 = new Year(1);
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    year0.setCurrentPos(0);
    boolean boolean0 = day0.isValid();
    assertFalse(boolean0);
    assertEquals(1, day0.getDay());
  }

  @Test(timeout = 4000)
  public void test42214()  throws Throwable  {
    Day day0 = null;
    try {
      day0 = new Day((-25), (Month) null);
      fail("Expecting exception: IllegalArgumentException");

    } catch(IllegalArgumentException e) {
      //
      // Not a valid day
      //

    }
  }

  @Test(timeout = 4000)
  public void test41225()  throws Throwable  {
    Year year0 = new Year((-1621));
    Month month0 = new Month(2, year0);
    Day day0 = new Day(2, month0);
    // Undeclared exception!
    try {
      day0.setDay((-508), month0);
      fail("Expecting exception: IllegalArgumentException");

    } catch(IllegalArgumentException e) {
      //
      // Not a valid day
      //

    }
  }

  @Test(timeout = 4000)
  public void test4126()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(3, year0);
    Day day0 = new Day(1, month0);
    month0.increment();
    day0.setCurrentPos(30);
    day0.increment();
    boolean boolean0 = day0.isValid();
    assertEquals(31, day0.getDay());
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test4217()  throws Throwable  {
    Year year0 = new Year((-3005));
    Month month0 = new Month(1, year0);
    Day day0 = new Day(1, month0);
    int int0 = day0.getDay();
    assertEquals(1, int0);
  }
}
