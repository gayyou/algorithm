const Resolution = (node) => {
  if (node === null) {
    return true;
  }
  function process(p1, p2) {
    if (p1 === null && p2 === null) {
      return true;
    }

    if (p1 === null || p2 === null) {
      return false;
    }

    if (p1.val !== p2.val) {
      return false;
    }

    return process(p1.left, p2.right) && process(p1.right, p2.left);
  }

  return process(node.left, node.right);
};
