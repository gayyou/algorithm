package operateingSystem.shiyan1.osExpect2;

import java.util.*;

public class AuthorityWorks {
  public ArrayList<JCB> waitQueue;
  public ArrayList<JCB> runQueue;
  public ArrayList<JCB> finish;
  public static int sysTime;
  public static int sysResource;
  public static int sysMachine;

  public AuthorityWorks() {
    this.waitQueue = new ArrayList<>();
    this.runQueue = new ArrayList<>();
    this.finish = new ArrayList<>();
    createJCB();
  }

  public static void initSystemOptions(int resourceCount, int sysMachine) {
    sysTime = 0;
    sysResource = resourceCount;
    AuthorityWorks.sysMachine = sysMachine;
  }

  private void createJCB() {
    JCB jcb1 = new JCB("作业1", 15, 0, 20, 'w', 1, 2);
    JCB jcb2 = new JCB("作业2", 30, 20, 60, 'w', 2, 1);
    JCB jcb3 = new JCB("作业3", 9, 30, 45, 'w', 6, 3);
    JCB jcb4 = new JCB("作业4", 12, 35, 10, 'w', 5, 2);
    JCB jcb5 = new JCB("作业5", 6, 40, 25, 'w', 4, 3);
    this.waitQueue.add(jcb1);
    this.waitQueue.add(jcb2);
    this.waitQueue.add(jcb3);
    this.waitQueue.add(jcb4);
    this.waitQueue.add(jcb5);
    this.waitQueue.sort((o1, o2) -> {
      if (o1.runTime < o2.runTime) {
        return -1;
      } else if (o1.runTime > o2.runTime) {
        return 1;
      }
      return 0;
    });
  }

  private void print() {
    System.out.println("***********************************");
    System.out.println("系统时间：" + sysTime + " 系统所剩资源：" + sysResource + " 系统所剩磁带机数量：" + sysMachine);
    System.out.println("等待队列内容");
    for (JCB jcb : waitQueue) {
      System.out.println("作业名：" + jcb.name + " 作业状态：" + jcb.state + " 作业到达时间：" + jcb.submitTime + " 作业所需时间：" + jcb.runTime + " 作业所需资源：" + jcb.resource + " 作业所需磁带机：" + jcb.needMachine);
    }
    System.out.println("运行队列内容");
    for (JCB jcb : runQueue) {
      System.out.println("作业名：" + jcb.name + " 作业状态：" + jcb.state + " 作业到达时间：" + jcb.submitTime + " 作业所需时间：" + jcb.runTime + " 作业所需资源：" + jcb.resource + " 作业所需磁带机：" + jcb.needMachine);
    }
    System.out.println("完成队列内容");
    for (JCB jcb : finish) {
      System.out.println("作业名：" + jcb.name + " 作业状态：" + jcb.state + " 作业到达时间：" + jcb.submitTime + " 作业开始时间：" + jcb.startWorkTime + " 作业完成时间：" + jcb.finishTime + " 作业周转时间：" + jcb.serveTime + " 作业带权周转时间：" + jcb.auServeTime);
    }
    System.out.println("***********************************");
  }

  private void resolveRunningJCB() {
    ArrayList<JCB> arrayList = new ArrayList<>();
    for (JCB jcb : runQueue) {
      if (sysTime - jcb.submitTime >= jcb.runTime) {
        // 如果已经完成的话，那么就进行移除操作
        jcb.state = 'f';
        jcb.finishTime = sysTime;
        jcb.workTime = jcb.finishTime - jcb.startWorkTime;
        jcb.serveTime = jcb.finishTime - jcb.submitTime;
        jcb.auServeTime = jcb.serveTime / jcb.workTime;
        finish.add(jcb);
        arrayList.add(jcb);
        sysResource += jcb.resource;
        sysMachine += jcb.needMachine;
      }
    }
    for (JCB jcb : arrayList) {
      runQueue.remove(jcb);
    }
  }

  public void runs() throws InterruptedException {
    while(this.waitQueue.size() != 0 || this.runQueue.size() != 0) {
      resolveRunningJCB();
//      JCB jcb = this.waitQueue.get(0);
//      if (jcb == null) {
//        print();
//        Thread.sleep(300);
//        sysTime += 1;
//        continue;
//      }
      ArrayList<JCB> arrayList = new ArrayList<>();
      // 进行遍历，如果有存在优先级比较高，并且可以放进内存的就把这个作业放进内存
      for (JCB jcb : this.waitQueue) {
        if (AuthorityWorks.sysResource >= jcb.resource && sysTime >= jcb.submitTime && sysMachine >= jcb.needMachine) {
          jcb.state = 'r';
          jcb.startWorkTime = sysTime;
          this.runQueue.add(jcb);
          sysResource -= jcb.resource;
          sysMachine -= jcb.needMachine;
          arrayList.add(jcb);
        }
      }

      for (JCB jcb : arrayList) {
        this.waitQueue.remove(jcb);
      }

      print();
      sysTime += 5;
    }
  }

  public void printAllAuServeTime() {
    float sumServeTime = 0;
    float auSumServeTime = 0;
    for (JCB jcb : finish) {
      sumServeTime += jcb.serveTime;
      auSumServeTime += jcb.auServeTime;
    }
    System.out.println("平均周转时间：" + sumServeTime / finish.size() + " 带权平均周转时间：" + auSumServeTime / finish.size());
  }

  public static void main(String[] args) throws InterruptedException {
    AuthorityWorks authorityWorks = new AuthorityWorks();
    AuthorityWorks.initSystemOptions(100, 5);
    authorityWorks.runs();
    authorityWorks.printAllAuServeTime();
  }
}
