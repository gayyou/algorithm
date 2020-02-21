package chaper3HeightQuailty;

public class Matrix {
  int[][] matrix;

  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }

  public void printInCircle() {
    if (this.matrix.length == 0) {
      return ;
    }

    int horiStartLine = 0;
    int horiEndLine = this.matrix.length - 1;
    int verticalStartLine = 0;
    int verticalEndLine = this.matrix[0].length - 1;

    while (horiStartLine < horiEndLine) {
      printHorizontal(verticalStartLine, verticalEndLine, horiStartLine);
      horiStartLine++;
      printVertical(horiStartLine, horiEndLine, verticalEndLine);
      verticalEndLine--;
      printHorizontalReverse(verticalEndLine, verticalStartLine, horiEndLine);
      horiEndLine--;
      printVerticalReverse(horiEndLine, horiStartLine, verticalStartLine);
      verticalStartLine++;
    }
  }

  private void printHorizontal(int start, int end, int row) {
    for (int i = start; i <= end; i++) {
      System.out.println(this.matrix[row][i]);
    }
  }

  private void printVertical(int start, int end, int col) {
    for (int i = start; i <= end; i++) {
      System.out.println(this.matrix[i][col]);
    }
  }

  private void printHorizontalReverse(int start, int end, int row) {
    for (int i = start; i >= end; i--) {
      System.out.println(this.matrix[row][i]);
    }
  }

  private void printVerticalReverse(int start, int end, int col) {
    for (int i = start; i >= end; i--) {
      System.out.println(this.matrix[i][col]);
    }
  }
}
