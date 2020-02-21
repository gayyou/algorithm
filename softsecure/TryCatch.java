package softsecure;

public class TryCatch {
  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      try {
        System.out.println("我是try内部的打印");
        break;
      } finally {
        System.out.println("我是finally内部的打印");
      }
    }
    System.out.println("我是跳出循环时候的打印");
  }
}
