package test;

import java.util.Arrays;

public class OperateArrayElement {
  private int[] activeArray;
  private int index = 0;

  OperateArrayElement(int[] target) {
    this.activeArray = target;

    Arrays.sort(this.activeArray);
  }

  public void operate() {
    System.out.println(this.activeArray[this.index]);

    int temp = this.activeArray[this.index];

    for (int i = this.index; i < this.activeArray.length; i++) {
      this.activeArray[i] -= temp;

      if (this.activeArray[i] <= 0) {
        this.index = i + 1;
      }
    }
  }
}
