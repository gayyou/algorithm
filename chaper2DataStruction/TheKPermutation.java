package chaper2DataStruction;

public class TheKPermutation {
  public String getPermutation(int n, int k) {
    if (this.factorial == null) {
      this.factorial = new int[n + 1];
    }

    return "";
  }

  private int[] factorial;

  public int getFactorial(int num) {
    if (this.factorial[num] != 0) {
      return this.factorial[num];
    }

    int sum = 1;
    for (int i = 1; i < num; i++) {
      sum *= i;
      if (this.factorial[i] == 0) {
        this.factorial[i] = sum;
      }
    }

    return num;
  }
}
