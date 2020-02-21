package operateingSystem.shiyan1.osExpect3;

import operateingSystem.shiyan1.osExpect3.job.Job;
import operateingSystem.shiyan1.osExpect3.memory.Memory;
import operateingSystem.shiyan1.osExpect3.memory.Zone;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
  static Zone removeBackup;

  public static void main(String[] args) {
    //初始化7个任务模拟队列
    Job job1 = new Job(1, 130);
    Job job2 = new Job(2, 60);
    Job job3 = new Job(3, 100);
    Job job4 = new Job(4, 200);
    Job job5 = new Job(5, 140);
    Job job6 = new Job(6, 60);
    Job job7 = new Job(7, 50);

    Scanner scanner = new Scanner(System.in);
    ArrayList<Job> arrayList = new ArrayList<>();
    int size = 0;
    int uid = 0;
    while(size != -1) {
      System.out.println("请输入job的id");
      uid = scanner.nextInt();
      System.out.println("请输入job的大小");
      size = scanner.nextInt();
      Job job = new Job(uid, size);
      tryLocate(job);
      arrayList.add(job);
      Memory.FREE_ZONELIST.remove(removeBackup);
      Memory.printFreeZone();
      Memory.sortFreeZone();
      System.out.println("请输入想要释放的资源, 不清除输入-1");
      uid = scanner.nextInt();
      if (uid != -1) {
        for (Job jobs : arrayList) {
          if (jobs.getJobId() == uid) {
            tryRelease(jobs);
            Memory.printFreeZone();
            Memory.sortFreeZone();
          }
        }
      }
    }

//    //DO 首次适应
//    tryLocate(job1);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
//    Memory.sortFreeZone();
//    //最佳适应算法
//    tryLocate(job2);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryLocate(job3);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    //job2释放
//    tryRelease(job2);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryLocate(job4);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    //释放3
//    tryRelease(job3);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryRelease(job1);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryLocate(job5);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryLocate(job6);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//    tryLocate(job6);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
//
//    tryLocate(job4);
//    Memory.FREE_ZONELIST.remove(removeBackup);
//    Memory.printFreeZone();
////    Memory.sortFreeZone();
  }

  private static void tryLocate(Job job) {
    for (Zone z : Memory.FREE_ZONELIST) {
      //满足分配条件
      if (job.getMemory() <= z.getSize()) {
        z.setStatus(true);
        System.out.println("任务" + job.getJobId() + "申请内存：" + job.getMemory() + "KB,分配分区为：" + z.toString());
        //分配hash表
        Memory.JOB_ZONE_MAP.put(job, z);
        //标记为已经使用
        removeBackup = z;
        Memory.BUSY_ZONELIST.add(z);
        return;
      }
    }
    System.out.println("分配失败！任务为" + job.toString());
  }

  private static void tryRelease(Job job) {
    Zone zone = Memory.JOB_ZONE_MAP.get(job);
    zone.setStatus(false);
    Memory.FREE_ZONELIST.add(zone);
    Memory.BUSY_ZONELIST.remove(zone);
    System.out.println("任务：" + job.getJobId() + " 释放内存" + job.getMemory() + "KB");
  }

}
