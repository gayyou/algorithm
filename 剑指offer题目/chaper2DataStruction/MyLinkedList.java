package chaper2DataStruction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MyLinkedList extends LinkedList {
  class Node {
    int val;
    Node pre;
    Node next;

    Node(int val) {
      this.val = val;
    }
  }

  Node head;
  Node last;

  MyLinkedList(int val) {
     this.last = this.head = new Node(val);
  }

  public boolean insert(int val) {
    if (this.head == null) {
      this.last = this.head = new Node(val);
    } else {
      this.last.next = new Node(val);
      this.last = this.last.next;
    }
    return true;
  }

  public void reservePrint(Node p) {
    if (p == null) return ;
    reservePrint(p.next);
    System.out.println(p.val);
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    new MyLinkedList(1).print(list);
  }

  public void print(LinkedList<Integer> p) {
    if (p.size() == 0) return ;
    int a = p.getFirst();
    p.removeFirst();
    print(p);
    System.out.println(a);
  }
}
