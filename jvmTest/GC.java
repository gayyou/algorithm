package jvmTest;

import reflect.Reflect;

import java.lang.ref.SoftReference;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/9 21:05
 */
public class GC {
  private static final int _1MB = 1024 * 1024;

  public static void main(String[] args) {
    byte[] allocation, allocation2, allocation3, allocation4;

//    SoftReference<MyTest> softReference = new SoftReference<MyTest>(new MyTest());

    allocation = new byte[2 * _1MB];

    allocation2 = new byte[2 * _1MB];

    allocation3 = new byte[2 * _1MB];

    allocation4 = new byte[4 * _1MB];
  }
}
