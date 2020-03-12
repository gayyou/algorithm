const Resolution = (node) => {
  if (node === null) {
    return null;
  }

  if (node.right != null) {
    let right = node.right;

    while (right.left != null) {
      right = right.left;
    }

    return right;
  } else if (node.parent != null) {
    let cur = node;
    let parent = node.parent;

    while (parent != null && parent.right === cur) {
      cur = parent;
      parent = parent.parent;
    }

    return parent;
  }

  return node.parent;
};
