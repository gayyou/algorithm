package chaper1;

/**
 * @description 这是在单线程情况下使用的,多线程的情况下可能会浪费资源
 */
class Singleton {
  private static Singleton target;

  public static Singleton getInstance() {
    if (Singleton.target == null) {
      Singleton.target = new Singleton();
    }
    return Singleton.target;
  }
}

/**
 * @description 当对象没有创建的时候，会通过静态变量进行加锁操作
 */
class SingletonInMultiThread {
  private static SingletonInMultiThread target;

  private static boolean isCreating = false;

  private static SingletonInMultiThread getInstance() throws InterruptedException {
    if (target == null) {
      if (SingletonInMultiThread.isCreating) {
        Thread.sleep(10);
        return SingletonInMultiThread.getInstance();
      } else {
        SingletonInMultiThread.isCreating = true;
        return SingletonInMultiThread.target = new SingletonInMultiThread();
      }
    }

    return SingletonInMultiThread.target;
  }
}

/**
 * @description 静态变量，在初始化阶段进行赋值，以便以后使用
 */
class SingletonBestResolve {
  private static SingletonBestResolve target = new SingletonBestResolve();

  public static SingletonBestResolve getInstance() {
    return SingletonBestResolve.target;
  }
}