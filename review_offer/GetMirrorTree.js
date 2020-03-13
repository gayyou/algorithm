const Resolution = (node) => {
  if (node === null) {
    return null;
  }

  function process(example, tar) {
    if (example.left !== null) {
      tar.right = new TreeNode(example.left.val);
      process(example.left, tar.right);
    }

    if (example.right !== null) {
      tar.left = new TreeNode(example.right.val);
      process(example.right, tar.left);
    }
  }

  let root = new TreeNode(node.val);

  process(node, root);

  return root;
};
