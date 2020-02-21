package algorithms.dynamic.bst;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author Weybn
 * @motto Rare in the world you're worth it.
 * @time 2019/12/16 15:09
 */
public class BestSearchTree {
  static int[][] rootTable;
  static double[][] probabilityTable;

  @Data
  @AllArgsConstructor
  public static class BSTNode {
    double probability;
    BSTNode left;
    BSTNode right;

    public BSTNode(double probability) {
      this.probability = probability;
    }
  }

  public static BSTNode getBestSearchTree(double[] probabilityList) {
    rootTable = new int[probabilityList.length + 1][probabilityList.length + 1];
    probabilityTable = new double[probabilityList.length + 1][probabilityList.length + 1];

    for (int i = 0; i < rootTable.length; i++) {
      probabilityTable[i][i] = 0;
      if (i > 0) {
        probabilityTable[i - 1][i] = probabilityList[i - 1];
        rootTable[i - 1][i] = i - 1;
      }
    }
    return null;
  }

/*  private static double getBestProbability(int x, int y) {
    if (x > y) {
      return 0;
    }

    if (x == y) {
      return probabilityTable[x][x];
    }

    if (probabilityTable[x][y] > 0) {
      return probabilityTable[x][y];
    }


  }*/

  public static void printTree() {

  }

  public static void main(String[] args) {
    double[] probabilityList = new double[]{0.1, 0.2, 0.3, 0.4};
    BestSearchTree.getBestSearchTree(probabilityList);
  }
}
