package algorithms.greedy.prim;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/14 21:43
 */
public class Prim {
  @Data
  public static class PrimNode {
    boolean isSelect = false;
    int uid;
    LinkedList<PrimEdge> edgeList;
    LinkedList<PrimEdge> minList;

    {
      edgeList = new LinkedList<>();
      minList = new LinkedList<>();
    }

    public PrimNode(int uid) {
      this.uid = uid;
    }

    @Override
    public String toString() {
      return "PrimNode{" +
              "isSelect=" + isSelect +
              ", uid=" + uid +
              ", edgeList=" + edgeList +
              ", minList=" + minList +
              '}';
    }
  }

  @Data
  public static class PrimEdge implements Comparable<PrimEdge> {
    int weight;
    PrimNode form;
    PrimNode to;

    public PrimEdge(int weight, PrimNode form, PrimNode to) {
      this.weight = weight;
      this.form = form;
      this.to = to;
      form.getEdgeList().add(this);
    }

    @Override
    public int compareTo(PrimEdge o) {
      if (this.weight == o.weight) {
        return 0;
      }
      return this.weight > o.weight ? 1 : -1;
    }

    @Override
    public String toString() {
      return "PrimEdge{" +
              "weight=" + weight +
              ", form=" + form.uid +
              ", to=" + to.uid +
              '}';
    }
  }

  public PrimNode getMinTree(PrimNode start, ArrayList<PrimNode> nodeList) {
    if (start == null || nodeList.indexOf(start) == -1) {
      return null;
    }
    Heap<PrimEdge> heap = new Heap<>(10, (PrimEdge primEdge1, PrimEdge primEdge2) -> {
      if (primEdge1.weight == primEdge2.weight) {
        return 0;
      }
      return primEdge1.weight > primEdge2.weight ? 1 : -1;
    });
    PrimNode temp = start;
    start.isSelect = true;
    PrimEdge tempEdge = null;
    while (temp != null) {
      for (PrimEdge primEdge : temp.getEdgeList()) {
        // 将tempNode中的所有的堆都放到这个小顶堆中
        heap.insert(primEdge);
      }
      if (!heap.isEmpty()) {
        tempEdge = heap.poll();
        while (!heap.isEmpty() && tempEdge.to.isSelect) {
          tempEdge = heap.poll();
        }
        if (heap.isEmpty()) {
          break;
        }
        temp.getMinList().add(tempEdge);
        temp = tempEdge.to;
        temp.isSelect = true;
      } else {
        break;
      }
    }

    return start;
  }

  public void printMinTree(PrimNode start) {
    Deque<PrimNode> deque = new ArrayDeque();
    deque.add(start);
    while (!deque.isEmpty()) {
      PrimNode primNode = deque.poll();
      System.out.println("uid： " + primNode.uid);
      for (PrimEdge temp : primNode.getMinList()) {
        deque.add(temp.to);
      }
    }
  }

  public static void main(String[] args) {
    PrimNode primNode1 = new PrimNode(1);
    PrimNode primNode2 = new PrimNode(2);
    PrimNode primNode3 = new PrimNode(3);
    PrimNode primNode4 = new PrimNode(4);
    PrimNode primNode5 = new PrimNode(5);
    PrimNode primNode6 = new PrimNode(6);
    PrimEdge primEdge1 = new PrimEdge(3, primNode1, primNode2);
    PrimEdge primEdge2 = new PrimEdge(1, primNode2, primNode3);
    PrimEdge primEdge3 = new PrimEdge(4, primNode2, primNode5);
    PrimEdge primEdge4 = new PrimEdge(5, primNode1, primNode5);
    PrimEdge primEdge5 = new PrimEdge(4, primNode3, primNode5);
    PrimEdge primEdge6 = new PrimEdge(5, primNode4, primNode5);
    PrimEdge primEdge7 = new PrimEdge(6, primNode3, primNode4);
    PrimEdge primEdge8 = new PrimEdge(6, primNode1, primNode6);
    PrimEdge primEdge9 = new PrimEdge(2, primNode5, primNode6);
    PrimEdge primEdge10 = new PrimEdge(8, primNode4, primNode6);
    PrimEdge primEdge11 = new PrimEdge(3, primNode2, primNode1);
    PrimEdge primEdge12 = new PrimEdge(1, primNode3, primNode2);
    PrimEdge primEdge13 = new PrimEdge(4, primNode5, primNode2);
    PrimEdge primEdge14 = new PrimEdge(5, primNode5, primNode1);
    PrimEdge primEdge15 = new PrimEdge(4, primNode5, primNode3);
    PrimEdge primEdge16 = new PrimEdge(5, primNode5, primNode4);
    PrimEdge primEdge17 = new PrimEdge(6, primNode4, primNode3);
    PrimEdge primEdge18 = new PrimEdge(6, primNode6, primNode1);
    PrimEdge primEdge19 = new PrimEdge(2, primNode6, primNode5);
    PrimEdge primEdge110 = new PrimEdge(8, primNode6, primNode4);
    Prim prim = new Prim();
//    System.out.println(primNode1.edgeList.get(2).weight);
    ArrayList<PrimNode> arrayList = new ArrayList<>();
    arrayList.add(primNode1);
    arrayList.add(primNode2);
    arrayList.add(primNode3);
    arrayList.add(primNode4);
    arrayList.add(primNode5);
    arrayList.add(primNode6);
    prim.printMinTree(prim.getMinTree(primNode1, arrayList));
  }
}
