package reflect;

import proxy.Developer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflect {
  public static void main(String[] args) {
    Class<?> clz = Developer.class;
    try {
      Constructor<?> constructor = clz.getConstructor();
      System.out.println(constructor.toString());
    } catch (NoSuchMethodException e) {

    }
    try {
      Method[] methods = clz.getMethods();
      System.out.println(Arrays.toString(methods));
    } catch (Exception e) {

    }
    try {
      Field[] fields = clz.getFields();
      System.out.println(fields);
    } catch (Exception e) {

    }
  }
}
