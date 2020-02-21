package leetcode;

import java.lang.reflect.Array;

public class Solution {
  public void getList(StudentGrade[] gradeList) {

  }

  public boolean VerifySquenceOfBST(int [] sequence) {
    if (sequence == null || sequence.length == 0) {
      return false;
    }

    return this.VerifySquenceOfBST(sequence, 0, sequence.length - 1);
  }

  private boolean VerifySquenceOfBST(int[] sequence, int left, int right) {
    int rootNum = sequence[right];
    int splitLine = 0;

    for (int i = right; i >= left; i--) {
      if (sequence[i] < rootNum) {
        splitLine = i;
        break;
      }
    }

    for (int i = splitLine; i >= left; i--) {
      if (sequence[i] > rootNum) {
        return false;
      }
    }

    return this.VerifySquenceOfBST(sequence, left, splitLine) && this.VerifySquenceOfBST(sequence, splitLine + 1, right - 1);
  }
}

class StudentGrade {
  int ChineseGrade;
  int mathGrade;
  int EnglishGrade;
  String name;
}