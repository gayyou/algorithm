package operateingSystem.shiyan1.osExpect1;

import java.util.Deque;
import java.util.LinkedList;

public class RoundPCB {
  Deque<PCB> deque;
  Deque<PCB> finishDeque;
  int roundTime;
  int allTime;
  int runTimes;

  public RoundPCB(int roundTime) {
    this.deque = new LinkedList<>();
    this.finishDeque = new LinkedList<>();
    this.roundTime = roundTime;
    this.allTime = 0;
    this.runTimes = 1;
  }

  public void createProcess() {
    // r w f
    PCB pcb1 = new PCB("进程1", 'w', 5, 5);
    PCB pcb2 = new PCB("进程2", 'w', 3, 3);
    PCB pcb3 = new PCB("进程3", 'w', 9, 9);
    PCB pcb4 = new PCB("进程4", 'w', 2, 2);
    PCB pcb5 = new PCB("进程5", 'w', 4, 4);
    this.deque.add(pcb1);
    this.deque.add(pcb2);
    this.deque.add(pcb3);
    this.deque.add(pcb4);
    this.deque.add(pcb5);
  }

  public void run() {
    PCB start = deque.peek();
    int newResultTime = start.resultTime - this.roundTime;
    if (newResultTime <= 0) {
      start.state = 'f';
      this.allTime += start.resultTime;
      start.resultTime = 0;
      this.print();
      start = deque.pollFirst();
      this.finishDeque.addLast(start);
    } else {
      start.state = 'r';
      this.allTime += this.roundTime;
      start.resultTime -= this.roundTime;
      this.print();
      start.state = 'w';
      start = deque.pollFirst();
      this.deque.addLast(start);
    }
    this.runTimes++;
  }

  private void print() {
    System.out.println("*****************************************");
    System.out.println("当前操作系统运行次数：" + this.runTimes);
    System.out.println("当前操作系统运行这一批系统的总时间：" + this.allTime);
    for (PCB pcb : this.deque) {
      System.out.println("进程名: " + pcb.name + " 进程状态: " + pcb.state + " 进程总共运行时间：" + pcb.allTime + " 进程剩余运行的时间：" + pcb.resultTime);
    }

    for (PCB pcb : this.finishDeque) {
      System.out.println("进程名: " + pcb.name + " 进程状态: " + pcb.state + " 进程总共运行时间：" + pcb.allTime + " 进程剩余运行的时间：" + pcb.resultTime);
    }
    System.out.println("*****************************************");
  }

  public static void main(String[] args) throws InterruptedException {
    RoundPCB roundPCB = new RoundPCB(3);
    roundPCB.createProcess();
    while(roundPCB.deque.size() != 0) {
      roundPCB.run();
      Thread.sleep(300);
    }
    roundPCB.print();
  }
}
