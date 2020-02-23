package chaper3HeightQuailty;

import java.util.ArrayList;
import java.util.Random;

public class SlipList {
  static class SlipNode {
    public SlipNode(int val) {
      this.val = val;
    }

    int val;
    SlipNode next;
    SlipNode down;
  }

  int maxLevel;
  int searchCount;
  SlipNode[] headList;

  public SlipList(int maxLevel) {
    this.maxLevel = maxLevel;
    this.headList = new SlipNode[maxLevel];
  }

  public void insert(int val) {
    int numberMaxLevel = getNumberMaxLevel();
    this.insert(new SlipNode(val), 0, numberMaxLevel);
  }

  public int searchNode(int val) {
    this.searchCount = 0;
    int maxLevel = this.maxLevel - 1;

    while (maxLevel > 0) {
      if (this.headList[maxLevel] != null) {
        break;
      }

      maxLevel--;
    }

    if (isInList(this.headList[maxLevel], val, maxLevel)) {
      return this.searchCount;
    } else {
      return -1;
    }
  }

  private boolean isInList(SlipNode startNode, int val, int level) {
    this.searchCount++;
    SlipNode p, q;
    p = q = startNode;

    while (p != null && p.val < val) {
      this.searchCount++;
      q = p;
      p = p.next;
    }

    if (p != null && p.val == val) {
      return true;
    }

    if (q.down == null) {
      return false;
    }

    if (q == this.headList[level]) {
      // 当比本层次链表的第一个值还小的时候，从下一层的第一个链表中找起
      return isInList(this.headList[level - 1], val, level - 1);
    } else {
      // 在下一层的节点上进行查找
      return isInList(q.down, val, level - 1);
    }
  }

  private void insert(SlipNode slipNode, int level, int numberMaxLevel) {
    SlipNode currentLevelHead = this.headList[level];
    if (currentLevelHead == null) {
      // 为空的时候进行创建
      this.headList[level] = slipNode;
    } else {
      // 当当前的链表不为空的时候，进行遍历插入
      this.insert(this.headList[level], slipNode);
    }

    if (level < numberMaxLevel - 1) {
      SlipNode upperLevelNode = new SlipNode(slipNode.val);
      upperLevelNode.down = slipNode;
      this.insert(upperLevelNode, level + 1, numberMaxLevel);
    }
  }
  
  private void insert(SlipNode head, SlipNode node) {
    while(head.val < node.val && head.next != null) {
      head = head.next;
    }

    // 中间插入和尾插入都是这么来处理的
    node.next = head.next;
    head.next = node;
  }

  private int getZeroOrOne() {
    Random rand = new Random();
    return rand.nextInt(2);
  }

  private int getNumberMaxLevel() {
    int level = 0;
    while(getZeroOrOne() == 1 && level < this.maxLevel) {
      level++;
    }

    return level;
  }

  public void print() {
    for (SlipNode slipNode : this.headList) {
      this.printList(slipNode);
    }
  }

  private void printList(SlipNode p) {
    while (p != null) {
      System.out.print(p.val);
      System.out.print(" ");
      p = p.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
  }
}
