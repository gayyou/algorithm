package algorithms.greedy.krushkal;

import dataStructure.MergeFindUnion;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/15 14:12
 */
public class Kruskal {
  @Data
  @AllArgsConstructor
  public static class KruskalEdge {
    int form;
    int to;
    int weight;

    @Override
    public String toString() {
      return " form=" + form +
              ", to=" + to +
              ", weight=" + weight + " ";
    }
  }

  public List<KruskalEdge> getMinTree(int[][] matrix) {
    LinkedList<KruskalEdge> kruskalEdgeList = new LinkedList<>();
    ArrayList<KruskalEdge> resultEdgeList = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > 0) {
          kruskalEdgeList.add(new KruskalEdge(i, j, matrix[i][j]));
        }
      }
    }
    // 进行排序
    kruskalEdgeList.sort(Comparator.comparingInt((KruskalEdge e) -> e.weight));
    // 初始化并查集
    MergeFindUnion<Integer> mergeFindUnion = new MergeFindUnion<>();
    for (int i = 0; i < matrix.length; i++) {
      mergeFindUnion.makeSet(i);
    }

    int count = 0;
    for (KruskalEdge kruskalEdge : kruskalEdgeList) {
      int form = kruskalEdge.getForm();
      int to = kruskalEdge.getTo();

      if (!mergeFindUnion.find(form).equals(mergeFindUnion.find(to))) {
        // 排序后进行查找边是否符合要求，如果符合要求的话，看看这条边的两个顶点是否在同一个并查集中，如果是的话，加进来肯定会成环
        mergeFindUnion.union(form, to);
        resultEdgeList.add(kruskalEdge);
        count++;

        if (count == matrix.length - 1) {
          return resultEdgeList;
        }
      }
    }

    return resultEdgeList;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
      {0, 3, -1, -1, 5, 6},
      {3, 0, 1, -1, 4, -1},
      {-1, 1, 0, 6, 4, -1},
      {-1, -1, 6, 0, 5, 8},
      {5, 4, 4, 5, 0, 2},
      {6, -1, -1, 8, 2, 0},
    };
    Kruskal kruskal = new Kruskal();
    System.out.println(kruskal.getMinTree(matrix).toString());
  }
}
