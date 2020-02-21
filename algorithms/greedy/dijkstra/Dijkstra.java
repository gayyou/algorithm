package algorithms.greedy.dijkstra;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/14 10:07
 */
public class Dijkstra {
  @Data
  public static class Node {
    int uid;
    Node preNode;
    int distance;
    boolean isFind;
    ArrayList<Edge> edgeList;
    ArrayList<Node> minTreeList;

    public Node(int uid) {
      edgeList = new ArrayList<>();
      isFind = false;
      this.uid = uid;
      minTreeList = new ArrayList<>();
    }

    public Edge getLessDistanceEdge() {
      Edge minDistanceEdge = null;
      int distance = Integer.MAX_VALUE;
      for (Edge edge : edgeList) {
        if (!edge.to.isFind && edge.weight < distance) {
          distance = edge.weight;
          minDistanceEdge = edge;
        }
      }

      return minDistanceEdge;
    }

    public void print() {
      ArrayList<Node> arrayList = new ArrayList<>();
      arrayList.add(this);
      while (arrayList.size() > 0) {
        Node node = arrayList.remove(0);
        arrayList.addAll(node.minTreeList);
        System.out.println("uid： " + node.getUid() + " 距离： " + node.getDistance());
      }
    }
  }

  @Data
  public static class Edge {
    Node from;
    Node to;
    int weight;

    public Edge(Node form, Node to, int weight) {
      this.from = form;
      this.to = to;
      this.weight = weight;
      form.getEdgeList().add(this);
    }
  }

  public Node getSmallestTree(Node start, ArrayList<Node> graph) {
    if (start == null) {
      return null;
    }
    if (graph.size() == 0) {
      return start;
    }
    ArrayList<Node> findNodeList = new ArrayList<>();
    findNodeList.add(start);
    while (true) {
      Node nextMinNode = null;
      Edge temp = null, minEdge = null;
      int minDis = Integer.MAX_VALUE;
      for (Node node : findNodeList) {
        temp = node.getLessDistanceEdge();
        if (temp != null) {
          if (node.distance + temp.weight < minDis) {
            nextMinNode = temp.to;
            minEdge = temp;
            minDis = node.distance + temp.weight;
          }
        }
      }
      if (nextMinNode != null) {
        nextMinNode.preNode = minEdge.from;
        nextMinNode.distance = nextMinNode.preNode.distance + minEdge.weight;
        nextMinNode.isFind = true;
        minEdge.from.minTreeList.add(nextMinNode);
        findNodeList.add(nextMinNode);
      } else {
        break;
      }
    }

    return start;
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Edge edge1 = new Edge(node1, node2, 3);
    Edge edge2 = new Edge(node1, node4, 7);
    Edge edge3 = new Edge(node2, node4, 2);
    Edge edge4 = new Edge(node2, node3, 4);
    Edge edge5 = new Edge(node4, node3, 5);
    Edge edge6 = new Edge(node3, node5, 6);
    Edge edge7 = new Edge(node4, node5, 4);
    ArrayList<Node> nodes = new ArrayList<>();
    nodes.add(node1);
    nodes.add(node2);
    nodes.add(node3);
    nodes.add(node4);
    nodes.add(node5);
    Dijkstra dijkstra = new Dijkstra();
    dijkstra.getSmallestTree(node1, nodes).print();
  }
}
