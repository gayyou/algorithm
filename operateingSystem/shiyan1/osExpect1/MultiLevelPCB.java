package operateingSystem.shiyan1.osExpect1;

import java.util.Deque;
import java.util.LinkedList;

public class MultiLevelPCB {
  Deque<PCBDeque> deques;
  Deque<PCB> finished;
  int allTime;
  int runTimes;
  int dequeNums;

  public MultiLevelPCB(int dequeNums) {
    this.allTime = 0;
    this.runTimes = 0;
    this.dequeNums = dequeNums;
    this.deques = new LinkedList<>();
    this.finished = new LinkedList();
    this.runTimes = 1;
  }

  public void createDeque() {
    for (int i = 0; i < dequeNums; i++) {
      PCBDeque pcbDeque = new PCBDeque(i + 1, i + 2);
      this.deques.add(pcbDeque);
    }
  }

  public void createPCB() {
    PCB pcb = new PCB("进程1", 'w', 11, 11);
    PCB pcb2 = new PCB("进程2", 'w', 14, 14);
    PCB pcb3 = new PCB("进程3", 'w', 24, 24);
    PCB pcb4 = new PCB("进程4", 'w', 21, 21);
    PCB pcb5 = new PCB("进程5", 'w', 15, 15);
    PCB pcb6 = new PCB("进程6", 'w', 15, 15);
//    PCB pcb7 = new PCB("进程7", 'w', 12, 12);
//    PCB pcb8 = new PCB("进程8", 'w', 3, 3);
//    PCB pcb9 = new PCB("进程9", 'w', 5, 5);
    PCBDeque pcbDeque = this.deques.getFirst();
    pcbDeque.deque.add(pcb);
    pcbDeque.deque.add(pcb2);
    pcbDeque.deque.add(pcb3);
    pcbDeque.deque.add(pcb4);
    pcbDeque.deque.add(pcb5);
    pcbDeque.deque.add(pcb6);
//    pcbDeque.deque.add(pcb7);
//    pcbDeque.deque.add(pcb8);
//    pcbDeque.deque.add(pcb9);
  }

  public void init() {
    this.createDeque();
    this.createPCB();
  }

  public void run() {
    PCBDeque pcbDeque;
    boolean isLastQueue = false;

    if (this.deques.size() <= 1) {
      // 最后一个队列，换成简单轮转法
      pcbDeque = this.deques.getFirst();
      isLastQueue = true;
    } else {
      // 拿下一个队列
      pcbDeque = this.deques.pollFirst();
    }
    assert pcbDeque != null;
    int roundTime = pcbDeque.roundTime;
    Deque<PCB> deque = pcbDeque.deque;

    while(deque.size() != 0) {
      PCB pcb = deque.peekFirst();
      int newResultTime = pcb.resultTime - roundTime;
      if (newResultTime <= 0) {
        // 完成运行的话，那么就放到完成队列
        pcb.state = 'f';
        this.allTime += pcb.resultTime;
        pcb.resultTime = 0;
        if (!isLastQueue) {
          this.deques.addFirst(pcbDeque);
          this.print();
          this.deques.pollFirst();
        } else {
          this.print();
        }
        pcb = deque.pollFirst();
        this.finished.addLast(pcb);
      } else {
        // 如果没有完成的话，要放到下一级队列
        pcb.state = 'r';
        this.allTime += roundTime;
        pcb.resultTime -= roundTime;
        if (!isLastQueue) {
          this.deques.addFirst(pcbDeque);
          this.print();
          this.deques.pollFirst();
        } else {
          this.print();
        }
        pcb.state = 'w';
        pcb = deque.pollFirst();
        if (isLastQueue) {
          deque.addLast(pcb);
        } else {
          PCBDeque pcbDeque1 = this.deques.getFirst();
          pcbDeque1.deque.addLast(pcb);
        }
      }
    }

    if (this.deques.size() == 1 && this.deques.getFirst().deque.size() == 0) {
      this.deques.pollFirst();
      this.print();
    }

    this.runTimes++;
  }

  private void print() {
    System.out.println("**********************************************");
    System.out.println("当前操作系统运行次数：" + this.runTimes);
    System.out.println("当前操作系统运行这一批系统的总时间：" + this.allTime);
    for (PCBDeque pcbDeque : this.deques) {
      System.out.println("队列的优先级：" + pcbDeque.authority + " 队列时间片：" + pcbDeque.roundTime);
      Deque<PCB> deque = pcbDeque.deque;
      for (PCB pcb : deque) {
        System.out.println("进程名: " + pcb.name + " 进程状态: " + pcb.state + " 进程总共运行时间：" + pcb.allTime + " 进程剩余运行的时间：" + pcb.resultTime);
      }
    }
    System.out.println("已完成队列：");
    for (PCB pcb : finished) {
      System.out.println("进程名: " + pcb.name + " 进程状态: " + pcb.state + " 进程总共运行时间：" + pcb.allTime + " 进程剩余运行的时间：" + pcb.resultTime);
    }
    System.out.println("**********************************************");
  }

  public static void main(String[] args) throws InterruptedException {
    MultiLevelPCB multiLevelPCB = new MultiLevelPCB(3);
    multiLevelPCB.init();
    while(multiLevelPCB.deques.size() != 0) {
      multiLevelPCB.run();
    }
  }
}
