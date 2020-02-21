package dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2020/1/11 23:26
 */
@Data
@NoArgsConstructor
public class SingleNode<T> {
  T val;
  SingleNode<T> next;

  public SingleNode(T val) {
    this.val = val;
    this.next = null;
  }

  public SingleNode(T[] valArray) {
    if (valArray != null && valArray.length != 0) {
      this.val = valArray[0];
      SingleNode<T> temp = this, temp2;
      for (int i = 1; i < valArray.length; i++) {
        temp2 = new SingleNode<>(valArray[i]);
        temp.setNext(temp2);
        temp = temp2;
      }
    }
  }
}
