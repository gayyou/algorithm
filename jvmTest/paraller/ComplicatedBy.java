package jvmTest.paraller;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/12 16:01
 */
public class ComplicatedBy {
  public static volatile int race = 0;

  public static final int ThreadCount = 200;

  public static void increase() {
    ComplicatedBy.race++;
  }

  public static void main(String[] args) {
    Thread[] threads = new Thread[ComplicatedBy.ThreadCount];

    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 10000; i++) {
            increase();
          }
        }
      });
      threads[i].start();
    }

    while (Thread.activeCount() > 2) {
      Thread.yield();
    }

    System.out.println(race);
  }
}
