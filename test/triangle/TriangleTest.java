package test.triangle;

import org.junit.Test;

public class TriangleTest {
  @Test
  public void test01() {
    Triangle triangle = new Triangle(1, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test02() {
    Triangle triangle = new Triangle(1, 2, 3);
    triangle.getType(triangle);
  }

  @Test
  public void test03() {
    Triangle triangle = new Triangle(1, 1, 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test04() {
    Triangle triangle = new Triangle(0, 0, 0);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test05() {
    Triangle triangle = new Triangle(-1, -1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test06() {
    Triangle triangle = new Triangle(Long.MAX_VALUE + 1, Long.MAX_VALUE + 1, Long.MAX_VALUE + 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test07() {
    Triangle triangle = new Triangle(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test08() {
    Triangle triangle = new Triangle(-1, Long.MAX_VALUE, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test09() {
    Triangle triangle = new Triangle(1, -1, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test10() {
    Triangle triangle = new Triangle(1, 1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test11() {
    Triangle triangle = new Triangle(-1, -1, Long.MAX_VALUE);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test12() {
    Triangle triangle = new Triangle(1, -1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test13() {
    Triangle triangle = new Triangle(-1, 1, -1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test14() {
    Triangle triangle = new Triangle(3, 2, 2);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test15() {
    Triangle triangle = new Triangle(1, 1, 4);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test16() {
    Triangle triangle = new Triangle(4, 6, 9);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test17() {
    Triangle triangle = new Triangle(4, 9, 6);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test18() {
    Triangle triangle = new Triangle(4, 10, 5);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test19() {
    Triangle triangle = new Triangle(18, 1, 1);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test20() {
    Triangle triangle = new Triangle(11, 8, 4);
    triangle.isTriangle(triangle);
  }

  @Test
  public void test21() {
    Triangle triangle = new Triangle(11, 8, 4);
    triangle.getBorders();
  }

  @Test
  public void test22() {
    Triangle triangle = new Triangle(-1, -1, -1);
    triangle.getType(triangle);
  }

  @Test
  public void test23() {
    Triangle triangle = new Triangle(1, 1, 1);
    triangle.getType(triangle);
  }

  @Test
  public void test24() {
    Triangle triangle = new Triangle(0, 0, 0);
    triangle.getType(triangle);
  }

  @Test
  public void test25() {
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
