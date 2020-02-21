package algorithms.greedy.huffmanTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/14 15:54
 */
public class HuffmanTree {
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class HuffmanNode {
    double probability;
    char character;
    String code;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(double probability, char character) {
      this.probability = probability;
      this.character = character;
    }

    public HuffmanNode(double probability, HuffmanNode left, HuffmanNode right) {
      this.probability = probability;
      this.left = left;
      this.right = right;
    }

    public void printAllTree() {
      ArrayList<HuffmanNode> arrayList = new ArrayList<>();
      arrayList.add(this);
      while (arrayList.size() > 0) {
        HuffmanNode node = arrayList.remove(0);
        if (node.left != null) {
          arrayList.add(node.left);
        }

        if (node.right != null) {
          arrayList.add(node.right);
        }
        System.out.println("概率： " + node.getProbability() + " 字符： " + node.getCharacter() + " 编码： " + node.getCode());
      }
    }
  }

  public HuffmanNode getHuffmanTree(ArrayList<HuffmanNode> huffmanNodes) {
    if (huffmanNodes == null || huffmanNodes.size() == 0) {
      return null;
    }

    if (huffmanNodes.size() == 1) {
      return huffmanNodes.get(0);
    }

    // 首先根据权重进行一次排序
    huffmanNodes.sort((HuffmanNode node1, HuffmanNode node2) -> {
      if (node1.probability == node2.probability) {
        return 0;
      }
      return node1.probability > node2.probability ? 1 : -1;
    });

    HuffmanNode left, right, head;
    left = huffmanNodes.remove(0);
    StringBuilder stringBuilder = new StringBuilder();

    while (huffmanNodes.size() > 0) {
      right = huffmanNodes.remove(0);
      head = new HuffmanNode(left.getProbability() + right.getProbability(), left, right);
      left = head;
    }

    this.setCode(left, "");

    return left;
  }

  private void setCode(HuffmanNode head, String code) {
    // 进行编码操作
    if (head.getCharacter() != '\0') {
      head.setCode(code);
    }

    if (head.getLeft() != null) {
      this.setCode(head.getLeft(), code + "0");
    }
    if (head.getRight() != null) {
      this.setCode(head.getRight(), code + "1");
    }
  }

  public static void main(String[] args) {
    ArrayList<HuffmanNode> arrayList = new ArrayList<>();
    HuffmanNode huffmanNode1 = new HuffmanNode(0.15, 'a');
    HuffmanNode huffmanNode2 = new HuffmanNode(0.25, 'b');
    HuffmanNode huffmanNode3 = new HuffmanNode(0.2, 'c');
    HuffmanNode huffmanNode4 = new HuffmanNode(0.1, 'd');
    HuffmanNode huffmanNode5 = new HuffmanNode(0.3, 'e');
    arrayList.add(huffmanNode1);
    arrayList.add(huffmanNode2);
    arrayList.add(huffmanNode3);
    arrayList.add(huffmanNode4);
    arrayList.add(huffmanNode5);
    HuffmanTree huffmanTree = new HuffmanTree();
    huffmanTree.getHuffmanTree(arrayList).printAllTree();
  }
}
