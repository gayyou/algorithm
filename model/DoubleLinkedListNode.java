package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/2/21 20:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoubleLinkedListNode<T> {
  T val;
  DoubleLinkedListNode<T> next;
  DoubleLinkedListNode<T> pre;

  public DoubleLinkedListNode(T item) {
    this.val = item;
  }

  public DoubleLinkedListNode(T[] array) {
    if (array == null || array.length == 0) {
      throw new NullPointerException("数组不能为空");
    }

    this.val = array[0];

    DoubleLinkedListNode<T> temp2 = this;

    for (int i = 1; i < array.length; i++) {
      DoubleLinkedListNode<T> item = new DoubleLinkedListNode<>(array[i]);
      temp2.setNext(item);
      item.setPre(temp2);
      temp2 = item;
    }
  }
}
