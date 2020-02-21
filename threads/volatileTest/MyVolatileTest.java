package threads.volatileTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/22 15:36
 */
public class MyVolatileTest {
  public static AtomicInteger race = new AtomicInteger(0);

  private static final int THREADS_COUNT = 20;

  public static void increase() {
    race.getAndIncrement();
  }

  public static void main(String[] args) throws InterruptedException {
    Thread[] threads = new Thread[THREADS_COUNT];
    for (int i = 0; i < THREADS_COUNT; i++) {
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
