package chaper3HeightQuailty;

import java.util.HashMap;

public class ComplexList {
  public static class ComplexNode {
    int val;
    ComplexNode next;
    ComplexNode jumpNext;

    ComplexNode(int val) {
      this.val = val;
    }

    public int toInt() {
      return this.val;
    }
  }

  public ComplexNode createNode(ComplexNode head) {
    HashMap<ComplexNode, ComplexNode> hashMap = new HashMap<>();
    ComplexNode newHead, temp, oldTemp;
    oldTemp = head;
    newHead = temp = new ComplexNode(oldTemp.val);
    hashMap.put(oldTemp, temp);
    oldTemp = oldTemp.next;
    while (oldTemp != null) {
      temp.next = new ComplexNode(oldTemp.val);
      temp = temp.next;
      hashMap.put(oldTemp, temp);
      oldTemp = oldTemp.next;
    }

    oldTemp = head;
    temp = newHead;

    while (oldTemp != null) {
      temp.jumpNext = oldTemp.jumpNext != null ? hashMap.get(oldTemp.jumpNext) : null;
      temp = temp.next;
      oldTemp = oldTemp.next;
    }

    return newHead;
  }

  public void print(ComplexNode node) {
    while (node != null) {
      System.out.println(node.toInt() + " toJump " + (node.jumpNext != null ? node.jumpNext.toInt() : "null"));
      node = node.next;
    }
  }

  public ComplexNode create2(ComplexNode head) {
    ComplexNode temp1, temp2;
    temp1 = head;
    while(temp1 != null) {
      // 先拷贝一份节点， 并且每个复制好的节点都放到样本节点的后面
      temp2 = new ComplexNode(temp1.val);
      temp2.next = temp1.next;
      temp1.next = temp2;
      temp1 = temp2.next;
    }

    temp1 = head;
    while (temp1 != null) {
      // 进行跳跃节点的连接
      temp2 = temp1.next;
      if (temp1.jumpNext != null) {
        temp2.jumpNext = temp1.jumpNext.next;
      }
      temp1 = temp2.next;
    }

    // 进行链表的拆分
    temp1 = head.next;
    while(temp1.next != null) {
      temp1.next = temp1.next.next;
      temp1 = temp1.next;
    }

    return head.next;
  }

  public static void main(String[] args) {
    ComplexNode complexNode1 = new ComplexNode(1);
    ComplexNode complexNode2 = new ComplexNode(2);
    ComplexNode complexNode3 = new ComplexNode(3);
    ComplexNode complexNode4 = new ComplexNode(4);
    ComplexNode complexNode5 = new ComplexNode(5);
    ComplexNode complexNode6 = new ComplexNode(6);
    ComplexNode complexNode7 = new ComplexNode(7);
    ComplexNode complexNode8 = new ComplexNode(8);
    ComplexNode complexNode9 = new ComplexNode(9);
    complexNode1.jumpNext = complexNode3;
    complexNode2.jumpNext = complexNode1;
    complexNode3.jumpNext = complexNode9;
    complexNode4.jumpNext = complexNode9;
    complexNode5.jumpNext = complexNode7;
    complexNode6.jumpNext = complexNode1;
    complexNode7.jumpNext = complexNode4;
    complexNode8.jumpNext = complexNode6;
    complexNode9.jumpNext = complexNode9;
    complexNode1.next = complexNode2;
    complexNode2.next = complexNode3;
    complexNode3.next = complexNode4;
    complexNode4.next = complexNode5;
    complexNode5.next = complexNode6;
    complexNode6.next = complexNode7;
    complexNode7.next = complexNode8;
    complexNode8.next = complexNode9;
    ComplexList complexList = new ComplexList();
    ComplexNode complexNode = complexList.create2(complexNode1);
    complexList.print(complexNode);
    System.out.println("___________________");
    complexList.print(complexNode1);
  }
}
