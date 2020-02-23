package chaper3HeightQuailty;

import org.junit.Test;

public class ModuleTest {
  @Test
  public void test01() {
    BinaryTree tree1 = new BinaryTree();
    BinaryTree tree2;

    tree1.root = new BinaryTree.BinaryNode(1);
    tree1.root.rightChild = new BinaryTree.BinaryNode(2);
    tree1.root.leftChild = new BinaryTree.BinaryNode(3);
    tree1.root.rightChild.rightChild = new BinaryTree.BinaryNode(4);
    tree1.root.rightChild.leftChild = new BinaryTree.BinaryNode(5);
    tree1.root.leftChild.rightChild = new BinaryTree.BinaryNode(6);

    tree2 = BinaryTree.getMirrorTree(tree1);

    tree2.print(tree2.root);
    System.out.println("______");
    tree1.print(tree1.root);
  }

  @Test
  public void test02() {
    BinaryTree tree1 = new BinaryTree();

    tree1.root = new BinaryTree.BinaryNode(1);
    tree1.root.rightChild = new BinaryTree.BinaryNode(2);
    tree1.root.leftChild = new BinaryTree.BinaryNode(2);
    tree1.root.rightChild.rightChild = new BinaryTree.BinaryNode(3);
    tree1.root.rightChild.leftChild = new BinaryTree.BinaryNode(4);
    tree1.root.leftChild.rightChild = new BinaryTree.BinaryNode(4);
    tree1.root.leftChild.leftChild = new BinaryTree.BinaryNode(3);

    System.out.println(BinaryTree.isSymmetricalTree(tree1));
  }

  @Test
  public void test03() {
    int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    Matrix matrix1 = new Matrix(matrix);
    matrix1.printInCircle();
  }

  @Test
  public void test04() {
    SlipList slipList = new SlipList(12);
    for (int i = 0; i < 10000; i++) {
      slipList.insert(i);
    }
    System.out.println(slipList.searchNode(9999));
    slipList.print();
  }
}
