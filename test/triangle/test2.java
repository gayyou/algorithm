package test.triangle;

import static org.junit.Assert.*;
import org.junit.Test;

public class test2 {
  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
    Triangle triangle0 = new Triangle(1002L, 1406L, 1406L);
    Triangle triangle1 = new Triangle(1002L, 1406L, 1002L);
    triangle1.lborderA = 774L;
    String string0 = triangle0.getType(triangle1);
    assertEquals("Scalene", string0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    Triangle triangle0 = new Triangle((-1L), 0L, 1982L);
    Triangle triangle1 = new Triangle(1982L, 2291L, 2291L);
    try {
      triangle1.getBorders()[3] = 385L;
      fail("Expecting exception: ArrayIndexOutOfBoundsException\"");
    } catch (ArrayIndexOutOfBoundsException e) {

    }

    String string0 = triangle0.getType(triangle1);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
    Triangle triangle0 = new Triangle(377L, 377L, 377L);
    triangle0.lborderC = 377L;
    triangle0.lborderC = 628L;
    String string0 = triangle0.getType(triangle0);
    assertEquals("Isosceles", string0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
    Triangle triangle0 = new Triangle(0L, 0L, 0L);
    Triangle triangle1 = new Triangle(1211L, 1211L, 1L);
    String string0 = triangle0.getType(triangle1);
    assertEquals("Isosceles", string0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
    Triangle triangle0 = new Triangle(9223372036854775807L, 9223372036854775807L, 9223372036854775807L);
    Triangle triangle1 = new Triangle(9223372036854775807L, 9223372036854775807L, 19L);
    boolean boolean0 = triangle0.isTriangle(triangle1);
    //  // Unstable assertion: assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
    Triangle triangle0 = new Triangle((-3687L), 2541L, 2541L);
    triangle0.lborderA = 1264L;
    triangle0.lborderC = (-3687L);
    triangle0.lborderC = 1277L;
    String string0 = triangle0.getType(triangle0);
    assertEquals("Illegal", string0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
    Triangle triangle0 = new Triangle(0L, 0L, 0L);
    triangle0.lborderA = 1L;
    triangle0.lborderB = 986L;
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
    Triangle triangle0 = new Triangle(1L, 1L, 1L);
    Triangle triangle1 = new Triangle(1020L, 1L, 1L);
    triangle1.lborderB = 0L;
    String string0 = triangle0.getType(triangle1);
    assertEquals("Illegal", string0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
    Triangle triangle0 = new Triangle(1539L, 1539L, 1389L);
    Triangle triangle1 = new Triangle((-1485L), 150L, 0L);
    triangle1.lborderA = 0L;
    String string0 = triangle0.getType(triangle1);
    assertEquals("Illegal", string0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
    Triangle triangle0 = new Triangle((-1240L), 9223372036854775807L, (-1240L));
    long long0 = triangle0.diffOfBorders((-1240L), 9223372036854775807L);
    assertEquals((-9223372036854774569L), long0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
    Triangle triangle0 = new Triangle(0L, 0L, 0L);
    // Undeclared exception!
    try {
      triangle0.isTriangle((Triangle) null);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
//      verifyException("trangle.target.Triangle", e);
    }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
    Triangle triangle0 = new Triangle(377L, 377L, 377L);
    // Undeclared exception!
    try {
      triangle0.getType((Triangle) null);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {
      //
      // no message in exception (getMessage() returned null)
      //
//      verifyException("trangle.target.Triangle", e);
    }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
    Triangle triangle0 = new Triangle(9223372036854775807L, 9223372036854775807L, 9223372036854775807L);
    long long0 = triangle0.diffOfBorders((-2719L), (-2719L));
    assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
    Triangle triangle0 = new Triangle(1L, 1L, 1L);
    long long0 = triangle0.diffOfBorders((-1116L), (-2051L));
    assertEquals(935L, long0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
    Triangle triangle0 = new Triangle(3663L, 3663L, 1062L);
    Triangle triangle1 = new Triangle(3663L, 1062L, 3663L);
    String string0 = triangle0.getType(triangle1);
    assertEquals("Isosceles", string0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
    Triangle triangle0 = new Triangle(3663L, 3663L, 1062L);
    Triangle triangle1 = new Triangle(1062L, 3663L, 3663L);
    String string0 = triangle0.getType(triangle1);
    assertEquals("Isosceles", string0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
    Triangle triangle0 = new Triangle(9223372036854775690L, 9223372036854775690L, 9223372036854775690L);
    String string0 = triangle0.getType(triangle0);
    assertEquals("Regular", string0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
    Triangle triangle0 = new Triangle(2007L, (-2820L), 1700L);
    String string0 = triangle0.getType(triangle0);
    assertEquals("Illegal", string0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
    Triangle triangle0 = new Triangle(2002L, (-33L), 2002L);
    Triangle triangle1 = new Triangle(2002L, 2002L, 2002L);
    triangle1.lborderB = 9223372036854771605L;
    triangle1.lborderC = 9223372036854773564L;
    boolean boolean0 = triangle0.isTriangle(triangle1);
    //  // Unstable assertion: assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
    Triangle triangle0 = new Triangle(2002L, 2002L, 2002L);
    triangle0.lborderC = 9223372036854773564L;
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
    Triangle triangle0 = new Triangle(2007L, (-2820L), 1700L);
    triangle0.lborderB = 3816L;
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
    Triangle triangle0 = new Triangle((-24L), (-24L), (-24L));
    Triangle triangle1 = new Triangle((-24L), (-24L), (-24L));
    triangle1.lborderB = 1841L;
    triangle1.lborderA = 2081L;
    boolean boolean0 = triangle0.isTriangle(triangle1);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
    Triangle triangle0 = new Triangle(2002L, (-33L), 2002L);
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
    Triangle triangle0 = new Triangle(377L, 377L, 377L);
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertTrue(boolean0);
  }

  private void assertTrue(boolean boolean0) {
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
    Triangle triangle0 = new Triangle((-24L), (-24L), (-24L));
    boolean boolean0 = triangle0.isTriangle(triangle0);
    assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
    Triangle triangle0 = new Triangle(2007L, (-2820L), 1700L);
    long[] longArray0 = triangle0.getBorders();
    assertArrayEquals(new long[] {2007L, (-2820L), 1700L}, longArray0);
  }

  @Test
  public void test011() {
    Triangle triangle = new Triangle(1, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test021() {
    Triangle triangle = new Triangle(1, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test031() {
    Triangle triangle = new Triangle(1, 1, 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test041() {
    Triangle triangle = new Triangle(0, 0, 0);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test051() {
    Triangle triangle = new Triangle(-1, -1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test061() {
    Triangle triangle = new Triangle(Long.MAX_VALUE + 1, Long.MAX_VALUE + 1, Long.MAX_VALUE + 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test071() {
    Triangle triangle = new Triangle(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test081() {
    Triangle triangle = new Triangle(-1, Long.MAX_VALUE, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test091() {
    Triangle triangle = new Triangle(1, -1, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test101() {
    Triangle triangle = new Triangle(1, 1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test111() {
    Triangle triangle = new Triangle(-1, -1, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test121() {
    Triangle triangle = new Triangle(1, -1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test131() {
    Triangle triangle = new Triangle(-1, 1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test141() {
    Triangle triangle = new Triangle(3, 2, 2);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test151() {
    Triangle triangle = new Triangle(1, 1, 4);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test161() {
    Triangle triangle = new Triangle(4, 6, 9);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test171() {
    Triangle triangle = new Triangle(4, 9, 6);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test181() {
    Triangle triangle = new Triangle(4, 10, 5);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test191() {
    Triangle triangle = new Triangle(18, 1, 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test201() {
    Triangle triangle = new Triangle(11, 8, 4);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test211() {
    Triangle triangle = new Triangle(11, 8, 4);
    triangle.getBorders();
  }

  @Test
  public void test221() {
    Triangle triangle = new Triangle(-1, -1, -1);
    triangle.getType(triangle);
  }

  @Test
  public void test231() {
    Triangle triangle = new Triangle(1, 1, 1);
    triangle.getType(triangle);
  }

  @Test
  public void test241() {
    Triangle triangle = new Triangle(0, 0, 0);
    triangle.getType(triangle);
  }

  @Test
  public void test251() {
    Triangle triangle = new Triangle(1, 3, 5);
    triangle.getType(triangle);
  }

  @Test
  public void test26() {
    Triangle triangle = new Triangle(1, 10, 20);
    triangle.getType(triangle);
  }

  @Test
  public void test27() {
    Triangle triangle = new Triangle(1, 1, 2);
    triangle.getType(triangle);
  }

  @Test
  public void test28() {
    Triangle triangle = new Triangle(2, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test29() {
    Triangle triangle = new Triangle(2, 3, 2);
    triangle.getType(triangle);
  }

  @Test
  public void test30() {
    Triangle triangle = new Triangle(3, 2, 2);
    triangle.getType(triangle);
  }

  @Test
  public void test31() {
    Triangle triangle = new Triangle(2, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test32() {
    Triangle triangle = new Triangle(2, 2, 3);
    try {
      triangle.getType(null);
    } catch (Exception e) {

    }
  }

  @Test
  public void test33() {
    Triangle triangle = new Triangle(2, 2, 3);
    try {
      triangle.isTriangle(null);
    } catch (Exception e) {

    }
  }

  @Test
  public void test34() {
    Triangle triangle = new Triangle(2, 2, 3);
    try {
      triangle.diffOfBorders(0, 1);
    } catch (Exception e) {

    }
  }

  @Test
  public void test35() {
    Triangle triangle = new Triangle(2, 2, 3);
    try {
      triangle.diffOfBorders(1, 0);
    } catch (Exception e) {

    }
  }

  @Test
  public void test36() {
    Triangle triangle = new Triangle(2, 2, 3);
    try {
      triangle.diffOfBorders(-1, 1);
    } catch (Exception e) {

    }
  }

  @Test
  public void test37() {
    Triangle triangle = new Triangle(564, 2654, 364);
  }

  @Test
  public void test38() {
    Triangle triangle = new Triangle(4, 5, 6);
    try {
      triangle.getType(triangle);
    } catch (Exception e) {

    }
  }

  @Test
  public void test39() {
    Triangle triangle = new Triangle(3, 3, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test40() {
    Triangle triangle = new Triangle(0, 1, 2);
    triangle.getType(triangle);
  }

  @Test
  public void test41() {
    Triangle triangle = new Triangle(4, 5, 6);
    triangle.getType(triangle);
  }

  @Test
  public void test42() {
    Triangle triangle = new Triangle(4, 4, 5);
    triangle.getType(triangle);
  }

  @Test
  public void test43() {
    Triangle triangle = new Triangle(5, 4, 4);
    triangle.getType(triangle);
  }

  @Test
  public void test44() {
    Triangle triangle = new Triangle(4, 5, 4);
    triangle.getType(triangle);
  }
}
