package dataStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Weybn
 * @motto Rare in the word you're worth it.
 * @time 2019/12/14 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinaryTreeNode {
  int val;
  BinaryTreeNode left;
  BinaryTreeNode right;

  public BinaryTreeNode(int val) {
    this.val = val;
  }
}
