package model;

public class LinkedListNode<T> {
  T val;
  LinkedListNode<T> next;

  public LinkedListNode(T val) {
    this.val = val;
  }

  public void insert(LinkedListNode<T> nextPoint) {
    this.next = nextPoint;
  }

  public LinkedListNode<T> getNext() {
    return this.next;
  }

  public void setNext(LinkedListNode<T> nextPoint) {
    this.next = nextPoint;
  }

  public T getVal() {
    return this.val;
  }
  
  public LinkedListNode<T> toList(T[] array) {
    if (array.length == 0) {
      return null;
    }
    LinkedListNode<T> head = null, p = null;
    
    for (T item : array) {
      if (head == null) {
        head = p = new LinkedListNode<>(item);
      } else {
        p.setNext(new LinkedListNode<>(item));
        p = p.next;
      }
    }

    return head;
  }

  public static void print(LinkedListNode node) {
    while (node != null) {
      System.out.println(node.val);
      node = node.getNext();
    }
  }
}
